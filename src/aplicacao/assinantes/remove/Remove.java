package aplicacao.assinantes.remove;

import dominio.excecoesDeRegraDeNegocio.ExcecaoDeRemocaoDeAssinante;

public interface Remove {
    public void remover(String nomeDoAssinanteARemover) throws ExcecaoDeRemocaoDeAssinante;
}
