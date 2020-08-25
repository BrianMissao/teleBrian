package dominio.calculos;

import dominio.builders.FuncionarioBuilder;
import dominio.entidades.Funcionario;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CalculoDeGastosTest {

    @Test
    public void deveCalcularOTotalDeGastos() throws Exception {
        Funcionario funcionario1 = new FuncionarioBuilder().criar();
        Funcionario funcionario2 = new FuncionarioBuilder().comNome("Funcionario2").criar();
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(funcionario1);
        funcionarios.add(funcionario2);
        Calculos calculoDeGastos = new CalculoDeGastos(funcionarios);
        BigDecimal totalDeGastosEsperado = new BigDecimal("10000.00").setScale(2, RoundingMode.HALF_EVEN);

        BigDecimal totalDeGastos = calculoDeGastos.calcular();

        Assertions.assertThat(totalDeGastos).isEqualTo(totalDeGastosEsperado);
    }
}