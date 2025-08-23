package com.brian.teleBrian.aplicacao.assinantes.adicionaAssinante;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.brian.teleBrian.aplicacao.assinantes.AssinanteDTO;
import com.brian.teleBrian.aplicacao.assinantes.AssinantePessoaFisicaDTO;
import com.brian.teleBrian.dominio.entidades.Plano;
import com.brian.teleBrian.dominio.entidades.PlanoCrudRepository;
import com.brian.teleBrian.dominio.entidades.assinante.AssinanteCrudRepository;
import com.brian.teleBrian.dominio.entidades.assinante.AssinantePessoaFisica;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDePlanoInesistente;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("AdicionaAssinantePessoaFisica")
@Transactional
public class AdicionaAssinantePessoaFisica implements AdicionaAssinante {

    private final AssinanteCrudRepository assinanteCrudRepository;
    private final PlanoCrudRepository planoCrudRepository;

    public AdicionaAssinantePessoaFisica(AssinanteCrudRepository assinanteCrudRepository,
            PlanoCrudRepository planoCrudRepository) {
        this.assinanteCrudRepository = assinanteCrudRepository;
        this.planoCrudRepository = planoCrudRepository;
    }

    @Override
    public AssinantePessoaFisica adicionar(AssinanteDTO assinanteDTO) throws ExcecaoDeArgumentoInvalido, ExcecaoDePlanoInesistente {
        AssinantePessoaFisicaDTO assinantePessoaFisicaDTO = (AssinantePessoaFisicaDTO) assinanteDTO;
        Plano plano = planoCrudRepository.findById(assinanteDTO.getPlanoId()).orElseThrow(() -> new ExcecaoDePlanoInesistente("Não foi possível adicionar o assinante porque o plano informado não existe."));
        return assinanteCrudRepository.save(new AssinantePessoaFisica(assinantePessoaFisicaDTO.getNome(), assinantePessoaFisicaDTO.getCpf(), plano));
    }

}