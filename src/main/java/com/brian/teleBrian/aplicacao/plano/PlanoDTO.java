package com.brian.teleBrian.aplicacao.plano;

import java.math.BigDecimal;

import com.brian.teleBrian.aplicacao.BaseDTO;

public class PlanoDTO extends BaseDTO {

    private String nome;
    private BigDecimal valor;

    public PlanoDTO(Integer id) {
        super(id);
    }

    public PlanoDTO(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

}
