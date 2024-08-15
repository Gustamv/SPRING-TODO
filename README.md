
## Gerenciador de Tarefas Spring Boot
Descrição
Este é um aplicativo web simples desenvolvido em Spring Boot para gerenciar tarefas do dia a dia. Ele permite aos usuários criar, editar, excluir e marcar tarefas como concluídas.

Tecnologias Utilizadas
. Spring Boot: Framework Java para desenvolvimento rápido de aplicações web.
. JPA: Para persistência de dados em um banco de dados relacional.
Thymeleaf: Motor de templates para renderizar as páginas HTML.
Bootstrap: Framework CSS para estilização.
Pré-requisitos
Java Development Kit (JDK): Versão 8 ou superior.
Maven ou Gradle: Para gerenciamento de dependências.
Banco de dados relacional: Configure as informações de conexão no arquivo application.properties.
Instalação
Clone o repositório:
Bash
git clone https://github.com/seu-usuario/seu-repositorio.git
Use o código com cuidado.

Instale as dependências:
Bash
cd seu-repositorio   

mvn clean install  # Se estiver usando Maven
# Ou
gradle build      # Se estiver usando Gradle
Use o código com cuidado.

Execução
Configure o banco de dados:
H2 (em memória): Para desenvolvimento rápido, o H2 é uma boa opção. Configure as propriedades no arquivo application.properties.
Outro banco de dados: Configure as propriedades de conexão com seu banco de dados (MySQL, PostgreSQL, etc.) no arquivo application.properties.
Execute a aplicação:
Bash
mvn spring-boot:run  # Se estiver usando Maven
# Ou
./gradlew bootRun    # Se estiver usando Gradle
Use o código com cuidado.

Uso
Acesse a aplicação: Abra um navegador e vá para http://localhost:8080.
Crie uma nova tarefa: Clique no botão "Nova tarefa" e preencha o formulário.
Edite uma tarefa: Clique no botão "Editar" na linha da tarefa desejada.
Exclua uma tarefa: Clique no botão "Excluir" na linha da tarefa desejada.
Marque uma tarefa como concluída: Clique no botão "Concluir" na linha da tarefa desejada.
