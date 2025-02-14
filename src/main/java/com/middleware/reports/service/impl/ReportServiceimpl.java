package com.middleware.reports.service.impl;

import com.middleware.reports.dao.ReportDao;
import com.middleware.reports.request.ReportRequest;
import com.middleware.reports.response.ReportResponse;
import com.middleware.reports.service.KafkaConsumerService;
import com.middleware.reports.service.KafkaProducerService;
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

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Override
    public ReportResponse generarReport(String fecha) {
        String fechaSolicitada = fecha + " 00:00:00";
        Timestamp fechaTimestamp = Timestamp.valueOf(fechaSolicitada);

        List<ReportVo> lisResultadosVo = reportDao.obtenerReportesPorFecha(fechaTimestamp);

        for(ReportVo reportVo : lisResultadosVo){
            kafkaProducerService.sendMessage(reportVo.toString());

        }
        ReportResponse response = new ReportResponse();
        response.setFecha(fecha);
        response.setTotalCampana(lisResultadosVo.size());
        response.setCampanas(lisResultadosVo);

        return response;
    }
}