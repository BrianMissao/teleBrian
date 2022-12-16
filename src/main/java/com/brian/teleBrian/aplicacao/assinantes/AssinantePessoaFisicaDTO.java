package com.brian.teleBrian.aplicacao.assinantes;

import com.brian.teleBrian.aplicacao.plano.PlanoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class AssinantePessoaFisicaDTO extends AssinanteDTO {

    private String cpf;

    public AssinantePessoaFisicaDTO() {
        super();
    }

    public String getCpf() {
        return cpf;
    }

}
