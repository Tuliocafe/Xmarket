var marca = document.getElementById('marca');
var descricao = document.getElementById('descricao');
var buttonCadastrar = document.getElementById('buttonCadastrar');

var marcaEditar = document.getElementById('marcaEditar');
var descricaoEditar = document.getElementById('descricao1')
var buttonPutMarca = document.getElementById('buttonPutMarca')
var idMarca

buttonCadastrar.addEventListener('click', function(){

if(marca.value != ""){
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
    alert("O campo nome da marca é obrigatorio.");
    }

var endPoint = 'http://localhost:8080/marcas'

    fetch(endPoint, init).then(function (response) {
    return response.json();
    }).then(function (data) {
    //console.log(data);


        window.location.href = "/admin"

    })
})

function getMarca(){
    var url = "http://localhost:8080/marcas";
    var selected = document.getElementById('dropDownListEditarMarca');

    fetch(url).then(function (response) {
        return response.json();

    }).then(function (data) {
    //console.log(data);
        data.forEach(marca=>{
        var option = document.createElement('option')
        var nome = marca.nome_marca
        var id = marca.id_marca;
        //console.log(id)
        option.setAttribute('value', `${id}`)
        option.appendChild(document.createTextNode(`${nome}`))
        selected.appendChild(option)
        })
    })
    selected.addEventListener('change', function () {
    idMarca = selected.value
    localStorage.setItem('idMarca', idMarca)
    var endPoint = "http://localhost:8080/marcas/" + idMarca
    fetch(endPoint).then(function (response) {
     return response.json();
    }).then(function (data){
        var nomeMarca = document.getElementById('marcaEditar')
        nomeMarca.value = data.nome_marca
        var descricao = document.getElementById('descricao1')
        descricao.value = data.descricao


    })
   })
}
getMarca()

buttonPutMarca.addEventListener('click', function(){

    editarMarca = {
    "nome_marca": marcaEditar.value,
    "descricao": descricao1.value
    };
 var init ={
            method: 'PUT',
            headers: { "Content-Type":'application/json'},
            body: JSON.stringify(editarMarca)
        }

        var endpoint = 'http://localhost:8080/marcas/'+ localStorage.getItem('idMarca')


       fetch(endpoint, init).then(function (response) {
           return response.json();
           }).then(function (data) {
       //    console.log(data);
               alert('Marca atualizado com sucesso');

               window.location.href = "/admin"

           })
       })

buttonDeleteMarca.addEventListener('click', function(){

        var init = {
                    method: 'DELETE',
                    headers: { "Content-Type": 'application/json'}
                }

                var endPoint = 'http://localhost:8080/marcas/' + localStorage.getItem('idMarca')

                fetch(endPoint, init)

        //vai retornar mensagem de erro ou sucesso janela de sim ou nao ?
        alert("Produto deletado com sucesso")
        window.location.href = "/admin"

 })
