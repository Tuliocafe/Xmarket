var logado = localStorage.getItem('logado');
var botaoLogin = document.getElementById('buttonLogin');
var carrinhoIcone = document.getElementById("carrinhoIndex");
var botaoSair = document.getElementById("botaoSair");

setTimeout(sessao, 5000000);


var venda
var usuario = 209
var listavenda


verificaCarrinho()

async function verificaCarrinho(){

    var endPoint = "http://localhost:8080/vendas/usuario/" + usuario
    init = {
            method: "GET",
            mode: 'cors',
            cache: 'no-cache',
            credentials: 'same-origin',
            headers: {
                'Content-Type': 'application/json'
            },
            referrerPolicy: 'no-referrer',
        }

            var response = await fetch(endPoint, init);
            listavenda = await response.json();

        try{
        venda = await listavenda[0].id
        console.log(venda)
        }catch(e){

        console.log("Nao tem venda aberta")
        }

}




function addItem(idproduto){

    var idproduto = idproduto
    console.log(idproduto)

        var item = {
                       "quantidade": 1,
                       "desconto": 0,
                       "idVenda": venda,
                       "idProduto": idproduto
                   };

        var init = {
            method: 'POST',
            headers: { "Content-Type": 'application/json'},
            body: JSON.stringify(item)
        }

        var endPoint = 'http://localhost:8080/vendas/'+ venda +'/item'

    fetch(endPoint, init).then(function (response) {
    return response.json();

    }).then(function (data) {
    console.log(data);
        alert('Produto adicionado com sucesso');
            })
}

         //pega a informação do login do usuário
        var logado = localStorage.getItem('logado');

        if (logado) {
             var auxCliente = localStorage.getItem("cliente");
             var cliente = JSON.parse(auxCliente);
         }




function verificaLogin()
{
alert('verific');
if (logado) {

         var auxCliente = localStorage.getItem("cliente");
         console.log(auxCliente);
         var cliente = JSON.parse(auxCliente);

     }
     else {
        alert("Usuário não está logado")
        window.location.href = "/login";
     }

}


 if (logado) {

     var auxCliente = localStorage.getItem("cliente");
     console.log(auxCliente);
     var cliente = JSON.parse(auxCliente);

        botaoSair.style.display = "flex";
             botaoLogin.style.display = "none";
             carrinhoIcone.style.display = "flex";

     }
     else {
         botaoLogin.style.display = "flex";
         carrinhoIcone.style.display = "none";
         botaoSair.style.display = "none";


     }



     botaoSair.addEventListener('click', sairDaPagina);

     function sairDaPagina(){
         localStorage.clear();
         alert("Usuário Deslogado");
         window.location.href = "/index"

     }

// } else {
//
//     window.location.href = "/index";
// }




function sessao(){
    localStorage.clear();
    alert("O usuário está deslogado");
    window.location.href = "/index"
}


//Cria uma venda no banco de dados

var botaoCarrinho = document.getElementById('botaoCarrinho');

var auxCliente = localStorage.getItem("cliente");
var cliente = JSON.parse(auxCliente);

console.log(cliente);
console.log(cliente.id);



botaoCarrinho.addEventListener('click', function(){
    var novaVenda = {

    "idCliente": cliente.id,
    "statusVenda": 2

    };

    var init = {
        method: 'POST',
        headers: { "Content-Type": 'application/json'},
        body: JSON.stringify(novaVenda)
    }

var endPoint = 'http://localhost:8080/vendas'

    fetch(endPoint, init).then(function (response) {
    return response.json();

    }).then(function (data) {
       console.log(data);
        alert('success criacaoVenda');
        var auxVenda = localStorage.setItem("venda", JSON.stringify(data))
        var vendaCriada =  JSON.parse(auxCliente);
        console.log(vendaCriada);
        alert(vendaCriada.id);
        window.location.href = "/index"

    })
})


