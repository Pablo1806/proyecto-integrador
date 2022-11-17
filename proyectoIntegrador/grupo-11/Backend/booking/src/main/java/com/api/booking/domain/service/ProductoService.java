package com.api.booking.domain.service;

import com.api.booking.domain.dto.ProductoDTO;
import com.api.booking.exceptions.ResourceNotFoundException;
import com.api.booking.persistance.entity.Producto;

import java.util.List;

public interface ProductoService {
    ProductoDTO createProducto(Producto producto) throws ResourceNotFoundException;

    ProductoDTO finById(Long id) throws ResourceNotFoundException;

    ProductoDTO updateProducto(Producto producto) throws ResourceNotFoundException;

    ProductoDTO deleteProductoById(Long id) throws ResourceNotFoundException;

    List<ProductoDTO> readAllProducto() throws ResourceNotFoundException;

    // metodo para insertar categorias al desplegar la aplicacion
    void insertProductos();
}
