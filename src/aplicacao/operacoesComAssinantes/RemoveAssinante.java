package aplicacao.operacoesComAssinantes;

import dominio.entidades.Assinante;

import java.util.List;

public class RemoveAssinante {
    private List<Assinante> assinantes;

    public RemoveAssinante(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    public void remover(String nomeDoAssinanteARemover) {
        if (assinantes.removeIf(assinante -> assinante.getNome().equals(nomeDoAssinanteARemover))) {
            System.out.println("O assinante " + nomeDoAssinanteARemover+" foi removido com sucesso.");
            return;
        }
        System.out.println("O assinante " + nomeDoAssinanteARemover + " não está cadastrado, portanto não pode ser removido.");
    }

}
