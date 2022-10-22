var logado = localStorage.getItem('logado');

var botaoLogin = document.getElementById('buttonLogin');
var carrinhoIcone = document.getElementById("carrinhoIndex");

setTimeout(sessao, 5000000);


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
             alert(cliente.nome);
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