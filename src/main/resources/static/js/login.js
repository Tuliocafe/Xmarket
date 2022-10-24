var email = document.getElementById('email');
var senha = document.getElementById('senha');
var buttonLogin = document.getElementById('buttonLogin');

buttonLogin.addEventListener('click', function(){
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

//                    console.log("body " + response.body);
//                    console.log("headers" + response.headers);

                    //conseguir o valor de retorno de uma promisse
                    console.log("RESPONSE.BODY");
                    console.log(response.body);
                    console.log("RESPONSE");
                    console.log(response);

                    console.log(response.text())
                    console.log(response.text());

//                    console.log("response"+ response);
                     alert("Email ou senha inválidos");
        }


        return response.json();
    }).then(function(data) {
        console.log(data);
                alert('success');
                localStorage.setItem("logado",true);
                localStorage.setItem("cliente", JSON.stringify(data));
                window.location.href = "/index";
    }).catch(function(error) {
    alert(error)
//       window.location.href = "/login";
    });
})


