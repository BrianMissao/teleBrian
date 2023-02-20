package com.brian.teleBrian.aplicacao.assinantes;

import com.brian.teleBrian.aplicacao.plano.PlanoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class AssinantePessoaFisicaDTO extends AssinanteDTO {

    private String cpf;

    public AssinantePessoaFisicaDTO() {
        super();
    }

    public AssinantePessoaFisicaDTO(String nome, PlanoDTO planoDTO, String cpf) {
        //this.nome = nome;
        //super.planoDTO = planoDTO;
        super(nome, planoDTO);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

}
