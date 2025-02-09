package com.middleware.reports.dao;

import com.middleware.reports.vo.ReportVo;

import java.sql.Timestamp;
import java.util.List;

public interface ReportDao {
    List<ReportVo> obtenerReportesPorFecha(Timestamp fecha);
}
