package com.middleware.reports.mapper;

import com.middleware.reports.vo.ReportVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DetaCampRowMapper implements RowMapper<ReportVo.DetalleVo> {
    @Override
    public ReportVo.DetalleVo mapRow(ResultSet rs, int rowNum) throws SQLException {
        ReportVo.DetalleVo detalle = new ReportVo.DetalleVo();
        detalle.setIdDetalle(rs.getLong("id_detalle"));
        detalle.setMensaje(rs.getString("mensaje"));
        detalle.setDestinatario(rs.getString("destinatario"));
        detalle.setFechaEnvio(rs.getTimestamp("fecha_envio"));

        return detalle;
    }

}
