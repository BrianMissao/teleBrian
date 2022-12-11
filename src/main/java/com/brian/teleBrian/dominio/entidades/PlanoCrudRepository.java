package com.brian.teleBrian.dominio.entidades;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PlanoCrudRepository extends CrudRepository<Plano, Integer> {
}