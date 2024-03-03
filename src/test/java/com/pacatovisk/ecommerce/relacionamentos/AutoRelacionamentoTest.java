package com.pacatovisk.ecommerce.relacionamentos;

import com.pacatovisk.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.pacatovisk.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AutoRelacionamentoTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamentoManyToOneTest2() {
        Categoria categoriaPai = new Categoria();
        categoriaPai.setNome("Eletrônicos");

        Categoria categoriaFilha = new Categoria();
        categoriaFilha.setNome("Celulares");
        categoriaFilha.setCategoriaPai(categoriaPai);

        entityManager.getTransaction().begin();
        entityManager.persist(categoriaPai);
        entityManager.persist(categoriaFilha);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Categoria categoriaFilhaVerificacao = entityManager.find(Categoria.class, categoriaFilha.getId());
        Assert.assertNotNull(categoriaFilhaVerificacao);

        Categoria categoriaPaiVerificacao = entityManager.find(Categoria.class, categoriaPai.getId());
        Assert.assertNotNull(categoriaPaiVerificacao);
        Assert.assertFalse(categoriaPaiVerificacao.getCategorias().isEmpty());
    }

}
