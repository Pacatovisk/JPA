package com.pacatovisk.ecommerce.relacionamentos;

import com.pacatovisk.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.pacatovisk.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoManyToOneTest extends EntityManagerTest {


    @Test
    public void verificarRelacionamentoManyToOneTest2() {
        Produto produto = entityManager.find(Produto.class, 1);
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setTotal(BigDecimal.TEN);
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setCliente(cliente);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPrecoProduto(BigDecimal.TEN);
        itemPedido.setQuantidade(23);
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.persist(itemPedido);
        entityManager.getTransaction().commit();
        entityManager.clear();

        ItemPedido itemPedidoVerificado = entityManager.find(ItemPedido.class, itemPedido.getId());
        Assert.assertNotNull(itemPedidoVerificado.getPedido());
        Assert.assertNotNull(itemPedidoVerificado.getProduto());

        Pedido pedidoVerificado = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertFalse(pedidoVerificado.getItemPedidos().isEmpty());

        Cliente clienteVerificacao = entityManager.find(Cliente.class, cliente.getId());
        Assert.assertFalse(clienteVerificacao.getPedidos().isEmpty());
    }


    @Test
    public void verificarRelacionamentoManyToOneTest() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Pedido pedido = new Pedido();

        pedido.setStatus(StatusPedido.AGUARDANDO);
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
