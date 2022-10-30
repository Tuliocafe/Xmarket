#  XMarket 
<fig>
<img src="https://user-images.githubusercontent.com/25533217/198898706-7ab0d961-585e-4972-a9e0-62238102400a.png" alt="Uma imagem relacionada ao projeto">
<figcaption>Página inicial XMarket</figcaption>
</fig>

## Inicialização
Para executar o projeto, utilize as ferramentas descritas na sessão *Ferramentas*.

## Ferramentas
* [IntelliJ](https://www.jetbrains.com/idea/) - IDE para desenvolvimento.

## Links importantes
* [Spring Boot Rest API](https://spring.io/projects/spring-boot) -  Spring Boot.

#  XMarket 

## Introdução

> A empresa XMarket lançou um novo serviço de vendas online de produtos e deseja gerar relatórios de testes de unidade relacionados a parte de cadastro de Clientes. Os Clientes devem realizar seu cadastro através da aplicação e apenas assim estarão habilitados para realizarem e confirmarem suas compras. O desafio consiste em construir na linguagem Java a parte operacional da aplicação e um Web Service que seja capaz de manipular as informações da classe Cliente. Após isso, a equipe deverá executar, no mínimo, dois testes estruturais demonstrando a estabilidade, segurança e confiabilidade desse cadastro.

Este projeto possui o objetivo principal **Desenvolver um sistema funcional de um E-commerce**.  
Com os objetivos gerais de realizar a venda de **Produtos**, cadastrados no site  e realizar o controle do estoque verificação de **estoque**. 

## Análise técnica

### Descrição do ambiente técnico

O sistema é composto por um banco de dados, uma interface web e uma API de consumo interna. As funcionalidades principais são :

* **F1** - Compra de produtos.
* **F2** - Controle de Usuários
* **F3** - Controle de Produtos
* **F4** - Controle de Marcas
* **F5** - Controle de Estoque
* **F6** - Relatório de Vendas geral e por filtro





As ferramentas utilizadas para o desenvolvimento incluem **Java** que é uma linguagem de programação utilizada para o Back-end, para front-end foi utilizado **HTML**, **CSS**, **JavaScript**, **Bootstrap**, **Thymeleaf** . **Mysql** atuando como sistema gerenciador de banco de dados relacional e **Spring Boot** para utilizar o ambiente de desenvolvimento web.

### Levantamento de requisitos  
> Os requisitos foram  validados com o cliente e aprovados.

### Requisitos Funcionais
Respeitando a proposta, o sistema deverá atender os seguintes requisitos:

* **RF1** - O cliente cria um pedido de venda.
* **RF2** - O cliente Realiza a exclusão do carrinho.
* **RF3** - O cliente Realizar modificações no pedido.
* **RF3** - O cliente Realizar modificações dos seus dados cadastrados.
* **RF5** - Página administrativa - Realiza Controle de Marcas.
* **RF6** - Página administrativa - Realiza Controle de Produtos.
* **RF7** - Página administrativa - Geração de  relatórios de vendas.


## Regras de Negócio



_Realização da compra de um Produto_  

**RGN1** -  Somente clientes com cadastro ativo e logado estarão habilitados para realizarem e confirmarem suas compras.

**RGN2** -  Ao realizar o login na página, é criada uma nova venda com status pendente. 

**RGN3** -  Caso o cliente faça o logout da página, a venda  pendente é cancelada. 

**RGN4** -  Ao finalizar o carrinho de compras, a venda é concluída com sucesso. 

**RGN5** -  O cliente deve possuir necessariamente: Nome, E-mail, Telefone, CPF, RG e Endereço.



_Controle de Estoque_  

**RGN6** - Ao adicionar um produto no carrinho, é reservado para o cliente a quantidade um do produto.

**RGN7** - Ao finalizar a venda, a quantidade dos produtos que estiverem no carrinho de compra são atualizados no estoque.

**RGN8** - Ao cancelar uma venda, a quantidade reservada dos produtos no carrinho de compra é retornada para o estoque.

**RGN9** - Produtos sem estoque são impedidos de serem adicionados no carrinho de compra. 



_Acesso ao site_  

**RGN10** - A sessão do usuário logado no site possui o limite de  1 hora e 38 minutos.

**RGN11** - Caso a sessão do site expire, a venda é cancelada. 

**RGN12** - Existe uma conta padrão para o usuário administrador. 


## Casos de Uso

**UC** - *Sistema XMarket*

<img src="https://user-images.githubusercontent.com/25533217/198898785-535087cd-b7b9-4d80-a908-beffa7c43885.png">


### Mensagens internas

Rotas utilizadas pela aplicação web para executar metodos de **POST** , **GET** , **PUT** e **DELETE** no banco de dados. Onde o retorno de cada uma das funções será contido em uma sessão para renderização de páginas web.

> Aqui ficam descritos os endpoints: 

* [Swagger]( http://localhost:8080/swagger-ui.html) -  Swagger presente no localhost da aplicação. 





## Conceitos básicos
> [Design pattern](https://en.wikipedia.org/wiki/Software_design_pattern) - Design Patterns ou padrões de projetos que foram utilizados no desenvolvimento do sistema.

> [MVC](https://pt.wikipedia.org/wiki/MVC) - MVC é o acrônimo de Model-View-Controller é um padrão de projeto de software.  As regras de negócio ficam relacionadas à pasta Service, e os endpoints 

> [Inversão de controle](https://pt.wikipedia.org/wiki/Invers%C3%A3o_de_controle) - Trata-se do redirecionamento do fluxo de execução de código retirando parcialmente o controle sobre ele e delegando-o para um container. 

> [Injeção de dependência](https://pt.wikipedia.org/wiki/Inje%C3%A7%C3%A3o_de_depend%C3%AAncia) - É um padrão de desenvolvimento com a finalidade de manter baixo o nível de acoplamento entre módulos de um sistema. O Container do SPRING injeta as dependências  (objetos) que sua aplicação necessita.

> [Singleton](https://pt.wikipedia.org/wiki/Singleton) - o container do spring define apenas uma instância do objeto. Exemplos do Spring  @Bean  e @Autowired 


> [Strategy](https://en.wikipedia.org/wiki/Strategy) - categorizado como um padrão comportamental de desenvolvimento de software.  De modo que delega as responsabilidades adquiridas pelas entidades, atribuindo, portanto, o comportamento. Exemplos do Spring  @Service e @Repository 

> [Facade](https://pt.wikipedia.org/wiki/Fa%C3%A7ade) -  Construiremos uma API REST com o mesmo Objetivo desse padrão, abstrair a complexidade das seguintes integrações : Spring Data JPA e ViaCEP

