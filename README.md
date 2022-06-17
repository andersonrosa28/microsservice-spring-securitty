# microsservice-spring-securitty
Serviço para implementar a parte de security do spring:

* No primeiro commit o usuario e senha estão fixos no codigos, somente para ensino, NÃO RECOMENDADO UTILIZAR ASSIM.
* Já a feature/spring-security-com-usuario-do-banco se conecta no banco para pegar o usuario, nesse caso estamos utilizando o postgres.


# Subindo o banco de dados via docker 

No projeto temos um docker-compose, basta acessar o terminal nessa pasta e rodar o comando:
 * docker-compose -f docker-compose-db.yml up

As configurações do banco estão dentro do arquivo compose:
porta: 5432
senha: 123456
versão da imagem: postgres:12-alpine


### Arquivo de configuração do banco 

As configurações para se conectar no banco estão no arquivo /src/main/resources/application.yml

