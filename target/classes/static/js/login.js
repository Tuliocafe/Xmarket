var email = document.getElementById('email');
var senha = document.getElementById('senha');
var buttonLogin = document.getElementById('buttonLogin');
var temVenda = localStorage.getItem('temVenda');
var venda = localStorage.getItem('venda');


buttonLogin.addEventListener('click', function(){
    localStorage.clear();
    var login = {
    "email": email.value,
    "senha": senha.value
    };

    var init = {
        method: 'POST',
        headers: { "Content-Type": 'application/json'},
        body: JSON.stringify(login)
    }

    var endPoint = 'http://localhost:8080/clientes/login';

   fetch(endPoint,init)
    .then(function(response) {

     if (response.status != 200) {

                    //conseguir o valor de retorno de uma promisse
                    console.log("RESPONSE.BODY");
                    console.log(response.body);
                    console.log("RESPONSE");
                    console.log(response);

                    console.log(response.text())
//                    console.log("response"+ response);
                     alert("Email ou senha inválidos");
        }


        return response.json();
    }).then(async function(data) {
                alert('success');
                localStorage.setItem("logado",true);
                localStorage.setItem("cliente", JSON.stringify(data));
                cliente = await data
                iniciarvenda();
//                window.location.href = "/index";
    }).catch(function(error) {
    alert(error)
//       window.location.href = "/login";
    });
})


async function iniciarvenda(){

        await verificaCarrinho()
        if (venda == null){
                cadastrarCarrinhio ()
            }
          window.location.href = "/index"
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

            fetch(endPoint, init).then(function (response) {
            return response.json();

            }).then( async function (data) {
               console.log(data);
                alert('success criacaoVenda');
                var venda = await localStorage.setItem("venda", JSON.stringify(data))
                console.log(venda);
//                alert(venda.id);
            })
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
    console.log(listavenda)

    if(listavenda != ''){
        venda = await listavenda[0].id
        console.log(venda)
        localStorage.setItem("venda", JSON.stringify(venda));
        }
   }