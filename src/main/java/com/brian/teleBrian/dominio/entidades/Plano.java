package com.brian.teleBrian.dominio.entidades;

import com.brian.teleBrian.dominio.ValidadorDeCamposObrigatorios;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Plano extends EntidadeBase {

    @Column
    private String nome;

    @Column
    private BigDecimal valor;

    public Plano() {
    }

    public Plano(String nome, BigDecimal valor) throws ExcecaoDeArgumentoInvalido {
        validarNome(nome);
        validarValor(valor);
        this.nome = nome;
        this.valor = valor.setScale(2, RoundingMode.HALF_EVEN);
    }

    private void validarValor(BigDecimal valor) throws ExcecaoDeArgumentoInvalido {
        new ValidadorDeCamposObrigatorios().validarBigDecimal(valor).validar();
    }

    private void validarNome(String nome) throws ExcecaoDeArgumentoInvalido {
        new ValidadorDeCamposObrigatorios().validarString(nome).validar();
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void atualizarNome(String nomeAtualizado) throws ExcecaoDeArgumentoInvalido {
        validarNome(nomeAtualizado);
        this.nome = nomeAtualizado;
    }

    public void atualizarValor(BigDecimal valorAtualizado) throws ExcecaoDeArgumentoInvalido {
        validarValor(valorAtualizado);
        this.valor = valorAtualizado;
    }
}
