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

    public String getNome() {
        return nome;
    }

    public Plano getPlano() {
        return plano;
    }
}
