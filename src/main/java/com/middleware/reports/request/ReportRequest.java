package com.middleware.reports.request;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class ReportRequest {
    @NotNull
    private String fechaIngresada;
}
