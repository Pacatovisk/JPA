package com.pacatovisk.ecommerce.conhecendoEntityManager;

import com.pacatovisk.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.pacatovisk.ecommerce.model.Produto;
import org.junit.Test;

import java.math.BigDecimal;

public class ContextoDePersistenciaTest extends EntityManagerTest {


    @Test
    public void usarContextoPersistencia() {

        entityManager.getTransaction().begin();

        Produto produto = entityManager.find(Produto.class, 1);
        produto.setPreco(new BigDecimal("100.0")); // Dirty checking

        Produto produto2 = new Produto();
        produto2.setNome("Caneca para café");
        produto2.setPreco(new BigDecimal("100.0"));
        produto2.setDescricao("Boa caneca para café");
        entityManager.persist(produto2);

        Produto produto3 = new Produto();
        produto3.setNome("Caneca para chá");
        produto3.setDescricao("Boa caneca para chá");
        produto3.setPreco(new BigDecimal("100.0"));
        produto3 = entityManager.merge(produto3);

        entityManager.flush();

        produto3.setDescricao("Alterar descrição");

        entityManager.getTransaction().commit();
    }
}
