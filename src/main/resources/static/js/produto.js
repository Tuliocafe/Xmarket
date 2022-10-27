var qtdProduto = document.getElementById('qtdProduto');
var produto = document.getElementById('produto');
var preco = document.getElementById('preco');
var tamanhoProd = document.getElementById('tamanhoProd');
var corProd = document.getElementById('corProd');
var imagem = document.getElementById('imagem');
var marca = document.getElementById('dropDownList');
//var categoria = document.getElementById('dropDownList1');

var buttonCadastrarProd = document.getElementById('buttonCadastrarProd');
var buttonDeleteProduto = document.getElementById('buttonDeleteProduto');

var cadastroProd
var idProduto
var nomeProduto = document.getElementById("produtoEditar")
var qtdProduto = document.getElementById('qtdProduto2')
var preco2 = document.getElementById('preco2')
var tamanhoProduto = document.getElementById('tamanhoProd2')
var corProduto = document.getElementById('corProduto2')
var imagem2 = document.getElementById('imagem2')
var marcaProduto = document.getElementById('dropDownList2')

buttonCadastrarProd.addEventListener('click', function(){

    var marca = document.getElementById('dropDownList');
//    console.log('marca', marca.value);

    cadastroProd = {
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


getMarcas();

function getProduto(){
    var url = "http://localhost:8080/produtos";
    var selected = document.getElementById('dropDownListEditarProduto');

    fetch(url).then(function (response) {
        return response.json();

    }).then(function (data) {
//    console.log(data);
        data.forEach(produto=>{
        var option = document.createElement('option')
        var nome = produto.nome_produto
        var id = produto.id_produto;
        //console.log(id)
        option.setAttribute('value', `${id}`)
        option.appendChild(document.createTextNode(`${nome}`))
        selected.appendChild(option)
        })
    })

    selected.addEventListener('change', function () {
    idProduto = selected.value
    localStorage.setItem('idProduto', idProduto)
    var endPoint = "http://localhost:8080/produtos/" + idProduto
    fetch(endPoint).then(function (response) {
     return response.json();
    }).then(function (data){
        var nomeProduto = document.getElementById("produtoEditar")
        nomeProduto.value = data.nome_produto;
        var qtdProduto = document.getElementById('qtdProduto2')
        qtdProduto.value = data.quantidade_produto
        var preco2 = document.getElementById('preco2')
        preco2.value = data.preco_produto
        var tamanhoProduto = document.getElementById('tamanhoProd2')
        tamanhoProduto.value = data.tamanho
        var corProduto = document.getElementById('corProduto2')
        corProduto.value = data.cor
        var marcaProduto = document.getElementById('dropDownList2')
        function getMarcas(){
         var url = "http://localhost:8080/marcas";
         var selected = document.getElementById('dropDownList2');

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
        getMarcas()
    })
   })
}
getProduto()




buttonPutProduto.addEventListener('click', function(){

    cadastroProd = {
    "quantidade": qtdProduto2.value,
    "nome": nomeProduto.value,
    "preco": preco2.value,
    "tamanho": tamanhoProd2.value,
    "cor": corProduto.value,
    "imagem_path": "images/"+imagem2.files[0].name,
    "marca": marcaProduto.value,
    "categoria": 2
    };
 var init ={
            method: 'PUT',
            headers: { "Content-Type":'application/json'},
            body: JSON.stringify(cadastroProd)
        }
        var endpoint = 'http://localhost:8080/produtos/'+ localStorage.getItem('idProduto')


       fetch(endpoint, init).then(function (response) {
           return response.json();
           }).then(function (data) {
       //    console.log(data);
               alert('Produto atualizado com sucesso');

               window.location.href = "/admin"

           })
       })


buttonDeleteProduto.addEventListener('click', function(){

        var init = {
                    method: 'DELETE',
                    headers: { "Content-Type": 'application/json'}
                }

                var endPoint = 'http://localhost:8080/produtos/' + localStorage.getItem('idProduto')

                fetch(endPoint, init)

        //vai retornar mensagem de erro ou sucesso janela de sim ou nao ?
        alert("Produto deletado com sucesso")
        window.location.href = "/admin"
 })

