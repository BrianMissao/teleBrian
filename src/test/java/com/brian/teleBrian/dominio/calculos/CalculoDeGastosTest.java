package com.brian.teleBrian.dominio.calculos;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.brian.teleBrian.aplicacao.TesteBase;
import com.brian.teleBrian.dominio.builders.FuncionarioBuilder;
import com.brian.teleBrian.dominio.entidades.Funcionario;
import com.brian.teleBrian.dominio.entidades.FuncionarioCrudRepository;

public class CalculoDeGastosTest extends TesteBase {

    @Autowired
    @Qualifier("CalculoDeGastos")
    private CalculoDeGastos calculoDeGastos;

    @Autowired
    private FuncionarioCrudRepository funcionarioCrudRepository;

    @Test
    public void deveCalcularOTotalDeGastos() throws Exception {
        Funcionario funcionario1 = new FuncionarioBuilder().criar();
        Funcionario funcionario2 = new FuncionarioBuilder().comNome("Funcionario2").criar();
        funcionarioCrudRepository.save(funcionario1);
        funcionarioCrudRepository.save(funcionario2);
        BigDecimal totalDeGastosEsperado = new BigDecimal("10000.00").setScale(2, RoundingMode.HALF_EVEN);

        BigDecimal totalDeGastos = calculoDeGastos.calcular();

        assertThat(totalDeGastos).isEqualTo(totalDeGastosEsperado);
    }
}