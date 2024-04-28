package com.pacatovisk.ecommerce.mapeamentoavancado;

import com.pacatovisk.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.pacatovisk.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ChaveCompostaIdClassTest extends EntityManagerTest {

    @Test
    public void criarItemPedidoComChaveComposta() {
        entityManager.getTransaction().begin();
        Produto produto = entityManager.find(Produto.class, 1);
        Cliente cliente = entityManager.find(Cliente.class,1);

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDataCriacao(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(BigDecimal.TEN);

        entityManager.persist(pedido);

        entityManager.flush();

        ItemPedido item = new ItemPedido();

        item.setId(new ItemPedidoId());
        item.setProduto(produto);
        item.setPedido(pedido);
        item.setPrecoProduto(BigDecimal.TEN);
        item.setQuantidade(1);

        entityManager.persist(item);

        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao);
        Assert.assertFalse(pedidoVerificacao.getItemPedidos().isEmpty());

    }

    @Test
    public void buscarItemComChaveComposta() {
        ItemPedido itemPedidoPersistido = entityManager.find(ItemPedido.class, new ItemPedidoId(1,1));

        Assert.assertNotNull(itemPedidoPersistido);
    }

}
