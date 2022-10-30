var logado = localStorage.getItem('logado');

if (logado) {
     var auxCliente = localStorage.getItem("cliente");
     var cliente = JSON.parse(auxCliente);

 }

var enderecoClienteLogado = localStorage.getItem('listaenderecos');
var auxEndereco = localStorage.getItem('listaenderecos');
var endereco = JSON.parse(auxEndereco);


var logradouro = document.getElementById('logradouro');
var bairro = document.getElementById('bairro');
var numero = document.getElementById('numero');
var cidade = document.getElementById('cidade');
var complemento = document.getElementById('complemento');
var referencia = document.getElementById('referencia');
var tipo = document.getElementById('tipo');
var idCliente = cliente.id;
//var cep = document.getElementById('cep');




btnSalvarEnd.addEventListener('click', async function(){
if(logradouro.value===""||bairro.value===""||cidade.value===null||cep.value===""||tipo.value===""){
    alert("Há campos obrigatórios não preenchidos!")
}else{
    var address = {

            "logradouro": logradouro.value,
            "bairro": bairro.value,
            "numero": numero.value,
            "cidade": cidade.value,
            "cep": cep.value,
            "complemento": complemento.value,
            "referencia":referencia.value,
            "tipo": tipo.value,
            "idUsuario": cliente.id
            };

            var init ={
            method: 'POST',
            headers: { "Content-Type":'application/json'},
            body: JSON.stringify(address)
        }

        var endpoint = 'http://localhost:8080/clientes/'+cliente.id+'/enderecos'
        alert("Endereço cadastrado!")

        var response = await fetch(endpoint, init)
        console.log(response)
        return response.json();
        window.location.href = "/area-cliente/"+cliente.id;

        }

          })

function getCidades(){
    var ulr = "http://localhost:8080/cidades";
    var selected = document.getElementById('cidade');

    fetch(ulr).then(function(response){
        return response.json();

    }).then(function(data){
        data.forEach(address=>{
        var option = document.createElement('option');
        var cidade = address.nome;
        var id = address.id;


        option.setAttribute('value', `${id}`)
        option.appendChild(document.createTextNode(`${cidade}`))
        selected.appendChild(option)
        })

    })

}
getCidades();

btnVoltar.addEventListener('click', function(){
     window.location.href = "/area-cliente/"+cliente.id;

})

