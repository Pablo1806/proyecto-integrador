package com.api.booking.domain.service;

import com.api.booking.domain.dto.CategoriaDTO;
import com.api.booking.exceptions.ResourceNotFoundException;
import com.api.booking.persistance.entity.Categoria;

import java.util.List;

public interface CategoriaService {

    // CRUD Categoria

    CategoriaDTO createCategoria(Categoria categoria) throws ResourceNotFoundException;

    CategoriaDTO finByTitulo(String titulo) throws ResourceNotFoundException;

    CategoriaDTO updateCategoria(Categoria categoria) throws ResourceNotFoundException;

    CategoriaDTO deleteCategoriaById(Long id) throws ResourceNotFoundException;

    List<CategoriaDTO> readAllCategoria() throws ResourceNotFoundException;

    // metodo para insertar categorias al desplegar la aplicacion
    void insertCategorias();

}
