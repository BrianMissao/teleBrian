package com.brian.teleBrian.aplicacao.funcionario;

import com.brian.teleBrian.aplicacao.BaseDTO;

import javax.persistence.Column;
import java.math.BigDecimal;

public class FuncionarioDTO extends BaseDTO {

    private String nome;
    private String cargo;
    private BigDecimal salario;



    public FuncionarioDTO(String nome, String cargo, BigDecimal salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public FuncionarioDTO(Integer id, String nome, String cargo, BigDecimal salario) {
        super(id);
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public FuncionarioDTO(Integer id) {
        super(id);
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }
}
