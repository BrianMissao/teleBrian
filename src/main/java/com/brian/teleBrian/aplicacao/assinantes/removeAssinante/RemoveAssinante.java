package com.brian.teleBrian.aplicacao.assinantes.removeAssinante;

import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeRemocaoDeAssinante;

public interface RemoveAssinante {
    public void remover(Integer IdDoAssinante) throws ExcecaoDeRemocaoDeAssinante;
}
