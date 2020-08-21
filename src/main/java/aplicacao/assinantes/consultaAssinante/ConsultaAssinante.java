package aplicacao.assinantes.consultaAssinante;

import dominio.entidades.assinante.Assinante;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeBuscaDeAssinante;

public interface ConsultaAssinante {
    public Assinante consultar(String nomeDoAssinanteAConsultar) throws ExcecaoDeBuscaDeAssinante;
}
