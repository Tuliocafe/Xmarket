var frete = document.getElementById('frete');
var idVenda = document.getElementById('idVenda');
var codigoDesconto = document.getElementById('codigoDesconto1');

var rotaCarrinhos = 'http://localhost:8080/carrinhos/'
var rotaVendas = 'http://localhost:8080/vendas/'

// var precoUnitario = document.getElementById('precoUnitario');
// var precoTotalItem = document.getElementById('preco');
//     precoTotalItem.innerHTML = parseInt(precoUnitario.innerHTML);
//     product_total_amt.innerHTML = parseInt(precoTotalItem.innerHTML);
var somaValores = 0
var dados
var valorTotal = document.getElementById("precoTotal")
var quantidadeIten = document.getElementById("quantidadeIten")
var carrinho  = {listaCarrinho: []}
var vendaAtualizada
var idVenda = 13


getdados()



async function calcularTotal(){
    for (var i = 0; i <  dados.listaItensCarrinho.length; i ++ ){
    valorTotal =+ dados.listaItensCarrinho[i].precoTotal
    }
}

async function getdados(){
    var endPoint = "http://localhost:8080/vendas/" +idVenda
    init = {
            method: "GET",
            mode: 'cors',
            cache: 'no-cache',
            credentials: 'same-origin',
            headers: {
                'Content-Type': 'application/json'
            },
            referrerPolicy: 'no-referrer',
        }
        var response = await fetch(endPoint, init);


        dados = await response.json()

         for (var i = 0; i <  dados.listaItensCarrinho.length; i ++ ){
             somaValores += (dados.listaItensCarrinho[i].quantidade * dados.listaItensCarrinho[i].precoUnitario);

             carrinho.listaCarrinho.push({id:dados.listaItensCarrinho[i].id ,quantidade: dados.listaItensCarrinho[i].quantidade,
              venda:dados.id, produto:dados.listaItensCarrinho[i].produto.id_produto}, )
         }
        valorTotal.innerHTML =  somaValores.toFixed(2)
        quantidadeIten.innerHTML = "Carrinho " + dados.listaItensCarrinho.length +" itens"
        console.log(dados)




//carrinho ={id: dados }
//carrinho  = {id: dados.id}
//carrinho  = {produto: dados.listaItensCarrinho[0].produto.id_produto}


//vendaAtualizada.listaCarrinho.push({id: 7})

}



async function atualizarVenda(){

         for (var i = 0; i <  carrinho.listaCarrinho.length; i ++ ){
               rotaCarrinhos = rotaCarrinhos + carrinho.listaCarrinho[i].id
               putDados(rotaCarrinhos, carrinho.listaCarrinho[i])
         }

         vendaAtualizada = {id: idVenda , precoTotal: valorTotal.innerHTML, cliente:{id:dados.cliente.id } , statusVendas:{id:3} }

    rotaVendas = rotaVendas + dados.id

    console.log(rotaVendas)

    putDados(rotaVendas, vendaAtualizada )
}



async function putDados(rota, dadosJson){
var rota
var dadosJson
    fetch(rota,{
    method: 'put',
      headers: {
        'Content-Type': 'application/json',
      },
    body: JSON.stringify(dadosJson),}).then((response) => response.json())
                   .then((result) => {
                     console.log('Success:', result);
                   })
                   .catch((error) => {
                     console.error('Error:', error);
                   });
}







const diminuir = (incdec, valorUnitario) => {
    var quantidade = document.getElementById(incdec);
    var valorUnitario = valorUnitario;
//    var precoTotal = document.getElementById(precoTotal);
    if (quantidade.value <= 1) {
        quantidade.value = 1;
        alert('Não é possível valores negativos');
    } else {
       for (var i = 0; i <  carrinho.listaCarrinho.length; i ++ ){
                  if(incdec == carrinho.listaCarrinho[i].id){
                    carrinho.listaCarrinho[i].quantidade --
                  }
                }
         quantidade.value = parseInt(quantidade.value) - 1;
         valorTotal.innerHTML = parseInt(valorTotal.innerHTML) -  valorUnitario

    }
}


const aumentar = (incdec, valorUnitario) => {
    var quantidade = document.getElementById(incdec);
    var valorUnitario = valorUnitario;
       for (var i = 0; i <  carrinho.listaCarrinho.length; i ++ ){
                  if(incdec == carrinho.listaCarrinho[i].id){
                    carrinho.listaCarrinho[i].quantidade ++
                  }
                }

          quantidade.value = parseInt(quantidade.value) + 1;
          valorTotal.innerHTML = parseInt(valorTotal.innerHTML) +  valorUnitario

}




