buscarPlanos();


function buscarPlanos() {

    let request = new XMLHttpRequest();

    request.open('GET', '/planos', true);

    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            if (request.status == 200) {
                exibirPlanos(request.responseText);
                //document.getElementById('listaPlanos').innerHTML = 'finalizada a requisição, status ' + request.status;
            }

        }
    }
    request.send();
}

function exibirPlanos(planos) {
    console.log('entrei na função');
    var planosEmJson = JSON.parse(planos);
    console.log(planosEmJson);
    var planosParaExibicao = '<table>';
    planosEmJson.forEach(element => {
            planosParaExibicao += `<tr><th>nome</th><th>valor</th></tr><tr><td>${element.nome}</td><td>${element.valor}</td></tr>`
    });
    planosParaExibicao += '</table>';
    document.getElementById('listaPlanos').innerHTML = planosParaExibicao;
}