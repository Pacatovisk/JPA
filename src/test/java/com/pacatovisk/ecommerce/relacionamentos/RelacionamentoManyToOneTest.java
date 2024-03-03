package com.pacatovisk.ecommerce.relacionamentos;

import com.pacatovisk.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.pacatovisk.ecommerce.model.Cliente;
import com.pacatovisk.ecommerce.model.Pedido;
import com.pacatovisk.ecommerce.model.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoManyToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamentoManyToOneTest() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Pedido pedido = new Pedido();

        pedido.setStatusPedido(StatusPedido.AGUARDADANDO);
        pedido.setCliente(cliente);
        pedido.setTotal(BigDecimal.TEN);
        pedido.setDataPedido(LocalDateTime.now());

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao);
    }
}
