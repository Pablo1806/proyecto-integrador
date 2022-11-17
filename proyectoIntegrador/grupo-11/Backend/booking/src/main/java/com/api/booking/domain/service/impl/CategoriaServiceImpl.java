package com.api.booking.domain.service.impl;

import com.api.booking.domain.dto.CategoriaDTO;
import com.api.booking.domain.service.CategoriaService;
import com.api.booking.exceptions.ResourceNotFoundException;
import com.api.booking.persistance.entity.Categoria;
import com.api.booking.persistance.repository.CategoriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    //LOGGER log4j
    final static Logger LOGGER = Logger.getLogger(CategoriaServiceImpl.class);

    // inyeccion de dependencias de Categoria Repository
    private CategoriaRepository categoriaRepository;

    // object mapper
    private ObjectMapper mapper;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, ObjectMapper mapper) {
        this.categoriaRepository = categoriaRepository;
        this.mapper = mapper;
    }

    //----------------------BEGIN. IMPLEMENTED METHODS---------------------------


    @Override
    public CategoriaDTO createCategoria(Categoria categoria) throws ResourceNotFoundException {
        LOGGER.info("GUARDANDO CATEGORIA METODO - createCategoria");
        CategoriaDTO saveCategoriaDTO = new CategoriaDTO();
        CategoriaDTO categoriaLocal = mapper.convertValue(categoriaRepository.findByTitulo(categoria.getTitulo()), CategoriaDTO.class);
        if (categoriaLocal != null) {
            LOGGER.info("CATEGORIA YA EXISTE EN LA BASE DE DATOS");
            throw new ResourceNotFoundException("Categoria ya existe");
        } else {
            // guardar categoria
            categoriaLocal = mapper.convertValue(categoriaRepository.save(categoria), CategoriaDTO.class);
        }
        return saveCategoriaDTO;
    }

    @Override
    public CategoriaDTO finByTitulo(String titulo) throws ResourceNotFoundException {
        LOGGER.info("BUSCANDO CATEGORIA POR TITULO METODO - findByTitulo");
        Optional<Categoria> categoria;
        CategoriaDTO categoriaDTO = new CategoriaDTO();

        if (titulo != null) {
            categoria = Optional.ofNullable(categoriaRepository.findByTitulo(titulo));
            if (categoria.isPresent()) {
                categoriaDTO = mapper.convertValue(categoria.get(), CategoriaDTO.class);
            } else {
                LOGGER.info("CATEGORIA NO ENCONTRADA");
                throw new ResourceNotFoundException("Categoria no encontrada");
            }
        }
        LOGGER.info("CATEGORIA ENCONTRADA");
        return categoriaDTO;
    }

    @Override
    public CategoriaDTO updateCategoria(Categoria categoria) throws ResourceNotFoundException {
        LOGGER.info("ACTUALIZANDO CATEGORIA METODO - updateCategoria");
        CategoriaDTO updateCategoriaDTO = new CategoriaDTO();
        CategoriaDTO categoriaLocal = mapper.convertValue(categoriaRepository.findByTitulo(categoria.getTitulo()), CategoriaDTO.class);
        if (categoriaLocal.getTitulo() != null) {
            // actualizar categoria
            categoriaLocal = mapper.convertValue(categoriaRepository.save(categoria), CategoriaDTO.class);
            updateCategoriaDTO = categoriaLocal;
        } else {
            LOGGER.info("CATEGORIA NO ENCONTRADA");
            throw new ResourceNotFoundException("Categoria no encontrada");
        }
        return updateCategoriaDTO;
    }

    @Override
    public CategoriaDTO deleteCategoriaById(Long id) throws ResourceNotFoundException {
        LOGGER.info("ELIMINANDO CATEGORIA METODO - deleteCategoriaById");
        CategoriaDTO deleteCategoriaDTO = new CategoriaDTO();
        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if (categoria.isPresent()) {
            // eliminar categoria
            categoriaRepository.deleteById(id);
            deleteCategoriaDTO = mapper.convertValue(categoria.get(), CategoriaDTO.class);
        } else {
            LOGGER.info("CATEGORIA NO ENCONTRADA");
            throw new ResourceNotFoundException("Categoria no encontrada");
        }
        return deleteCategoriaDTO;
    }

    @Override
    public List<CategoriaDTO> readAllCategoria() throws ResourceNotFoundException {
        LOGGER.info("LISTANDO TODAS LAS CATEGORIAS METODO - readAllCategoria");
        List<CategoriaDTO> categoriaDTOList = new ArrayList<>();
        List<Categoria> categoriaList = categoriaRepository.findAll();

        if (categoriaList.isEmpty()) {
            LOGGER.info("NO HAY CATEGORIAS EN LA BASE DE DATOS");
            throw new ResourceNotFoundException("No hay categorias en la base de datos");
        } else {
            categoriaList.forEach(categoria -> {
                CategoriaDTO categoriaDTO = mapper.convertValue(categoria, CategoriaDTO.class);
                categoriaDTOList.add(categoriaDTO);
            });
        }
        LOGGER.info("LISTA DE CATEGORIAS");
        return categoriaDTOList;
    }


    //----------------------END. IMPLEMENTED METHODS---------------------------


    // metodo que inserta datos de prueba en la base de datos al iniciar la aplicacion
    @Override
    public void insertCategorias() {
        LOGGER.info("INSERTANDO CATEGORIAS");
        Categoria categoria1 = new Categoria();
        categoria1.setId(1L);
        categoria1.setTitulo("deportivos");
        categoria1.setDescripcion("Modelo 2022, con la mejor tecnologia y el mejor diseño. El mejor auto para vos");
        categoria1.setImagen("https://images.pexels.com/photos/2127037/pexels-photo-2127037.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
        categoriaRepository.save(categoria1);

        Categoria categoria2 = new Categoria();
        categoria2.setId(2L);
        categoria2.setTitulo("premium");
        categoria2.setDescripcion("Modelo 2023, elegancia y confort. El auto ideal para vos.");
        categoria2.setImagen("https://images.pexels.com/photos/951318/pexels-photo-951318.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
        categoriaRepository.save(categoria2);

        Categoria categoria3 = new Categoria();
        categoria3.setId(3L);
        categoria3.setTitulo("camionetas");
        categoria3.setDescripcion("Modelo 2019, una camioneta con la que podras presumir en cualquier lugar.");
        categoria3.setImagen("https://images.pexels.com/photos/116675/pexels-photo-116675.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
        categoriaRepository.save(categoria3);

        Categoria categoria4 = new Categoria();
        categoria4.setId(4L);
        categoria4.setTitulo("blindados");
        categoria4.setDescripcion("Modelo 2022, blindado con la mejor tecnologia y el mejor diseño. Sin duda una suv para vos");
        categoria4.setImagen("https://images.pexels.com/photos/1429775/pexels-photo-1429775.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
        categoriaRepository.save(categoria4);


    }
}

