package com.middleware.reports.mapper;

import com.middleware.reports.vo.ReportVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class campanaRowMapper implements RowMapper<ReportVo>{
    @Override
    public ReportVo mapRow(ResultSet rs, int rowNum) throws SQLException {
        //Mapear datos de la campaña de la tabla maestro
        ReportVo reporte = new ReportVo();
        reporte.setIdCampana(rs.getLong("id_campana"));
        reporte.setNombreCampana(rs.getString("nombre_campana"));
        reporte.setFechaEmisionCampana(rs.getTimestamp("fecha_emision_campana"));

        //Mapear detalles de la campaña
        List<ReportVo.DetalleVo> detalles = new ArrayList<>();

        do {
            ReportVo.DetalleVo detalle = new ReportVo.DetalleVo();
            detalle.setIdDetalle(rs.getLong("id_detalle"));
            detalle.setMensaje(rs.getString("mensaje"));
            detalle.setDestinatario(rs.getString("destinatario"));
            detalle.setFechaEnvio(rs.getTimestamp("fecha_envio"));
            detalles.add(detalle);
        } while (rs.next() && rs.getLong("id_campana") == reporte.getIdCampana());

        reporte.setDetalles(detalles);
        rs.previous();
        return reporte;
    }
}
