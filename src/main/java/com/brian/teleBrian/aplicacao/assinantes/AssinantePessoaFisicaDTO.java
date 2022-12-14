package com.brian.teleBrian.aplicacao.assinantes;

import com.brian.teleBrian.aplicacao.plano.PlanoDTO;

public class AssinantePessoaFisicaDTO extends AssinanteDTO {

    private String cpf;

    public AssinantePessoaFisicaDTO(Integer id, String nome, PlanoDTO planoDTO, String cpf) {
        super(id, nome, planoDTO);
        this.cpf = cpf;
    }

    public AssinantePessoaFisicaDTO(String nome, PlanoDTO planoDTO, String cpf) {
        super(nome, planoDTO);
        this.cpf = cpf;
    }

    public AssinantePessoaFisicaDTO(Integer id) {
        super(id);
    }

    public String getCpf() {
        return cpf;
    }

}
