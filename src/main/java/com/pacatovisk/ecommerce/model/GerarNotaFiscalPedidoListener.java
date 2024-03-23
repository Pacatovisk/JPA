package com.pacatovisk.ecommerce.model;

import com.pacatovisk.ecommerce.service.GerarNotaFiscalPedido;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class GerarNotaFiscalPedidoListener {

    private final GerarNotaFiscalPedido gerarNotaFiscalPedido = new GerarNotaFiscalPedido();

    @PrePersist
    @PreUpdate
    public void executar(Pedido pedido) {
        if (pedido.isPago() && pedido.getNotaFiscal() == null) {
            gerarNotaFiscalPedido.executar(pedido);
        }
    }
}
