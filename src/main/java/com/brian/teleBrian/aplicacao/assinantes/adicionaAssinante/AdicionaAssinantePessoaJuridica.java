package com.brian.teleBrian.aplicacao.assinantes.adicionaAssinante;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.brian.teleBrian.aplicacao.assinantes.AssinanteDTO;
import com.brian.teleBrian.aplicacao.assinantes.AssinantePessoaJuridicaDTO;
import com.brian.teleBrian.dominio.entidades.Plano;
import com.brian.teleBrian.dominio.entidades.PlanoCrudRepository;
import com.brian.teleBrian.dominio.entidades.assinante.AssinanteCrudRepository;
import com.brian.teleBrian.dominio.entidades.assinante.AssinantePessoaJuridica;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDePlanoInesistente;

@Service
@Qualifier("AdicionaAssinantePessoaJuridica")
public class AdicionaAssinantePessoaJuridica implements AdicionaAssinante {

    private AssinanteCrudRepository assinanteCrudRepository;
    private PlanoCrudRepository planoCrudRepository;

    public AdicionaAssinantePessoaJuridica(AssinanteCrudRepository assinanteCrudRepository,
            PlanoCrudRepository planoCrudRepository) {
        this.assinanteCrudRepository = assinanteCrudRepository;
        this.planoCrudRepository = planoCrudRepository;
    }

    @Override
    public String adicionar(AssinanteDTO assinanteDTO) throws ExcecaoDeArgumentoInvalido, ExcecaoDePlanoInesistente {
        AssinantePessoaJuridicaDTO assinantePessoaJuridicaDTO = (AssinantePessoaJuridicaDTO) assinanteDTO;
        Plano plano = planoCrudRepository.findById(assinantePessoaJuridicaDTO.getPlanoId())
                .orElseThrow(() -> new ExcecaoDePlanoInesistente(
                        "Não foi possível adicionar o assinante porque o plano informado não existe."));
        AssinantePessoaJuridica assinantePessoaJuridica = new AssinantePessoaJuridica(
                assinantePessoaJuridicaDTO.getNome(), assinantePessoaJuridicaDTO.getCnpj(), plano);
        assinanteCrudRepository.save(assinantePessoaJuridica);
        return null;
    }
}
