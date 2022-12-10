package com.brian.teleBrian.dominio.entidades.assinante;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AssinanteCrudRepository extends CrudRepository<Assinante, Integer> {
}