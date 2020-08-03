package aplicacao.operacoesComAssinantes;

import dominio.entidades.Assinante;

import java.util.List;

public class AdicionaAssinante {
private List<Assinante> assinantes;
    public AdicionaAssinante(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    public boolean adicionar(Assinante assinante) {
        assinantes.add(assinante);
        return true;
    }
}
