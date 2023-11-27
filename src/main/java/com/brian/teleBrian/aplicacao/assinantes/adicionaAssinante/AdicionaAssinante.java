package com.brian.teleBrian.aplicacao.assinantes.adicionaAssinante;

import com.brian.teleBrian.aplicacao.assinantes.AssinanteDTO;
import com.brian.teleBrian.dominio.entidades.assinante.Assinante;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDePlanoInesistente;

public interface AdicionaAssinante {
    public Assinante adicionar(AssinanteDTO assinanteDTO) throws ExcecaoDeArgumentoInvalido, ExcecaoDePlanoInesistente;
}
