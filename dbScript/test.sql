-- database: ../db/EXOBOT.sqlite
/*
 * test: Valoracion de Sentencias
 copyRight
    - Create: insert INSERT 
    - Read: SELECT
    - Update: UPDATE
    - Delete: DELETE
    * autor: darez
    * fecha: 2k25
*/
SELECT IdIABot, Version, Estado, FechaCreacion "
                 + "FROM IABot WHERE Estado = 'A' AND IdIABot = 1;
SELECT IdIABot
        ,Version
        ,Estado
        ,FechaCreacion
FROM IABot 
WHERE Estado = 'A'; 
SELECT IdIABot, Version, Estado, FechaCreacion, FechaModifica
FROM IABot WHERE Estado = 'A' AND IdIABot = 1;
SELECT IdIABot, Version, Estado, FechaCreacion,FechaModifica 
FROM IABot WHERE Estado = 'B' AND IdIABot =2;
UPDATE IABoT SET IdIABot = 2, Version = 'IA-ruso', Estado = 'B' WHERE IdIABot = 2;
SELECT * FROM IABot WHERE IdIABot = 2 AND Estado = 'A';
UPDATE IABot SET Estado = 'A' WHERE IdIABot = 2;
UPDATE PersonaTipo SET Estado = 'A' , FechaModifica = datetime('now') WHERE IdPersonaTipo = 5;
