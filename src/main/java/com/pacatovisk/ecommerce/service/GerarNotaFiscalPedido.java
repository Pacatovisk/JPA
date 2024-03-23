package com.pacatovisk.ecommerce.service;

import com.pacatovisk.ecommerce.model.Pedido;

public class GerarNotaFiscalPedido {

    public void executar(Pedido pedido) {
        System.out.println("Nota fiscal gerada para o pedido " + pedido.getId() + ".");
    }

}
