package com.api.booking.domain.dto;

public class ProductoDTO {
    private Long id;
    private String titulo;


    public ProductoDTO(Long id, String titulo) {

        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
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

    @Override public String toString(){
        return "ProductoDTO{"+
                " id="+ id +
                ", titulo="+ titulo+'\''+
                '}';
    }
}


