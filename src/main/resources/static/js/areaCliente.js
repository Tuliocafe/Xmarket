var cliente = localStorage.getItem("cliente")
var auxCliente = JSON.parse(cliente.getItem)

//async function getdados(){
//    var endPoint = "http://localhost:8080/clientes/" +idCliente.innerHTML
//    init = {
//            method: "GET",
//            mode: 'cors',
//            cache: 'no-cache',
//            credentials: 'same-origin',
//            headers: {
//                'Content-Type': 'application/json'
//            },
//            referrerPolicy: 'no-referrer',
//        }
//        var response = await fetch(endPoint, init);
//        var somaValorTotal = 0
//
//        dados = await response.json()

var id = auxCliente.getId

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

console.log('inicio')

btnSalvar.addEventListener('click', async function(){

    alert('inicio')
    var cadastro = {
        "id": id.value,
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

    var init ={
        method: 'PUT',
        headers: { "Content-Type": 'application/json'},
        body: JSON.stringify(cadastro)
    }

    var endpoint = 'http://localhost:8080/clientes/'+id
    console.log("teste")
    fetch(endpoint, init).then(function(response){
        return response.json();

    }).then(function (data) {
          console.log(data);
            alert(data.email)
          })

          window.location.href = "/areaCliente"



})

