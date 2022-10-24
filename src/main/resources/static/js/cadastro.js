

var nome = document.getElementById('nome');
var sobrenome = document.getElementById('sobrenome');
var cpf = document.getElementById('cpf');
var rg = document.getElementById('rg');
var dataNascimento = document.getElementById('dataNascimento');
var telefoneUm = document.getElementById('telefoneUm');
var telefoneDois = document.getElementById('telefoneDois');
var email = document.getElementById('email');
var senha = document.getElementById('senha');
var senhaDois = document.getElementById('senhaDois');
var btnInscrever = document.getElementById('btnInscrever');

console.log('inicio')

btnInscrever.addEventListener('click', function(){
    if(senha.value!=senhaDois.value){
    alert('Senhas não conferem')
    }
        else {
    var cadastro = {

        "nome": nome.value,
        "sobrenome": sobrenome.value,
        "cpf": cpf.value,
        "rg": rg.value,
        "dataNascimento": dataNascimento.value,
        "telefoneUm": telefoneUm.value,
        "telefoneDois": telefoneDois.value,
        "email": email.value,
        "senha": senha.value
    };

    var init ={
        method: 'POST',
        headers: { "Content-Type":'application/json'},
        body: JSON.stringify(cadastro)
    }

    var endpoint = 'http://localhost:8080/clientes'
    console.log("teste")
    fetch(endpoint, init).then(function(response){
        return response.json();

    }).then(function (data) {
          console.log(data);
          alert("Dados cadastrados com sucesso!")

          })

          window.location.href = "/login"

    }
})
