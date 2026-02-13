/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LibrosDAO {
    
    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private PreparedStatement ps2;
    private ResultSet rs;

    public List<Libros> listarLibros() {
        List<Libros> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM Libro JOIN Autor ON Libro.Id_Autor = Autor.Id_Autor";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Libros libro = new Libros(
                    rs.getInt("Id_Book"),
                    rs.getString("Tittle_Book"),
                    rs.getString("Name_Autor"),
                    rs.getString("Last_Name_Autor"),
                    rs.getString("Lan_Book"),
                    rs.getString("Edit_Book"),
                    rs.getString("Link_Book")
                );
                lista.add(libro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }


        public boolean agregarLibro(String titulo, String nombreAutor, String apellidoAutor, String idioma, String editorial, String link) {
        boolean isAdded = false;
        try {
            con = cn.Conexion();
            String buscarAutorSQL = "SELECT Id_Autor FROM Autor WHERE Name_Autor = ? AND Last_Name_Autor = ?";
            ps = con.prepareStatement(buscarAutorSQL);
            ps.setString(1, nombreAutor);
            ps.setString(2, apellidoAutor);
            rs = ps.executeQuery();

            //BUSCAR SI EXISTE EL AUTOR, SI NO, LO CREA EN TABLA AUTOR:), luego inserta todo en la tabla de los libros
            
            int idAutor = -1;
            if (rs.next()) {
                idAutor = rs.getInt("Id_Autor");
            } else {
                String insertarAutorSQL = "INSERT INTO Autor (Name_Autor, Last_Name_Autor) VALUES (?, ?)";
                ps = con.prepareStatement(insertarAutorSQL, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, nombreAutor);
                ps.setString(2, apellidoAutor);
                ps.executeUpdate();
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    idAutor = rs.getInt(1); 
                }
            }

            String insertarLibroSQL = "INSERT INTO Libro (Tittle_Book, Lan_Book, Edit_Book, Link_Book, Id_Autor) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(insertarLibroSQL);
            ps.setString(1, titulo);
            ps.setString(2, idioma);
            ps.setString(3, editorial);
            ps.setString(4, link);
            ps.setInt(5, idAutor);
            ps.executeUpdate();
            
            isAdded = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isAdded;
    }
        
    public boolean eliminarLibro(int idLibro) {
        String sql2 = "DELETE FROM Guardar WHERE Id_Book = ?";
        String sql = "DELETE FROM Libro WHERE Id_Book = ?";     
        boolean isDeleted = false;

        try {
            con = cn.Conexion();

            ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, idLibro);
            ps2.executeUpdate();

            ps = con.prepareStatement(sql);
            ps.setInt(1, idLibro);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                isDeleted = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps2 != null) ps2.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isDeleted;
    }
    
    public Libros obtenerLibroPorId(int idLibro) {
        Libros libro = null;
        String sql = "SELECT * FROM Libro JOIN Autor ON Libro.Id_Autor = Autor.Id_Autor WHERE Id_Book = ?";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idLibro);
            rs = ps.executeQuery();

            if (rs.next()) {
                libro = new Libros(
                    rs.getInt("Id_Book"),
                    rs.getString("Tittle_Book"),
                    rs.getString("Name_Autor"),
                    rs.getString("Last_Name_Autor"),
                    rs.getString("Lan_Book"),
                    rs.getString("Edit_Book"),
                    rs.getString("Link_Book")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return libro;
    }
    
    public boolean modificarLibro(Libros libro) {
        String sql = "UPDATE Libro SET Tittle_Book = ?, Lan_Book = ?, Edit_Book = ?, Link_Book = ? WHERE Id_Book = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, libro.getTittle_Book());
            ps.setString(2, libro.getLan_Book());
            ps.setString(3, libro.getEdit_Book());
            ps.setString(4, libro.getLink_Book());
            ps.setInt(5, libro.getId_Book());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
