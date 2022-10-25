var logado = localStorage.getItem('logado');
var botaoLogin = document.getElementById('buttonLogin');
var carrinhoIcone = document.getElementById("carrinhoIndex");
var botaoSair = document.getElementById("botaoSair");

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
            console.log('tem valor')
            console.log(idVenda)
        }else{
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
        console.log("criar venda")
        await cadastrarCarrinhio()
        }

    var idproduto = idproduto
    console.log(idproduto)
    console.log(venda)
        var item = {
                       "quantidade": 1,
                       "desconto": 0,
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
    console.log(data);
        alert('Produto adicionado com sucesso');
            })
}







function verificaLogin()
{
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

             if(cliente.tipoUsuario != 'administrador'){
              botaoAdmin.style.display = "none";
             } else {
             botaoAdmin.style.display = "flex";
             }
     }
     else {
         botaoLogin.style.display = "flex";
         carrinhoIcone.style.display = "none";
         botaoSair.style.display = "none";
          botaoAdmin.style.display = "none";


     }

     //Verifica se o usuario é um administrador e deixa visivel ou nao o botão admin
//     function verificaAdmin(){
//     var Cliente = localStorage.getItem("cliente");
//               console.log(auxCliente);
//               var cliente = JSON.parse(auxCliente);
//      if (logado && Cliente.tipoUsuario == "administrador") {
//
//
//          botaoAdmin.style.display = "flex";
//
//          }
//          else {
//             botaoAdmin.style.display = "none";
//
//          }
//}




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
    listavenda = await response.json();
    console.log(listavenda)

    if(listavenda != ''){
        idVenda = await listavenda[0].id
        console.log(idVenda)
        localStorage.setItem("venda", JSON.stringify(listavenda[0]));
        }else{idVenda = ''}
   }

