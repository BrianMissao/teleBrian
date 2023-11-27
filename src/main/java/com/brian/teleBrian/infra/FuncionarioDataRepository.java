package com.brian.teleBrian.infra;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brian.teleBrian.dominio.entidades.FuncionarioCrudRepository;

@Repository
public interface FuncionarioDataRepository extends FuncionarioCrudRepository {

    @Query("SELECT SUM (salario) FROM Funcionario")
    BigDecimal somarSalarios();
}
