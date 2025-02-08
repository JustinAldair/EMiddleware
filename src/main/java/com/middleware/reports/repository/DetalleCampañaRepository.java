package com.middleware.reports.repository;

import com.middleware.reports.entity.DetalleCampanaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCampañaRepository {
    //metodo para buscar en la tabla detalle todos los registro con coincidencia de id de la primera busqueda
    List<DetalleCampanaEntity> findByCampanaId(Long id);
}
