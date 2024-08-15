## Gerenciador de Tarefas Spring Boot

### Descrição
Um aplicativo web simples e intuitivo para gerenciar tarefas diárias. Construído com Spring Boot, este projeto oferece funcionalidades como criação, edição, exclusão e marcação de tarefas como concluídas.

### Arquitetura
O projeto segue a arquitetura MVC (Model-View-Controller), com o Spring Boot fornecendo a infraestrutura básica. As entidades são persistidas em um banco de dados relacional utilizando JPA. A interface do usuário é construída com Thymeleaf e estilizada com Bootstrap.

[Diagrama de classes simplificado aqui]

### Tecnologias
* **Frontend:** HTML, CSS (Bootstrap), Thymeleaf
* **Backend:** Java, Spring Boot, JPA
* **Banco de dados:** [MySQL/PostgreSQL/etc.]

### Instalação
1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
   ```

2. **Instale as dependências:**
   ```bash
   cd seu-repositorio
   mvn clean install  # Maven
   gradle build      # Gradle
   ```

### Funcionalidades

* Criação de tarefas: Adicione novas tarefas com título, descrição e data de vencimento.
* Edição de tarefas: Modifique as informações de tarefas existentes.
* Exclusão de tarefas: Remova tarefas indesejadas.
* Marcação como concluída: Marque tarefas como concluídas para acompanhar o progresso.
* Busca: Pesquise por tarefas usando palavras-chave.
* Filtros: Filtre tarefas por status (a fazer, em andamento, concluídas), data de vencimento, etc.
