var logado = localStorage.getItem('logado');

if (logado) {
     var auxCliente = localStorage.getItem("cliente");
     var cliente = JSON.parse(auxCliente);

 }
 console.log(cliente);

var logradouro = document.getElementById('logradouro');
var bairro = document.getElementById('bairro');
var cidade = document.getElementById('cidade');
var cep = document.getElementById('cep');
var complemento = document.getElementById('complemento');
var referencia = document.getElementById('referencia');
var tipo = document.querySelector("input[name='form']:checked").value

//const selectedRadio = document.querySelector("input[name='car']:checked").value

btnSalvarEnd.addEventListener('click', async function(){

    var endereco = {
            "id": cliente.id,
            "logradouro": logradouro.value,
            "bairro": bairro.value,
            "cidade": cidade.value,
            "cep": cep.value,
            "complemento": complemento.value,
            "referencia":referencia.value,
            "tipo": tipo.value
            };

            console.log(cliente.id)

            var init ={
            method: 'POST',
            headers: { "Content-Type":'application/json'},
            body: JSON.stringify(endereco)
        }

        var endpoint = 'http://localhost:8080/clientes/249/enderecos'
        console.log("teste")
        console.log(cliente.id)

        var response = await fetch(endpoint, init)
        console.log(response)
        return response.json();
        alert("Endereço cadastrado!")

          })
