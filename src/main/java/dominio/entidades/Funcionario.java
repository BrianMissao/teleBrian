package dominio.entidades;

import dominio.Validador;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;

public class Funcionario {
    private String nome;
    private String cargo;
    private BigDecimal salario;

    public Funcionario(String nome, String cargo, BigDecimal salario) throws ExcecaoDeArgumentoInvalido {
        new Validador().validarString(nome);
        new Validador().validarString(cargo);
        new Validador().validarBigDecimal(salario);
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
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
