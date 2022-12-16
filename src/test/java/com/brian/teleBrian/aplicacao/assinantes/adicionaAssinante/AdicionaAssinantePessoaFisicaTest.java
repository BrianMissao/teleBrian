package com.brian.teleBrian.aplicacao.assinantes.adicionaAssinante;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.brian.teleBrian.aplicacao.TesteBase;
import com.brian.teleBrian.aplicacao.assinantes.AssinanteDTO;
import com.brian.teleBrian.aplicacao.assinantes.AssinantePessoaFisicaDTO;
import com.brian.teleBrian.aplicacao.plano.PlanoDTO;
import com.brian.teleBrian.dominio.builders.PlanoBuilder;
import com.brian.teleBrian.dominio.entidades.Plano;
import com.brian.teleBrian.dominio.entidades.PlanoCrudRepository;
import com.brian.teleBrian.dominio.entidades.assinante.Assinante;
import com.brian.teleBrian.dominio.entidades.assinante.AssinanteCrudRepository;
import com.brian.teleBrian.dominio.entidades.assinante.AssinantePessoaFisica;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDePlanoInesistente;

public class AdicionaAssinantePessoaFisicaTest extends TesteBase {

        @Autowired
        private AssinanteCrudRepository assinanteCrudRepository;

        @Autowired
        @Qualifier("AdicionaAssinantePessoaFisica")
        private AdicionaAssinante adicionaAssinante;

        @Autowired
        private PlanoCrudRepository planoCrudRepository;

        @Test
        public void deve_adicionar_um_assinante_pessoa_fisica()
                        throws ExcecaoDeArgumentoInvalido, ExcecaoDePlanoInesistente {
                Plano plano = new PlanoBuilder().criar();
                planoCrudRepository.save(plano);
                PlanoDTO planoDTO = new PlanoDTO(plano.getId());
                String nomeEsperado = "Cileide";
                String cpfEsperado = "098.3098.179.50";
//                AssinantePessoaFisicaDTO assinantePessoaFisicaDTO = new AssinantePessoaFisicaDTO(nomeEsperado,
//                                planoDTO, cpfEsperado);
            AssinantePessoaFisicaDTO assinantePessoaFisicaDTO = new AssinantePessoaFisicaDTO();

                adicionaAssinante.adicionar(assinantePessoaFisicaDTO);

                Iterable<Assinante> assinantesRetornados = assinanteCrudRepository.findAll();
                assertThat(assinantesRetornados).hasSize(1);
                Assinante assinante = assinantesRetornados.iterator().next();
                assertThat(assinante).isInstanceOf(AssinantePessoaFisica.class);
                assertThat(assinante.getNome()).isEqualTo(nomeEsperado);
        }

    @Test
    public void deve_lancar_excecao_ao_tentar_adicionar_um_assinante_com_plano_inexistente_na_base_de_dados()
            throws ExcecaoDeArgumentoInvalido {
        Integer idInexistente = 1;
        PlanoDTO planoDTO = new PlanoDTO(idInexistente);
//                AssinanteDTO assinantePessoaFisicaDTO = new AssinantePessoaFisicaDTO("Super Brian",
//                planoDTO, "043.856.222-87");
        AssinantePessoaFisicaDTO assinantePessoaFisicaDTO = new AssinantePessoaFisicaDTO();

        Throwable throwable = catchThrowable(() -> adicionaAssinante.adicionar(assinantePessoaFisicaDTO));

        assertThat(throwable).isInstanceOf(ExcecaoDePlanoInesistente.class)
                .hasMessage("Não foi possível adicionar o assinante porque o plano informado não existe.");
    }
}