package com.brian.teleBrian.aplicacao.assinantes.consultaAssinante;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.brian.teleBrian.aplicacao.TesteBase;
import com.brian.teleBrian.dominio.builders.AssinantePessoaFisicaBuilder;
import com.brian.teleBrian.dominio.builders.AssinantePessoaJuridicaBuilder;
import com.brian.teleBrian.dominio.entidades.PlanoCrudRepository;
import com.brian.teleBrian.dominio.entidades.assinante.Assinante;
import com.brian.teleBrian.dominio.entidades.assinante.AssinanteCrudRepository;
import com.brian.teleBrian.dominio.entidades.assinante.AssinantePessoaFisica;
import com.brian.teleBrian.dominio.entidades.assinante.AssinantePessoaJuridica;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeBuscaDeAssinante;

public class ConsultaAssinanteConcretoTest extends TesteBase {

    @Autowired
    private ConsultaAssinante consultaAssinante;

    @Autowired
    private AssinanteCrudRepository assinanteCrudRepository;

    @Autowired
    private PlanoCrudRepository planoCrudRepository;

    @Test
    public void deveConsultarUmAssinanteNaListaDeAssinantes()
            throws ExcecaoDeBuscaDeAssinante, ExcecaoDeArgumentoInvalido {
        AssinantePessoaFisica assinanteDoTipoPessoaFisica = new AssinantePessoaFisicaBuilder().comNome("Brian").criar();
        String nomeDoAssinanteABuscar = "Brian";
        planoCrudRepository.save(assinanteDoTipoPessoaFisica.getPlano());
        assinanteCrudRepository.save(assinanteDoTipoPessoaFisica);

        Assinante assinanteEncontrado = consultaAssinante.consultar(nomeDoAssinanteABuscar);

        assertThat(assinanteEncontrado).isEqualTo(assinanteDoTipoPessoaFisica);
    }

    @Test
    public void deve_lancar_excecao_se_nao_encontrar_o_assinante() throws ExcecaoDeArgumentoInvalido {
        AssinantePessoaJuridica assinanteDoTipoPessoaJuridica = new AssinantePessoaJuridicaBuilder()
                .comNome("Organizações Tabajara").criar();
        String nomeDoAssinanteABuscar = "José";
        planoCrudRepository.save(assinanteDoTipoPessoaJuridica.getPlano());
        assinanteCrudRepository.save(assinanteDoTipoPessoaJuridica);

        Throwable excecaoLancada = Assertions.catchThrowable(() -> consultaAssinante.consultar(nomeDoAssinanteABuscar));

        assertThat(excecaoLancada).hasMessageContaining("Assinante não encontrado");
    }
}