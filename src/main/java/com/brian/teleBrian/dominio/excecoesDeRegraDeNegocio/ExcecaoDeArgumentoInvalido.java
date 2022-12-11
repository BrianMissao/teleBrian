package com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio;

public class ExcecaoDeArgumentoInvalido extends Exception{
    private long serialVersionUID = 1l;
    public ExcecaoDeArgumentoInvalido(String mensagem) {
        super(mensagem);
    }
}
