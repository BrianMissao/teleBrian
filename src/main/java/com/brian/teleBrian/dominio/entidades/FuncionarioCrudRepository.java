package com.brian.teleBrian.dominio.entidades;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.math.BigDecimal;
import java.util.List;

@NoRepositoryBean
public interface FuncionarioCrudRepository extends CrudRepository<Funcionario, Integer> {
    BigDecimal somarSalarios();

    List<Funcionario> findAll();
}

