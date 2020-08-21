package dominio.entidades.assinante;

import dominio.PlanoBuilder;
import dominio.entidades.Plano;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AssinantePessoaJuridicaTest {
    private Plano plano;
    private String nome;
    private String cnpj;

    @Before
    public void init() throws ExcecaoDeArgumentoInvalido {
        nome = "Organizações Tabajara";
        cnpj = "000.000.000-00";
        plano = new PlanoBuilder().criar();
    }

    @Test
    public void deveCriarUmAssinanteDePessoaJuridica() throws ExcecaoDeArgumentoInvalido {
        String nomeEsperado = "Brian";
        String cnpjEsperado = "00.00000.00";
        Plano planoEsperado = new PlanoBuilder().criar();

        AssinantePessoaJuridica assinantePessoaJuridica = new AssinantePessoaJuridica(nomeEsperado, cnpjEsperado, planoEsperado);

        Assertions.assertThat(assinantePessoaJuridica.getNome()).isEqualTo(nomeEsperado);
        Assertions.assertThat(assinantePessoaJuridica.getCnpj()).isEqualTo(cnpjEsperado);
        Assertions.assertThat(assinantePessoaJuridica.getPlano()).isEqualTo(planoEsperado);
    }

    @Test
    public void naoDeveCriarUmAssinanteDePessoaJuridicaSeNomeForNulo() throws ExcecaoDeArgumentoInvalido {
        String nomeNulo = null;
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new AssinantePessoaJuridica(nomeNulo, cnpj, plano));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmAssinanteDePessoaJuridicaSeONomeForVazio() throws ExcecaoDeArgumentoInvalido {
        String nomeVazio = "";
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new AssinantePessoaJuridica(nomeVazio, cnpj, plano));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmAssinanteSemUmPlano() {
        Plano planoNulo = null;
        String mensagemEsperada = "Objeto inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new AssinantePessoaJuridica(nome, cnpj, planoNulo));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmAssinanteDePessoaJuridicaComUmCnpjNulo() throws ExcecaoDeArgumentoInvalido {
        String cnpjNulo = null;
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new AssinantePessoaJuridica(nome, cnpjNulo, plano));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmAssinanteDePessoaJuridicaComUmCnpjVazio() throws ExcecaoDeArgumentoInvalido {
        String cnpjVazio = "";
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new AssinantePessoaJuridica(nome, cnpjVazio, plano));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void deveAtualizarNome() throws ExcecaoDeArgumentoInvalido {
        String nomeAtualizado = "Diego";
        AssinantePessoaJuridica assinantePessoaJuridica = new AssinantePessoaJuridica(nome, cnpj, plano);

        assinantePessoaJuridica.atualizarNome(nomeAtualizado);

        Assertions.assertThat(assinantePessoaJuridica.getNome()).isEqualTo(nomeAtualizado);
    }

    @Test
    public void naoDeveAtualizarONomeComNomeVazio() throws ExcecaoDeArgumentoInvalido {
        String mensagemEsperada = "String inválida.";
        AssinantePessoaJuridica assinantePessoaJuridica = new AssinantePessoaJuridica(nome, cnpj, plano);
        String nomeAtualizado = "";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> assinantePessoaJuridica.atualizarNome(nomeAtualizado));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveAtualizarONomeComUmNomeNulo() throws ExcecaoDeArgumentoInvalido {
        String nomeAtualizado = null;
        String mensagemEsperada = "String inválida.";
        AssinantePessoaJuridica assinantePessoaJuridica = new AssinantePessoaJuridica(nome, cnpj, plano);

        Throwable excecaoLancada = Assertions.catchThrowable(() -> assinantePessoaJuridica.atualizarNome(nomeAtualizado));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void deveAtualizarCnpj() throws ExcecaoDeArgumentoInvalido {
        AssinantePessoaJuridica assinantePessoaJuridica = new AssinantePessoaJuridica(nome, cnpj, plano);
        String cnpjAtualizado = "111.111.111-11";

        assinantePessoaJuridica.atualizarCnpj(cnpjAtualizado);

        Assertions.assertThat(assinantePessoaJuridica.getCnpj()).isEqualTo(cnpjAtualizado);
    }

    @Test
    public void naoDeveAtualizarOCnpjComUmCnpjNulo() throws ExcecaoDeArgumentoInvalido {
        AssinantePessoaJuridica assinantePessoaJuridica = new AssinantePessoaJuridica(nome, cnpj, plano);
        String cnpjAtualizado = null;
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> assinantePessoaJuridica.atualizarCnpj(cnpjAtualizado));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveAtualizarOCnpjComUmCnpjVazio() throws ExcecaoDeArgumentoInvalido {
        AssinantePessoaJuridica assinantePessoaJuridica = new AssinantePessoaJuridica(nome, cnpj, plano);
        String cnpjAtualizado = "";
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> assinantePessoaJuridica.atualizarCnpj(cnpjAtualizado));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void deveAtualizarOPlano() throws ExcecaoDeArgumentoInvalido {
        AssinantePessoaJuridica assinantePessoaJuridica = new AssinantePessoaJuridica(nome, cnpj, plano);
        Plano planoAtualizado = new PlanoBuilder().criar();

        assinantePessoaJuridica.atualizarPlano(planoAtualizado);

        Assertions.assertThat(assinantePessoaJuridica.getPlano()).isEqualTo(planoAtualizado);
    }

    @Test
    public void naoDeveAtualizarOPlanoComUmPlanoNulo() throws ExcecaoDeArgumentoInvalido {
        AssinantePessoaJuridica assinantePessoaJuridica = new AssinantePessoaJuridica(nome, cnpj, plano);
        Plano planoAtualizado = null;
        String mensagemEsperada = "Objeto inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> assinantePessoaJuridica.atualizarPlano(planoAtualizado));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void deveObterOValorDoPlano() throws ExcecaoDeArgumentoInvalido {
        AssinantePessoaJuridica assinantePessoaJuridica = new AssinantePessoaJuridica(nome, cnpj, plano);
        BigDecimal valorEsperadoDoPlano = new BigDecimal("75.00").setScale(2, RoundingMode.HALF_EVEN);

        BigDecimal valorDoPlanoObtido = assinantePessoaJuridica.obterValorDoPlano();

        Assertions.assertThat(valorDoPlanoObtido).isEqualTo(valorEsperadoDoPlano);
    }
}