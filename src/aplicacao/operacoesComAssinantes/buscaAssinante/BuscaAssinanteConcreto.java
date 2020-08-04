package aplicacao.operacoesComAssinantes.buscaAssinante;

import dominio.entidades.assinante.Assinante;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeBuscaDeAssinante;

import java.util.List;

public class BuscaAssinanteConcreto implements BuscaAssinante {
    private List<Assinante> assinantes;

    public BuscaAssinanteConcreto(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    @Override
    public Assinante buscar(String nomeDoAssinanteABuscar) throws ExcecaoDeBuscaDeAssinante {
        return assinantes.stream().filter(assinante -> assinante.getNome().equals(nomeDoAssinanteABuscar)).findFirst().orElseThrow(() -> new ExcecaoDeBuscaDeAssinante("O assinante " + nomeDoAssinanteABuscar + " não está cadastrado"));
    }
}
