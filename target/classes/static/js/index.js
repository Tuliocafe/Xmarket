var logado = localStorage.getItem('logado');
var botaoLogin = document.getElementById('buttonLogin');
var carrinhoIcone = document.getElementById("carrinhoIndex");

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




function verificaLogin()
{
alert('verific');
if (logado) {
     if(localStorage.getItem('cliente') !=""){
         var auxCliente = localStorage.getItem("cliente");
         console.log(auxCliente);
         var cliente = JSON.parse(auxCliente);
     }
     }
     else {
        alert("Usuário não está logado")
        window.location.href = "/login";
     }

}


 if (logado) {

     if(localStorage.getItem('cliente') !=""){
     var auxCliente = localStorage.getItem("cliente");
     console.log(auxCliente);
     var cliente = JSON.parse(auxCliente);
//             alert(cliente.nome);
             botaoLogin.style.display = "none";
             carrinhoIcone.style.display = "flex";

     }
     else {
         botaoLogin.style.display = "flex";
         carrinhoIcone.style.display = "none";

     }
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