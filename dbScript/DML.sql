-- database: ../db/EXOBOT.sqlite
/*
 * DDL: Lenguaje de Manipulacion de Datos - CRUD (create, read, update, delete)
 copyRight
    - Create: insert INSERT 
    - Read: SELECT
    - Update: UPDATE
    - Delete: DELETE
    * autor: darez
    * fecha: 2k25
*/
 
    -- Inserción de datos en las tablas padre
INSERT INTO PersonaTipo (Tipo)
VALUES 
    ("Soldado"),
    ("Mecatronico"),
    ("Experto Ingles"),
    ("Experto Español");
    
INSERT INTO IABOT (Version)
VALUES             ('1.0');

UPDATE IABOT SET Version = 'IA-BOT-Darez', Estado = 'A' WHERE IdIABot = 1;

INSERT INTO IABOT (Version , Estado)
VALUES ('IA-RUSO', 'B');

INSERT INTO ExaBot
        (IdIABot, Serie)
VALUES  (1, 'ExaBot1-Darez');

INSERT INTO ExaBot
        (IdIABot, Serie)
VALUES  (2, 'ExaBot2-Darez');

SELECT IdIABot, Serie FROM ExaBot;

INSERT INTO Persona(IdPersonaTipo, Cedula, Nombre,Idioma)
VALUES (1, '1234567890', 'Darez1',            'Ruso'       ),
       (1, '0987654321', 'Darez2',            'Ruso'       ),
       (2, '1122334455', 'DarezMecatronico',  'Ruso'       ),
       (3, '5566778899', 'DarezIngles',       'Ingles'       ),
       (4, '9988776655', 'DarezEspañol',      'Español'       );
-- SELECT Descripcion con filtro LIKE
SELECT * FROM PersonaTipo WHERE Tipo Like '%s';
SELECT * FROM PersonaTipo WHERE Tipo Like '%o';
SELECT * FROM PersonaTipo WHERE Tipo Like '%o%';     
SELECT * FROM PersonaTipo WHERE Tipo Like '%ñ%';    
SELECT count(*)TotalTipoPersona FROM PersonaTipo;
   SELECT * FROM IABOT;
    SELECT * FROM ExaBot;
    SELECT * FROM Persona;
    SELECT * FROM PersonaTipo;
-- SELECT ALL
SELECT * FROM PersonaTipo WHERE IdPersonaTipo = 2;
SELECT * FROM PersonaTipo WHERE IdPersonaTipo = 4;

-- SELECT Descripcion
SELECT Tipo FROM PersonaTipo WHERE IdPersonaTipo = 4;
UPDATE PersonaTipo SET Tipo = 'Experto Ingles2' WHERE IdPersonaTipo = 3;