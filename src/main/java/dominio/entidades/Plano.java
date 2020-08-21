package dominio.entidades;

import dominio.ValidadorDeCamposObrigatorios;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Plano {
    private String nome;
    private BigDecimal valor;

    public Plano(String nome, BigDecimal valor) throws ExcecaoDeArgumentoInvalido {
        new ValidadorDeCamposObrigatorios().validarString(nome);
        new ValidadorDeCamposObrigatorios().validarBigDecimal(valor);
        this.nome = nome;
        this.valor = valor.setScale(2, RoundingMode.HALF_EVEN);
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void atualizarNome(String nomeAtualizado) throws ExcecaoDeArgumentoInvalido {
        new ValidadorDeCamposObrigatorios().validarString(nomeAtualizado);
        this.nome = nomeAtualizado;
    }

    public void atualizarValor(BigDecimal valorAtualizado) throws ExcecaoDeArgumentoInvalido {
        new ValidadorDeCamposObrigatorios().validarBigDecimal(valorAtualizado);
        this.valor = valorAtualizado;
    }
}
