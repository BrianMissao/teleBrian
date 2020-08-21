package aplicacao.assinantes.consultaAssinante;

import dominio.builders.AssinantePessoaFisicaBuilder;
import dominio.builders.AssinantePessoaJuridicaBuilder;
import dominio.entidades.assinante.*;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeBuscaDeAssinante;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ConsultaAssinanteConcretoTest {
    private List<Assinante> assinantes;

    @Before
    public void inicia() throws ExcecaoDeArgumentoInvalido {
        assinantes = new ArrayList<>();
    }

    @Test
    public void deveConsultarUmAssinanteNaListaDeAssinantes() throws ExcecaoDeBuscaDeAssinante, ExcecaoDeArgumentoInvalido {
        AssinantePessoaFisica assinanteDoTipoPessoaFisica = new AssinantePessoaFisicaBuilder().comNome("Brian").criar();
        ConsultaAssinante consultaAssinante = new ConsultaAssinanteConcreto(assinantes);
        String nomeDoAssinanteABuscar = "Brian";
        assinantes.add(assinanteDoTipoPessoaFisica);

        Assinante assinanteEncontrado = consultaAssinante.consultar(nomeDoAssinanteABuscar);

        Assertions.assertThat(assinanteEncontrado).isEqualTo(assinanteDoTipoPessoaFisica);
    }

    @Test
    public void deveLancarExcecaoSeNaoEncontrarOAssinante() throws ExcecaoDeArgumentoInvalido {
        AssinantePessoaJuridica assinanteDoTipoPessoaJuridica = new AssinantePessoaJuridicaBuilder().comNome("Organizações Tabajara").criar();
        ConsultaAssinante consultaAssinante = new ConsultaAssinanteConcreto(assinantes);
        String nomeDoAssinanteABuscar = "José";
        assinantes.add(assinanteDoTipoPessoaJuridica);

        Throwable excecaoLancada = Assertions.catchThrowable(() -> consultaAssinante.consultar(nomeDoAssinanteABuscar));

        Assertions.assertThat(excecaoLancada).hasMessageContaining("Assinante não encontrado");
    }

}