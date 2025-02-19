--Insercion de registros tabla TA_SMS_MAESTRO
INSERT INTO REPORT_USER.TA_SMS_MAESTRO (nombre_campana, fecha_emision_campana)
VALUES ('Telcel', TO_TIMESTAMP('2023-10-02 09:00:00','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO REPORT_USER.TA_SMS_MAESTRO (nombre_campana, fecha_emision_campana)
VALUES ('Hulux', TO_TIMESTAMP('2024-12-20 09:45:55','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO REPORT_USER.TA_SMS_MAESTRO (nombre_campana, fecha_emision_campana)
VALUES ('Movistar', TO_TIMESTAMP('2024-11-09 08:00:01','YYYY-MM-DD HH24:MI:SS'));

INSERT INTO REPORT_USER.TA_SMS_MAESTRO (nombre_campana, fecha_emision_campana)
VALUES ('Pillofon', TO_TIMESTAMP('2025-01-20 10:30:30','YYYY-MM-DD HH24:MI:SS'));

COMMIT;