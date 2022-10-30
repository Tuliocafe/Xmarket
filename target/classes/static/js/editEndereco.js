var logado = localStorage.getItem('logado');

if (logado) {
     var auxCliente = localStorage.getItem("cliente");
     var cliente = JSON.parse(auxCliente);

 }

var auxEndereco = localStorage.getItem('listaenderecos');
var endereco = JSON.parse(auxEndereco);



var logradouro = document.getElementById('logradouro');
var logradouro = document.getElementById('logradouro');
var bairro = document.getElementById('bairro');
var cidade = document.getElementById('cidade');
var cep = document.getElementById('cep');
var complemento = document.getElementById('complemento');
var referencia = document.getElementById('referencia');
var tipo = document.getElementById('tipo');
var idCliente = cliente.id;
var idEnd = document.getElementById('idEndereco');



btnSalvarEnd2.addEventListener('click', function(){
if(logradouro.value===""||bairro.value===""||cidade.value===""||cep.value===""||tipo.value===""){
    alert("Há campos obrigatórios não preenchidos!")
}else{


     var endereco1 = {

                "logradouro": logradouro.value,
                "bairro": bairro.value,
                "cidade": cidade.value,
                "cep": cep.value,
                "complemento": complemento.value,
                "referencia":referencia.value,
                "tipo": tipo.value,
                "idUsuario": cliente.id
                };

        var init ={
            method: 'PUT',
            headers: { "Content-Type":'application/json'},
            body: JSON.stringify(endereco1)
        }

        var endpoint = 'http://localhost:8080/clientes/'+cliente.id+'/enderecos/'+idEnd.value

        fetch(endpoint, init).then(function(response){
           return response.json();
           }).then(function (data)     {
                   alert("Alteração realizada!")
                 })
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