package com.pacatovisk.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pagamento_cartao")
public class PagamentoCartao implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "pedido_id")
    private Integer id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @Column(name = "numero")
    private Integer numero;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;
}