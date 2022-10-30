
//função para buscar o cep:
document.getElementById('cep').addEventListener('focusout', pesquisarCep);

var preencherFormulario = (endereco)=>{
    document.getElementById('logradouro').value = endereco.logradouro;
    document.getElementById('bairro').value = endereco.bairro;
    document.getElementById('cidade').value = endereco.logradouro;
    document.getElementById('cidade').value = endereco.localidade;

}

 async function pesquisarCep (){
var cep = document.getElementById('cep').value;
var ulr = `https://viacep.com.br/ws/${cep}/json`;

var dados =  await fetch(ulr);
var endereco = await dados.json();
if(endereco.hasOwnProperty('erro')){
        alert('Cep não encontrado');

} else{
preencherFormulario(endereco);
}
}