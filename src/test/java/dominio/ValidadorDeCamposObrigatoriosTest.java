package dominio;

import dominio.entidades.Plano;
import dominio.builders.PlanoBuilder;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ValidadorDeCamposObrigatoriosTest {

    private ValidadorDeCamposObrigatorios validadorDeCamposObrigatorios;

    @Before
    public void init() throws Exception {
        validadorDeCamposObrigatorios = new ValidadorDeCamposObrigatorios();
    }

    @Test
    public void deveLancarExcecaoAoReceberUmaStringVazia() {
        String stringASerValidada = "";
        String erroEsperado = "String inválida";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> validadorDeCamposObrigatorios.validarString(stringASerValidada));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(erroEsperado);
    }

    @Test
    public void deveLancarExcecaoAoReceberUmaStringNula() {
        String erroEsperado = "String inválida";
        String stringASerValidada = null;

        Throwable excecaoLancada = Assertions.catchThrowable(() -> validadorDeCamposObrigatorios.validarString(stringASerValidada));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(erroEsperado);
    }

    @Test
    public void naoDeveLancarExcecaoAoReceberUmaStringValida() {
        String stringValida = "String válida";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> validadorDeCamposObrigatorios.validarString(stringValida));

        Assertions.assertThat(excecaoLancada).isNull();
    }

    @Test
    public void deveLancarExcecaoAoReceberUmBigDecimalMenorOuIgualAZero() {
        BigDecimal bigDecimalASerValidado = BigDecimal.ZERO;
        String mensagemEsperada = "BigDecimal inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> validadorDeCamposObrigatorios.validarBigDecimal(bigDecimalASerValidado));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void deveLancarExcecaoAoReceberUmBigDecimalNulo() {
        String mensagemEsperada = "BigDecimal inválido";
        BigDecimal bigDecimalASerValidado = null;

        Throwable excecaoLancada = Assertions.catchThrowable(() -> validadorDeCamposObrigatorios.validarBigDecimal(bigDecimalASerValidado));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveLancarExcecaoAoReceberUmBigDecimalValido() {
        BigDecimal bigDecimalValido = new BigDecimal("0.1");

        Throwable excecaoLancada = Assertions.catchThrowable(() -> validadorDeCamposObrigatorios.validarBigDecimal(bigDecimalValido));

        Assertions.assertThat(excecaoLancada).isNull();
    }

    @Test
    public void deveLancarExcecaoAoReceberUmObjetoNulo() {
        Object objetoAValidar = null;
        String mensagemEsperada = "Objeto inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> validadorDeCamposObrigatorios.validarObjeto(objetoAValidar));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveLancarExcecaoAoReceberUmObjetoValido() throws ExcecaoDeArgumentoInvalido {
        Plano objetoAValidar = new PlanoBuilder().criar();

        Throwable excecaoLancada = Assertions.catchThrowable(() -> validadorDeCamposObrigatorios.validarObjeto(objetoAValidar));

        Assertions.assertThat(excecaoLancada).isNull();
    }
}