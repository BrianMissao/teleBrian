buscarPlanos();


function buscarPlanos() {

    let request = new XMLHttpRequest();

    request.open('GET', '/planos', true);

    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            if (request.status == 200) {
                exibirPlanos(request.responseText);
            }

        }
    }
    request.send();
}

function exibirPlanos(planos) {
    var planosEmJson = JSON.parse(planos);
    if(planosEmJson) {
        montarTabelaEExibirNoHtml(planosEmJson);
    }
}

function montarTabelaEExibirNoHtml(planosEmJson) {
    var tabelaDeExibicao = '<table><tr><th>nome</th><th>valor</th></tr>';
    planosEmJson.forEach(element => {
            tabelaDeExibicao += `<tr><td>${element.nome}</td><td>${element.valor}R$</td></tr>`
    });
    tabelaDeExibicao += '</table>';
    document.getElementById('listaPlanos').innerHTML = tabelaDeExibicao;
}