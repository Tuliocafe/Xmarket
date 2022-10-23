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
        return response.json();
    }).then(function(response) {
        console.log(data);
                alert('success');
                localStorage.setItem("logado",true);
                localStorage.setItem("cliente", JSON.stringify(data));
                window.location.href = "/index";
    }).catch(function(error) {
        console.log(JSON.parse(error));
    });
})


