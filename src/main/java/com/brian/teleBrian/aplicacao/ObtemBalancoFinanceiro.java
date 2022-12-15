package com.brian.teleBrian.aplicacao;

import com.brian.teleBrian.dominio.calculos.Calculos;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ObtemBalancoFinanceiro {

    @Qualifier("CalculoDeFaturamento")
    private Calculos calculoDeFaturamento;

    @Qualifier("CalculoDeFaturamento")
    private Calculos calculoDeGastos;

    public ObtemBalancoFinanceiro(Calculos calculoDeFaturamento, Calculos calculoDeGastos) {
        this.calculoDeFaturamento = calculoDeFaturamento;
        this.calculoDeGastos = calculoDeGastos;
    }

    public BigDecimal obter() {
        return calculoDeFaturamento.calcular().subtract(calculoDeGastos.calcular());
    }
}
