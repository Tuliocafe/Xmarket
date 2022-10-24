var acessarModal = document.getElementById('acessarModal');
var modal = document.getElementById('modal');
var fecharModal = document.getElementById('fecharModal');
acessarModal.addEventListener('click', function () {
    modal.style.display = 'block';
})

fecharModal.addEventListener('click', function () {
    modal.style.display = 'none';
})

var acessarModal1 = document.getElementById('acessarModal1');
var modal1 = document.getElementById('modal1');
var fecharModal1 = document.getElementById('fecharModal1');
acessarModal1.addEventListener('click', function () {
    modal1.style.display = 'block';
})

fecharModal1.addEventListener('click', function () {
    modal1.style.display = 'none';
})

var acessarModal2 = document.getElementById('acessarModal2');
var modal2 = document.getElementById('modal2');
var fecharModal2 = document.getElementById('fecharModal2');
acessarModal2.addEventListener('click', function () {
    modal2.style.display = 'block';
})

fecharModal2.addEventListener('click', function () {
    modal2.style.display = 'none';
})



//var fileUpload  = document.getElementById('fileUpload'),
//    hiddenField = document.getElementById('hiddenField');
//
//function fileChanged() {
//    function onLoad(e) {
//        // Adicionando o arquivo em base64 ao hidden field:
//        hiddenField.innerHTML = e.target.result;
//    }
//
//    if (this.files && this.files[0]) {
//        var fileReader = new FileReader();
//        fileReader.onload = onLoad;
//        // Isso vai transformar o arquivo em uma string base64:
//        fileReader.readAsDataURL(this.files[0]);
//    }
//}
//
//document.getElementById('#fileUpload')
//    .addEventListener('change', fileChanged, false);