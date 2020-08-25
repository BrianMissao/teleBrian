package dominio.entidades;

import dominio.ValidadorDeCamposObrigatorios;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Funcionario {
    private String nome;
    private String cargo;
    private BigDecimal salario;

    public Funcionario(String nome, String cargo, BigDecimal salario) throws ExcecaoDeArgumentoInvalido {
        validarCamposObrigatorios(nome, cargo, salario);
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario.setScale(2, RoundingMode.HALF_EVEN);
    }

    private void validarCamposObrigatorios(String nome, String cargo, BigDecimal salario) throws ExcecaoDeArgumentoInvalido {
        ValidadorDeCamposObrigatorios validadorDeCamposObrigatorios = new ValidadorDeCamposObrigatorios();
        validadorDeCamposObrigatorios.validarString(nome).validarString(cargo).validarBigDecimal(salario).validar();
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void atualizarNome(String nomeAtualizado) throws ExcecaoDeArgumentoInvalido {
        new ValidadorDeCamposObrigatorios().validarString(nomeAtualizado).validar();
        this.nome = nomeAtualizado;
    }

    public void atualizarCargo(String cargoAtualizado) throws ExcecaoDeArgumentoInvalido {
        new ValidadorDeCamposObrigatorios().validarString(cargoAtualizado).validar();
        this.cargo = cargoAtualizado;
    }

    public void atualizarSalario(BigDecimal salarioAtualizado) throws ExcecaoDeArgumentoInvalido {
        new ValidadorDeCamposObrigatorios().validarBigDecimal(salarioAtualizado).validar();
        this.salario = salarioAtualizado;
    }
}
