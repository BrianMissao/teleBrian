package aplicacao;

import dominio.calculos.Calculos;

import java.math.BigDecimal;

public class ObtemBalancoFinanceiro {
    private Calculos calculoDeFaturamento;
    private Calculos calculoDeGastos;

    public ObtemBalancoFinanceiro(Calculos calculoDeFaturamento, Calculos calculoDeGastos) {
        this.calculoDeFaturamento = calculoDeFaturamento;
        this.calculoDeGastos = calculoDeGastos;
    }

    public BigDecimal obter() {
        return null;
    }
}
