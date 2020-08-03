package aplicacao.operacoesComAssinantes;

import dominio.entidades.Assinante;

import java.util.List;

public class BuscaAssinante {
    private List<Assinante> assinantes;

    public BuscaAssinante(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    public String buscar(String nomeDoAssinanteABuscar) {
        for (Assinante assinante : assinantes) {
            if (assinante.getNome().equals(nomeDoAssinanteABuscar)) {
                return assinante.toString();
            }
        }
        return "O assinante "+nomeDoAssinanteABuscar+" não está cadastrado.";
    }
}
