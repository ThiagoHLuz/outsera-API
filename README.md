# gra-api
API RESTful para consulta e manutenção da lista de indicados e vencedores da categoria Pior Filme do Golden Raspberry Awards.

## Requisitos
Para execução do projeto, é necessário instalação do JDK 11.
O passo-a-passo abaixo foi feito com base no Intellij.

## Para executar o projeto
Para executar o projeto, nenhuma instalação externa é necessária. A aplicação cria o banco de dados e o popula com os dados do arquivo movielist.csv, 
que se encontra em *src/main/resources/*.
1. Clone o repositório o faça download;

2. Abrir o IntelliJ IDEA:
   1. Inicie o IntelliJ IDEA.
   2. Abrir o Projeto OutseraApi:
      - Vá para File > Open.
      - Navegue até a pasta do seu projeto e selecione o arquivo pom.xml.
      - Clique em Open as Project.

3. Configurar o Maven
   1. Confirmar a Estrutura do Projeto:
      - Certifique-se de que o IntelliJ reconheceu corretamente a estrutura do projeto Maven.
      - No painel lateral esquerdo, você deve ver uma seção chamada Maven com os detalhes do projeto.
   2. Configurar o JDK:
      - Vá para File > Project Structure.
      - Na seção Project, selecione o JDK correto (por exemplo, JDK 11).
      - Confirme se o JDK está corretamente configurado em Modules > Dependencies.

4. Compilar o Projeto
   1. Compilar com Maven:
      - No painel Maven (lado direito da tela), expanda o seu projeto.
      - Expanda Lifecycle.
      - Clique duas vezes em compile para compilar o projeto.

5. Executar o Projeto Maven via Linha de Comando (Opcional)
   1. Abrir o Terminal no IntelliJ:
      - Vá para View > Tool Windows > Terminal.
   2. Executar Comandos Maven:
      - Para compilar o projeto: mvn compile.
      - Para executar os testes: mvn test.



## EndPoints
Os EndPoints disponíveis são:
```sh
    GET: http://localhost:8080/movie/{id}
``` 
```sh
    GET: http://localhost:8080/producer/awards-interval
```    

## Testes
1. Executar os Testes
   1. Executar Todos os Testes:
      - No painel Maven, expanda Lifecycle.
      - Clique duas vezes em test para executar todos os testes.

2. Executar Testes Individualmente
   1. Executar Testes de uma Classe Específica:
      - No painel Project (lado esquerdo), navegue até a pasta src/test/java.
      - Encontre a classe de teste que deseja executar.
      - Clique com o botão direito do mouse na classe de teste e selecione Run 'ClassName'.
   2. Executar um Teste Específico:
      - Abra a classe de teste.
      - Clique com o botão direito do mouse no método de teste que deseja executar e selecione Run 'MethodName'.

3. Verificar os Resultados dos Testes
   1. Conferir Resultados:
      - Após executar os testes, o IntelliJ exibirá a janela Run com os resultados dos testes.
      - Verifique se todos os testes passaram. Se algum teste falhou, o IntelliJ mostrará detalhes do erro.

4. Configurar e Executar a Suíte de Testes
   1. Criar uma Classe de Suíte de Testes:
      - Se você ainda não criou, siga o exemplo de uma suíte de testes JUnit mencionada anteriormente.
   2. Executar a Suíte de Testes:
      - Navegue até a classe ApplicationTests.
      - Clique com o botão direito do mouse na classe e selecione Run 'ApplicationTests'.