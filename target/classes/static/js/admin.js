var nomeAdmin = document.getElementById('apresentaNome');
var auxCliente = localStorage.getItem("cliente");
var cliente = JSON.parse(auxCliente);
var logado = localStorage.getItem('logado');

console.log(logado);

if (cliente  == null || cliente.tipoUsuario != 'administrador') {
     alert("Você não tem permissão para acessar está página.")

                   window.location.href = "/index"

             } else {
               nomeAdmin.innerHTML = cliente.nome;
             }








function sairDaPagina(){
         localStorage.clear();
         alert("Usuário Deslogado");
         window.location.href = "/index"

     }