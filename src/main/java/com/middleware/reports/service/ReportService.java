package com.middleware.reports.service;


import com.middleware.reports.response.ReportResponse;
import com.middleware.reports.vo.ReportVo;

import java.sql.Timestamp;
import java.util.List;

public interface ReportService {
    public ReportResponse generarReport(String fecha);

}
