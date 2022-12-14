package com.brian.teleBrian.dominio.calculos;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.brian.teleBrian.dominio.entidades.FuncionarioCrudRepository;

@Service
@Qualifier("CalculoDeGastos")
public class CalculoDeGastos implements Calculos {

    private final FuncionarioCrudRepository funcionarioCrudRepository;

    public CalculoDeGastos(FuncionarioCrudRepository funcionarioCrudRepository) {
        this.funcionarioCrudRepository = funcionarioCrudRepository;
}

    @Override
    public BigDecimal calcular() {
        return funcionarioCrudRepository.somarSalarios();
    }
}
