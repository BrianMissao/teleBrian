package dominio.calculos;

import dominio.builders.PlanoBuilder;
import dominio.entidades.Plano;
import dominio.entidades.assinante.Assinante;
import dominio.builders.AssinantePessoaFisicaBuilder;
import dominio.builders.AssinantePessoaJuridicaBuilder;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalculoDeFaturamentoTest {

    @Test
    public void deveCalcularOFaturamentoTotal() throws ExcecaoDeArgumentoInvalido {
        Plano plano = new PlanoBuilder().comValor(new BigDecimal("100.00")).criar();
        Assinante pessoaFisica = new AssinantePessoaFisicaBuilder().comPlano(plano).criar();
        Assinante pessoaJuridica = new AssinantePessoaJuridicaBuilder().comPlano(plano).comNome("Organizações tabajara").criar();
        List<Assinante> assinantes = new ArrayList<>();
        assinantes.add(pessoaFisica);
        assinantes.add(pessoaJuridica);
        Calculos calculoDeFaturamento = new CalculoDeFaturamento(assinantes);
        BigDecimal totalDeFaturamentoEsperado = new BigDecimal("175.00");

        BigDecimal totalDeFaturamento = calculoDeFaturamento.calcular();

        Assertions.assertThat(totalDeFaturamento).isEqualTo(totalDeFaturamentoEsperado);
    }

}