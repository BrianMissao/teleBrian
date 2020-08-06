package dominio.entidades;

import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Funcionario {
    private String nome;
    private Integer numeroDaMatricula;
    private BigDecimal salario;

    public Funcionario(String nome, Integer numeroDaMatricula, BigDecimal salario) throws ExcecaoDeArgumentoInvalido{
        validarCampo(nome);
        validarCampo(numeroDaMatricula);
        validarCampo(salario);
        this.nome = nome;
        this.numeroDaMatricula = numeroDaMatricula;
        this.salario = salario.setScale(2, RoundingMode.HALF_EVEN);
    }

    private void validarCampo(String nome) throws ExcecaoDeArgumentoInvalido {
        if (nome.equals("") || nome == null) {
            throw new ExcecaoDeArgumentoInvalido("Nome inválido");
        }
    }

    private void validarCampo(Integer matricula) throws ExcecaoDeArgumentoInvalido {
        if (matricula <= 0 || matricula == null) {
            throw new ExcecaoDeArgumentoInvalido("Matrícula inválida");
        }
    }

    private void validarCampo(BigDecimal salario) throws ExcecaoDeArgumentoInvalido {
        if (salario == null || salario.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ExcecaoDeArgumentoInvalido("Salário inválido");
        }
    }

    @Override
    public String toString() {
        return "*" + nome + "\nNúmero de matrícula: " + numeroDaMatricula + "\nSalário: " + salario;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumeroDaMatricula() {
        return numeroDaMatricula;
    }

    public BigDecimal getSalario() {
        return salario;
    }
}
