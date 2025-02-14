package com.middleware.reports.dao.impl;

import com.middleware.reports.dao.ReportDao;
import com.middleware.reports.mapper.CampanaRowMapper;
import com.middleware.reports.mapper.DetaCampRowMapper;
import com.middleware.reports.vo.ReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class ReportDaoimpl implements ReportDao {
    @Autowired private JdbcTemplate jdbcTemplate;

    @Override
    public List<ReportVo> obtenerReportesPorFecha(Timestamp fecha) {
        String sql = "{call sp_obtener_mensajes(?,?)}";
        return jdbcTemplate.query(sql, new Object[]{fecha}, new CampanaRowMapper());
    }

    @Override
    public List<ReportVo.DetalleVo> obtenerDetallesPorCampaña(Long idCampana) {
        String sql = "{call sp_obtener_detalles_campanas(?,?)}";
        return jdbcTemplate.query(sql, new Object[]{idCampana}, new DetaCampRowMapper());

    }

}