package dominio.entidades;

import dominio.excecoesDeRegraDeNegocio.ExcecaoDeNomeInvalido;

public class Assinante {
    private String nome;
    private Plano plano;

    public Assinante(String nome, Plano plano) throws ExcecaoDeNomeInvalido {
        validarNome(nome);
        this.nome = nome;
        this.plano = plano;
    }

    private void validarNome(String nome) throws ExcecaoDeNomeInvalido {
        if (nome.equals("") || nome == null) {
            throw new ExcecaoDeNomeInvalido("Nome inválido");
        }
    }

    @Override
    public String toString() {
        return nome + ", contratou o plano " + plano.getNome() + ", no valor de " + plano.getValor() + "R$";
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
