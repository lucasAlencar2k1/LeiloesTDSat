## Sistema de Leilões
sistema desenvolvido em Java (utilizando a interface gráfica Swing) para o gerenciamento e cadastro de produtos de um leilão. O projeto segue o padrão DAO (Data Access Object) para se conectar e salvar as informações em um banco de dados MySQL.
---
## Tecnologias Utilizadas
Java (JDK)

Java Swing (Interface Gráfica)

MySQL (Banco de dados)

JDBC (Conexão com o banco)
---
## Estrutura do Projeto
cadastroVIEW.java: Tela inicial para cadastrar o nome e o valor de um produto.

listagemVIEW.java: Tela que exibe a tabela com todos os produtos e a opção de vender.

conectaDAO.java: Faz a conexão com o banco de dados MySQL.

ProdutosDAO.java: Contém a lógica de persistência (comandos SQL para cadastrar e listar).

ProdutosDTO.java: Objeto que representa o modelo de dados de um Produto.