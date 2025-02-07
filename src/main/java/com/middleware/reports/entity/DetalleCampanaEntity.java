package com.middleware.reports.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "TA_SMS_DETALLE")
public class DetalleCampanaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long idDetalle;

    @ManyToOne
    @JoinColumn(name = "id_campana", nullable = false)
    private CampanaEntity idCampana;

    @Column(name = "mensaje", nullable = false, length = 500)
    private String mensaje;

    @Column(name = "destinatario", nullable = false, length = 15)
    private String destinatario;

    @Column(name = "fecha_envio", nullable = false)
    private Timestamp fechaEnvio;

}
