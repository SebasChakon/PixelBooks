/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sebas
 */
public class Conexion {
    
    private Connection con;
    private String url = "jdbc:mysql://localhost:3307/PixelBooks?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String user = "root";
    private String pass = "sebas";
    private String driver = "com.mysql.cj.jdbc.Driver";
    
    
    public Connection Conexion(){
        try{
            Class.forName(driver);
            System.out.println("Driver cargado con exito");
            try{
                con=DriverManager.getConnection(url,user,pass);
                if(con!=null){
                    System.out.println("Conexion realizada correctamente");
                }
            }catch(Exception e){
                System.out.println("Ha ocurrido un error al intentar conectar con la base de datos, "+e.getMessage());
            }
        } catch (Exception e){
            System.out.println("Ha ocurrido un error al cargar el driver, "+e.getMessage());
        }
        return con;
    }
}