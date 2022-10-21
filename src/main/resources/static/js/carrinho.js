
//var product_total_amt = document.getElementById('product_total_amt');
var frete = document.getElementById('frete');
var idVenda = document.getElementById('idVenda');
var codigoDesconto = document.getElementById('codigoDesconto1');

var fetchId = 'http://localhost:8080/carrinhos/'

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
             somaValores += dados.listaItensCarrinho[i].precoTotal;
             carrinho.listaCarrinho.push({id:dados.listaItensCarrinho[i].id ,quantidade: dados.listaItensCarrinho[i].quantidade,
              venda:dados.id, produto:dados.listaItensCarrinho[i].produto.id_produto})
         }
        valorTotal.innerHTML =  somaValores
        quantidadeIten.innerHTML = "Carrinho " + dados.listaItensCarrinho.length +" itens"





//carrinho ={id: dados. }
//carrinho  = {id: dados.id}
//carrinho  = {produto: dados.listaItensCarrinho[0].produto.id_produto}


//vendaAtualizada.listaCarrinho.push({id: 7})



}
//calcularTotal()

//        console.log(dados.precoTotal)
//        dados.precoTotal = 320
//        console.log(dados)
//        console.log(dados.precoTotal)
//        console.log(dados.listaItensCarrinho[1].quantidade)

async function atualizarVenda(){

         for (var i = 0; i <  carrinho.listaCarrinho.length; i ++ ){
               vendaAtualizada = carrinho.listaCarrinho[i]
               fetchId = fetchId + carrinho.listaCarrinho[i].id
               console.log(fetchId)
               console.log(vendaAtualizada)
               putDados()
         }

//         vendaAtualizada = {id: idVenda , precoTotal: parseInt(valorTotal), cliente:{id:dados.cliente.id } , statusVendas:{id:3} }
//         console.log(vendaAtualizada)

}




async function putDados(){

    fetch(fetchId,{
    method: 'put',
      headers: {
        'Content-Type': 'application/json',
      },
    body: JSON.stringify(vendaAtualizada),}).then((response) => response.json())
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

//    console.log(dados.listaItensCarrinho[0].quantidade)
//    console.log(valorUnitario)
//    var precoUnitario = document.getElementById(precoUnitario);

}

// localStorage.setItem("flagDesconto", false)
// const discount_code = () => {
//     let total = parseInt(product_total_amt.innerHTML);
//     let infoDesconto = document.getElementById('infoDesconto');
//    if(localStorage.getItem("flagDesconto") == "false"){
//     if (codigoDesconto.value === 'xMarket') {
//         let novoTotal = total - 15;
//         product_total_amt.innerHTML = novoTotal;
//
//         infoDesconto.innerHTML = "Desconto valido!";
//         localStorage.setItem("flagDesconto", true)
//     } else {
//         infoDesconto.innerHTML = "Esse código não é valido! Tente novamente";
//     }
//    }
//}



