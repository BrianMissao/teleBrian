package com.brian.teleBrian.aplicacao.assinantes.consultaAssinante;

import com.brian.teleBrian.dominio.entidades.assinante.Assinante;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeBuscaDeAssinante;

import java.util.List;

public class ConsultaAssinanteConcreto implements ConsultaAssinante {
    private List<Assinante> assinantes;

    public ConsultaAssinanteConcreto(List<Assinante> assinantes) {
        this.assinantes = assinantes;
    }

    @Override
    public Assinante consultar(String nomeDoAssinanteAConsultar) throws ExcecaoDeBuscaDeAssinante {
        return assinantes.stream().filter(assinante -> assinante.getNome().equals(nomeDoAssinanteAConsultar)).findFirst().orElseThrow(() -> new ExcecaoDeBuscaDeAssinante("Assinante não encontrado"));
    }
}
