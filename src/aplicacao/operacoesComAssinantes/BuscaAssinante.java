package aplicacao.operacoesComAssinantes;

import dominio.entidades.Assinante;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeBuscaDeAssinante;

import java.util.List;

public class BuscaAssinante {
    private List<Assinante> assinantes;

    public BuscaAssinante(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    public Assinante buscar(String nomeDoAssinanteABuscar) throws ExcecaoDeBuscaDeAssinante {
        for (Assinante assinante : assinantes) {
            if (assinante.getNome().equals(nomeDoAssinanteABuscar)) {
                return assinante;
            }
        }
        throw new ExcecaoDeBuscaDeAssinante("O assinante " + nomeDoAssinanteABuscar + " não está cadastrado");
    }
}
