package aplicacao.operacoesComAssinantes.buscaAssinante;

import dominio.entidades.Assinante;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeBuscaDeAssinante;

import java.util.List;

public class BuscaAssinanteConcreto implements BuscaAssinante {
    private List<Assinante> assinantes;

    public BuscaAssinanteConcreto(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    @Override
    public Assinante buscar(String nomeDoAssinanteABuscar) throws ExcecaoDeBuscaDeAssinante {
        for (Assinante assinante : assinantes) {
            if (assinante.getNome().equals(nomeDoAssinanteABuscar)) {
                return assinante;
            }
        }
        throw new ExcecaoDeBuscaDeAssinante("O assinante " + nomeDoAssinanteABuscar + " não está cadastrado");
    }
}
