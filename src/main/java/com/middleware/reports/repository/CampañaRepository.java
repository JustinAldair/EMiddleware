package com.middleware.reports.repository;

import com.middleware.reports.entity.CampanaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CampañaRepository extends JpaRepository <CampanaEntity, Long> {
    //Metodo personalizado para buscar por fecha
List<CampanaEntity> findByFechaEmisionCampana(Timestamp fecha);

}
