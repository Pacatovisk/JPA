package com.pacatovisk.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pagamento_cartao")
public class PagamentoCartao implements Serializable {

    @Id
    private Integer id;

    @Column(name = "pedido_id")
    private Integer pedidoId;

    @Column(name = "numero")
    private Integer numero;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;
}