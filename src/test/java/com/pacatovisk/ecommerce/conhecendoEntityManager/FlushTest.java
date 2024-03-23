package com.pacatovisk.ecommerce.conhecendoEntityManager;

import com.pacatovisk.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.pacatovisk.ecommerce.model.Pedido;
import com.pacatovisk.ecommerce.model.StatusPedido;
import org.junit.Test;

public class FlushTest extends EntityManagerTest {

    @Test(expected = Exception.class)
    public void chamarFlush() {
        try {
            entityManager.getTransaction().begin();

            Pedido pedido = entityManager.find(Pedido.class, 1);
            pedido.setStatus(StatusPedido.PAGO);

            entityManager.flush();

            if (pedido.getPagamento() == null) {
                throw new RuntimeException("Pedido ainda não foi pago!");
            }

            /*
             *
             *  A consulta obriga o JPA sincronizar com o pedido que está na mémoria antes de fazer a consulta. O flush é executado antes da consulta JPQL
             *  Pedido pedidoPago = entityManager.createQuery("select 'p' from Pedido 'p' where p.id = 1", Pedido.class).getSingleResult();
             *  Assert.assertEquals(pedido.getStatus(), pedidoPago.getStatus());
             *
             */

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
