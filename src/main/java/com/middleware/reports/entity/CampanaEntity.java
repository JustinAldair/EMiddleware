package com.middleware.reports.entity;

import jakarta.persistence.*; //Importa las dependencias necesarias para que sea una entidad JPA
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TA_SMS_MAESTRO")
public class CampanaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_campana")
    private Long idCampana;

    @Column(name = "nombre_campana", nullable = false, length = 50)
    private String nombreCampana;

    @CreationTimestamp
    @Column(name = "fecha_emision_campana", nullable = false)
    private Timestamp fechaEmisionCampana;

    //OneToMany
    @OneToMany(mappedBy = "campana", cascade = CascadeType.ALL)
    private List<DetalleCampanaEntity> detalles;
}
