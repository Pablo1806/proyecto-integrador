package com.api.booking.persistance.repository;

import com.api.booking.persistance.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // CRUD methods
    Categoria findByTitulo(String titulo);

    Categoria deleteByTitulo(String titulo);


}
