var logado = localStorage.getItem('logado');
var botaoLogin = document.getElementById('buttonLogin');
var carrinhoIcone = document.getElementById("carrinhoIndex");
var botaoSair = document.getElementById("botaoSair");
var botaoAreaCliente = document.getElementById("buttonAreaCliente");
var venda = localStorage.getItem('venda');

var listaProdutos
var idProduto
getlistaProdutos()



//for (var i = 0; i <  listaProdutos.length; i ++ ){
//    console.log(listaProdutos[i].quantidade)
//
////    document.getElementById(idProduto).textContent = ("Sem Estoque");
////    document.getElementById(idProduto).disabled = true;
//}

async function getlistaProdutos(){
    var endPoint = "http://localhost:8080/produtos"
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
        var somaValorTotal = 0

        listaProdutos = await response.json()



        console.log(listaProdutos)
        console.log(listaProdutos[0].id_produto)

        for (var i = 0; i <  listaProdutos.length; i ++ ){
                if(listaProdutos[i].quantidade_produto == 0){
                    console.log(listaProdutos[i])
                    document.getElementById(listaProdutos[i].id_produto).textContent = ("Sem Estoque");
                    document.getElementById(listaProdutos[i].id_produto).disabled = true;
                    }
               }
}






var auxVenda = localStorage.getItem('venda')
var idVenda
var venda = JSON.parse(auxVenda);
var desconto = 0
setTimeout(sessao, 5000000);

var listavenda



async function botaoCarrinho(){
    await verificaLogin()
    await verificaCarrinho()
    if(idVenda != ''){
            window.location.href = "carrinho/" + idVenda

        }else{
        console.log("criar venda")
        await cadastrarCarrinhio()
        window.location.href = "carrinho/" + idVenda
        }
}


botaoSair.addEventListener('click', sairDaPagina);

     async function sairDaPagina(){
         await verificaCarrinho()
                try{
                         var init = {
                             method: 'DELETE',
                             headers: { "Content-Type": 'application/json'}
                         }

                         var endPoint = 'http://localhost:8080/vendas/' + idVenda

                         fetch(endPoint, init)
                    } finally {
                     localStorage.clear();
                     alert("Usuário Deslogado");
                     window.location.href = "/index"
                    }
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

    var response = await fetch(endPoint, init)
    console.log(response.status)
    if(response.status == 201){
        alert("Produto adicionado com sucesso")
        }else if (response.status == 412){
          alert("Produto já está no carrinho")
            }
        else{
     alert("Erro " + response.status + " ao incluir produto ")
        }
var data = await response.json()
}








function verificaLogin(){
if (logado) {
         var auxCliente = localStorage.getItem("cliente");
         var cliente = JSON.parse(auxCliente);
     }
     else {
        alert("Usuário não está logado")
        window.location.href = "/login";
     }
}


 if (logado) {

     var auxCliente = localStorage.getItem("cliente");
     var cliente = JSON.parse(auxCliente);

             botaoSair.style.display = "flex";
             botaoLogin.style.display = "none";
             carrinhoIcone.style.display = "flex";
             botaoAreaCliente.style.display = "flex";

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
         botaoAreaCliente.style.display = "none";

     }

    // Verifica se o usuario é um administrador e deixa visivel ou nao o botão admin
     function verificaAdmin(){
     var Cliente = localStorage.getItem("cliente");
               console.log(auxCliente);
               var cliente = JSON.parse(auxCliente);
      if (logado && Cliente.tipoUsuario == "administrador") {

          botaoAdmin.style.display = "flex";

          }
          else {
             botaoAdmin.style.display = "none";

          }
}




// } else {
//
//     window.location.href = "/index";
// }




async function sessao(){
         await verificaCarrinho()

                //Se o cliente tiver venda em aberto ele vai cancelar a venda
                try{
                         var init = {
                             method: 'DELETE',
                             headers: { "Content-Type": 'application/json'}
                         }

                         var endPoint = 'http://localhost:8080/vendas/' + idVenda

                         fetch(endPoint, init)
                    } finally {
                     localStorage.clear();
                     window.location.href = "/index"
                     alert("Usuário Deslogado");
                    }
}



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

}


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

//    console.log(listavenda)
    if(listavenda != ''){
        idVenda = await listavenda[0].id
        localStorage.setItem("venda", JSON.stringify(listavenda[0]));
        }else{idVenda = ''}
}


function btnAreaCliente (){

      window.location.href = '/area-cliente/'+cliente.id

}