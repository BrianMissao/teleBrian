package com.brian.teleBrian.dominio.entidades;

import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PlanoTest {
    private String nome;
    private BigDecimal valor;

    @Before
    public void init() {
        nome = "Rock and Roll for business";
        valor = new BigDecimal("0.01").setScale(2, RoundingMode.HALF_EVEN);
    }

    @Test
    public void deveCriarUmPlano() throws ExcecaoDeArgumentoInvalido {
        String nomeEsperado = "Fale menos e trabalhe mais";
        BigDecimal valorEsperado = new BigDecimal("0.01");

        Plano plano = new Plano(nomeEsperado, valorEsperado);

        Assertions.assertThat(plano.getNome()).isEqualTo(nomeEsperado);
        Assertions.assertThat(plano.getValor()).isEqualTo(valorEsperado);
    }

    @Test
    public void naoDeveCriarUmPlanoComNomeNulo() {
        String nomeNulo = null;
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new Plano(nomeNulo, valor));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmPlanoComNomeVazio() {
        String nomeVazio = "";
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new Plano(nomeVazio, valor));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmPlanoComValorNulo() {
        BigDecimal valorNulo = null;
        String mensagemEsperada = "BigDecimal inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new Plano(nome, valorNulo));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmPlanoComValorMenorQueZero() {
        BigDecimal valorMenorQueZero = new BigDecimal("-0.01");
        String mensagemEsperada = "BigDecimal inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new Plano(nome, valorMenorQueZero));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmPlanoComValorIgualAZero() {
        BigDecimal valorIgualAZero = BigDecimal.ZERO;
        String mensagemEsperada = "BigDecimal inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new Plano(nome, valorIgualAZero));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void deveAtualizarNome() throws ExcecaoDeArgumentoInvalido {
        Plano plano = new Plano(nome, valor);
        String nomeAtualizado = "Ligação a cobrar";

        plano.atualizarNome(nomeAtualizado);

        Assertions.assertThat(plano.getNome()).isEqualTo(nomeAtualizado);
    }

    @Test
    public void naoDeveAtualizarONomeComUmNomeNulo() throws ExcecaoDeArgumentoInvalido {
        Plano plano = new Plano(nome, valor);
        String nomeNulo = null;
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> plano.atualizarNome(nomeNulo));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveAtualizarONomeComUmNomeVazio() throws ExcecaoDeArgumentoInvalido {
        Plano plano = new Plano(nome, valor);
        String nomeVazio = "";
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> plano.atualizarNome(nomeVazio));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void deveAtualizarValor() throws ExcecaoDeArgumentoInvalido {
        Plano plano = new Plano(nome, valor);
        BigDecimal valorAtualizado = new BigDecimal("500.00");

        plano.atualizarValor(valorAtualizado);

        Assertions.assertThat(plano.getValor()).isEqualTo(valorAtualizado);
    }

    @Test
    public void naoDeveAtualizarOValorComUmValorNulo() throws ExcecaoDeArgumentoInvalido {
        Plano plano = new Plano(nome, valor);
        BigDecimal valorNulo = null;
        String mensagemEsperada = "BigDecimal inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> plano.atualizarValor(valorNulo));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveAtualizarOValorComUmValorMenorQueZero() throws ExcecaoDeArgumentoInvalido {
        Plano plano = new Plano(nome, valor);
        BigDecimal valorMenorQueZero = new BigDecimal("-0.01");
        String mensagemEsperada = "BigDecimal inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> plano.atualizarValor(valorMenorQueZero));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveAtualizarOValorComUmValorIgualAZero() throws ExcecaoDeArgumentoInvalido {
        Plano plano = new Plano(nome, valor);
        BigDecimal valorIgualAZero = BigDecimal.ZERO;
        String mensagemEsperada = "BigDecimal inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> plano.atualizarValor(valorIgualAZero));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }
}