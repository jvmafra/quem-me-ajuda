# DACA - Projeto Quem me ajuda

O QUEM ME AJUDA (QMA) tem como objetivo aproximar alunos que precisam de ajuda em disciplinas dos demais alunos capacitados para oferecer ajuda. No QMA o aluno pode realizar seu cadastro e se colocar como tutor. O sistema deve dar suporte a listagem de alunos e tutores e deve permitir a criação de AJUDAS.

## User stories

### US1 - Cadastro de alunos

Como sistema, deve ser possível cadastrar alunos para que os mesmos fiquem registrados e possam ser recuperados pela matrícula.
Cada aluno é identificado unicamente pela matrícula e tem um nome, código do curso, telefone e e-mail.

### US2 - Login de alunos

Como aluno cadastrado, deve ser possível logar no sistema utilizando a matrícula e a senha cadastradas previamente. Alunos logados podem acessar a lista de outros alunos cadastrados, tutores e consultar horários e locais disponíveis para tutoria.

### US3 - Disponibilização de tutoria

Como aluno, quero poder me disponibilizar como tutor para que eu possa atender ajudas de outros alunos de acordo com minha proficiência. Apenas alunos previamente cadastrados pordem torna-se um tutor.

### US4 - Disponibilização de locais e horários

Como tutor, quero disponibilizar meus locais e horários para que eu possa atender alunos de acordo com minha disponibilidade.
Cada tutor deve cadastrar um conjunto de locais (identificados por nome) e um conjunto de dias disponíveis. O tutor deve indicar sua disponibilidade nos dias úteis da semana (seg, ter, qua, qui, sex).

### US5 - Cadastrar pedidos de ajuda

Como aluno, quero pedir ajuda presencial ou online de forma que um tutor possa me atender de acordo com a minha necessidade.
Um aluno (seja tutor ou não) pode cadastrar um pedido de ajuda. Existem dois tipos de pedidos, o pedido de ajuda presencial e o pedido de ajuda online.

Na ajuda presencial, o aluno indica a disciplina e dia que quer uma ajuda e o local que tem interesse. Ao realizar um pedido no sistema, o sistema deve associar um tutor a esse pedido. O tutor escolhido precisa ter proficiência na disciplina e disponibilidade no local e no horário/dia indicado. Caso mais de um tutor esteja disponível naquele dia, o primeiro tutor encontrado pelo sistema será retornado. O mesmo tutor pode ser retornado para vários pedidos de ajuda diferentes.

Na ajuda online, a interação irá acontecer via email (ou hangouts) sem necessidade de disponibilidade de horário. Há necessidade de especificar apenas a disciplina de interesse da ajuda. O tutor associado deve ter proficiência nessa disciplina. Em caso de empate, o primeiro tutor encontrado pelo sistema  retornado para ajuda.

Ao cadastrar um pedido, é retornado um ID referente a ajuda marcada. Deve ser possível pegar informações sobre esse pedido de ajuda (qual foi a disciplina, dia e local de interesse). Deve ser possível pegar a matrícula do tutor que atenderá aquela ajuda, bem como pegar informações sobre a ajuda em si (horário, dia, local e disciplina).


## Como rodar

Da pasta principal /quem-me-ajuda, rodar:

`$ mvn spring-boot:run`







