package com.pacatovisk.ecommerce.conhecendoEntityManager;

import com.pacatovisk.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.pacatovisk.ecommerce.model.Pedido;
import com.pacatovisk.ecommerce.model.Produto;
import com.pacatovisk.ecommerce.model.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class EntityListenersTest extends EntityManagerTest {

    @Test
    public void carregarEntidades() {
        entityManager.getTransaction().begin();
        Pedido pedido = entityManager.find(Pedido.class, 1);
        Produto produto = entityManager.find(Produto.class,1);
        entityManager.getTransaction().commit();
        Assert.assertNotNull(pedido);
        Assert.assertNotNull(produto);
    }

    @Test
    public void gerandoNotaFiscalPeloEntityListerners() {
        entityManager.getTransaction().begin();
        Pedido pedido = entityManager.find(Pedido.class,1);
        pedido.setStatus(StatusPedido.PAGO);
        pedido.setTotal(BigDecimal.TEN);
        entityManager.getTransaction().commit();
    }
}
