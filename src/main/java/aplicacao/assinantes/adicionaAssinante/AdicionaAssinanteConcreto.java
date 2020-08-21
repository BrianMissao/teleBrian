package aplicacao.assinantes.adicionaAssinante;

import dominio.entidades.assinante.Assinante;

import java.util.List;

public class AdicionaAssinanteConcreto implements AdicionaAssinante {
    private List<Assinante> assinantes;

    public AdicionaAssinanteConcreto(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    @Override
    public String adicionar(Assinante assinante) {
        assinantes.add(assinante);
        return "Assinante adicionado com sucesso!";
    }

}