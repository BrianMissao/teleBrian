package aplicacao.operacoesComAssinantes.removeAssinante;

import dominio.entidades.Assinante;

import java.util.List;

public class RemoveAssinanteConcreto implements RemoveAssinante {
    private List<Assinante> assinantes;

    public RemoveAssinanteConcreto(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    @Override
    public boolean remover(String nomeDoAssinanteARemover) {
        return assinantes.removeIf(assinante -> assinante.getNome().equals(nomeDoAssinanteARemover));
    }

}
