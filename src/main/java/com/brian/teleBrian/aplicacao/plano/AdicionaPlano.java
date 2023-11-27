package com.brian.teleBrian.aplicacao.plano;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brian.teleBrian.dominio.entidades.Plano;
import com.brian.teleBrian.dominio.entidades.PlanoCrudRepository;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

@Service
@Transactional
public class AdicionaPlano {

    private final PlanoCrudRepository planoCrudRepository;

    public AdicionaPlano(PlanoCrudRepository planoCrudRepository) {
        this.planoCrudRepository = planoCrudRepository;
    }

    public Plano adicionar(PlanoDTO planoDTO) throws ExcecaoDeArgumentoInvalido {
        Plano plano = new Plano(planoDTO.getNome(), planoDTO.getValor());
        return planoCrudRepository.save(plano);
    }

}
