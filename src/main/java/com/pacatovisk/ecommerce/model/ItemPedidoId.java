package com.pacatovisk.ecommerce.model;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedidoId implements Serializable {

    @EqualsAndHashCode.Include
    private Integer produtoId;

    @EqualsAndHashCode.Include
    private Integer pedidoId;
}
