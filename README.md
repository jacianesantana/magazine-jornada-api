# Magazine Jornada [em desenvolvimento]
O Magazine Jornada é um e-commerce focado em vender produtos para computadores, celulares e notebooks em geral.

## Projeto Jornada Tech v2 com o mentor Maicon Gerardi 
- Desenvolvedores: Bruno Alves, Guilherme Militão, Jaciane Santana e Pedro Andrade

## Requisitos Funcionais
### Funcionalidade Geral
1. Cadastrar Usuário:
- Tipo de usuários: Cliente e Parceiro
- Campos: tipo, nome, e-mail, foto de perfil e senha

### Funcionalidades de Parceiro
1. Cadastrar Produtos:
- Campos: título, descrição, quantidade, valor unitário e foto
2. Listar Produtos Cadastrados (página inicial):
- Podem visualizar seus produtos cadastrados
- Pode editar ou excluir esses produtos, mas não deve ser possível excluir um produto já comprado e só deve ser possível editar o nome, descrição e título do produto
	
### Funcionalidades de Cliente
1. Visualizar todos os produtos cadastrados (página inicial):
- Campos da listagem: foto, valor e título e vendedor
- Pode filtrar pelo nome do produto
- Pode filtrar pelo valor inicial e final
- Pode filtrar pelo nome do vendedor
2. Visualizar produtos:
- Pode ver a foto do produto, descrição, quantidade, valor unitário e vendedor
- Ao comprar o produto, deve solicitar a quantidade e adicionar ao carrinho, sendo que antes de adicionar ao carrinho deve verificar se a quantidade é maior do que a disponível
3. Carrinho de compras:
- Deve listar a listagem de produtos adicionados ao carrinho com os campos: foto do produto, nome produto, valor unitário, quantidade e valor total do item
- Deve conter o valor total da compra	(soma de todos os itens da compra)
- Pode adicionar ou remover produtos ao carrinho de compras 
- Pode finalizar a compra e efetuar o pagamento, ao finalizar uma compra, deve ser descontado o valor do produto disponível em estoque
- Deve ser possível limpar o carrinho de compras
4. Visualizar pedidos:
- Pode visualizar todos os pedidos realizados
- Pode cancelar um pedido

## Antes de executar a aplicação, é necessário:
1. Ter o Docker instalado
2. Java 11
3. Baixar a imagem do Postgres com o comando: docker pull postgres
4. Subir o container na sua máquina com o comando: sudo docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=root -e POSTGRES_DB=postgresdb -d postgres

## Stack
- Java 11
- Spring Boot
- Lombok
- PostgreSQL
- Docker
