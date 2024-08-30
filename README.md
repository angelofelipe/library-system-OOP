# library-system-OOP
Small implementation of a library system with OOP (Object-Oriented Programming)

## Compiling and running the program
Be in the root of this directory and run the following commands to compile and run the program:

* Compile
```bash
javac -d out -sourcepath src -cp src $(find src -name "*.java")
```

* Execute
```bash
java -cp out Main
```

## Viewing the class diagram
To create the class diagrams, the utility [PlantUML](https://github.com/plantuml/plantuml) was used.

To view them, you can simply run the command on directory "diagrama de classes":
```bash
plantuml -o "imagens dos diagramas" main.puml
```

It is necessary to have [PlantUML](https://plantuml.com/starting) installed, as well as [GraphViz](https://plantuml.com/graphviz-dot) on which it depends. If you don't know how to do this, click on one of the hyperlinks or see the complete documentation [here](https://plantuml.com/).

---

## MATA62 – SOFTWARE ENGINEERING I
#### Practical Work
### 1. Objective

In this assignment, the student will design and implement a very small and incomplete system. The goal is to allow students to apply their knowledge in object-oriented design and object-oriented programming.

Sections 2 and 3 describe the system requirements. Section 4 lists some design requirements. Section 5 explains the evaluation criteria. Section 6 describes how the work will be submitted. Finally, Section 7 lists the test data that must be used to run the system.

### 2. System Overview

The library system consists of the management and maintenance of books available in an academic library. It allows three types of users (undergraduate students, graduate students, and professors) to borrow, return, and reserve available books.

A specific book may have more than one copy available in the library. Thus, it is possible to find two or more copies of the same book in the library.

Each book must have an identifying code and a title. In addition to the code and title, books must maintain the following additional information: publisher, authors, edition, and year of publication.

Each user must have an identification code and a name. Each of the three types of users has specific rules for borrowing books. These rules are detailed in the loan functionality description in Section 3 of this document. Additionally, each type of user is allowed a certain time period, in days, during which they can keep the borrowed book, according to Table 1. Whenever a book loan is requested in the library, that operation is recorded in the system, and a return date is set based on the loan time for that type of user.

| **User Type**       | **Loan Time**             |
|:-------------------:|:-------------------------:|
|   Undergraduate     |         3 days            |
| Graduate Student    |         5 days            |
|      Professor      |         7 days            |
**Table 1: Loan time for each user type**

Users also have the right to reserve books. The reservation of a book guarantees priority in borrowing it only among students, as will become clearer in the loan rules detailed in Section 3. The reservation must also be recorded in the system.

### 3. Functionalities

1. The system must allow book loans. During the loan process, the user will enter the command “emp” followed by the user code and the book code, separated by a space. Ex.: “emp 123 100”. If the user has a previously made reservation for that book, the reservation must be removed, and the loan must be completed. At the end of the procedure, the system should issue a success or failure message, mentioning the user's name and the book title. If it is a failure message, it should also mention the reason for the failure.

#### Loan Rules for Students.

The loan of a book will only be completed for an **undergraduate** or a **graduate student** if: (i) there is a copy of that book available in the library; (ii) the user is not “in debt” with an overdue book; (iii) the specific rules for that type of user regarding the maximum number of loans are followed, according to Table 2; (iv) the number of reservations for the book is less than the number of available copies, if the user does not have a reservation for it; (v) the number of reservations is greater than or equal to the number of copies, but one of the reservations belongs to the user; and (vi) the user does not have any ongoing loan of a copy of that same book.

|      User Type      | Maximum Number of Ongoing Loans |
|:-------------------:|:-------------------------------:|
|   Undergraduate     |            3 books              |
| Graduate Student    |            4 books              |
**Table 2: Limits on the number of borrowed books**

#### Loan Rules for Professors.

The loan of a book will only be completed for a **professor** if: (i) there is a copy of that book available in the library; and (ii) the user is not “in debt” with an overdue book. Note that professors are not denied loans if there are reservations for that book and do not have a limit on the number of books they can borrow.

It is known that in this type of domain, these rules are subject to frequent changes. Furthermore, new types of users may emerge for whom the loan rules are different from those already existing for professors and undergraduate and graduate students.

2. The system must allow the return of a book. During the return process, the user must enter the command “dev” followed by the identification code of the user and the identification code of the borrowed book. At the end, the system must issue a success or failure message for the return, mentioning the user's name and the book title. The failure message should state the reason. In this case, failure only occurs if there is no open loan for that book for that user.

3. The system must allow book reservations. During this reservation process, the user must enter the command “res,” the identification code of the user, and the identification code of the book the user wants to reserve. Reservations are only allowed for a maximum of 3 books per user. At the end, the system must issue a success or failure message for the reservation, mentioning the user's name and the book title. The failure message should state the reason.

4. The system must allow professors to register to be notified whenever a particular book has more than two simultaneous reservations. The professor registers as an “observer” of the desired book. Whenever the book has more than two simultaneous reservations, the book must “notify” the “observers.” The observer must simply record internally how many times they have been notified. In the future, the system may be evolved to allow other types of users, such as coordinators, who can also observe book reservations. Implement this functionality using a pattern that allows for easy future evolution. To register a professor as an observer of a book, the user must enter the command “obs” followed by the user code and the book code. There is no need to check if the user code actually refers to a professor.

5. The system must provide the following queries:

> a. Given the code of a book, the system must present its information as follows: (i) title, (ii) number of reservations for that book, and if greater than zero, the names of the users who made each reservation should also be presented, (iii) for each copy, its code, status (available or borrowed), and if the copy is borrowed, the name of the user who borrowed it, the loan date, and the expected return date should be displayed. To request this query, the user must enter the command “liv,” followed by the book code.

> b. Given a user, the system must present a list of all their current and past loans, as well as their reservations. The listing of each loan should present the book title, the loan date, the current status of that loan (ongoing or completed), and the actual or expected return date. The reservation listing should present the title of the reserved book and the date of the reservation request. To request this query, the user must enter the command “usu,” followed by the user code.

> c. Given a professor, the system must return the number of times they were notified about more than two simultaneous reservations on books observed by them. To request this query, the user must enter the command “ntf,” followed by the user code. There is no need to check if the code actually refers to a professor.

6. The user should have the option to exit the system. To do this, simply enter the command “sai.”

### 4. Design Requirements

1. The system should NOT be concerned with data persistence, that is, it should NOT use a database. The objects related to the test data (Section 7) should be instantiated in memory at system initialization.

2. The system should NOT have a graphical user interface. All commands should be provided via the command line, and their responses should be displayed on the console.

3. The project should have a class responsible for reading the commands and displaying the responses on the console. This class should be a Singleton.

4. The class from the previous item should communicate with the business classes through a command scheme, designed according to the “Command” design pattern.

5. Avoid using “if” or “switch” to determine the type of user you are dealing with, and **in particular, use a design pattern to implement the different rules for loan processing and avoid using ifs to select between the possible rules.**

### 5. Project Submission

The project must be developed in an object-oriented programming language and **done in pairs.**

In addition to the source code, the team must prepare a class diagram. The source code should be uploaded to the AVA by the project submission deadline. The class diagram and code must be presented on the day of the oral examination. The diagram should be legible. If necessary, it can be split into multiple pages. Suggested approach: one page showing the class that interacts with the user via console and the command classes, and another page showing the business classes.

#### Project Oral Examination:

The teams will meet individually with the professor to present and discuss the diagram and the source code.

### 6. Evaluation Criteria

During the oral examination, the professor will ask questions to each team member individually. The grade of one team member may differ from that of the other team member depending on their answers.

The project will be evaluated according to the following criteria:

- Consistent use of object-oriented concepts (inheritance, polymorphism, interfaces, association, etc.)
- Use of design patterns.
- Compliance with the project description.

---

---
# library-system-OOP
Small implementation of library system with OOP (Oriented Object Programing)

Pequena implementação de um sistema de biblioteca com POO (Programação Orientada a Objetos) 

## Compilando e executando o programa
Esteja na raiz desse diretório e rode os seguintes comandos para compilar e executar o programa:
* Compile
```bash
javac -d out -sourcepath src -cp src $(find src -name "*.java")
```

* Execute
```bash
java -cp out Main
```

## Visualizando o diagrama de classes
Para criar os diagramas de classe foi utilizado o utilitário [PlantUML](https://github.com/plantuml/plantuml).

Para visualizá-los vá a pasta "diagram classes" e rode o comando:
```bash
plantuml -o ../"out diagrams" main.puml
```

É necessário ter o [PlantUML](https://plantuml.com/starting) instalado, assim como o [GraphViz](https://plantuml.com/graphviz-dot) do qual ele depende. Se não sabe como fazê-lo, clique em um dos hiper-links ou veja a documentação completa [aqui](https://plantuml.com/).

---

## MATA62 – ENGENHARIA DE SOFTWARE I
#### Trabalho Prático
### 1. Objetivo
 
Neste trabalho, o aluno projetará e implementar um sistema de porte muito pequeno e não completo. O objetivo é permitir que os alunos usem seus conhecimentos em projeto orientado a objetos e programação orientada a objetos.

As Seções 2 e 3 descrevem os requisitos do sistema. A Seção 4 lista algumas exigências de projeto. A Seção 5 explica os critérios de avaliação. A Seção 6 descreve como será a entrega do trabalho. Finamente, a Seção 7 lista os dados de teste que devem ser usados na execução do sistema.

### 2. Visão Geral do Sistema

O sistema de biblioteca consiste no gerenciamento e manutenção de livros disponíveis em uma biblioteca acadêmica. Ele permite que três tipos de usuários (alunos de graduação, alunos de pós-graduação e professores) realizem o empréstimo, devolução e reserva de livros disponíveis.

Um livro específico pode dispor na biblioteca de mais de um exemplar. Assim, é possível encontrar na biblioteca dois ou mais exemplares de um mesmo livro.

Cada livro deve possuir um código que o identifique e um título. Além do código e do título, os livros devem manter as seguintes informações adicionais: editora, autores, edição e ano da publicação.

Cada usuário deve ter um código de identificação e nome. Cada um dos três tipos de usuários possui regras específicas para poder pegar livro emprestado. Essas regras são detalhadas na descrição da funcionalidade de empréstimo, na Seção 3 deste documento. Além disso, a cada tipo de usuário é permitido um determinado intervalo de tempo, em dias, durante o qual ele pode ficar com o livro   emprestado, conforme a Tabela 1. Sempre que o empréstimo de um livro é solicitado na biblioteca, é feito o registro daquela operação no sistema e é fixada uma data de devolução baseada no tempo de empréstimo do tipo de usuário.

| **Tipo de Usuário** | **Tempo de Empréstimo** |
|:-------------------:|:-----------------------:|
|   Aluno Graduação   |         3 dias          |
| Aluno Pós-Graduação |         5 dias          |
|      Professor      |         7 dias          |
**Tabela 1: Tempo de empréstimo de cada tipo de usuário**

Usuários têm também o direito de realizar reservas de livros. A reserva de um livro garante a prioridade no seu empréstimo apenas entre os alunos, como ficará mais claro nas regras de empréstimo, detalhadas na Seção 3. A reserva também tem que ser registrada no sistema.

### 3. Funcionalidades

1. O sistema deve permitir o empréstimo de livros. Durante o empréstimo, o usuário informará o comando “emp” seguido do código do usuário e do código do livro, separados por espaço em branco. Ex.: “emp 123 100”. Caso o usuário tenha uma reserva feita previamente por ele para o dado livro, a reserva deve ser excluída e o empréstimo efetivado. Ao final do procedimento o sistema deve emitir uma mensagem de sucesso ou insucesso, que mencione o nome do usuário e o título do livro. Se for uma mensagem de insucesso, ela deve também mencionar o motivo do insucesso.

#### Regra de Empréstimo para Aluno.

O empréstimo do livro só será concretizado para um **aluno de graduação** ou um **aluno de pós-graduação** se: (i) houver a disponibilidade de algum exemplar daquele livro na biblioteca; (ii) o usuário não estiver “devedor” de um livro em atraso; (iii) forem obedecidas as regras específicas daquele tipo de usuário no que se refere à quantidade máxima de empréstimos, de acordo com a Tabela 2; (iv) a quantidade de reservas existentes do livro for menor do que a quantidade de exemplares disponíveis, caso o usuário não tenha reserva para ele; (v) a quantidade de reservas for maior ou igual a de exemplares, mas uma das reservas é do usuário; e (vi) o usuário não tiver nenhum empréstimo em curso de um exemplar daquele mesmo livro.

|   Tipo de Usuário   | Limite de Empréstimos em Aberto |
|:-------------------:|:-------------------------------:|
|   Aluno Graduação   |            3 livros             |
| Aluno Pós-Graduação |            4 livros             |
**Tabela 2: Limites da quantidade de livros tomados como empréstimo**

#### Regra de Empréstimo para Professor.

O empréstimo do livro só será concretizado para um **professor** se: (i) houver a disponibilidade de algum exemplar daquele livro na biblioteca; e (ii) o usuário não estiver “devedor” de um livro em atraso. Note que os professores não tem empréstimo negado caso haja reservas para aquele livro e não tem limite da quantidade de livros que pode pegar emprestado.

É sabido que nesse tipo de domínio essas regras estão sujeitas a frequentes mudanças. Além disso, podem surgir novos tipos de usuário para os quais as regras de empréstimo sejam diferentes das já existentes para professor e alunos de graduação e de pós.

2. O sistema deve permitir a devolução de um dado livro. Durante a devolução, o usuário deve digitar o comando “dev” seguido do código de identificação do usuário e do código de identificação do livro emprestado. Ao final, o sistema deve emitir uma mensagem de sucesso ou insucesso da devolução, que mencione o nome do usuário e o título do livro. A mensagem de insucesso deve dizer o motivo. Nesse caso, o insucesso só ocorre se não houver empréstimo em aberto daquele livro para aquele usuário.


3. O sistema deve permitir a reserva de um livro. Durante esse processo de reserva, o usuário deve digitar o comando “res”, o código de identificação do usuário e o código de identificação do livro que o usuário deseja reservar. Será permitida a reserva de apenas 3 livros por usuário. Ao final, o sistema deve emitir uma mensagem de sucesso ou insucesso da reserva, que mencione o nome do usuário e o título do livro. A mensagem de insucesso deve dizer o motivo.


4. O sistema deve permitir que professores registrem que querem observar toda vez que determinado livro tiver mais de duas reservas simultâneas. O professor se registra como “observador” do livro que desejar. Toda vez que o livro tiver mais de duas reservas simultâneas, o livro deve “avisar” aos “observadores”. O observador deve simplesmente registrar internamente quantas vezes ele foi notificado. No futuro, o sistema pode ser evoluído de forma que permita outros tipos de usuários, por exemplo, coordenadores, que também possam observar a reserva de livros. Implemente essa funcionalidade usando um padrão que permita facilmente essa evolução no futuro. Para registrar um professor como observador de um livro, o usuário deve digitar o comando “obs” seguido do código do usuário e do código do livro. Não há necessidade de checar se o código do usuário se refere realmente a um professor.


5. O sistema deve fornecer as seguintes consultas:

> a. Dado o código de um livro, o sistema deve apresentar suas informações da seguinte forma: (i) título, (ii) quantidade de reservas para aquele livro, e, se diferente de zero, devem ser também apresentados o nome dos usuários que realizaram cada reserva, (iii) para cada exemplar, deve ser apresentado seu código, seu status (disponível ou emprestado), e em caso do exemplar estar emprestado deverá ser exibido o nome do usuário que realizou o empréstimo, a data de empréstimo e a data prevista para devolução. Para solicitar tal consulta, o usuário deverá digitar o comando “liv”, seguido do código do livro.

> b. Dado um usuário, o sistema deverá apresentar a lista de todos os seus empréstimos
correntes e passados, assim como de suas reservas. A listagem de cada empréstimo deverá
apresentar o título do livro, a data do empréstimo, o status atual daquele empréstimo (em
curso ou finalizado) e a data da devolução já realizada ou prevista. A listagem das
reservas deverá apresentar o título do livro reservado e a data da solicitação da reserva.
Para solicitar tal consulta, o usuário deverá digitar o comando “usu”, seguido do código
do usuário.

> c. Dado um professor, o sistema deve retornar a quantidade de vezes que ele foi notificado sobre mais de duas reservas simultâneas em livros observados por ele. Para solicitar tal consulta, o usuário deverá digitar o comando “ntf”, seguido do código do usuário. Não há necessidade de checar se o código se refere realmente a um professor.

6. O usuário deve ter a opção de sair do sistema. Para isso, basta digitar o comando “sai”.

### 4. Exigências de Projeto

1. O sistema NÃO deve se preocupar com a persistência de dados, ou seja, NÃO deve usar banco de    dados. Os objetos relativos aos dados de teste (Seção 7) deverão ser instanciados na memória no    momento da inicialização do sistema.


2. O sistema NÃO deve ter interface com o usuário gráfica. Todos os comandos deverão ser fornecidos via linha de comando, e suas respostas devem ser mostradas no console.


3. O projeto deve ter uma classe responsável por ler os comandos e mostrar as respostas no console. Essa classe deverá ser um Singleton.


4. A classe do item anterior deve se comunicar com as classes de negócio por meio de um esquema de comandos, projetados de acordo com o padrão de projeto “Command”.


5. Evite o uso de “if “ou “switch” para saber o tipo de usuário que está lidando e, **em particular, use algum padrão de projeto para implementar as diferentes regras para realização de empréstimo e evitar o uso de ifs para selecionar entre as possíveis regras.**

### 5. Quanto à Entrega do Trabalho

   O trabalho deve ser desenvolvido em uma linguagem orientada a objetos e **feito em duplas.**

   Além do código fonte, a equipe deverá elaborar o diagrama de classes. O código fonte deve ser colocado no AVA até o prazo para entrega do trabalho. O diagrama de classe e o código devem ser mostrados no dia da arguição. O diagrama deve estar legível. Se for necessário, pode quebrar o diagrama em mais de uma página. Sugestão: uma página mostrando a classe que faz a interação com usuário via console e as classes dos comandos, e outra página mostrando as classes de negócio.
   
#### Arguição sobre o projeto:

   As equipes irão se reunir individualmente com o professor para mostrar e discutir o diagrama e o código fonte.

### 6. Critérios de Avaliação

   Durante a arguição, o professor fará perguntas individuais a cada membro de cada dupla. A nota do trabalho de um membro de uma dupla pode ser diferente da nota do outro membro da mesma dupla a depender das respostas às perguntas.

   O projeto será avaliado de acordo com os seguintes critérios:


- Uso coerente dos conceitos de orientação a objetos (herança, polimorfismo, interfaces, associação etc)
- Uso de padrões de projeto.
- Conformidade com a descrição do trabalho.
