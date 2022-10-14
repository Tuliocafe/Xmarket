'use strict';

const pesquisarCep=() => {
    const cep = document.getElementById('cep').value;
    const url = 'https://viacep.com.br/ws/${cep}/json/';
    fetch(url).then(console.log);
    

}

document.getElementById('cep')
.addEventListener('focusout', pesquisarCep);

