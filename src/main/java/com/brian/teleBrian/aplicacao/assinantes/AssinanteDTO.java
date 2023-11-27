package com.brian.teleBrian.aplicacao.assinantes;

import com.brian.teleBrian.aplicacao.BaseDTO;
import com.brian.teleBrian.aplicacao.plano.PlanoDTO;

public abstract class AssinanteDTO extends BaseDTO {

    private String nome;

    private PlanoDTO planoDTO;

    public AssinanteDTO() {
        super();
    }

    public AssinanteDTO(String nome, PlanoDTO planoDTO) {
        this.nome = nome;
        this.planoDTO = planoDTO;
    }

    public AssinanteDTO(Integer id, String nome, PlanoDTO planoDTO) {
        super(id);
        this.nome = nome;
        this.planoDTO = planoDTO;
    }

    public AssinanteDTO(Integer id) {
        super(id);
    }

    public String getNome() {
        return nome;
    }

    public Integer getPlanoId() {
        return planoDTO.getId();
    }

    public PlanoDTO getPlanoDTO() {
        return planoDTO;
    }

    }
