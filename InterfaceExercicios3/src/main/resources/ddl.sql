CREATE DATABASE IF NOT EXISTS adrianabd;
USE adrianabd;

CREATE TABLE IF NOT EXISTS ciclista (
    id_ciclista INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    idade INT,
    usa_capacete BOOLEAN
);

CREATE TABLE IF NOT EXISTS bicicleta (
    id_bicicleta INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(100),
    marcha_atual INT,
    velocidade DOUBLE
);

CREATE TABLE IF NOT EXISTS trilha (
    id_trilha INT AUTO_INCREMENT PRIMARY KEY,
    tipo_terreno VARCHAR(100),
    distancia_km DOUBLE,
    dificuldade VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS escultura (
    id_escultura INT AUTO_INCREMENT PRIMARY KEY,
    estilo VARCHAR(100),
    altura_cm DOUBLE,
    peso_kg DOUBLE
);

CREATE TABLE IF NOT EXISTS mascara (
    id_mascara INT AUTO_INCREMENT PRIMARY KEY,
    material VARCHAR(100),
    origem_cultural VARCHAR(100),
    esta_exposta BOOLEAN
);

CREATE TABLE IF NOT EXISTS painel (
    id_painel INT AUTO_INCREMENT PRIMARY KEY,
    quantidade_itens INT,
    textura_fundo VARCHAR(100),
    fixado_na_parede BOOLEAN
);