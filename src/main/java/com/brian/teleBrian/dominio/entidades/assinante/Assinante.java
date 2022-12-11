package com.brian.teleBrian.dominio.entidades.assinante;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import com.brian.teleBrian.dominio.ValidadorDeCamposObrigatorios;
import com.brian.teleBrian.dominio.entidades.EntidadeBase;
import com.brian.teleBrian.dominio.entidades.Plano;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "tipo", length = 32)
public abstract class Assinante extends EntidadeBase {

    @Column
    private String nome;

    @ManyToOne
    private Plano plano;

    public Assinante() {
    }

    public Assinante(String nome, Plano plano) throws ExcecaoDeArgumentoInvalido {
        validarCamposObrigatorios(nome, plano);
        this.nome = nome;
        this.plano = plano;
    }

    private void validarCamposObrigatorios(String nome, Plano plano) throws ExcecaoDeArgumentoInvalido {
        new ValidadorDeCamposObrigatorios().validarObjeto(plano).validarString(nome).validar();
    }

    public String obterNomeDoPlano() {
        return plano.getNome();
    }

    public BigDecimal obterValorDoPlano() {
        return plano.getValor();
    }

    public String getNome() {
        return nome;
    }

    public void atualizarNome(String nome) throws ExcecaoDeArgumentoInvalido {
        new ValidadorDeCamposObrigatorios().validarString(nome).validar();
        this.nome = nome;
    }

    public Plano getPlano() {
        return plano;
    }

    public void atualizarPlano(Plano planoAtualizado) throws ExcecaoDeArgumentoInvalido {
        new ValidadorDeCamposObrigatorios().validarObjeto(planoAtualizado).validar();
        this.plano = planoAtualizado;
    }
}