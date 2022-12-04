package com.brian.teleBrian.dominio.entidades.assinante;

import com.brian.teleBrian.dominio.ValidadorDeCamposObrigatorios;
import com.brian.teleBrian.dominio.entidades.Plano;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AssinantePessoaJuridica extends Assinante {
    private String cnpj;

    public AssinantePessoaJuridica(String nome, String cnpj, Plano plano) throws ExcecaoDeArgumentoInvalido {
        super(nome, plano);
        validarCamposObrigatorios(cnpj);
        this.cnpj = cnpj;
    }

    private void validarCamposObrigatorios(String campoAValidar) throws ExcecaoDeArgumentoInvalido {
        new ValidadorDeCamposObrigatorios().validarString(campoAValidar).validar();
    }

    public void atualizarCnpj(String cnpjAtualizado) throws ExcecaoDeArgumentoInvalido {
        validarCamposObrigatorios(cnpjAtualizado);
        this.cnpj = cnpjAtualizado;
    }

    @Override
    public BigDecimal obterValorDoPlano() {
        BigDecimal valorDoDesconto = super.obterValorDoPlano().multiply(new BigDecimal("0.25"));
        return super.obterValorDoPlano().subtract(valorDoDesconto).setScale(2, RoundingMode.HALF_EVEN);
    }

    public String getCnpj() {
        return cnpj;
    }
}
