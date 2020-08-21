package aplicacao;

import dominio.calculos.Calculos;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

public class ObtemBalancoFinanceiroTest {
    @Mock
    private Calculos calculoDeFaturamento;
    @Mock
    private Calculos calculoDeGastos;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deveObterOBalancoFinanceiro() {
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