// var product_total_amt = document.getElementById('product_total_amt');
// var frete = document.getElementById('frete');
// var precoTotal = document.getElementById('precoTotal');
//  var codigoDesconto = document.getElementById('codigoDesconto1');


const diminuir = (incdec, precoProduto) => {
    var quantidade = document.getElementById(incdec);
    var precoProduto = document.getElementById(precoProduto);
    
    


    if (quantidade.value <= 0) {
        quantidade.value = 0;
        alert('Não é possível valores negativos');
    } else {
        quantidade.value = parseInt(quantidade.value) - 1;
        // precoProduto.innerHTML = parseInt(precoProduto.innerHTML) - 15;
        // product_total_amt.innerHTML = parseInt(product_total_amt.innerHTML) - 15;
        // precoTotal.innerHTML = parseInt(product_total_amt.innerHTML) + parseInt(frete.innerHTML);
    }
}


const aumentar = (incdec, precoProduto) => {
    var quantidade = document.getElementById(incdec);
    var precoProduto = document.getElementById(precoProduto);

 

    if (quantidade.value >= 5) {
        quantidade.value = 5;
        alert('Maximo de 5 produtos');
    } else {
        quantidade.value = parseInt(quantidade.value) + 1;
        // precoProduto.innerHTML = parseInt(precoProduto.innerHTML) + 15;
        // product_total_amt.innerHTML = parseInt(product_total_amt.innerHTML) + 15;
        // precoTotal.innerHTML = parseInt(product_total_amt.innerHTML) + parseInt(frete.innerHTML);
    }
}

// localStorage.setItem("flagDesconto", false)
// const discount_code = () => {
//     let total = parseInt(product_total_amt.innerHTML);
//     let infoDesconto = document.getElementById('infoDesconto');
//    if(localStorage.getItem("flagDesconto") == "false"){
//     if (codigoDesconto.value === 'xMarket') {
//         let novoTotal = total - 15;
//         product_total_amt.innerHTML = novoTotal;

//         infoDesconto.innerHTML = "Desconto valido!"; 
//         localStorage.setItem("flagDesconto", true)
//     } else {
//         infoDesconto.innerHTML = "Esse código não é valido! Tente novamente";
//     }
//    }
//}



