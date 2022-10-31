 var logado = localStorage.getItem('logado');

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