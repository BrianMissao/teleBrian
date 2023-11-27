package com.brian.teleBrian.aplicacao.funcionario;

import com.brian.teleBrian.aplicacao.TesteBase;
import com.brian.teleBrian.dominio.builders.FuncionarioBuilder;
import com.brian.teleBrian.dominio.entidades.Funcionario;
import com.brian.teleBrian.dominio.entidades.FuncionarioCrudRepository;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ConsultaFuncionariosTest extends TesteBase {

    @Autowired
    private ConsultaFuncionarios consultaFuncionarios;

    @Autowired
    private FuncionarioCrudRepository funcionarioCrudRepository;

    @Test
    public void deve_retornar_uma_lista_com_todos_os_funcionarios_cadastrados() throws ExcecaoDeArgumentoInvalido {
        Funcionario funcionario1 = new FuncionarioBuilder().criar();
        Funcionario funcionario2 = new FuncionarioBuilder().criar();
        funcionarioCrudRepository.save(funcionario1);
        funcionarioCrudRepository.save(funcionario2);

        List<Funcionario> funcionariosRetornados = consultaFuncionarios.consultarTodos();

        assertThat(funcionariosRetornados).containsExactly(funcionario1, funcionario2);
    }
}