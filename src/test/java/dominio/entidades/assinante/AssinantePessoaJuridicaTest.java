package dominio.entidades.assinante;

import dominio.PlanoBuilder;
import dominio.entidades.Plano;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

public class AssinantePessoaJuridicaTest {

    @Test
    public void deveObterOValorCorretoDoPlano() throws ExcecaoDeArgumentoInvalido {
        Plano plano = new PlanoBuilder().comValor(new BigDecimal("100.00")).criar();
        Assinante pessoaJuridica = new AssinantePessoaJuridicaBuilder().comPlano(plano).criar();
        BigDecimal valorEsperado = new BigDecimal("75.00").setScale(2, RoundingMode.HALF_EVEN);

        BigDecimal valorDoPlano = pessoaJuridica.obterValorDoPlano();

        Assertions.assertThat(valorDoPlano).isEqualTo(valorEsperado);
    }
}