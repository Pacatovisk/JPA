package com.pacatovisk.ecommerce.mapeamentobasico;

import com.pacatovisk.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.pacatovisk.ecommerce.model.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;

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

        Cliente cliente = new Cliente();
        cliente.setNome("Miquéias");
        cliente.setSexo(SexoCliente.MASCULINO);

        Pedido pedido = new Pedido();

        ///pedido.setId(10); Comentado porque estamos utilizando IDENTITY
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO);
        pedido.setTotal(new BigDecimal(1000));
        pedido.setEnderecoEntrega(enderecoEntregaPedido);
        pedido.setCliente(cliente);


        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.persist(pedido);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Pedido pedidoVerificado = entityManager.find(Pedido.class, pedido.getId());

        Assert.assertNotNull(pedidoVerificado);
        Assert.assertEquals("MG", pedidoVerificado.getEnderecoEntrega().getEstado());
    }
}
