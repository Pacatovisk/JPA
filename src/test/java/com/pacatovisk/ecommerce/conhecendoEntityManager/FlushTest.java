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
             *  Quando uma consulta JPQL é executada, o JPA automaticamente sincroniza o estado dos objetos gerenciados na memória com o banco de dados antes de executar a consulta.
             *  Isso garante que os resultados da consulta reflitam as alterações mais recentes feitas na transação atual, mesmo sem a chamada explícita do método flush().
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
