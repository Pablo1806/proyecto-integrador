package com.api.booking.domain.service.impl;


import com.api.booking.domain.dto.ProductoDTO;
import com.api.booking.domain.service.ProductoService;
import com.api.booking.exceptions.ResourceNotFoundException;
import com.api.booking.persistance.entity.Producto;
import com.api.booking.persistance.repository.ProductoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;



@Service
public class ProductoServiceImpl implements ProductoService {
    final static Logger LOGGER = Logger.getLogger(ProductoServiceImpl.class);

    private ProductoRepository productoRepository;

    private ObjectMapper mapper;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository, ObjectMapper mapper){
        this.productoRepository = productoRepository;
        this.mapper=mapper;
    }


   @Override
    public ProductoDTO createProducto(Producto producto) throws ResourceNotFoundException {
        LOGGER.info("GUARDANDO PRODUCTO METODO - createProducto");
        ProductoDTO saveProductoDTO = new ProductoDTO();
        ProductoDTO productoLocal = mapper.convertValue(ProductoRepository.findById(producto.getId()), ProductoDTO.class);
        if (productoLocal != null) {
            LOGGER.info("PRODUCTO YA EXISTE EN LA BASE DE DATOS");
            throw new ResourceNotFoundException("Producto ya existe");
        } else {
            productoLocal = mapper.convertValue(productoRepository.save(producto), ProductoDTO.class);
        }
        return saveProductoDTO;
    }

    @Override
    public ProductoDTO finById(Long id) throws ResourceNotFoundException {
        LOGGER.info("BUSCANDO PRODUCTO POR ID- findById");
        Optional<Producto>producto;
        ProductoDTO productoDTO=new ProductoDTO();
        if(id != null){
            producto = Optional.ofNullable(ProductoRepository.findById(id));
            if (producto.isPresent()){
                productoDTO = mapper.convertValue(producto.get(),ProductoDTO.class);
            } else {
                LOGGER.info("PRODUCTO NO ENCONTRADO");
                throw new ResourceNotFoundException("Producto no encontrado");
            }
        }
        LOGGER.info("PRODUCTO ENCONTRADO");
        return productoDTO;
    }

   @Override
    public ProductoDTO updateProducto(Producto producto) throws ResourceNotFoundException {
       LOGGER.info("ACTUALIZANDO PRODUCTO - updateProducto");
       ProductoDTO updateProductoDTO = new ProductoDTO();
       ProductoDTO productoLocal = mapper.convertValue(ProductoRepository.findById(producto.getId()), ProductoDTO.class);
       if (productoLocal.getId() != null) {
           // actualizar categoria
           productoLocal = mapper.convertValue(productoRepository.save(producto), ProductoDTO.class);
           updateProductoDTO = productoLocal;
       } else {
           LOGGER.info("PRODUCTO NO ENCONTRADO");
           throw new ResourceNotFoundException("Producto no encontrado");
       }
        return updateProductoDTO;
    }

    @Override
    public ProductoDTO deleteProductoById(Long id) throws ResourceNotFoundException {
        LOGGER.info("ELIMINANDO PRODUCTO - deleteProductoById");
        ProductoDTO deleteProductoDTO = new ProductoDTO();
        Optional<Producto> producto = Optional.ofNullable(ProductoRepository.findById(id));

        if (producto.isPresent()) {
            // eliminar producto
            productoRepository.deleteById(id);
            deleteProductoDTO = mapper.convertValue(producto.get(), ProductoDTO.class);
        } else {
            LOGGER.info("PRODUCTO NO ENCONTRADO");
            throw new ResourceNotFoundException(" Producto no encontrado");
        }
        return deleteProductoDTO;
    }

    @Override
    public List<ProductoDTO> readAllProducto() throws ResourceNotFoundException {
        LOGGER.info("LISTANDO TODOS LOS PRODUCTOS - readAllProducto");
        List<ProductoDTO> productoDTOList = new ArrayList<>();
        List<Producto> productoList = productoRepository.findAll();

        if (productoList.isEmpty()) {
            LOGGER.info("NO HAY PRODUCTOS EN LA BASE DE DATOS");
            throw new ResourceNotFoundException("No hay productos en la base de datos");
        } else {
            productoList.forEach(producto -> {
                ProductoDTO productoDTO = mapper.convertValue(producto, ProductoDTO.class);
                productoDTOList.add(productoDTO);
            });
        }
        LOGGER.info("LISTA DE PRODUCTOS");
        return productoDTOList;
    }

    @Override
    public void insertProductos() {

        LOGGER.info("INSERTANDO PRODUCTOS");
        Producto producto1 = new Producto();
        producto1.setId(1l);
        producto1.setTitulo("Renault Duster");


    }

}
