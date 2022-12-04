package com.brian.teleBrian.dominio.calculos;

import com.brian.teleBrian.dominio.entidades.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CalculoDeGastos implements Calculos {
    private List<Funcionario> funcionarios;

    public CalculoDeGastos(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public BigDecimal calcular() {
        return funcionarios.stream().map(funcionario -> funcionario.getSalario()).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_EVEN);
    }
}
