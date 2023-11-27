package com.brian.teleBrian.aplicacao;

import com.brian.teleBrian.dominio.calculos.Calculos;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ObtemBalancoFinanceiroTest extends TesteBase {

    @SpyBean
    @Qualifier("CalculoDeFaturamento")
    private Calculos calculoDeFaturamento;

    @SpyBean
    @Qualifier("CalculoDeGastos")
    private Calculos calculoDeGastos;

    @Autowired
    private ObtemBalancoFinanceiro obtemBalancoFinanceiro;

    @Test
    public void deveObterOBalancoFinanceiro() {
        BigDecimal totalDeFaturamento = new BigDecimal("1000.00");
        BigDecimal totalDeGastos = new BigDecimal("800.00");
        BigDecimal balancoEsperado = new BigDecimal("200.00");
        when(calculoDeFaturamento.calcular()).thenReturn(totalDeFaturamento.setScale(2, RoundingMode.HALF_EVEN));
        when(calculoDeGastos.calcular()).thenReturn(totalDeGastos.setScale(2, RoundingMode.HALF_EVEN));

        BigDecimal balancoObtido = obtemBalancoFinanceiro.obter();

        assertThat(balancoObtido).isEqualTo(balancoEsperado);
    }
}