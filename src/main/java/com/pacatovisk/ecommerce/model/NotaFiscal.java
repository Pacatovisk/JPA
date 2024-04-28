package com.pacatovisk.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nota_fiscal")
public class NotaFiscal implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "pedido_id")
    private Integer id;

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    /**
     * Mapeamento possivel com o @JoinTable para o relacionamento um para um
     *
     * @OneToOne
     * @JoinTable(name = "pedido_nota_fiscal",
     * joinColumns   = @JoinColumn(name = "nota_fiscal_id", unique = true),
     * inverseJoinColumns = @JoinColumn(name = "pedido_id", unique = true))
     * private Pedido pedido;
     */

    @Column(name = "xml")
    private String xml;

    @Column(name = "data_emissao")
    private Date dataEmissao;

}
