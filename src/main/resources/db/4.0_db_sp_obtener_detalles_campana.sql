CREATE OR REPLACE PROCEDURE REPORT_USER.sp_obtener_detalles_campana(
       p_idcampana IN NUMBER,
       p_resultado out SYS_REFCURSOR
) AS
       BEGIN
            OPEN p_resultado FOR
            SELECT id_detalle, mensaje, destinatario, fecha_envio
            FROM REPORT_USER.TA_SMS_DETALLE
            WHERE id_campana = p_idcampana;
END sp_obtener_detalles_campana;

