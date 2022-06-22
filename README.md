# microsservice-spring-securitty
Serviço para implementar a parte de security do spring:

* No primeiro commit o usuario e senha estão fixos no codigos, somente para ensino, NÃO RECOMENDADO UTILIZAR ASSIM.
* Já a feature/spring-security-com-usuario-do-banco se conecta no banco para pegar o usuario, nesse caso estamos utilizando o postgres.


# Subindo o banco de dados via docker 

No projeto temos um docker-compose, basta acessar o terminal nessa pasta e rodar o comando:
  
    * docker-compose -f docker-compose-db.yml up

As configurações do banco estão dentro do arquivo compose:
  
    * porta: 5432
    * senha: 123456
    * versão da imagem: postgres:12-alpine


### Arquivo de configuração do banco 

As configurações para se conectar no banco estão no arquivo /src/main/resources/application.yml


### Usuario para autenticação

O usuario e senha estão sendo inseridos no banco, no momento que a aplicação sobe, o arquivo de insert se chama data.sql
Então, quando for efetuar uma chamada para o endpoint é necessario passar o Authorization do tipo Basic Auth:
    
     * username: anderson
     * password: 123456

Exemplo de chamada via curl:
  
    * curl -u anderson:123456  http://localhost:8080/v1/api/carro


### Subindo Redis via docker 

No projeto temos um docker-compose, basta acessar o terminal nessa pasta e rodar o comando:

    * docker-compose -f docker-compose-redis.yml up



### Spring Session

Para ver os headers da aplicação:

    * curl -i -u anderson:123456 http://localhost:8080/v1/api/carro

    * O token fica no header X-Auth-Token.

Para testar sem autenticação basta passar o token no header:
    
    * curl -H "X-Auth-Token: ea91adbd-97bc-4f80-84f8-f1691a565033" http://localhost:8080/v1/api/carro

Foi necessario criar a classe SpringSessionConfig, para configurar a Session do Spring.

Para ver a sessão funcionando entre os dois MS, basta chamar o /usuario de cada MS passando no header o token 
e veja que irão retornar o mesmo usuario e token,
pois os dois estão se conectando no redis para pegar o usuario da sessao, um ponto positivo nessa implementação 
é que a sessão não fica na aplicação, mas sim no redis, então mesmo se a aplicação morrer a sessão continua ativa.

Chamada para o primeiro MS:
    
    * curl -H "X-Auth-Token: 8ca9cb32-afb0-462b-b368-494c6f8860c9" http://localhost:8080/usuario 

Retorno do MS 1: 
   
    * {"nome":"anderson","token":"8ca9cb32-afb0-462b-b368-494c6f8860c9"}
Chamada para o segundo MS usando o roteamento do zuul (veja que estou usando o /moto no endereço, pois foi esse endereço que adicionei na configuracao do zuul):

    * curl -H "X-Auth-Token: 8ca9cb32-afb0-462b-b368-494c6f8860c9" http://localhost:8080/moto/usuario

Retorno do MS 2:

    * {"token MS 2":"8ca9cb32-afb0-462b-b368-494c6f8860c9","nome MS 2":"anderson"}