--Script Examen middleware
--Creacion tabla TA_SMS_MAESTRO
CREATE TABLE TA_SMS_MAESTRO(
                               id_campana NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                               nombre_campana VARCHAR2(50) NOT NULL,
                               fecha_emision_campana TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);
--Creacion tabla TA_SMS_DETALLE
CREATE TABLE TA_SMS_DETALLE(
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
CREATE INDEX idx_id_campana ON TA_SMS_DETALLE(id_campana);
CREATE INDEX idx_fecha_envio ON TA_SMS_DETALLE(fecha_envio);
CREATE INDEX idx_fecha_emision ON TA_SMS_MAESTRO(fecha_emision_campana);

--Insercion de registros tabla TA_SMS_MAESTRO
INSERT INTO TA_SMS_MAESTRO (nombre_campana, fecha_emision_campana)
VALUES ('Telcel', TO_TIMESTAMP('2023-10-02 09:00:00','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TA_SMS_MAESTRO (nombre_campana, fecha_emision_campana)
VALUES ('Hulux', TO_TIMESTAMP('2024-12-20 09:45:55','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TA_SMS_MAESTRO (nombre_campana, fecha_emision_campana)
VALUES ('Movistar', TO_TIMESTAMP('2024-11-09 08:00:01','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TA_SMS_MAESTRO (nombre_campana, fecha_emision_campana)
VALUES ('Pillofon', TO_TIMESTAMP('2025-01-20 10:30:30','YYYY-MM-DD HH24:MI:SS'));

--Insercion de registros tabla TA_SMS_DETALLE
INSERT INTO TA_SMS_DETALLE (id_campana, mensaje, destinatario, fecha_envio)
VALUES (1, 'Contrata telcel, la red mas rapida', '7721137021', TO_TIMESTAMP('2023-10-02 01:11:10','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TA_SMS_DETALLE (id_campana, mensaje, destinatario, fecha_envio)
VALUES (1, '¿Te quedaste sin datos?, contrata telcel la red mas rapida', '7771137022', TO_TIMESTAMP('2023-10-20 09:00:00','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TA_SMS_DETALLE (id_campana, mensaje, destinatario, fecha_envio)
VALUES (1, 'Adelantos telcel, contrate ahora mismo', '3331137021', TO_TIMESTAMP('2023-10-22 19:50:00','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TA_SMS_DETALLE (id_campana, mensaje, destinatario, fecha_envio)
VALUES (2, 'Rebajas del 50% en paquetes de internet por dia de los enamorados', '5521138021', TO_TIMESTAMP('2023-11-12 09:00:00','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TA_SMS_DETALLE (id_campana, mensaje, destinatario, fecha_envio)
VALUES (2, 'Hulux, somos seres de luz, contrate ahora mismo', '4521137021', TO_TIMESTAMP('2023-11-02 03:30:33','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TA_SMS_DETALLE (id_campana, mensaje, destinatario, fecha_envio)
VALUES (3, 'Nuevos paquetes y mas velocidad', '5521137021', TO_TIMESTAMP('2024-04-08 05:50:50','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TA_SMS_DETALLE (id_campana, mensaje, destinatario, fecha_envio)
VALUES (3, 'Contrate Movistar, la red mas rapida', '7121137021', TO_TIMESTAMP('2022-10-30 06:15:55','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TA_SMS_DETALLE (id_campana, mensaje, destinatario, fecha_envio)
VALUES (3, 'Regala una recarga a tu pareja por este 14 de febrero', '7715137021', TO_TIMESTAMP('2023-07-02 09:00:00','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TA_SMS_DETALLE (id_campana, mensaje, destinatario, fecha_envio)
VALUES (3, 'Descuentos del 25% en paquetes mayores a 100 pesos', '7851137021', TO_TIMESTAMP('2023-10-02 10:10:10','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO TA_SMS_DETALLE (id_campana, mensaje, destinatario, fecha_envio)
VALUES (4, 'Estate en onda con pillofon', '4271507890', TO_TIMESTAMP('2023-10-02 09:00:00','YYYY-MM-DD HH24:MI:SS'));

CREATE OR REPLACE PROCEDURE sp_obtener_mensajes(
    p_fecha IN TIMESTAMP,
    p_limite IN NUMBER,
    p_offset IN NUMBER,
    p_resultado OUT SYS_REFCURSOR
) AS
BEGIN
OPEN p_resultado FOR
SELECT
    m.id_campana,
    m.nombre_campana,
    m.fecha_emision_campana,
    d.id_detalle,
    d.mensaje,
    d.destinatario,
    d.fecha_envio
FROM TA_SMS_MAESTRO m
         JOIN TA_SMS_DETALLE d ON m.id_campana = d.id_campana
WHERE TRUNC(m.fecha_emision_campana) = TRUNC(p_fecha)
ORDER BY d.fecha_envio
OFFSET p_offset ROWS FETCH NEXT p_limite ROWS ONLY;
END sp_obtener_mensajes;
/