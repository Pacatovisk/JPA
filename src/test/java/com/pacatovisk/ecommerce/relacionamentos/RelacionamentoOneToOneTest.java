package com.pacatovisk.ecommerce.relacionamentos;

import com.pacatovisk.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.pacatovisk.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RelacionamentoOneToOneTest extends EntityManagerTest {

    @Test
    public void verificarRelacionamento() {
        Pedido pedido = entityManager.find(Pedido.class, 1);

        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.setStatus(StatusPagamento.PROCESSANDO);
        pagamentoCartao.setPedido(pedido);
        pagamentoCartao.setNumero(2232);

        entityManager.getTransaction().begin();
        entityManager.persist(pagamentoCartao);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
        Assert.assertNotNull(pedidoVerificacao.getPagamento());
    }
}
