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

public class MislibrosDAO {
    
    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public List<Mislibros> listarMisLibros(long codUser) {
        List<Mislibros> lista = new ArrayList<>();
        
        String sql = "SELECT Libro.Id_Book, Libro.Tittle_Book, Autor.Name_Autor, Autor.Last_Name_Autor, Libro.Lan_Book, Libro.Edit_Book, Libro.Link_Book " +
                     "FROM Guardar " +
                     "JOIN Libro ON Guardar.Id_Book = Libro.Id_Book " +
                     "JOIN Autor ON Libro.Id_Autor = Autor.Id_Autor " +
                     "WHERE Guardar.Cod_User = ?";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setLong(1, codUser);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mislibros libro = new Mislibros(
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


    public boolean eliminarLibroGuardado(long codUser, int idBook) {
        String sql = "DELETE FROM Guardar WHERE Cod_User = ? AND Id_Book = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setLong(1, codUser);
            ps.setInt(2, idBook);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
