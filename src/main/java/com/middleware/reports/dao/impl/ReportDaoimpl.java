package com.middleware.reports.dao.impl;

import com.middleware.reports.dao.ReportDao;
import com.middleware.reports.mapper.CampanaRowMapper;
import com.middleware.reports.mapper.DetaCampRowMapper;
import com.middleware.reports.util.DataBaseParams;
import com.middleware.reports.vo.ReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ReportDaoimpl implements ReportDao {
    private final JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall simpleJdbcCall;

    @Autowired
    public ReportDaoimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }



    @Override
    public List<ReportVo> obtenerReportesPorFecha(Timestamp fecha) {
        List<ReportVo> reports;
        this.simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName(DataBaseParams.NAME_SP_OBTENER_CAMPANAS)
                .declareParameters(
                        new SqlParameter(DataBaseParams.In.P_FECHA, Types.TIMESTAMP),
                        new SqlParameter(DataBaseParams.Out.P_RESULTADO, Types.REF_CURSOR)
                )
                .returningResultSet(DataBaseParams.Out.P_RESULTADO, new CampanaRowMapper());
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(DataBaseParams.In.P_FECHA, fecha);
        Map<String, Object> result = this.simpleJdbcCall.execute(params);
        reports = (List<ReportVo>) result.get(DataBaseParams.Out.P_RESULTADO);
        return reports;
    }

    @Override
    public List<ReportVo.DetalleVo> obtenerDetallesPorFecha(Long idCampana) {
        String sql = "{call sp_obtener_detalles_campanas(?,?)}";
        return jdbcTemplate.query(sql, new Object[]{idCampana}, new DetaCampRowMapper());

    }

}