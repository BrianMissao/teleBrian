package com.brian.teleBrian.aplicacao.assinantes.removeAssinante;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.brian.teleBrian.aplicacao.TesteBase;
import com.brian.teleBrian.dominio.builders.AssinantePessoaFisicaBuilder;
import com.brian.teleBrian.dominio.entidades.PlanoCrudRepository;
import com.brian.teleBrian.dominio.entidades.assinante.Assinante;
import com.brian.teleBrian.dominio.entidades.assinante.AssinanteCrudRepository;
import com.brian.teleBrian.dominio.entidades.assinante.AssinantePessoaJuridica;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeRemocaoDeAssinante;

public class RemoveAssinanteImplTest extends TesteBase {

    @Autowired
    private AssinanteCrudRepository assinanteCrudRepository;

    @Autowired
    private RemoveAssinante removeAssinante;

    @Autowired
    private PlanoCrudRepository planoCrudRepository;

    private Assinante pessoaFisica;
    private Assinante pessoaJuridica;

    @Before
    public void criarCenariosPadroes() throws ExcecaoDeArgumentoInvalido {
        pessoaFisica = new AssinantePessoaFisicaBuilder().comNome("Brian").criar();
        planoCrudRepository.save(pessoaFisica.getPlano());
        assinanteCrudRepository.save(pessoaFisica);
    }

    @Test
    public void deve_remover_um_assinante_da_base_de_dados() throws ExcecaoDeRemocaoDeAssinante {
        Integer idDoAssinante = pessoaFisica.getId();

        removeAssinante.remover(idDoAssinante);

        Iterable<Assinante> assinantesRetornados = assinanteCrudRepository.findAll();
        assertThat(assinantesRetornados).isEmpty();
    }
}