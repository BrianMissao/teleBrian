package com.brian.teleBrian.aplicacao.assinantes;

import com.brian.teleBrian.aplicacao.plano.PlanoDTO;

public class AssinantePessoaJuridicaDTO extends AssinanteDTO {

    private String cnpj;

    public AssinantePessoaJuridicaDTO(Integer id, String nome, PlanoDTO planoDTO, String cnpj) {
        super(id, nome, planoDTO);
        this.cnpj = cnpj;
    }

    public AssinantePessoaJuridicaDTO(String nome, PlanoDTO planoDTO, String cnpj) {
        super(nome, planoDTO);
        this.cnpj = cnpj;
    }

    public AssinantePessoaJuridicaDTO(Integer id) {
        super(id);
    }

    public String getCnpj() {
        return cnpj;
    }
}
