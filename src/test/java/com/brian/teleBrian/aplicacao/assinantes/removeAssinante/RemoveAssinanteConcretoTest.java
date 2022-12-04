package com.brian.teleBrian.aplicacao.assinantes.removeAssinante;

import com.brian.teleBrian.dominio.entidades.assinante.Assinante;
import com.brian.teleBrian.dominio.builders.AssinantePessoaFisicaBuilder;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeRemocaoDeAssinante;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RemoveAssinanteConcretoTest {
    private List<Assinante> assinantes;
    private Assinante pessoaFisica;
    private Assinante pessoaJuridica;

    @Before
    public void criarCenariosPadroes() throws ExcecaoDeArgumentoInvalido {
        pessoaFisica = new AssinantePessoaFisicaBuilder().comNome("Brian").criar();
        assinantes = new ArrayList<>();
        assinantes.add(pessoaFisica);
    }

    @Test
    public void deveRemoverUmAssinanteDaListaDeAssinantes() throws ExcecaoDeRemocaoDeAssinante {
        RemoveAssinante removeAssinante = new RemoveAssinanteConcreto(assinantes);

        removeAssinante.remover(pessoaFisica.getNome());

        Assertions.assertThat(assinantes).doesNotContain(pessoaFisica);
    }

    @Test
    public void deveLancarExcecaoAoRemoverUmAssinanteInexistente() {
        RemoveAssinante removeAssinante = new RemoveAssinanteConcreto(assinantes);
        String nomeDoAssinanteARemover =  "José";
        String mensagemEsperada = "O assinante não pode ser removido.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> removeAssinante.remover(nomeDoAssinanteARemover));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }
}