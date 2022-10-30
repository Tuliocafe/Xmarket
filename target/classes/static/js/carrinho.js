var frete = document.getElementById('frete');
var idVenda = document.getElementById('idVenda');
var codigoDesconto = document.getElementById('codigoDesconto1');
var logado = localStorage.getItem('logado');
var venda = localStorage.getItem('venda')
var valorTotal1 = document.getElementById("precoTotal1")
var rotaCarrinhos = 'http://localhost:8080/carrinhos/'
var rotaVendas = 'http://localhost:8080/vendas/'

var somaValores = 0
var dados
var valorTotal = document.getElementById("precoTotal")
var quantidadeIten = document.getElementById("quantidadeIten")
var carrinho  = {listaCarrinho: []}
var vendaAtualizada


setTimeout(sessao, 5000000);

getdados()


var idEstoque = document.getElementById('estoque'+71)
console.log(idEstoque)


function sessao(){
    localStorage.clear();
    alert("O usuário está deslogado");
    window.location.href = "/index"
}


async function calcularTotal(){
    for (var i = 0; i <  dados.listaItensCarrinho.length; i ++ ){
    valorTotal =+ dados.listaItensCarrinho[i].precoTotal
    }
}

async function getdados(){
    var endPoint = "http://localhost:8080/vendas/" +idVenda.innerHTML
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
        var somaValorTotal = 0

        dados = await response.json()

        //cria um JSON dos itens que estao no carrinho e calcula valor total
         for (var i = 0; i <  dados.listaItensCarrinho.length; i ++ ){
             somaValores = (dados.listaItensCarrinho[i].quantidade * dados.listaItensCarrinho[i].precoUnitario);
             somaValorTotal += somaValores
             carrinho.listaCarrinho.push({
                                        id:dados.listaItensCarrinho[i].id,
                                        quantidade: dados.listaItensCarrinho[i].quantidade,
                                        venda:dados.id,
                                        produto:dados.listaItensCarrinho[i].produto.id_produto,
                                        precoTotal: somaValores
                                        } )


         }
        valorTotal.innerHTML =  somaValorTotal.toFixed(2)
        valorTotal1.innerHTML = valorTotal.innerHTML

        quantidadeIten.innerHTML = "Carrinho " + dados.listaItensCarrinho.length +" itens"

        console.log(dados.statusVendas.id)
        if(dados.statusVendas.id != 2){
            console.log("Ta fechada")
            for (var i = 0; i <  dados.listaItensCarrinho.length; i ++ ){

             document.getElementById('botaoRemover' + dados.listaItensCarrinho[i].id).disabled = true;
//             console.log(document.getElementById('botaoRemover' + dados.listaItensCarrinho[i].id));
             document.getElementById('mais').disabled = true;
             document.getElementById('menos').disabled = true;
            }
            console.log(document.getElementById('botaoRemover' + dados.))

            document.getElementById('finalizar').disabled = true;

            }
}



async function atualizarVenda(){
    try{
         for (var i = 0; i <  carrinho.listaCarrinho.length; i ++ ){
               rotaCarrinhos = rotaCarrinhos + carrinho.listaCarrinho[i].id
               putDados(rotaCarrinhos, carrinho.listaCarrinho[i])
                }
         vendaAtualizada = {
                            id: idVenda.innerHTML,
                            precoTotal: valorTotal.innerHTML,
                            cliente:{id:dados.cliente.id},
                            statusVendas:{id:3}
                            }

         rotaVendas = rotaVendas + dados.id
         putDados(rotaVendas, vendaAtualizada )

         var venda = localStorage.setItem("venda",null)
         alert("Venda Finalizada com sucesso")
         window.location.href = "/index"
        } catch(e){
            alert("Nao foi Possivel")
            }

}



async function putDados(rota, dadosJson){
    var rota
    var dadosJson
        fetch(rota,{
        method: 'put',
          headers: {
            'Content-Type': 'application/json',
          },
        body: JSON.stringify(dadosJson),})
        .then((response) => response.json())
                       .then((result) => {
                         console.log('Success:', result);
                       })
                       .catch((error) => {
                         console.error('error:', error);
                       });
}


function deletarItem(idItem){
    var Item = document.getElementById(idItem);
    console.log(Item)
                var init = {
                    method: 'DELETE',
                    headers: { "Content-Type": 'application/json'}
                }

                var endPoint = 'http://localhost:8080/carrinhos/' +Item.id

                fetch(endPoint, init)


        //vai retornar mensagem de erro ou sucesso janela de sim ou nao ?
        alert("Item deletado com sucesso")

        window.location.href = "../carrinho/" + idVenda.innerHTML
}




const diminuir = (incdec, valorUnitario) => {
    var quantidade = document.getElementById(incdec);
    var valorUnitario = valorUnitario;
    if (quantidade.value <= 1) {
        quantidade.value = 1;
        alert('Valor minimo 1');
    } else {
       for (var i = 0; i <  carrinho.listaCarrinho.length; i ++ ){
                  if(incdec == carrinho.listaCarrinho[i].id){
                    carrinho.listaCarrinho[i].quantidade --
                    carrinho.listaCarrinho[i].precoTotal = (carrinho.listaCarrinho[i].quantidade * dados.listaItensCarrinho[i].precoUnitario)
                  }
                }
         quantidade.value = parseInt(quantidade.value) - 1;
         valorTotal.innerHTML = parseInt(valorTotal.innerHTML) -  valorUnitario
         valorTotal1.innerHTML = valorTotal.innerHTML
    }
}


const aumentar = (incdec, valorUnitario, estoque) => {
    var estoque = estoque
    var quantidade = document.getElementById(incdec);
    var valorUnitario = valorUnitario;

    console.log(estoque)
    console.log(quantidade.value)
    console.log(carrinho)
    for (var i = 0; i <  carrinho.listaCarrinho.length; i ++ ){

           if(incdec == carrinho.listaCarrinho[i].id){
                    if (quantidade.value >= estoque && estoque != 0){
                        quantidade.value = estoque
                        alert('Limite estoque atingido');
                    }else if(quantidade.value >= estoque &&  estoque == 0){
                    quantidade.value = 1
                    alert('Nao temos estoque extra');
                    }else {
                     carrinho.listaCarrinho[i].quantidade ++
                     carrinho.listaCarrinho[i].precoTotal = (carrinho.listaCarrinho[i].quantidade * dados.listaItensCarrinho[i].precoUnitario)
                     quantidade.value = parseInt(quantidade.value) + 1;
                     valorTotal.innerHTML = parseInt(valorTotal.innerHTML) +  valorUnitario
                     valorTotal1.innerHTML = valorTotal.innerHTML
                     }
           }
    }
}

 if (logado) {

     var auxCliente = localStorage.getItem("cliente");
     console.log(auxCliente);
     var cliente = JSON.parse(auxCliente);
        botaoSair.style.display = "flex";
     }
     else {
         botaoSair.style.display = "none";
  }

  function sairDaPagina(){
           localStorage.clear();
           alert("Usuário Deslogado");
           window.location.href = "/index"

       }




