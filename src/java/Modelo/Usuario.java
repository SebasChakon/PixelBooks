/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author sebas
 */
public class Usuario {
    private long Cod_User;
    private String Name_User;
    private String Apellido_User;
    private String Nick_Name;
    private String Pass_User;
    private int Id_Rol;
    private String Foto_User;
    
    public Usuario(){
        
        
    }

    public Usuario(long Cod_User, String Name_User, String Apellido_User, String Nick_Name, String Pass_User, int Id_Rol, String Foto_User) {
        this.Cod_User = Cod_User;
        this.Name_User = Name_User;
        this.Apellido_User = Apellido_User;
        this.Nick_Name = Nick_Name;
        this.Pass_User = Pass_User;
        this.Id_Rol = Id_Rol;
        this.Foto_User = Foto_User;
    }

    public long getCod_User() {
        return Cod_User;
    }

    public void setCod_User(long Cod_User) {
        this.Cod_User = Cod_User;
    }

    public String getName_User() {
        return Name_User;
    }

    public void setName_User(String Name_User) {
        this.Name_User = Name_User;
    }

    public String getApellido_User() {
        return Apellido_User;
    }

    public void setApellido_User(String Apellido_User) {
        this.Apellido_User = Apellido_User;
    }

    public String getNick_Name() {
        return Nick_Name;
    }

    public void setNick_Name(String Nick_Name) {
        this.Nick_Name = Nick_Name;
    }

    public String getPass_User() {
        return Pass_User;
    }

    public void setPass_User(String Pass_User) {
        this.Pass_User = Pass_User;
    }

    public int getId_Rol() {
        return Id_Rol;
    }

    public void setId_Rol(int Id_Rol) {
        this.Id_Rol = Id_Rol;
    }

    public String getFoto_User() {
        return Foto_User;
    }

    public void setFoto_User(String Foto_User) {
        this.Foto_User = Foto_User;
    }
    
}
