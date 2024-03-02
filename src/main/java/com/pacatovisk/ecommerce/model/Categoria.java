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
@Table(name = "categoria")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tabela")
    @TableGenerator(name  = "tabela", table = "hibernate_sequences",
                    pkColumnName = "sequence_name",
                    pkColumnValue = "categoria",
                    valueColumnName = "next_val",
                    initialValue = 0,
                    allocationSize = 50)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "categoria_pai_id")
    private Integer categoriaPaiId;
}
