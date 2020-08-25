package dominio.entidades;

import dominio.ValidadorDeCamposObrigatorios;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;

public class Funcionario {
    private String nome;
    private String cargo;
    private BigDecimal salario;

    public Funcionario(String nome, String cargo, BigDecimal salario) throws ExcecaoDeArgumentoInvalido {
        validarCamposObrigatorios(nome, cargo, salario);
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    private void validarCamposObrigatorios(String nome, String cargo, BigDecimal salario) throws ExcecaoDeArgumentoInvalido {
        ValidadorDeCamposObrigatorios validadorDeCamposObrigatorios = new ValidadorDeCamposObrigatorios();
        validadorDeCamposObrigatorios.validarString(nome);
        validadorDeCamposObrigatorios.validarString(cargo);
        validadorDeCamposObrigatorios.validarBigDecimal(salario);
    }

    @Override
    public String toString() {
        return "*"+nome+"\nCargo: "+cargo+"Salário: "+salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
}
