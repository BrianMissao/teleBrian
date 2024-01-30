package com.brian.teleBrian.dominio.calculos;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.brian.teleBrian.dominio.entidades.assinante.AssinanteCrudRepository;

@Service
@Qualifier("CalculoDeFaturamento")
public class CalculoDeFaturamento implements Calculos {

    private final AssinanteCrudRepository assinanteCrudRepository;

    public CalculoDeFaturamento(AssinanteCrudRepository assinanteCrudRepository) {
        this.assinanteCrudRepository = assinanteCrudRepository;
    }

    @Override
    public BigDecimal calcular() {
        return assinanteCrudRepository.findAll().stream().map((assinante -> assinante.obterValorDoPlano())).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
