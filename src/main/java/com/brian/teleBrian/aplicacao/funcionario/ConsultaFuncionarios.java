package com.brian.teleBrian.aplicacao.funcionario;

import com.brian.teleBrian.dominio.entidades.Funcionario;
import com.brian.teleBrian.dominio.entidades.FuncionarioCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaFuncionarios {

    private final FuncionarioCrudRepository funcionarioCrudRepository;

    public ConsultaFuncionarios(FuncionarioCrudRepository funcionarioCrudRepository) {
        this.funcionarioCrudRepository = funcionarioCrudRepository;
    }

    public List<Funcionario> consultarTodos() {
        return funcionarioCrudRepository.findAll();
    }
}
