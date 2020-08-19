package dominio.entidades.assinante;

import dominio.Validador;
import dominio.entidades.Plano;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;

public abstract class Assinante {
    private String nome;
    private Plano plano;

    public Assinante(String nome, Plano plano) throws ExcecaoDeArgumentoInvalido {
        new Validador().validarString(nome);
        new Validador().validarObjeto(plano);
        this.nome = nome;
        this.plano = plano;
    }

    public String obterNomeDoPlano() {
        return plano.getNome();
    }

    public BigDecimal obterValorDoPlano() {
        return plano.getValor();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
}
