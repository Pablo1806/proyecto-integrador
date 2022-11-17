package com.api.booking.web.config;

import com.api.booking.domain.service.impl.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InsercionesBD {

    // Inyeccion de dependencias categoria service impl
    @Autowired
    private CategoriaServiceImpl categoriaService;

    // anotacion que llama al metodo al iniciar la aplication para insertar datos en la base de datos
    @PostConstruct
    public void insertarDatos() {

        //Insertar datos en la base de datos
        categoriaService.insertCategorias();

    }

}
