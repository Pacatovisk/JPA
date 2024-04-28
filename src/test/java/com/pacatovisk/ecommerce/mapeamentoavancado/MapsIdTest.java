package com.pacatovisk.ecommerce.mapeamentoavancado;

import com.pacatovisk.ecommerce.iniciandocomjpa.EntityManagerTest;
import com.pacatovisk.ecommerce.model.NotaFiscal;
import com.pacatovisk.ecommerce.model.Pedido;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MapsIdTest extends EntityManagerTest {


    @Test
    public void inserirPagamento() {
        Pedido pedido = entityManager.find(Pedido.class, 1);

        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setPedido(pedido);
        notaFiscal.setDataEmissao(new Date());
        notaFiscal.setXml("<xml/>");

        entityManager.getTransaction().begin();

        entityManager.persist(notaFiscal);

        entityManager.getTransaction().commit();

        entityManager.clear();

        NotaFiscal notaFiscalVerificacao = entityManager.find(NotaFiscal.class,1);
        assertNotNull(notaFiscalVerificacao);
        assertEquals(pedido.getId(), notaFiscalVerificacao.getId());
    }
}
