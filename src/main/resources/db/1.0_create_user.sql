-- Crear el usuario
CREATE USER REPORT_USER IDENTIFIED BY Ora123;

-- Otorgar privilegios básicos para iniciar sesión y manipular datos
GRANT CREATE SESSION TO REPORT_USER;

-- Otorgar el rol RESOURCE para permitir la creación de objetos
GRANT RESOURCE TO REPORT_USER;

-- Otorgar el rol CONNECT para permitir la conexión
GRANT CONNECT TO REPORT_USER;

-- Otorga quota sobre tablescpace de users
ALTER USER REPORT_USER QUOTA UNLIMITED ON USERS;