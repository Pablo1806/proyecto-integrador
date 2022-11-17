package com.api.booking.web.controller;

import com.api.booking.domain.dto.CategoriaDTO;
import com.api.booking.domain.service.impl.CategoriaServiceImpl;
import com.api.booking.exceptions.ResourceNotFoundException;
import com.api.booking.persistance.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/categorias")
// anotacion para permitir peticiones desde cualquier origen frontend
@CrossOrigin(origins = "*")
public class CategoriaController {

    // Inyeccion de dependencia de CategoriaService impl
    @Autowired
    private CategoriaServiceImpl categoriaService;


    // -------------------BEGIN. VIEWS HTTP REQUESTS-------------------

    @PostMapping("/save")
    public ResponseEntity<?> saveCategoria(@RequestBody Categoria categoria) throws ResourceNotFoundException {
        ResponseEntity response = new ResponseEntity<>("AUTOINCREMENT ID", HttpStatus.BAD_REQUEST);
        CategoriaDTO categoriaDTOResponse = new CategoriaDTO();
        categoriaDTOResponse = categoriaService.createCategoria(categoria);

        if (categoriaDTOResponse != null) {
            response = new ResponseEntity<>("CATEGORIA CREADA CON EXITO", HttpStatus.CREATED);
        }
        return response;
    }

    @GetMapping("/read/{titulo}")
    public ResponseEntity<?> readCategoria(@PathVariable("titulo") String titulo) throws ResourceNotFoundException {
        ResponseEntity response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        CategoriaDTO categoriaDTOResponse = categoriaService.finByTitulo(titulo);

        if (categoriaDTOResponse.getId() != null) {
            response = new ResponseEntity<>(categoriaDTOResponse, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("CATEGORIA NO ENCONTRADA", HttpStatus.NOT_FOUND);
        }
        return response;

    }

    @GetMapping("/readAll")
    public ResponseEntity<?> readAllCategorias() throws ResourceNotFoundException {
        ResponseEntity response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Stream<CategoriaDTO> categoriaDTOResponse = categoriaService.readAllCategoria().stream();

        if (categoriaDTOResponse != null) {
            response = new ResponseEntity<>(categoriaDTOResponse, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>("NO HAY CATEGORIAS", HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCategoria(@RequestBody Categoria categoria) throws ResourceNotFoundException {
        ResponseEntity response = new ResponseEntity<>("CATEGORIA NO ENCONTRADA", HttpStatus.NOT_FOUND);
        CategoriaDTO categoriaDTOResponse = new CategoriaDTO();
        categoriaDTOResponse = categoriaService.updateCategoria(categoria);

        if (categoriaDTOResponse != null) {
            response = new ResponseEntity<>("CATEGORIA ACTUALIZADA CON EXITO", HttpStatus.OK);
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable("id") Long id) throws ResourceNotFoundException {
        ResponseEntity response = new ResponseEntity<>("CATEGORIA NO ENCONTRADA", HttpStatus.NOT_FOUND);
        CategoriaDTO categoriaDTOResponse = categoriaService.deleteCategoriaById(id);

        if (categoriaDTOResponse != null) {
            response = new ResponseEntity<>("CATEGORIA ELIMINADA CON EXITO", HttpStatus.OK);
        }
        return response;
    }

    // -------------------END. VIEWS HTTP REQUESTS-------------------


}
