package com.middleware.reports.controller;

import com.middleware.reports.response.ReportResponse;
import com.middleware.reports.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reporte")
public class ReportController {
    //inyeccion del service
    @Autowired
    private ReportService reportService;

    @GetMapping
    public ReportResponse obtenerReporte(@RequestParam String fecha) {
        return reportService.generarReport(fecha);
    }
}
