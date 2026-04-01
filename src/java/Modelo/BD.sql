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

INSERT INTO Autor (Id_Autor, Name_Autor, Last_Name_Autor) VALUES
(1, 'Harper', 'Lee'),
(2, 'J.K.', 'Rowling'),
(3, 'Ernest', 'Hemingway'),
(4, 'George', 'Orwell'),
(5, 'F. Scott', 'Fitzgerald'),
(6, 'Jane', 'Austen'),
(7, 'Leo', 'Tolstoy'),
(8, 'Charles', 'Dickens'),
(9, 'Herman', 'Melville'),
(10, 'Mark', 'Twain');

INSERT INTO Libro (Id_Book, Tittle_Book, Lan_Book, Edit_Book, Link_Book, Id_Autor) VALUES
(1, 'Pride and Prejudice', 'English', 'Thomas Egerton', 'https://pruebat.org/biblioteca/descargar/pdf/Pride-and-Prejudice.pdf', 6),
(2, '1984', 'English', 'Secker & Warburg', 'https://www.philosophia.cl/biblioteca/orwell/1984.pdf', 4),
(3, 'Moby-Dick', 'English', 'Harper & Brothers', 'https://www.suneo.mx/literatura/subidas/Herman%20Melville%20%20%20Moby%20Dick.pdf', 9),
(4, 'To Kill a Mockingbird', 'English', 'J.B. Lippincott & Co.', 'https://www.raio.org/TKMFullText.pdf', 1),
(5, 'Great Expectations', 'English', 'Chapman & Hall', 'https://www.argentina.gob.ar/sites/default/files/great_expectations_dickens.pdf', 8),
(6, 'War and Peace', 'English', 'The Russian Messenger', 'https://antilogicalism.com/wp-content/uploads/2017/07/war-and-peace.pdf', 7),
(7, 'The Great Gatsby', 'English', 'Charles Scribner''s Sons', 'https://www.planetebook.com/free-ebooks/the-great-gatsby.pdf', 5),
(8, 'A Tale of Two Cities', 'English', 'Chapman & Hall', 'https://www.gutenberg.org/files/98/old/2city12p.pdf', 8),
(9, 'Harry Potter and the Philosopher''s Stone', 'English', 'Bloomsbury', 'https://docenti.unimc.it/antonella.pascali/teaching/2018/19055/files/ultima-lezione/harry-potter-and-the-philosophers-stone', 2),
(10, 'The Old Man and the Sea', 'English', 'Charles Scribner''s Sons', 'https://www.arvindguptatoys.com/arvindgupta/oldmansea.pdf', 3);

INSERT INTO Usuario (Cod_User, Name_User, Apellido_User, Nick_Name, Pass_User, Id_Rol, Foto_User) VALUES
(123, 'John', 'Doe', 'John123', 'password123', 1, 'img/user.jpg'),
(456, 'Jane', 'Smith', 'Jane456', 'password456', 2, 'img/user.jpg'),
(789, 'Alice', 'Brown', 'Alice789', 'password789', 2, 'img/user.jpg'),
(1010, 'Bob', 'Johnson', 'Bob1010', 'password1010', 1, 'img/user.jpg'),
(1111, 'Charlie', 'Williams', 'Charlie1111', 'password1111', 2, 'img/user.jpg'),
(1212, 'David', 'Jones', 'David1212', 'password1212', 1, 'img/user.jpg'),
(1313, 'Emma', 'Taylor', 'Emma1313', 'password1313', 2, 'img/user.jpg'),
(1414, 'Olivia', 'Anderson', 'Olivia1414', 'password1414', 1, 'img/user.jpg'),
(1515, 'Sophia', 'Thomas', 'Sophia1515', 'password1515', 2, 'img/user.jpg'),
(1616, 'Liam', 'Jackson', 'Liam1616', 'password1616', 1, 'img/user.jpg');
       
ALTER TABLE Usuario ADD COLUMN Foto_User VARCHAR(255) DEFAULT 'img/user.jpg';