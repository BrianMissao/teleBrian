package com.brian.teleBrian.aplicacao.assinantes.consultaAssinante;

import com.brian.teleBrian.dominio.entidades.assinante.Assinante;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeBuscaDeAssinante;

public interface ConsultaAssinante {
    public Assinante consultar(String nomeDoAssinanteAConsultar) throws ExcecaoDeBuscaDeAssinante;
}
