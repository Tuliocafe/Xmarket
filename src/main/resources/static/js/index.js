var logado = localStorage.getItem('logado');
var botaoLogin = document.getElementById('buttonLogin');
var carrinhoIcone = document.getElementById("carrinhoIndex");
var botaoSair = document.getElementById("botaoSair");
var auxVenda = localStorage.getItem('venda')
var idVenda
var venda = JSON.parse(auxVenda);
var desconto = 0
setTimeout(sessao, 5000000);

var listavenda




//verificaCarrinho()

//async function verificaCarrinho(){
//
//    var endPoint = "http://localhost:8080/vendas/usuario/" + usuario
//    init = {
//            method: "GET",
//            mode: 'cors',
//            cache: 'no-cache',
//            credentials: 'same-origin',
//            headers: {
//                'Content-Type': 'application/json'
//            },
//            referrerPolicy: 'no-referrer',
//        }
//
//            var response = await fetch(endPoint, init);
//            listavenda = await response.json();
//
//        try{
//        venda = await listavenda[0].id
//        console.log(venda)
//        }catch(e){
//
//        console.log("Nao tem venda aberta")
//        }
//}


async function botaoCarrinho(){
    await verificaLogin()
    await verificaCarrinho()
    if(idVenda != ''){
            window.location.href = "carrinho/" + idVenda

        }else{
        venda.
        console.log("criar venda")
        await cadastrarCarrinhio()//.then(function(idVenda){console.log(idVenda)})
        window.location.href = "carrinho/" + idVenda
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


async function addItem(idproduto){

    await verificaLogin()
    await verificaCarrinho()
    if(idVenda != ''){
        }else{
        await cadastrarCarrinhio()
        }

    var idproduto = idproduto
        var item = {
                       "quantidade": 1,
                       "desconto": desconto,
                       "idVenda": idVenda,
                       "idProduto": idproduto
                   };
        var init = {
            method: 'POST',
            headers: { "Content-Type": 'application/json'},
            body: JSON.stringify(item)
        }

        var endPoint = 'http://localhost:8080/vendas/'+ idVenda +'/item'

    fetch(endPoint, init).then(function (response) {
    return response.json();

    }).then(function (data) {
    console.log(data)

    alert("Produto já está no carrinho")
//    if(data.status == 201){
//        alert('Produto adicionado com sucesso');
//        }
//
//    else if(data.status == "xxx"){
//        alert("Produto já está no carrinho")
//            }
//    else{
//    alert("Erro ao incluir produto")}
})
}







function verificaLogin()
{
if (logado) {
         var auxCliente = localStorage.getItem("cliente");
         var cliente = JSON.parse(auxCliente);
     }
     else {
        alert("Usuário não está logado")
        window.location.href = "/login";
     }

}


function sessao(){
    localStorage.clear();
    alert("O usuário está deslogado");
    window.location.href = "/index"
}


//Cria uma venda no banco de dados

//var botaoCarrinho = document.getElementById('botaoCarrinho');

//var auxCliente = localStorage.getItem("cliente");
//var cliente = JSON.parse(auxCliente);
//
//console.log(cliente);
//console.log(cliente.id);


async function cadastrarCarrinhio (){
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

        var response = await fetch(endPoint, init);

        dados = await response.json()
        venda = await localStorage.setItem("venda", JSON.stringify(dados))
        idVenda = await dados.id

//        alert('success criacaoVenda');

}



//async function cadastrarCarrinhio (){
//
//            var novaVenda = {
//
//            "idCliente": cliente.id,
//            "statusVenda": 2
//
//            };
//
//            var init = {
//                method: 'POST',
//                headers: { "Content-Type": 'application/json'},
//                body: JSON.stringify(novaVenda)
//            }
//
//        var endPoint = 'http://localhost:8080/vendas'
//
//            fetch(endPoint, init).then(function (response) {
//
//            data = response.json();
//
//            }).then( async function (data) {
//                alert('success criacaoVenda');
//                var vendaAuxiliar = await data
//                venda = await localStorage.setItem("venda", JSON.stringify(data))
//                console.log("gerando o id")
//                idVenda = await vendaAuxiliar.id
//                console.log(idVenda)
//                return(vendaAuxiliar.id)
////                alert(venda.id);
//            })
//}





async function verificaCarrinho(){


    var endPoint = "http://localhost:8080/vendas/usuario/" + cliente.id
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
    console.log(response)
    console.log(response.status)
    listavenda = await response.json();

//    console.log(listavenda)
    if(listavenda != ''){
        idVenda = await listavenda[0].id
        localStorage.setItem("venda", JSON.stringify(listavenda[0]));
        }else{idVenda = ''}
   }

