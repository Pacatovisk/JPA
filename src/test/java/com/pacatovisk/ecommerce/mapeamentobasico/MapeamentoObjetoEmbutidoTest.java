package com.pacatovisk.ecommerce.mapeamentobasico;

import com.pacatovisk.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.pacatovisk.ecommerce.model.EnderecoEntregaPedido;
import com.pacatovisk.ecommerce.model.Pedido;
import com.pacatovisk.ecommerce.model.StatusPedido;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MapeamentoObjetoEmbutidoTest extends EntityManagerTest {


    @Test
    public void analisarMapeamentoObejtoEmbutido() {
        EnderecoEntregaPedido enderecoEntregaPedido = new EnderecoEntregaPedido();
        enderecoEntregaPedido.setCep("00000-00");
        enderecoEntregaPedido.setLogradouro("Rua das Laranjeiras");
        enderecoEntregaPedido.setBairro("Centro");
        enderecoEntregaPedido.setNumero("1223");
        enderecoEntregaPedido.setCidade("Uberlandia");
        enderecoEntregaPedido.setEstado("MG");

        Pedido pedido = new Pedido();

        ///pedido.setId(10); Comentado porque estamos utilizando IDENTITY
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatusPedido(StatusPedido.AGUARDADANDO);
        pedido.setTotal(new BigDecimal(1000));
        pedido.setEnderecoEntrega(enderecoEntregaPedido);

        entityManager.getTransaction().begin();
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificado = entityManager.find(Pedido.class, pedido.getId());

        Assert.assertNotNull(pedidoVerificado);
        Assert.assertEquals("MG", pedidoVerificado.getEnderecoEntrega().getEstado());
    }
}
