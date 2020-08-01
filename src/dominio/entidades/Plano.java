package dominio.entidades;

import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Plano {
    private String nome;
    private BigDecimal valor;

    public Plano(String nome, BigDecimal valor) throws ExcecaoDeArgumentoInvalido {
        validarNome(nome);
        this.nome = nome;
        this.valor = valor.setScale(2, RoundingMode.HALF_EVEN);
    }

    private void validarNome(String nome) throws ExcecaoDeArgumentoInvalido {
        if (nome.equals("") || nome == null) {
            throw new ExcecaoDeArgumentoInvalido("O campo do nome está incorreto");
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
