var datainicio = document.getElementById('data-inicio');
var datafim = document.getElementById('data-fim');
var botao= document.getElementById('gerarData');

botao.addEventListener('click', async function(){

    var endPoint = "http://localhost:8080/admin/pdf/jr2/02?data_inicio="+datainicio.value+"&data_final="+datafim.value

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

        fetch(endPoint, init).then(function(response) {
            return response.blob();
        })

        .then(function(blob) {
            console.log(blob);
            var newBlob = new Blob([blob], { type: "application/json" })

                          if (window.navigator && window.navigator.msSaveOrOpenBlob) {
                              window.navigator.msSaveOrOpenBlob(newBlob);
                              return;
                          }

                          const data = window.URL.createObjectURL(newBlob);
                          var link = document.createElement('a');
                          link.href = data;


                          const timeElapsed = Date.now();
                          const today = new Date(timeElapsed);

                          link.download="file.pdf"
                          link.click();
                          setTimeout(function () {
                              // Firefox demnanda o delay
                              window.URL.revokeObjectURL(data);
                          }, 100);
          })




})



