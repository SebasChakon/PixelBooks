CREATE DATABASE PixelBooks;

USE PixelBooks;

CREATE TABLE Rol (
    Id_Rol INT PRIMARY KEY AUTO_INCREMENT,
    Name_Rol VARCHAR(100) NOT NULL
);

CREATE TABLE Usuario (
    Cod_User BIGINT PRIMARY KEY,  
    Name_User VARCHAR(100) NOT NULL,  
    Apellido_User VARCHAR(100) NOT NULL, 
    Nick_Name VARCHAR(100) NOT NULL,
    Pass_User VARCHAR(255) NOT NULL,
    Id_Rol INT, 
    FOREIGN KEY (Id_Rol) REFERENCES Rol(Id_Rol)
);

CREATE TABLE Autor (
    Id_Autor INT PRIMARY KEY AUTO_INCREMENT,
    Name_Autor VARCHAR(100) NOT NULL,
    Last_Name_Autor VARCHAR(100) NOT NULL
);

CREATE TABLE Libro (
    Id_Book INT PRIMARY KEY AUTO_INCREMENT,
    Tittle_Book VARCHAR(255) NOT NULL,
    Lan_Book VARCHAR(50),  
    Edit_Book VARCHAR(100),
    Link_Book TEXT(255),
    Id_Autor INT,
    FOREIGN KEY (Id_Autor) REFERENCES Autor(Id_Autor)
);

CREATE TABLE Guardar (
    ID_User_Book INT PRIMARY KEY AUTO_INCREMENT, 
    Cod_User BIGINT, 
    Id_Book INT,
    FOREIGN KEY (Cod_User) REFERENCES Usuario(Cod_User),
    FOREIGN KEY (Id_Book) REFERENCES Libro(Id_Book)
);
ALTER TABLE Guardar
ADD CONSTRAINT unique_user_book UNIQUE (Cod_User, Id_Book);


INSERT INTO Rol (Name_Rol)
VALUES ('Administrador'), ('Lector');

INSERT INTO Usuario (Cod_User, Name_User, Apellido_User, Nick_Name, Pass_User, Id_Rol)
VALUES (123, 'Juan', 'Pérez', 'Juan123', 'pass123', 1),
       (456, 'María', 'Gómez', 'Maria123', 'pass456', 2),
       (101359, 'Sebastian', 'Chacón', 'sebaschqmt', 'sebas', 1);

INSERT INTO Autor (Name_Autor, Last_Name_Autor)
VALUES ('Miguel', 'Cervantes'),
       ('George', 'Orwell');

INSERT INTO Libro (Tittle_Book, Lan_Book, Edit_Book, Link_Book, Id_Autor)
VALUES ('El Quijote', 'Español', 'Planeta', 'https://ejemplo.com/el-quijote', 1),
       ('1984', 'Inglés', 'Penguin Books', 'https://ejemplo.com/1984', 2);
       
ALTER TABLE Usuario ADD COLUMN Foto_User VARCHAR(255) DEFAULT 'img/user.jpg';