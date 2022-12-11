package com.brian.teleBrian.dominio.builders;

import com.brian.teleBrian.dominio.entidades.Plano;
import com.brian.teleBrian.dominio.entidades.assinante.AssinantePessoaFisica;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;

public class AssinantePessoaFisicaBuilder {

    private String nome;
    private String cpf;
    private Plano plano;

    public AssinantePessoaFisicaBuilder() throws ExcecaoDeArgumentoInvalido {
        this.nome = "Assinante 1";
        this.cpf = "000.000.000-00";
        this.plano = new Plano("Plano1", new BigDecimal(0.01));
    }

    public AssinantePessoaFisicaBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public AssinantePessoaFisicaBuilder comCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public AssinantePessoaFisicaBuilder comPlano(Plano plano) {
        this.plano = plano;
        return this;
    }

    public AssinantePessoaFisica criar() throws ExcecaoDeArgumentoInvalido {
        return new AssinantePessoaFisica(nome, cpf, plano);
    }
}
