package com.brian.teleBrian.dominio.calculos;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.brian.teleBrian.aplicacao.TesteBase;
import com.brian.teleBrian.dominio.builders.AssinantePessoaFisicaBuilder;
import com.brian.teleBrian.dominio.builders.AssinantePessoaJuridicaBuilder;
import com.brian.teleBrian.dominio.builders.PlanoBuilder;
import com.brian.teleBrian.dominio.entidades.Plano;
import com.brian.teleBrian.dominio.entidades.PlanoCrudRepository;
import com.brian.teleBrian.dominio.entidades.assinante.Assinante;
import com.brian.teleBrian.dominio.entidades.assinante.AssinanteCrudRepository;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

public class CalculoDeFaturamentoTest extends TesteBase {

    @Autowired
    @Qualifier("CalculoDeFaturamento")
    private Calculos calculoDeFaturamento;

    @Autowired
    private AssinanteCrudRepository assinanteCrudRepository;

    @Autowired
    private PlanoCrudRepository planoCrudRepository;

    @Test
    public void deve_calcular_o_faturamento_total() throws ExcecaoDeArgumentoInvalido {
        Plano plano = new PlanoBuilder().comValor(new BigDecimal("100.00")).criar();
        planoCrudRepository.save(plano);
        Assinante pessoaFisica = new AssinantePessoaFisicaBuilder().comPlano(plano).criar();
        Assinante pessoaJuridica = new AssinantePessoaJuridicaBuilder().comPlano(plano).comNome("Organizações tabajara")
                .criar();
        assinanteCrudRepository.save(pessoaFisica);
        assinanteCrudRepository.save(pessoaJuridica);
        BigDecimal totalDeFaturamentoEsperado = new BigDecimal("175.00");

        BigDecimal totalDeFaturamento = calculoDeFaturamento.calcular();

        assertThat(totalDeFaturamento).isEqualTo(totalDeFaturamentoEsperado);
    }
}