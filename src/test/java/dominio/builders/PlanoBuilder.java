package dominio.builders;

import dominio.entidades.Plano;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PlanoBuilder {
    private String nome;
    private BigDecimal valor;

    public PlanoBuilder() {
        this.nome = "Plano1";
        this.valor = new BigDecimal(100.00).setScale(2, RoundingMode.HALF_EVEN);
    }

    public PlanoBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public PlanoBuilder comValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public Plano criar() throws ExcecaoDeArgumentoInvalido {
        return      new Plano(nome, valor);
    }
}
