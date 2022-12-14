package com.brian.teleBrian.dominio.entidades.assinante;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AssinanteCrudRepository extends CrudRepository<Assinante, Integer> {
    Optional<Assinante> findByNome(String nome);

    BigDecimal somarValoresDosPlanosDosAssinantes();
}