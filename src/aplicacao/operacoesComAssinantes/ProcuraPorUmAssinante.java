package aplicacao.operacoesComAssinantes;

import dominio.entidades.Assinante;

import java.util.List;

public class ProcuraPorUmAssinante {
    private List<Assinante> assinantes;

    public ProcuraPorUmAssinante(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    public Assinante procurar(String nomeDoAssinanteABuscar) {
        for (Assinante assinante : assinantes) {
            if (assinante.getNome().equals(nomeDoAssinanteABuscar)) {
                return assinante;
            }
        }
        return null;
    }
}
