-- database: ../db/EXOBOT.sqlite
/*
 * DDL: Lenguaje de Definición de Datos
 * CopyRightgit
 * autor: pat_mlc
 * fecha: 2k25
 */

DROP TABLE IF EXISTS ExaBot;
DROP TABLE IF EXISTS IABOT;
 DROP TABLE IF EXISTS Persona;
DROP TABLE IF EXISTS PersonaTipo;

CREATE TABLE IABOT (
    IdIABot         INTEGER PRIMARY KEY AUTOINCREMENT,
    Version         TEXT NOT NULL UNIQUE,
    Estado          VARCHAR(1) NOT NULL DEFAULT 'A',
    FechaCreacion   DATETIME NOT NULL DEFAULT (datetime('now', 'localtime')),
    FechaModifica   DATETIME NOT NULL DEFAULT (datetime('now', 'localtime'))

);

CREATE TABLE ExaBot (
    IdExaBot        INTEGER PRIMARY KEY AUTOINCREMENT,
    IdIABot         INTEGER NOT NULL,
    Serie           TEXT NOT NULL,
    Estado          VARCHAR(1) NOT NULL DEFAULT 'A',
    FechaCreacion   DATETIME NOT NULL DEFAULT (datetime('now', 'localtime')),
    FechaModifica   DATETIME NOT NULL DEFAULT (datetime('now', 'localtime'))

    ,CONSTRAINT fk_IABot FOREIGN KEY (IdIABot) REFERENCES IABOT(IdIABot)
);

CREATE TABLE PersonaTipo (
    IdPersonaTipo   INTEGER PRIMARY KEY AUTOINCREMENT,
    Tipo            VARCHAR(15) NOT NULL UNIQUE,
    Estado          VARCHAR(1) NOT NULL DEFAULT 'A',
    FechaCreacion   DATETIME NOT NULL DEFAULT (datetime('now', 'localtime')) ,
    FechaModifica   DATETIME NOT NULL DEFAULT (datetime('now', 'localtime')) 
);

CREATE TABLE Persona (
    IdPersona       INTEGER PRIMARY KEY AUTOINCREMENT,
    IdPersonaTipo   INTEGER NOT NULL,
    Cedula          TEXT NOT NULL UNIQUE,
    Nombre          TEXT NOT NULL,
    FechaCreacion   DATETIME DEFAULT (datetime('now', 'localtime')),
    FechaModifica   DATETIME NOT NULL DEFAULT (datetime('now', 'localtime')),
    FOREIGN KEY (IdPersonaTipo) REFERENCES PersonaTipo(IdPersonaTipo)
);


-- Consulta filtrada
SELECT IdPersonaTipo
    ,Tipo
    ,Estado
    ,FechaCreacion
FROM PersonaTipo
WHERE Estado = 'A' AND IdPersonaTipo = 2;


 