package aplicacao.operacoesComAssinantes.removeAssinante;

import dominio.excecoesDeRegraDeNegocio.ExcecaoDeRemocaoDeAssinante;

public interface RemoveAssinante {
    public abstract void remover(String nomeDoAssinanteARemover) throws ExcecaoDeRemocaoDeAssinante;
}
