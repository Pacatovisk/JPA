package com.pacatovisk.ecommerce.model;

import jakarta.persistence.PostLoad;

public class GenericoListener {

    @PostLoad
    public void logCarregamentoEntidade(Object obj) {
        System.out.println("Entidade " + obj.getClass().getSimpleName() + " foi carregada!");
    }
}
