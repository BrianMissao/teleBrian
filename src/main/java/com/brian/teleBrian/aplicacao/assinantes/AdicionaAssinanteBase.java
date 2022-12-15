package com.brian.teleBrian.aplicacao.assinantes;

import com.brian.teleBrian.aplicacao.assinantes.adicionaAssinante.AdicionaAssinante;
import com.brian.teleBrian.dominio.entidades.assinante.Assinante;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDePlanoInesistente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AdicionaAssinanteBase {

    @Qualifier("AdicionaAssinantePessoaFisica")
    private final AdicionaAssinante adicionaAssinantePessoaFisica;

    @Qualifier("AdicionaAssinantePessoaJuridica")
    private final AdicionaAssinante adicionaAssinantePessoaJuridica;

    public AdicionaAssinanteBase(AdicionaAssinante adicionaAssinantePessoaFisica, AdicionaAssinante adicionaAssinantePessoaJuridica) {
        this.adicionaAssinantePessoaFisica = adicionaAssinantePessoaFisica;
        this.adicionaAssinantePessoaJuridica = adicionaAssinantePessoaJuridica;
    }

    public Assinante adicionar(AssinanteDTO assinanteDTO) throws ExcecaoDePlanoInesistente, ExcecaoDeArgumentoInvalido {
        if (assinanteDTO instanceof AssinantePessoaFisicaDTO) {
            return adicionaAssinantePessoaFisica.adicionar(assinanteDTO);
        }
        return adicionaAssinantePessoaJuridica.adicionar(assinanteDTO);
    }
}
