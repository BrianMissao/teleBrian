package com.brian.teleBrian.aplicacao.assinantes;

import com.brian.teleBrian.aplicacao.TesteBase;
import com.brian.teleBrian.aplicacao.plano.PlanoDTO;
import com.brian.teleBrian.dominio.builders.PlanoBuilder;
import com.brian.teleBrian.dominio.entidades.Plano;
import com.brian.teleBrian.dominio.entidades.PlanoCrudRepository;
import com.brian.teleBrian.dominio.entidades.assinante.Assinante;
import com.brian.teleBrian.dominio.entidades.assinante.AssinanteCrudRepository;
import com.brian.teleBrian.dominio.entidades.assinante.AssinantePessoaFisica;
import com.brian.teleBrian.dominio.entidades.assinante.AssinantePessoaJuridica;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDePlanoInesistente;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class AdicionaAssinanteBaseTest extends TesteBase {

    @Autowired
    private AdicionaAssinanteBase adicionaAssinante;

    @Autowired
    private PlanoCrudRepository planoCrudRepository;

    @Autowired
    private AssinanteCrudRepository assinanteCrudRepository;

    @Test
    public void deve_adicionar_um_assinante_pessoa_fisica_se_a_instancia_do_dto_for_de_pessoa_fisica() throws ExcecaoDeArgumentoInvalido, ExcecaoDePlanoInesistente {
        Plano plano = new PlanoBuilder().criar();
        planoCrudRepository.save(plano);
        PlanoDTO planoDTO = new PlanoDTO(plano.getId());
        String nomeEsperado = "Cileide";
        String cpfEsperado = "098.3098.179.50";
        AssinantePessoaFisicaDTO assinantePessoaFisicaDTO = new AssinantePessoaFisicaDTO(nomeEsperado, planoDTO, cpfEsperado);

        adicionaAssinante.adicionar(assinantePessoaFisicaDTO);

        Iterable<Assinante> assinantesRetornados = assinanteCrudRepository.findAll();
        assertThat(assinantesRetornados).hasSize(1);
        Assinante assinante = assinantesRetornados.iterator().next();
        assertThat(assinante).isInstanceOf(AssinantePessoaFisica.class);
        assertThat(assinante.getNome()).isEqualTo(nomeEsperado);
    }

    @Test
    public void deve_adicionar_um_assinante_pessoa_juridica_se_a_instancia_do_dto_for_de_pessoa_juridica() throws ExcecaoDeArgumentoInvalido, ExcecaoDePlanoInesistente {
        Plano plano = new PlanoBuilder().criar();
        planoCrudRepository.save(plano);
        PlanoDTO planoDTO = new PlanoDTO(plano.getId());
        String nomeEsperado = "DR. Pimpolho";
        String cnpjEsperado = "092.405.817.91-50";
        AssinantePessoaJuridicaDTO assinantePessoaJuridicaDTO = new AssinantePessoaJuridicaDTO(nomeEsperado, planoDTO, cnpjEsperado);

        adicionaAssinante.adicionar(assinantePessoaJuridicaDTO);

        Iterable<Assinante> assinantesRetornados = assinanteCrudRepository.findAll();
        assertThat(assinantesRetornados).hasSize(1);
        Assinante assinante = assinantesRetornados.iterator().next();
        assertThat(assinante).isInstanceOf(AssinantePessoaJuridica.class);
        assertThat(assinante.getNome()).isEqualTo(nomeEsperado);
    }

}