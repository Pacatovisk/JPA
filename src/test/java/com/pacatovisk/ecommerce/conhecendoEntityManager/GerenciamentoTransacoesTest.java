package com.pacatovisk.ecommerce.conhecendoEntityManager;

import com.pacatovisk.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.pacatovisk.ecommerce.model.Pedido;
import com.pacatovisk.ecommerce.model.StatusPedido;
import org.junit.Test;

public class GerenciamentoTransacoesTest extends EntityManagerTest {

    @Test(expected = Exception.class)
    public void abrirFecharCancelarTransacao() {
        try {
            // Inicia uma nova transação
            entityManager.getTransaction().begin();

            // Chama o método de negócio
            metodoDeNegocio();

            // Confirma a transação se o método de negócio for bem-sucedido
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            // Em caso de exceção, reverte a transação e lança a exceção
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    // Método de negócio que realiza operações no banco de dados
    private void metodoDeNegocio() {
        // Busca um pedido com o ID 1 no banco de dados
        Pedido pedido = entityManager.find(Pedido.class, 1);

        // Altera o status do pedido para PAGO
        pedido.setStatus(StatusPedido.PAGO);

        // Verifica se o pagamento do pedido é nulo
        if (pedido.getPagamento() == null) {
            // Se o pagamento for nulo, lança uma exceção
            throw new RuntimeException("Pedido ainda não foi pago.");
        }
    }
}
