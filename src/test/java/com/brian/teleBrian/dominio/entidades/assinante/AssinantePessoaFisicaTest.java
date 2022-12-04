package com.brian.teleBrian.dominio.entidades.assinante;

import com.brian.teleBrian.dominio.builders.PlanoBuilder;
import com.brian.teleBrian.dominio.entidades.Plano;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class AssinantePessoaFisicaTest {
    private String nome;
    private String cpf;
    private Plano plano;

    @Before
    public void init() throws ExcecaoDeArgumentoInvalido {
        this.nome = "José Droguinha";
        this.cpf = "000.000.000-00";
        this.plano = new PlanoBuilder().criar();
    }

    @Test
    public void deveCriarUmAssinantePessoaFisica() throws ExcecaoDeArgumentoInvalido {
        String nomeEsperado = "Brian";
        String cpfEsperado = "000.000.000-00";
        Plano planoEsperado = new PlanoBuilder().criar();

        AssinantePessoaFisica assinantePessoaFisica = new AssinantePessoaFisica(nomeEsperado, cpfEsperado, planoEsperado);

        Assertions.assertThat(assinantePessoaFisica.getNome()).isEqualTo(nomeEsperado);
        Assertions.assertThat(assinantePessoaFisica.getCpf()).isEqualTo(cpfEsperado);
        Assertions.assertThat(assinantePessoaFisica.getPlano()).isEqualTo(planoEsperado);
    }

    @Test
    public void naoDeveCriarUmAssinantePessoaFisicaComNomeNulo() throws ExcecaoDeArgumentoInvalido {
        String nomeNulo = null;
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new AssinantePessoaFisica(nomeNulo, cpf, plano));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmAssinantePessoaFisicaComNomeVazio() {
        String nomeVazio = "";
        String mensagemEsperada = "String inválida";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new AssinantePessoaFisica(nomeVazio, cpf, plano));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmAssinantePessoaFisicaComCpfNulo() {
        String cpfNulo = null;
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new AssinantePessoaFisica(nome, cpfNulo, plano));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmAssinantePessoaFisicaComCpfVazio() {
        String cpfVazio = "";
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new AssinantePessoaFisica(nome, cpfVazio, plano));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmAssinantePessoaFisicaComPlanoNulo() {
        Plano planoNulo = null;
        String mensagemEsperada = "Objeto inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new AssinantePessoaFisica(nome, cpf, planoNulo));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void deveAtualizarONome() throws ExcecaoDeArgumentoInvalido {
        AssinantePessoaFisica assinantePessoaFisica = new AssinantePessoaFisica(nome, cpf, plano);
        String nomeAtualizado = "Brian";

        assinantePessoaFisica.atualizarNome(nomeAtualizado);

        Assertions.assertThat(assinantePessoaFisica.getNome()).isEqualTo(nomeAtualizado);
    }

    @Test
    public void naoDeveAtualizarONomeComUmNomeNulo() throws ExcecaoDeArgumentoInvalido {
        AssinantePessoaFisica assinantePessoaFisica = new AssinantePessoaFisica(nome, cpf, plano);
        String nomeNulo = null;
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> assinantePessoaFisica.atualizarNome(nomeNulo));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveAtualizarONomeComUmNomeVazio() throws ExcecaoDeArgumentoInvalido {
        AssinantePessoaFisica assinantePessoaFisica = new AssinantePessoaFisica(nome, cpf, plano);
        String nomeVazio = "";
        String mensagemEsperada = "String inválida";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> assinantePessoaFisica.atualizarNome(nomeVazio));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void deveAtualizarOCpf() throws ExcecaoDeArgumentoInvalido {
        AssinantePessoaFisica assinantePessoaFisica = new AssinantePessoaFisica(nome, cpf, plano);
        String cpfAtualizado = "222.222.222-22";

        assinantePessoaFisica.atualizarCpf(cpfAtualizado);

        Assertions.assertThat(assinantePessoaFisica.getCpf()).isEqualTo(cpfAtualizado);
    }

    @Test
    public void naoDeveAtualizarOCpfComUmCpfNulo() throws ExcecaoDeArgumentoInvalido {
        AssinantePessoaFisica assinantePessoaFisica = new AssinantePessoaFisica(nome, cpf, plano);
        String cpfNulo = null;
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> assinantePessoaFisica.atualizarCpf(cpfNulo));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveAtualizarOCpfComUmCpfVazio() throws ExcecaoDeArgumentoInvalido {
        AssinantePessoaFisica assinantePessoaFisica = new AssinantePessoaFisica(nome, cpf, plano);
        String cpfVazio = "";
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> assinantePessoaFisica.atualizarCpf(cpfVazio));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void deveAtualizarOPlano() throws ExcecaoDeArgumentoInvalido {
        AssinantePessoaFisica assinantePessoaFisica = new AssinantePessoaFisica(nome, cpf, plano);
        Plano planoAtualizado = new PlanoBuilder().criar();

        assinantePessoaFisica.atualizarPlano(planoAtualizado);

        Assertions.assertThat(assinantePessoaFisica.getPlano()).isEqualTo(planoAtualizado);
    }

    @Test
    public void naoDeveAtualizarOPlanoComUmPlanoNulo() throws ExcecaoDeArgumentoInvalido {
        AssinantePessoaFisica assinantePessoaFisica = new AssinantePessoaFisica(nome, cpf, plano);
        Plano planoNulo = null;
        String mensagemEsperada = "Objeto inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> assinantePessoaFisica.atualizarPlano(planoNulo));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void deveObterOValorDoPlano() throws ExcecaoDeArgumentoInvalido {
        BigDecimal valorEsperadoDoPlano = new BigDecimal("100.00");
        AssinantePessoaFisica assinantePessoaFisica = new AssinantePessoaFisica(nome, cpf, plano);

        BigDecimal valorObtidoDoPlano = assinantePessoaFisica.obterValorDoPlano();

        Assertions.assertThat(valorObtidoDoPlano).isEqualTo(valorEsperadoDoPlano);
    }
}