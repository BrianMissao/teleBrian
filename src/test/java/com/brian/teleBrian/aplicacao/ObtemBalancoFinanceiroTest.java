package com.brian.teleBrian.aplicacao;

import com.brian.teleBrian.dominio.calculos.Calculos;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ObtemBalancoFinanceiroTest {

    private Calculos calculoDeFaturamento;

    private Calculos calculoDeGastos;

    @Test
    public void deveObterOBalancoFinanceiro() {
        calculoDeFaturamento = Mockito.mock(Calculos.class);
        calculoDeGastos = Mockito.mock(Calculos.class);
        BigDecimal totalDeFaturamento = new BigDecimal("1000.00");
        BigDecimal totalDeGastos = new BigDecimal("800.00");
        BigDecimal balancoEsperado = new BigDecimal("200.00");
        Mockito.when(calculoDeFaturamento.calcular()).thenReturn(totalDeFaturamento.setScale(2, RoundingMode.HALF_EVEN));
        Mockito.when(calculoDeGastos.calcular()).thenReturn(totalDeGastos.setScale(2, RoundingMode.HALF_EVEN));
        ObtemBalancoFinanceiro obtemBalancoFinanceiro = new ObtemBalancoFinanceiro(calculoDeFaturamento, calculoDeGastos);

        BigDecimal balancoObtido = obtemBalancoFinanceiro.obter();

        Assertions.assertThat(balancoObtido).isEqualTo(balancoEsperado);
    }
}