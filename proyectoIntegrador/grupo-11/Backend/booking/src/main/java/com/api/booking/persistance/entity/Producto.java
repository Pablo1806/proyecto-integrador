package com.api.booking.persistance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "Productos")
public class Producto {
    @Id
    @Column(name= "id_producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private static Long id;
    private String titulo;
    /*relacion entre Categoria y producto*/
    @OneToOne(mappedBy = "Productos")
    @JsonIgnore
    private Set<Categoria> categoria;

    public Producto(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public static Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
