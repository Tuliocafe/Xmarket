var logado = localStorage.getItem('logado');
var botaoLogin = document.getElementById('buttonLogin');
var carrinhoIcone = document.getElementById("carrinhoIndex");
var botaoSair = document.getElementById("botaoSair");
var venda = localStorage.getItem('venda');

 if (logado) {

     var auxCliente = localStorage.getItem("cliente");
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


btnVoltar.addEventListener('click', function(){
     window.location.href = "/area-cliente/"+cliente.id;

})

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