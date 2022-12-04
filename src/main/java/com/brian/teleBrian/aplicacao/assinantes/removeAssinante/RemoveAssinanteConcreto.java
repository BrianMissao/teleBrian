package com.brian.teleBrian.aplicacao.assinantes.removeAssinante;

import com.brian.teleBrian.dominio.entidades.assinante.Assinante;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeRemocaoDeAssinante;

import java.util.List;

public class RemoveAssinanteConcreto implements RemoveAssinante {
    private List<Assinante> assinantes;

    public RemoveAssinanteConcreto(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    @Override
    public void remover(String nomeDoAssinanteARemover) throws ExcecaoDeRemocaoDeAssinante {
        if (!assinantes.removeIf(assinante -> assinante.getNome().equals(nomeDoAssinanteARemover))) {
            throw new ExcecaoDeRemocaoDeAssinante("O assinante não pode ser removido.");
        }
    }
}
