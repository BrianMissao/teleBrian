package com.brian.teleBrian.dominio.entidades;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface PlanoCrudRepository extends CrudRepository<Plano, Integer> {

    List<Plano> findAll();
}