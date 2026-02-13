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

public class GuardarDAO {
    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;

    public boolean guardarLibro(long codUser, int idBook) {
        String sql = "INSERT INTO Guardar (Cod_User, Id_Book) VALUES (?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setLong(1, codUser);
            ps.setInt(2, idBook);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

