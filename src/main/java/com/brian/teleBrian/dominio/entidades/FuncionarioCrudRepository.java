package com.brian.teleBrian.dominio.entidades;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FuncionarioCrudRepository extends CrudRepository<Funcionario, Integer> {
    BigDecimal somarSalarios();
}

