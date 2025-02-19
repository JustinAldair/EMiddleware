--Script Examen middleware
--Creacion tabla TA_SMS_MAESTRO
CREATE TABLE REPORT_USER.TA_SMS_MAESTRO(
                               id_campana NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                               nombre_campana VARCHAR2(50) NOT NULL,
                               fecha_emision_campana TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);
--Creacion tabla TA_SMS_DETALLE
CREATE TABLE REPORT_USER.TA_SMS_DETALLE(
                               id_detalle NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                               id_campana NUMBER NOT NULL,
                               mensaje VARCHAR2(500) NOT NULL,
                               destinatario VARCHAR2(15) NOT NULL,
                               fecha_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
                               CONSTRAINT fk_campana
                                   FOREIGN KEY (id_campana)
                                       REFERENCES TA_SMS_MAESTRO (id_campana)
                                       ON DELETE CASCADE
);

--creacion de indices en respuesta la volumetria:
CREATE INDEX REPORT_USER.idx_id_campana ON REPORT_USER.TA_SMS_DETALLE(id_campana);
CREATE INDEX REPORT_USER.idx_fecha_envio ON REPORT_USER.TA_SMS_DETALLE(fecha_envio);
CREATE INDEX REPORT_USER.idx_fecha_emision ON REPORT_USER.TA_SMS_MAESTRO(fecha_emision_campana);


