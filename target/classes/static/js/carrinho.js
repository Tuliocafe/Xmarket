
//    var carrinhos = document.getElementById('carrinhos')
//    console.log(carrinhos.value)

 var product_total_amt = document.getElementById('product_total_amt');
 var frete = document.getElementById('frete');
// var precoTotal = document.getElementById('precoTotal');
 var codigoDesconto = document.getElementById('codigoDesconto1');
// var precoUnitario = document.getElementById('precoUnitario');
// var precoTotalItem = document.getElementById('preco');
//     precoTotalItem.innerHTML = parseInt(precoUnitario.innerHTML);
//     product_total_amt.innerHTML = parseInt(precoTotalItem.innerHTML);



const diminuir = (incdec) => {
    var quantidade = document.getElementById(incdec);
//    var precoTotal = document.getElementById(precoTotal);

    if (quantidade.value <= 1) {
        quantidade.value = 1;
        alert('Não é possível valores negativos');
    } else {
         quantidade.value = parseInt(quantidade.value) - 1;
//         precoTotal.innerHTML = parseInt(precoTotal.innerHTML) - parseInt(precoUnitario.innerHTML);
//         precoTotalItem.innerHTML = parseInt(precoTotalItem.innerHTML) - parseInt(precoUnitario.innerHTML);
//         product_total_amt.innerHTML = parseInt(product_total_amt.innerHTML) - parseInt(precoUnitario.innerHTML);
//         precoTotal.innerHTML = parseInt(product_total_amt.innerHTML) + parseInt(frete.innerHTML);
    }
}


const aumentar = (incdec, valor) => {
    var quantidade = document.getElementById(incdec);
    var precoTotal = document.getElementById(valor);
//    var precoUnitario = document.getElementById(precoUnitario);
        console.log(valor.value);
        console.log(valor.innerHTML);
          quantidade.value = parseInt(quantidade.value) + 1;
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



