package com.brian.teleBrian.aplicacao.assinantes;

import com.brian.teleBrian.aplicacao.plano.PlanoDTO;

public class AssinantePessoaJuridicaDTO extends AssinanteDTO {

    private String cnpj;

    public AssinantePessoaJuridicaDTO() {
    }

    public AssinantePessoaJuridicaDTO(String nome, PlanoDTO planoDTO, String cnpj) {
        super(nome, planoDTO);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
