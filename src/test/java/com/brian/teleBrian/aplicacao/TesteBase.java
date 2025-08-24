package com.brian.teleBrian.aplicacao;

import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@Transactional
public abstract class TesteBase {

    @PersistenceContext
    private EntityManager entityManager;


    @After
    public void afterClass() throws Exception {
        List<String> tabelas = entityManager.createNativeQuery("SELECT table_name FROM INFORMATION_SCHEMA.TABLES").getResultList();
        for (String tabela: tabelas) {
            entityManager.createNativeQuery("TRUNCATE TABLE "+tabela);
        }
        entityManager.clear();
    }
}
