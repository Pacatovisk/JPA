package com.pacatovisk.ecommerce.iniciandocomjpa;


import com.pacatovisk.ecommerce.model.Cliente;
import com.pacatovisk.ecommerce.model.SexoCliente;
import org.junit.Assert;
import org.junit.Test;

public class MapeandoEnumeracoesTest extends EntityManagerTest {


    @Test
    public void testarEnum() {
        Cliente cliente = new Cliente();

        cliente.setId(7);
        cliente.setNome("José Variante");
        cliente.setSexo(SexoCliente.MASCULINO);

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Cliente clienteVerificacao = entityManager.find(Cliente.class, 4);
        Assert.assertNotNull(clienteVerificacao);
    }

}
