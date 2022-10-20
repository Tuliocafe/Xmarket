var acessarModal = document.getElementById('acessarModal');
var modal = document.getElementById('modal');
var fecharModal = document.getElementById('fecharModal');
acessarModal.addEventListener('click', function () {
    modal.style.display = 'block';
})

fecharModal.addEventListener('click', function () {
    modal.style.display = 'none';
})