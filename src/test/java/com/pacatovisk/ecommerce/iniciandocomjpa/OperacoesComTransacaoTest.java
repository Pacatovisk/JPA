package com.pacatovisk.ecommerce.iniciandocomjpa;

import com.pacatovisk.ecommerce.model.Produto;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OperacoesComTransacaoTest extends EntityManagerTest {

    @Test
    public void impedirOperacaoComBancoDeDados() {
        Produto produto = entityManager.find(Produto.class, 1);
        entityManager.detach(produto); // desanexa a instância do objeto do entity manage e qualquer operação crud não terá efeitos no banco de dados

        entityManager.getTransaction().begin();
        produto.setNome("Pão de sal");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificado = entityManager.find(Produto.class, 1);
        Assert.assertEquals("Kindle", produtoVerificado.getNome());
    }


    @Test
    public void diferencaPersistEmerge() {
        Produto produtoPersist = new Produto();

        produtoPersist.setId(7);
        produtoPersist.setNome("Celular LG");
        produtoPersist.setDescricao("Melhor de todos");
        produtoPersist.setPreco(new BigDecimal(2000));

        entityManager.getTransaction().begin();
        entityManager.persist(produtoPersist);
        produtoPersist.setDescricao("Agora é o pior celular!");
        entityManager.getTransaction().commit();

        Produto produtoAssertionPersist = entityManager.find(Produto.class, produtoPersist.getId());

        Assert.assertNotNull(produtoAssertionPersist);

        Produto produtoMerge = new Produto();

        produtoMerge.setId(4);
        produtoMerge.setNome("Notebook HP");
        produtoMerge.setDescricao("Melhor da categoria");
        produtoMerge.setPreco(new BigDecimal(232));

        entityManager.getTransaction().begin();
        produtoMerge = entityManager.merge(produtoMerge);
        produtoMerge.setDescricao("Muito bom!");
        entityManager.getTransaction().commit();

        Produto produtoAssertionMerge = entityManager.find(Produto.class, produtoMerge.getId());

        Assert.assertNotNull(produtoAssertionMerge);
    }


    @Test
    public void inserirObjetoComMerge() {
        Produto produto = new Produto();

        produto.setId(4);
        produto.setNome("Microfone Rode Videmic");
        produto.setDescricao("A melhor qualidade de som.");
        produto.setPreco(new BigDecimal(500));

        entityManager.getTransaction().begin();
        entityManager.merge(produto); // insert product in database
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());

        Assert.assertEquals(produto.getId(), produtoVerificacao.getId());
    }

    @Test
    public void atualizarObjetoGerenciado() {
        Produto produto = entityManager.find(Produto.class, 1);

        entityManager.getTransaction().begin();
        produto.setNome("Kindle Paperwhite 2ª Geração");
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoAtualizado = entityManager.find(Produto.class, produto.getId());

        Assert.assertEquals("Kindle Paperwhite 2ª Geração", produtoAtualizado.getNome());
    }

    @Test
    public void atualizarObjeto() {
        Produto produto = new Produto();

        produto.setId(1);
        produto.setNome("Kindle Paperwhite");
        produto.setDescricao("Conheça o novo Kindle.");
        produto.setPreco(new BigDecimal(1000));

        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoAtualizado = entityManager.find(Produto.class, produto.getId());

        Assert.assertEquals("Kindle Paperwhite", produtoAtualizado.getNome());
    }

    @Test
    public void inserirOPrimeiroObjeto() {
        Produto produto = new Produto();
        produto.setId(2);
        produto.setNome("Câmera Canon");
        produto.setDescricao("A melhor definição para suas fotos.");
        produto.setPreco(new BigDecimal(5000));

        entityManager.getTransaction().begin();
        entityManager.persist(produto); // insert product in database
        entityManager.getTransaction().commit();
        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());

        Assert.assertEquals(produto.getId(), produtoVerificacao.getId());
    }

    @Test
    public void removerObjeto() {
        Produto produto = entityManager.find(Produto.class, 3);

        entityManager.getTransaction().begin();
        entityManager.remove(produto);
        entityManager.getTransaction().commit();

        Produto produtoVerificacao = entityManager.find(Produto.class, 3);
        Assert.assertNull(produtoVerificacao);
    }

}
