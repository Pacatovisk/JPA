package com.pacatovisk.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nota_fiscal")
public class NotaFiscal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    /**
     *
     * Mapeamento possivel com o @JoinTable para o relacionamento um para um
     *
     * @OneToOne
     * @JoinTable(name  = "pedido_nota_fiscal",
     * joinColumns   = @JoinColumn(name = "nota_fiscal_id", unique = true),
     *                inverseJoinColumns = @JoinColumn(name = "pedido_id", unique = true))
     * private Pedido pedido;
     */

    @Column(name = "xml")
    private String xml;

    @Column(name = "data_emissao")
    private Date dataEmissao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotaFiscal that = (NotaFiscal) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
