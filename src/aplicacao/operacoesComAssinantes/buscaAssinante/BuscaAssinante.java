package aplicacao.operacoesComAssinantes.buscaAssinante;

import dominio.entidades.Assinante;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeBuscaDeAssinante;

public interface BuscaAssinante {
    public abstract Assinante buscar(String nomeDoAssinanteABuscar) throws ExcecaoDeBuscaDeAssinante;
}
