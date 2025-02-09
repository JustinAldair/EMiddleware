package com.middleware.reports.service.impl;

import com.middleware.reports.dao.ReportDao;
import com.middleware.reports.request.ReportRequest;
import com.middleware.reports.response.ReportResponse;
import com.middleware.reports.service.ReportService;
import com.middleware.reports.vo.ReportVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
@Service
public class ReportServiceimpl implements ReportService {
    @Autowired
    private ReportDao reportDao;
//    @Override
//    public ReportResponse generarReport(ReportRequest reportRequest) {
//        String fechaSolicitada = reportRequest.getFechaIngresada() + "00:00:00";
//        Timestamp fechaTimestamp = Timestamp.valueOf(fechaSolicitada);
//
//        List<ReportVo> lisResultadosVo = reportDao.obtenerReportesPorFecha(fechaTimestamp);
//
//        ReportResponse response = new ReportResponse();
//        response.setFecha(reportRequest.getFechaIngresada());
//        response.setTotalCampana(lisResultadosVo.size());
//        response.setCampanas(lisResultadosVo);
//
//        return response;

    @Override
    public ReportResponse generarReport(String fecha) {
        String fechaSolicitada = fecha + "00:00:00";
        Timestamp fechaTimestamp = Timestamp.valueOf(fechaSolicitada);

        List<ReportVo> lisResultadosVo = reportDao.obtenerReportesPorFecha(fechaTimestamp);
        ReportResponse response = new ReportResponse();
        response.setFecha(fecha);
        response.setTotalCampana(lisResultadosVo.size());
        response.setCampanas(lisResultadosVo);

        return response;

    }
}
