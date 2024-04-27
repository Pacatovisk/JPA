package com.pacatovisk.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@ToString
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ItemPedidoId.class)
@Table(name = "item_pedido")
public class ItemPedido implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "pedido_id")
    private Integer pedidoId;

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "produto_id")
    private Integer produtoId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pedido_id", insertable = false, updatable = false)
    private Pedido pedido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id", insertable = false, updatable = false)
    private Produto produto;

    @Column(name = "preco_produto")
    private BigDecimal precoProduto;

    @Column(name = "quantidade")
    private Integer quantidade;

}