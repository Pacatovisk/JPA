package com.pacatovisk.ecommerce.iniciandocomjpa;

import com.pacatovisk.ecommerce.model.Cliente;
import com.pacatovisk.ecommerce.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

public class PrimeiroCrudTest extends EntityManagerTest {

    @Test
    public void buscarCliente() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        Assert.assertNotNull(cliente);
    }

    @Test
    public void criarCliente() {
        Cliente cliente = new Cliente(3, "Willian Viana", SexoCliente.MASCULINO);

        entityManager.getTransaction().begin();
        entityManager.merge(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificado = entityManager.find(Cliente.class, 3);

        Assert.assertNotNull(clienteVerificado);
        Assert.assertEquals("Willian Viana", clienteVerificado.getNome());
    }

    @Test
    public void atualizarCliente() {
        Cliente cliente = entityManager.find(Cliente.class, 1);

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        cliente.setNome("Marcelo Viana Dias");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteAtualizado = entityManager.find(Cliente.class, 1);
        Assert.assertNotNull(clienteAtualizado);
        Assert.assertEquals("Marcelo Viana Dias", clienteAtualizado.getNome());
    }

    @Test
    public void removerCliente() {
        Cliente cliente = entityManager.find(Cliente.class, 4);

        entityManager.getTransaction().begin();
        entityManager.remove(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteRemovido = entityManager.find(Cliente.class, 4);

        Assert.assertNull(clienteRemovido);
    }


}
