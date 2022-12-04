package com.brian.teleBrian.dominio.builders;

import com.brian.teleBrian.dominio.entidades.Plano;
import com.brian.teleBrian.dominio.entidades.assinante.AssinantePessoaJuridica;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;

public class AssinantePessoaJuridicaBuilder {
    private String nome;
    private String cnpj;
    private Plano plano;

    public AssinantePessoaJuridicaBuilder() throws ExcecaoDeArgumentoInvalido {
        this.nome = "Assinante Jurídico";
        this.cnpj = "000.000.000-00";
        this.plano = new Plano("Plano1", new BigDecimal("0.01"));
    }

    public AssinantePessoaJuridicaBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public AssinantePessoaJuridicaBuilder comCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public AssinantePessoaJuridicaBuilder comPlano(Plano plano) {
        this.plano = plano;
        return this;
    }

    public AssinantePessoaJuridica criar() throws ExcecaoDeArgumentoInvalido {
        return new AssinantePessoaJuridica(nome, cnpj, plano);
    }
}
