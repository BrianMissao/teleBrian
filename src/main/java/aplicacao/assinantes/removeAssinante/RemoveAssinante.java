package aplicacao.assinantes.removeAssinante;

import dominio.excecoesDeRegraDeNegocio.ExcecaoDeRemocaoDeAssinante;

public interface RemoveAssinante {
    public void remover(String nomeDoAssinanteARemover) throws ExcecaoDeRemocaoDeAssinante;
}
