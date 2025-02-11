CREATE OR REPLACE PROCEDURE sp_obtener_campanas(
    p_fecha IN TIMESTAMP,
    p_resultado OUT SYS_REFCURSOR
) AS
BEGIN
    OPEN p_resultado FOR
        SELECT id_campana, nombre_campana, fecha_emision_campana
        FROM TA_SMS_MAESTRO
        WHERE TRUNC(fecha_emision_campana) = TRUNC(p_fecha);
END sp_obtener_campanas;