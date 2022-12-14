package com.brian.teleBrian.infra;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brian.teleBrian.dominio.entidades.assinante.AssinanteCrudRepository;

@Repository
public interface AssinanteDataRepository extends AssinanteCrudRepository {

    @Query("SELECT SUM(a.plano.valor) FROM Assinante a")
    BigDecimal somarValorDosPlanosDosAssinantes();
}
