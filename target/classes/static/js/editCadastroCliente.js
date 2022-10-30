var logado = localStorage.getItem('logado');

if (logado) {
     var auxCliente = localStorage.getItem("cliente");
     var cliente = JSON.parse(auxCliente);

 }

var id = parseInt(cliente.id);
var nome = document.getElementById('nome');
var sobrenome = document.getElementById('sobrenome');
var rg = document.getElementById('rg');
var dataNascimento = document.getElementById('dataNascimento');
var telefoneUm = document.getElementById('telefoneUm');
var telefoneDois = document.getElementById('telefoneDois');
var email = document.getElementById('email');
var senha = document.getElementById('senha');
var cpf = document.getElementById('cpf');
var senhaDois = document.getElementById('senhaDois');
var btnSalvar = document.getElementById('btnSalvar');
var btnInscrever = document.getElementById('btnInscrever');



btnSalvar.addEventListener('click', function(){
    if(senha.value != senhaDois.value){
    alert('Senhas não conferem')
    return;
    }
    if(nome.value === ""||sobrenome.value ===""||rg.value ===""||dataNascimento.value === ""||telefoneUm.value ===""||cpf.value===""){
    alert('Há campo(s) obrigatório(s) não preenchido(s)!')
    }else{

    if(senha.value == ""){
        var cadastro = {
            "id": id,
            "nome": nome.value,
            "sobrenome": sobrenome.value,
            "rg": rg.value,
            "dataNascimento": dataNascimento.value,
            "telefoneUm": telefoneUm.value,
            "telefoneDois": telefoneDois.value,
            "email": cliente.email,
            "cpf": cpf.value,
            "senha": cliente.senha
            };
    }else {
        var cadastro = {
            "id": id,
            "nome": nome.value,
            "sobrenome": sobrenome.value,
            "rg": rg.value,
            "dataNascimento": dataNascimento.value,
            "telefoneUm": telefoneUm.value,
            "telefoneDois": telefoneDois.value,
            "email": email.value,
            "cpf": cpf.value,
            "senha": senha.value
            };
}
        var init ={
            method: 'PUT',
            headers: { "Content-Type":'application/json'},
            body: JSON.stringify(cadastro)
        }

        var endpoint = 'http://localhost:8080/clientes/'+id

        fetch(endpoint, init).then(function(response){

        return response.json();


        }).then(function (data)     {
              console.log(data);
                alert("Alteração realizada!")
              })

              }
          })


btnVoltar.addEventListener('click', function(){
     window.location.href = "/area-cliente/"+cliente.id;

})


