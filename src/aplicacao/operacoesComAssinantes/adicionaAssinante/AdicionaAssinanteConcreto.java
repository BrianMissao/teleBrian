package aplicacao.operacoesComAssinantes.adicionaAssinante;

import dominio.entidades.Assinante;

import java.util.List;

public class AdicionaAssinanteConcreto implements AdicionaAssinante {
    private List<Assinante> assinantes;

    public AdicionaAssinanteConcreto(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    @Override
    public boolean adicionar(Assinante assinante) {
        assinantes.add(assinante);
        return true;
    }
}
