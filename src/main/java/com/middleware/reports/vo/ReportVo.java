package com.middleware.reports.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;


@Data
public class ReportVo {
    private Long idCampana;
    private String nombreCampana;
    private Timestamp fechaEmisionCampana;
    private List<DetalleVo> detalles;

    @Data
    public static class DetalleVo {
        private Long idDetalle;
        private String mensaje;
        private String destinatario;
        private Timestamp fechaEnvio;
    }
}
