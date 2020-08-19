package dominio;

import dominio.entidades.Funcionario;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FuncionarioBuilder {
    private String nome;
    private String cargo;
    private BigDecimal salario;

    public FuncionarioBuilder() {
        this.nome = "Funcionario1";
        this.cargo = "Desenvolvedor";
        this.salario = new BigDecimal("5000.00").setScale(2, RoundingMode.HALF_EVEN);
    }

    public FuncionarioBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public FuncionarioBuilder comCargo(String cargo) {
        this.cargo = cargo;
        return this;
    }

    public FuncionarioBuilder comSalario(BigDecimal salario) {
        this.salario = salario.setScale(2, RoundingMode.HALF_EVEN);
        return this;
    }

    public Funcionario criar() throws ExcecaoDeArgumentoInvalido {
        return new Funcionario(nome, cargo, salario);
    }
}
