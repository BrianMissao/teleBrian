package com.brian.teleBrian.aplicacao.plano;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.brian.teleBrian.aplicacao.TesteBase;
import com.brian.teleBrian.dominio.builders.PlanoBuilder;
import com.brian.teleBrian.dominio.entidades.Plano;
import com.brian.teleBrian.dominio.entidades.PlanoCrudRepository;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import com.brian.teleBrian.infra.PlanoDataRepository;

public class    AdicionaPlanoTest extends TesteBase {

    @Autowired
    private PlanoCrudRepository planoCrudRepository;

    @Autowired
    private AdicionaPlano adicionaPlano;

    @Test
    public void deve_adicionar_um_plano() throws ExcecaoDeArgumentoInvalido {
        String nomeDoPlanoEsperado = "Tele mais";
        BigDecimal valorDoPlanoEsperado = new BigDecimal("200.00");
        PlanoDTO planoDTO = new PlanoDTO(nomeDoPlanoEsperado, valorDoPlanoEsperado);

        adicionaPlano.adicionar(planoDTO);

        Iterable<Plano> planosRetornados = planoCrudRepository.findAll();
        assertThat(planosRetornados).extracting(Plano::getNome).containsExactly(nomeDoPlanoEsperado);
        assertThat(planosRetornados).extracting(Plano::getValor).containsExactly(valorDoPlanoEsperado);
    }
}
    