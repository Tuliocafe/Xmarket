var qtdProduto = document.getElementById('qtdProduto');
var produto = document.getElementById('produto');
var preco = document.getElementById('preco');
var tamanhoProd = document.getElementById('tamanhoProd');
var corProd = document.getElementById('corProd');
var imagem = document.getElementById('imagem');
var marca = document.getElementById('dropDownList');
//var categoria = document.getElementById('dropDownList1');

var buttonCadastrarProd = document.getElementById('buttonCadastrarProd');


buttonCadastrarProd.addEventListener('click', function(){

    var marca = document.getElementById('dropDownList');


    var cadastroProd = {
    "quantidade": qtdProduto.value,
    "nome": produto.value,
    "preco": preco.value,
    "tamanho": tamanhoProd.value,
    "cor": corProd.value,
    "imagem_path": "images/"+imagem.files[0].name,
    "marca": marca.value,
    "categoria": 2
    };
//    console.log(cadastroProd);
    var init = {
        method: 'POST',
        headers: { "Content-Type": 'application/json'},
        body: JSON.stringify(cadastroProd)
    }

var endPoint = 'http://localhost:8080/produtos'

    fetch(endPoint, init).then(function (response) {
    return response.json();
    }).then(function (data) {
//    console.log(data);
        alert('Produto cadastrado com sucesso');

        window.location.href = "/admin"

    })
})

var imagem  = document.getElementById('imagem'),
    hiddenField = document.getElementById('hiddenField');

function fileChanged() {
    function onLoad(e) {
        // Adicionando o arquivo em base64 ao hidden field:
        hiddenField.innerHTML = e.target.result;
    }

    if (this.files && this.files[0]) {
        var fileReader = new FileReader();
        fileReader.onload = onLoad;
        // Isso vai transformar o arquivo em uma string base64:
        fileReader.readAsDataURL(this.files[0]);
    }
}

function getMarcas(){
    var url = "http://localhost:8080/marcas";
    var selected = document.getElementById('dropDownList');

    fetch(url).then(function (response) {
        return response.json();

    }).then(function (data) {
        data.forEach(produto=>{
        var option = document.createElement('option')
        var marca = produto.nome_marca
        var id = produto.id_marca;
        //console.log(id)
        option.setAttribute('value', `${id}`)
        option.appendChild(document.createTextNode(`${marca}`))
        selected.appendChild(option)
        })
    })
}

//getMarcas();
