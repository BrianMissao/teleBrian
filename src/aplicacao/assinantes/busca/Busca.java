package aplicacao.assinantes.busca;

import dominio.entidades.assinante.Assinante;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeBuscaDeAssinante;

public interface Busca {
    public Assinante buscar(String nomeDoAssinanteABuscar) throws ExcecaoDeBuscaDeAssinante;
}
