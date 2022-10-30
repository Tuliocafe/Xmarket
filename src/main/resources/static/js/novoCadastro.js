var logado = localStorage.getItem('logado');

if (logado) {
     var auxCliente = localStorage.getItem("cliente");
     var cliente = JSON.parse(auxCliente);

 }

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


var resposta

btnInscrever.addEventListener('click', async function(){

    if(nome.value === ""||sobrenome.value ===""||rg.value ===""||dataNascimento.value === ""||senha.value ===""||telefoneUm.value ===""||cpf.value===""){
        alert('Há campo(s) obrigatório(s) não preenchido(s)!')
        }else{
        if(senha.value== ""){
            alert ("Senha não preenchida!")
            } else if(senha.value!=senhaDois.value){
                alert('Senhas não conferem')
                } else {

    var cadastro =  {
                           "nome": nome.value,
                           "sobrenome": sobrenome.value,
                           "cpf": cpf.value,
                           "dataNascimento": dataNascimento.value,
                           "telefoneUm": telefoneUm.value,
                           "telefoneDois": telefoneDois.value,
                           "rg": rg.value,
                           "senha": senha.value,
                           "email": email.value,
                           "tipoUsuario": "administrador",
                           "status": null
                       }
                       console.log(cadastro)
    var init ={
        method: 'POST',
        headers: { "Content-Type":'application/json'},
        body: JSON.stringify(cadastro)
    }

    var endpoint = 'http://localhost:8080/clientes'
    console.log("teste")
    var response = await fetch(endpoint, init)
    console.log(response)

         if(response.status== 404){
                alert("Email já existente")

                }    else if(response.status ==201) {
                    alert("Dados cadastrados com sucesso! Faça Login")

                window.location.href = "/login"
                } else {
                alert("Código do erro:" + response.status)
                }
    }
    }
})
