package com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio;

public class ExcecaoDeBuscaDeAssinante extends Exception {
    private long serialVersionUID = 1l;
    private String mensagem;

    public ExcecaoDeBuscaDeAssinante(String mensagem) {
        super(mensagem);
    }
}
