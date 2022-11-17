package com.api.booking.persistance.repository;

import com.api.booking.persistance.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository <Producto,Long> {
     static Producto findById(Long id) {
        return null;
    }

}
