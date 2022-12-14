package com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio;

public class ExcecaoDePlanoInesistente extends Exception {
    
    private long serialVersionUID = 1l;

    public ExcecaoDePlanoInesistente(String mensagem) {
        super(mensagem);
    }
}
