package dominio.entidades.assinante;

import dominio.ValidadorDeCamposObrigatorios;
import dominio.entidades.Plano;
import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;

public abstract class Assinante {
    private String nome;
    private Plano plano;

    public Assinante(String nome, Plano plano) throws ExcecaoDeArgumentoInvalido {
        new ValidadorDeCamposObrigatorios().validarString(nome);
        new ValidadorDeCamposObrigatorios().validarObjeto(plano);
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

    public void atualizarNome(String nome) throws ExcecaoDeArgumentoInvalido {
        new ValidadorDeCamposObrigatorios().validarString(nome);
        this.nome = nome;
    }

    public Plano getPlano() {
        return plano;
    }

    public void atualizarPlano(Plano planoAtualizado) throws ExcecaoDeArgumentoInvalido {
        new ValidadorDeCamposObrigatorios().validarObjeto(planoAtualizado);
        this.plano = planoAtualizado;
    }
}