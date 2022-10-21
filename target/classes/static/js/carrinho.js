//var listaProduto = document.getElementById('lista')
//for(var key in listaProduto){
//    console.log(listaProduto[key])}
//    console.log(listaProduto.lastChild)

//listaProduto.childNodes.forEach(element => {
// if(element.nodeName != "#text"){
//    console.log(element.lastChild)
//        }
//    }
// )

var dados
var valorTotal = document.getElementById("precoTotal")
var quantidadeIten = document.getElementById("quantidadeIten")
var idVenda = 13
var idUsuario = 209
var vendaAtualizada
var carrinho


//teste[listaItensCarrinho] = 'novovalor'


getdados()



async function calcularTotal(){
    for (var i = 0; i <  dados.listaItensCarrinho.length; i ++ ){
    valorTotal =+ dados.listaItensCarrinho[i].precoTotal
    }
}

async function getdados(){

    var endPoint = "http://localhost:8080/vendas/13"
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
        var somaValores = 0

        dados = await response.json()

//    console.log(dados)
//        console.log(dados.listaItensCarrinho[0].precoUnitario)


//var carrinho = {carrinho: [{ id: 1,
//                            quantidade: 5,
//                            precoTotal: 1495 },]
//}


            vendaAtualizada = {           id: idVenda,
                                precoTotal: valorTotal,
                                statusVendas: {
                                    id: 3
                                },
                                cliente: {
                                    id: idUsuario
                             },
                             listaItensCarrinho: [{
                                       id: 13
                                       }
                             ],
                            }

vendaAtualizada.listaItensCarrinho = dados.listaItensCarrinho
carrinho = dados.listaItensCarrinho


//
         for (var i = 0; i <  dados.listaItensCarrinho.length; i ++ ){
             somaValores += dados.listaItensCarrinho[i].precoTotal
//             console.log(somaValores)
//             console.log("precototal")
//             console.log(dados.listaItensCarrinho[i].precoTotal)

         }
//        console.log(vendaAtualizada)
        console.log(carrinho)
//        console.log(dados)


        valorTotal.innerHTML =  somaValores
        console.log(dados.listaItensCarrinho.length)

        dados.listaItensCarrinho[0].precoTotal = 1495
        quantidadeIten.innerHTML = "Carrinho " + dados.listaItensCarrinho.length +" itens"

//        console.log( dados.listaItensCarrinho[0])

carrinho = dados.listaItensCarrinho[0]
carrinho ['venda'] = {id: dados.id}

carrinho.precoUnitario = 1000
console.log(carrinho)
}

//        console.log(dados.precoTotal)
//        dados.precoTotal = 320
//        console.log(dados)
//        console.log(dados.precoTotal)
//        console.log(dados.listaItensCarrinho[1].quantidade)



async function criarProduto(){



    fetch('http://localhost:8080/carrinhos/1',{
    method: 'put',
      headers: {
        'Content-Type': 'application/json',
      },
    body: JSON.stringify(carrinho),}).then((response) => response.json())
                   .then((result) => {
                     console.log('Success:', result);
                   })
                   .catch((error) => {
                     console.error('Error:', error);
                   });

//    console.log(dadosJson)
//    var endPointPost = "http://localhost:8080/vendas/13"
//       init = {
//               method: "PUT",
//               mode: 'cors',
//               cache: 'no-cache',
//               credentials: 'same-origin',
//               headers: {
//                   'Accept': 'application/json',
//                   'Content-Type': 'application/json'
//               },
//               referrerPolicy: 'no-referrer',
//               body: teste
//           }
//    var response = await fetch(endPointPost, init);
//    console.log(response)
}




 var product_total_amt = document.getElementById('product_total_amt');
 var frete = document.getElementById('frete');
// var precoTotal = document.getElementById('precoTotal');
 var codigoDesconto = document.getElementById('codigoDesconto1');
// var precoUnitario = document.getElementById('precoUnitario');
// var precoTotalItem = document.getElementById('preco');
//     precoTotalItem.innerHTML = parseInt(precoUnitario.innerHTML);
//     product_total_amt.innerHTML = parseInt(precoTotalItem.innerHTML);



const diminuir = (incdec, valorUnitario) => {
    var quantidade = document.getElementById(incdec);
    var valorUnitario = valorUnitario;
//    var precoTotal = document.getElementById(precoTotal);
    if (quantidade.value <= 1) {
        quantidade.value = 1;
        alert('Não é possível valores negativos');
    } else {
       for (var i = 0; i <  dados.listaItensCarrinho.length; i ++ ){
                  if(incdec == dados.listaItensCarrinho[i].id){
                    dados.listaItensCarrinho[i].quantidade --
                  }
                }
         quantidade.value = parseInt(quantidade.value) - 1;
         valorTotal.innerHTML = parseInt(valorTotal.innerHTML) -  valorUnitario

//         precoTotal.innerHTML = parseInt(precoTotal.innerHTML) - parseInt(precoUnitario.innerHTML);
//         precoTotalItem.innerHTML = parseInt(precoTotalItem.innerHTML) - parseInt(precoUnitario.innerHTML);
//         product_total_amt.innerHTML = parseInt(product_total_amt.innerHTML) - parseInt(precoUnitario.innerHTML);
//         precoTotal.innerHTML = parseInt(product_total_amt.innerHTML) + parseInt(frete.innerHTML);
    }
}


const aumentar = (incdec, valorUnitario) => {
    var quantidade = document.getElementById(incdec);
    var valorUnitario = valorUnitario;
    for (var i = 0; i <  dados.listaItensCarrinho.length; i ++ ){
              if(incdec == dados.listaItensCarrinho[i].id){
                dados.listaItensCarrinho[i].quantidade ++
              }
             }

          quantidade.value = parseInt(quantidade.value) + 1;
          valorTotal.innerHTML = parseInt(valorTotal.innerHTML) +  valorUnitario

//    console.log(dados.listaItensCarrinho[0].quantidade)
//    console.log(valorUnitario)
//    var precoUnitario = document.getElementById(precoUnitario);

//          precoTotal.calue = parseInt(precoTotal.value) + parseInt(precoUnitario.value);
//          precoTotalItem.innerHTML = parseInt(precoTotalItem.innerHTML) + parseInt(precoUnitario.innerHTML);
//          product_total_amt.innerHTML = parseInt(product_total_amt.innerHTML) + parseInt(precoUnitario.innerHTML);
//          precoTotal.innerHTML = parseInt(product_total_amt.innerHTML) + parseInt(frete.innerHTML);

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



