package dominio;

import dominio.entidades.Plano;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;

public class ValidadorTest {

    @Test
    public void deveLancarExcecaoAoReceberUmaStringVazia() {
        Validador validador = new Validador();
        String stringASerValidada = "";
        String erroEsperado = "String inválida";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> validador.validarString(stringASerValidada));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(erroEsperado);
    }

    @Test
    public void deveLancarExcecaoAoReceberUmaStringNula() {
        Validador validador = new Validador();
        String erroEsperado = "String inválida";
        String stringASerValidada = null;

        Throwable excecaoLancada = Assertions.catchThrowable(() -> validador.validarString(stringASerValidada));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(erroEsperado);
    }

    @Test
    public void naoDeveLancarExcecaoAoReceberUmaStringValida() {
        String stringValida = "String válida";
        Validador validador = new Validador();

        Throwable excecaoLancada = Assertions.catchThrowable(() -> validador.validarString(stringValida));

        Assertions.assertThat(excecaoLancada).isNull();
    }

    @Test
    public void deveLancarExcecaoAoReceberUmBigDecimalMenorOuIgualAZero() {
        Validador validador = new Validador();
        BigDecimal bigDecimalASerValidado = BigDecimal.ZERO;
        String mensagemEsperada = "BigDecimal inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> validador.validarBigDecimal(bigDecimalASerValidado));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void deveLancarExcecaoAoReceberUmBigDecimalNulo() {
        Validador validador = new Validador();
        String mensagemEsperada = "BigDecimal inválido";
        BigDecimal bigDecimalASerValidado = null;

        Throwable excecaoLancada = Assertions.catchThrowable(() -> validador.validarBigDecimal(bigDecimalASerValidado));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveLancarExcecaoAoReceberUmBigDecimalValido() {
        Validador validador = new Validador();
        BigDecimal bigDecimalValido = new BigDecimal("0.1");

        Throwable excecaoLancada = Assertions.catchThrowable(() -> validador.validarBigDecimal(bigDecimalValido));

        Assertions.assertThat(excecaoLancada).isNull();
    }

    @Test
    public void deveLancarExcecaoAoReceberUmObjetoNulo() {
        Validador validador = new Validador();
        Object objetoAValidar = null;
        String mensagemEsperada = "Objeto inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> validador.validarObjeto(objetoAValidar));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveLancarExcecaoAoReceberUmObjetoValido() throws ExcecaoDeArgumentoInvalido {
        Validador validador = new Validador();
        Plano objetoAValidar = new PlanoBuilder().criar();

        Throwable excecaoLancada = Assertions.catchThrowable(() -> validador.validarObjeto(objetoAValidar));

        Assertions.assertThat(excecaoLancada).isNull();
    }

}