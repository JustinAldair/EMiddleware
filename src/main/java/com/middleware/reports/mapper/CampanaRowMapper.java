package com.middleware.reports.mapper;

import com.middleware.reports.vo.ReportVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CampanaRowMapper implements RowMapper<ReportVo>{
    @Override
    public ReportVo mapRow(ResultSet rs, int rowNum) throws SQLException {
        //Mapear datos de la campaña de la tabla maestro
        ReportVo reporte = new ReportVo();
        reporte.setIdCampana(rs.getLong("id_campana"));
        //reporte.setIdCampana(rs.getLong("id_campana"));
        reporte.setNombreCampana(rs.getString("nombre_campana"));
        reporte.setFechaEmisionCampana(rs.getTimestamp("fecha_emision_campana"));
        return reporte;
    }
}
