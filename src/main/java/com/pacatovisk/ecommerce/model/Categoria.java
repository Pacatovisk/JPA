package com.pacatovisk.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "categoria_pai_id")
    private Integer categoriaPaiId;
}
