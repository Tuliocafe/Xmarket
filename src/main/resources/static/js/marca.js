var marca = document.getElementById('marca');
var descricao = document.getElementById('descricao');
var buttonCadastrar = document.getElementById('buttonCadastrar');


buttonCadastrar.addEventListener('click', function(){

if(marca.value != "" || descricao.value != ""){
    var cadastro = {
    "nome_marca": marca.value,
    "descricao": descricao.value
    };

    var init = {
        method: 'POST',
        headers: { "Content-Type": 'application/json'},
        body: JSON.stringify(cadastro)
    }
    alert('Marca cadastrada com sucesso');
    } else{
    alert("Todos os campos são obrigatórios")
    }

var endPoint = 'http://localhost:8080/marcas'

    fetch(endPoint, init).then(function (response) {
    return response.json();
    }).then(function (data) {
    console.log(data);


        window.location.href = "/admin"

    })
})
