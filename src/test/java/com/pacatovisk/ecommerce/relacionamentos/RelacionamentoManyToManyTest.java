package com.pacatovisk.ecommerce.relacionamentos;

import com.pacatovisk.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.pacatovisk.ecommerce.model.Categoria;
import com.pacatovisk.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class RelacionamentoManyToManyTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento() {
        Produto produto = entityManager.find(Produto.class, 1);
        Categoria categoria = entityManager.find(Categoria.class, 1);

        entityManager.getTransaction().begin();
        // categoria.setPedidos(Collections.singletonList(pedido));
        produto.setCategorias(Collections.singletonList(categoria));
        entityManager.getTransaction().commit();
        entityManager.clear();

        Categoria categoriaVerificacao = entityManager.find(Categoria.class, 1);
        Assert.assertFalse(categoriaVerificacao.getProdutos().isEmpty());

    }
}
