package aplicacao.assinantes.remove;

import dominio.entidades.assinante.Assinante;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeRemocaoDeAssinante;

import java.util.List;

public class RemoveConcreto implements Remove {
    private List<Assinante> assinantes;

    public RemoveConcreto(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    @Override
    public void remover(String nomeDoAssinanteARemover) throws ExcecaoDeRemocaoDeAssinante{
        if (!assinantes.removeIf(assinante -> assinante.getNome().equals(nomeDoAssinanteARemover))) {
            throw new ExcecaoDeRemocaoDeAssinante("Não foi possível remover o assinante " + nomeDoAssinanteARemover);
        }
    }
}
