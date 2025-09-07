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
        List<String> tabelas = entityManager.createNativeQuery("SELECT table_name FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'PUBLIC'").getResultList();
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();
        for (String tabela: tabelas) {
            entityManager.createNativeQuery("TRUNCATE TABLE "+tabela).executeUpdate();
        }
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
        entityManager.clear();
    }
}
