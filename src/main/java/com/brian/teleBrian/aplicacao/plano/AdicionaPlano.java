package com.brian.teleBrian.aplicacao.plano;

import org.springframework.stereotype.Service;

import com.brian.teleBrian.dominio.entidades.Plano;
import com.brian.teleBrian.dominio.entidades.PlanoCrudRepository;
import com.brian.teleBrian.dominio.excecoesDeRegraDeNegocio.ExcecaoDeArgumentoInvalido;

@Service
public class AdicionaPlano {

    private final PlanoCrudRepository planoCrudRepository;

    public AdicionaPlano(PlanoCrudRepository planoCrudRepository) {
        this.planoCrudRepository = planoCrudRepository;
    }

    public void adicionar(PlanoDTO planoDTO) throws ExcecaoDeArgumentoInvalido {
        Plano plano = new Plano(planoDTO.getNome(), planoDTO.getValor());
        planoCrudRepository.save(plano);
    }

}
