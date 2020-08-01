package dominio.entidades;

import dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

import java.math.BigDecimal;

public class Assinante {
    private String nome;
    private Plano plano;

    public Assinante(String nome, Plano plano) throws ExcecaoDeArgumentoInvalido {
        validarNome(nome);
        this.nome = nome;
        this.plano = plano;
    }

    private void validarNome(String nome) throws ExcecaoDeArgumentoInvalido {
        if (nome.equals("") || nome == null) {
            throw new ExcecaoDeArgumentoInvalido("Nome inválido");
        }
    }

    @Override
    public String toString() {
        return nome + ", contratou o plano " + obterNomeDoPlano() + ", no valor de " + obterValorDoPlano() + "R$";
    }

    private String obterNomeDoPlano() {
        return plano.getNome();
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

    public BigDecimal obterValorDoPlano() {
        return plano.getValor();
    }
}
