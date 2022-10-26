var nomeAdmin = document.getElementById('apresentaNome');
var auxCliente = localStorage.getItem("cliente");
var cliente = JSON.parse(auxCliente);
var logado = localStorage.getItem('logado');


if (logado) {
    nomeAdmin.innerHTML = cliente.nome;
             } else {
                alert("Você não tem permissão para acessar está página.")

               window.location.href = "/index"
             }








function sairDaPagina(){
         localStorage.clear();
         alert("Usuário Deslogado");
         window.location.href = "/index"

     }