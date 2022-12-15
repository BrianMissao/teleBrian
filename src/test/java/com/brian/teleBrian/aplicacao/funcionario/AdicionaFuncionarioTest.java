package com.brian.teleBrian.aplicacao.funcionario;

import com.brian.teleBrian.aplicacao.TesteBase;
import com.brian.teleBrian.dominio.entidades.Funcionario;
import com.brian.teleBrian.dominio.entidades.FuncionarioCrudRepository;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AdicionaFuncionarioTest extends TesteBase {

    @Autowired
    private AdicionaFuncionario adicionaFuncionario;

    @Autowired
    private FuncionarioCrudRepository funcionarioCrudRepository;

    @Test
    public void deve_adicionar_um_funcionario() throws ExcecaoDeArgumentoInvalido {
        String nomeEsperado = "Jarvas";
        String cargoEsperado = "Motorista";
        BigDecimal salarioEsperado = new BigDecimal("200.00");
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(nomeEsperado, cargoEsperado, salarioEsperado);

        adicionaFuncionario.adicionar(funcionarioDTO);

        List<Funcionario> funcionariosRetornados = funcionarioCrudRepository.findAll();
        assertThat(funcionariosRetornados).extracting(Funcionario::getNome).containsExactly(nomeEsperado);
        assertThat(funcionariosRetornados).extracting(Funcionario::getCargo).containsExactly(cargoEsperado);
        assertThat(funcionariosRetornados).extracting(Funcionario::getSalario).containsExactly(salarioEsperado);
    }
}