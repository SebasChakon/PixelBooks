/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import config.Conexion;

/**
 *
 * @author sebas
 */
public class UsuarioDAO {
    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public Usuario validar(String Nick_Name, String Pass_User) {
        Usuario us = new Usuario();
        String sql = "SELECT * FROM usuario WHERE Nick_Name=? AND Pass_User=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, Nick_Name);
            ps.setString(2, Pass_User);
            rs = ps.executeQuery();
            while (rs.next()) {
                us.setCod_User(rs.getLong("Cod_User"));
                us.setName_User(rs.getString("Name_User"));
                us.setApellido_User(rs.getString("Apellido_User"));
                us.setNick_Name(rs.getString("Nick_Name"));
                us.setPass_User(rs.getString("Pass_User"));
                us.setId_Rol(rs.getInt("Id_Rol"));
                us.setFoto_User(rs.getString("Foto_User"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return us;
    }
    
    public int registrar(long Cod_User, String Name_User, String Apellido_User, String Nick_Name, String Pass_User, int Id_Rol){
        int res = 0;
        String sql = " insert into usuario(Cod_User,Name_User,Apellido_User,Nick_Name,Pass_User,Id_Rol)values(?,?,?,?,?,?) ";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setLong(1, Cod_User);
            ps.setString(2, Name_User);
            ps.setString(3, Apellido_User);
            ps.setString(4, Nick_Name);
            ps.setString(5, Pass_User);
            ps.setInt(6, 2);
            res=ps.executeUpdate();
            System.out.println("Usuario registrado correctamente");
        } catch (Exception e) {
            System.out.println("Error al registrar");
        }
        return res;
    }
    
    public int actualizarUsuario(Usuario usuario) {
        int res = 0;
        String sql = "UPDATE usuario SET Name_User=?, Apellido_User=?, Nick_Name=?, Pass_User=?, Foto_User=? WHERE Cod_User=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getName_User());
            ps.setString(2, usuario.getApellido_User());
            ps.setString(3, usuario.getNick_Name());
            ps.setString(4, usuario.getPass_User());
            ps.setString(5, usuario.getFoto_User());
            ps.setLong(6, usuario.getCod_User());
            res = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    
    public Usuario obtenerUsuario(long Cod_User) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE Cod_User=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setLong(1, Cod_User);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setCod_User(rs.getLong("Cod_User"));
                usuario.setName_User(rs.getString("Name_User"));
                usuario.setApellido_User(rs.getString("Apellido_User"));
                usuario.setNick_Name(rs.getString("Nick_Name"));
                usuario.setPass_User(rs.getString("Pass_User"));
                usuario.setId_Rol(rs.getInt("Id_Rol"));
                usuario.setFoto_User(rs.getString("Foto_User"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
