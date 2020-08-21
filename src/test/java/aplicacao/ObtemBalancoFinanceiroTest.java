package aplicacao;

import dominio.calculos.Calculos;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class ObtemBalancoFinanceiroTest {
    @InjectMocks
    @Mock
    private Calculos calculoDeFaturamento;
    @Mock
    private Calculos calculoDeGastos;


}