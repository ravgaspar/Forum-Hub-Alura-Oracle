# Forum-Hub-Alura-Oracle
API RESTful parte do Desafio LiterAlura do curso de Spring Boot 3. A API contém endpoints CRUD simulando uma versão semelhante ao Fórum Alura. 


ForumHub - Challenge Alura 2024
API RESTful parte do Desafio LiterAlura do curso de Spring Boot 3. A API contém endpoints CRUD simulando uma versão semelhante ao Fórum Alura. Utiliza também Spring Security para implementar autenticação e autorização com JWT(JSON Web Tokens), Flyway para Migrations do Banco de Dados e documentação da API com SpringDoc-OpenAPI3.


Funcionalidades


Endpoints para realizar as seguintes Funcionalidades
•	Autenticação e Autorização com JWT e Roles via SpringSecurity.
•	Cadastrar novo tópico.
•	Listar/Detalhar tópicos.
•	Filtrar tópicos.
•	Atualizar tópicos.
•	Exclusão de tópicos (apenas para usuários com Role Admin).


Como Usar
1.	Clone este repositório:
git clone https://github.com/ravgaspar/Forum-Hub-Alura-Oracle/new/main?readme=1

Compile o código:
Navegue até o diretório do projeto e execute o seguinte comando Maven:
mvn clean package


2.	Executar o JAR gerado na pasta target do projeto:
java -jar target/forumhub-0.0.1-SNAPSHOT


Endpoints da API
Para mais informações sobre os endpoints executar o projeto e acessar a documentação em http://localhost:8080/swagger-ui/index.html
 

