package dominio.entidades;

import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.beans.BeanInfo;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

public class FuncionarioTest {
    private String nome;
    private String cargo;
    private BigDecimal salario;

    @Before
    public void init() {
        this.nome = "Funcionario1";
        this.cargo = "Gerente de vendas";
        this.salario = new BigDecimal("2000.00").setScale(2, RoundingMode.HALF_EVEN);
    }

    @Test
    public void deveCriarUmFuncionario() throws ExcecaoDeArgumentoInvalido {
        String nomeEsperado = "José Droguinha";
        String cargoEsperado = "Gerente de marketing";
        BigDecimal salarioEsperado = new BigDecimal("3000.00").setScale(2, RoundingMode.HALF_EVEN);

        Funcionario funcionario = new Funcionario(nomeEsperado, cargoEsperado, salarioEsperado);

        Assertions.assertThat(funcionario.getNome()).isEqualTo(nomeEsperado);
        Assertions.assertThat(funcionario.getCargo()).isEqualTo(cargoEsperado);
        Assertions.assertThat(funcionario.getSalario()).isEqualTo(salarioEsperado);
    }

    @Test
    public void naoDeveCriarUmFuncionarioComNomeNulo() {
        String nomeNulo = null;
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new Funcionario(nomeNulo, cargo, salario));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmFuncionarioComNomeVazio() {
        String nomeVazio = "";
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new Funcionario(nomeVazio, cargo, salario));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmFuncionarioComCargoNulo() {
        String cargoNulo = null;
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new Funcionario(nome, cargoNulo, salario));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmFuncionarioComCargoVazio() {
        String cargoVazio = "";
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new Funcionario(nome, cargoVazio, salario));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmFuncionarioComSalarioNulo() {
        BigDecimal salarioNulo = null;
        String mensagemEsperada = "BigDecimal inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new Funcionario(nome, cargo, salarioNulo));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmFuncionarioComSalarioIgualAZero() {
        BigDecimal salarioIgualAZero = BigDecimal.ZERO;
        String mensagemEsperada = "BigDecimal inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new Funcionario(nome, cargo, salarioIgualAZero));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveCriarUmFuncionarioComSalarioMenorQueZero() {
        BigDecimal salarioMenorQueZero = new BigDecimal("-0.01");
        String mensagemEsperada = "BigDecimal inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> new Funcionario(nome, cargo, salarioMenorQueZero));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void deveAtualizarNome() throws ExcecaoDeArgumentoInvalido {
        String nomeAtualizado = "Brian";
        Funcionario funcionario = new Funcionario(nome, cargo, salario);

        funcionario.atualizarNome(nomeAtualizado);

        Assertions.assertThat(funcionario.getNome()).isEqualTo(nomeAtualizado);
    }

    @Test
    public void naoDeveAtualizarONomeComUmNomeNulo() throws ExcecaoDeArgumentoInvalido {
        Funcionario funcionario = new Funcionario(nome, cargo, salario);
        String mensagemEsperada = "String inválida.";
        String nomeNulo = null;

        Throwable excecaoLancada = Assertions.catchThrowable(() -> funcionario.atualizarNome(nomeNulo));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveAtualizarONomeComUmNomeVazio() throws ExcecaoDeArgumentoInvalido {
        Funcionario funcionario = new Funcionario(nome, cargo, salario);
        String nomeVazio = "";
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> funcionario.atualizarNome(nomeVazio));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void deveAtualizarCargo() throws ExcecaoDeArgumentoInvalido {
        Funcionario funcionario = new Funcionario(nome, cargo, salario);
        String cargoAtualizado = "Desenvolvedor";

        funcionario.atualizarCargo(cargoAtualizado);

        Assertions.assertThat(funcionario.getCargo()).isEqualTo(cargoAtualizado);
    }

    @Test
    public void naoDeveAtualizarCargoComUmCargoNulo() throws ExcecaoDeArgumentoInvalido {
        Funcionario funcionario = new Funcionario(nome, cargo, salario);
        String cargoNulo = null;
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> funcionario.atualizarCargo(cargoNulo));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveAtualizarOCargoComUmCargoVazio() throws ExcecaoDeArgumentoInvalido {
        Funcionario funcionario = new Funcionario(nome, cargo, salario);
        String cargoVazio = "";
        String mensagemEsperada = "String inválida.";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> funcionario.atualizarCargo(cargoVazio));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void deveAtualizarSalario() throws ExcecaoDeArgumentoInvalido {
        Funcionario funcionario = new Funcionario(nome, cargo, salario);
        BigDecimal salarioAtualizado = new BigDecimal("3000.00");

        funcionario.atualizarSalario(salarioAtualizado);

        Assertions.assertThat(funcionario.getSalario()).isEqualTo(salarioAtualizado);
    }

    @Test
    public void naoDeveAtualizarOSalarioComUmSalarioNulo() throws ExcecaoDeArgumentoInvalido {
        Funcionario funcionario = new Funcionario(nome, cargo, salario);
        BigDecimal salarioNulo = null;
        String mensagemEsperada = "BigDecimal inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> funcionario.atualizarSalario(salarioNulo));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveAtualizarOSalarioComUmSalarioMenorQueZero() throws ExcecaoDeArgumentoInvalido {
        Funcionario funcionario = new Funcionario(nome, cargo, salario);
        BigDecimal salarioMenorQueZero = new BigDecimal("-0.01");
        String mensagemEsperada = "BigDecimal inválido";

        Throwable excecaoLancada = Assertions.catchThrowable(() -> funcionario.atualizarSalario(salarioMenorQueZero));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }

    @Test
    public void naoDeveAtualizarOSalarioComUmSalarioIgualAZero() throws ExcecaoDeArgumentoInvalido {
        Funcionario funcionario = new Funcionario(nome, cargo, salario);
        BigDecimal salarioIgualAZero = BigDecimal.ZERO;
        String mensagemEsperada = "BigDecimal inválido";

        Throwable excecaoLancada =  Assertions.catchThrowable(() -> funcionario.atualizarSalario(salarioIgualAZero));

        Assertions.assertThat(excecaoLancada).hasMessageContaining(mensagemEsperada);
    }
}