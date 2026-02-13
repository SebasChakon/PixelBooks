/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author sebas
 */
public class Libros {
    private int Id_Book;
    private String Tittle_Book;
    private String Name_Autor;
    private String Last_Name_Autor;
    private String Lan_Book;
    private String Edit_Book;
    private String Link_Book;

    public Libros(int Id_Book, String Tittle_Book, String Name_Autor, String Last_Name_Autor, String Lan_Book, String Edit_Book, String Link_Book) {
        this.Id_Book = Id_Book;
        this.Tittle_Book = Tittle_Book;
        this.Name_Autor = Name_Autor;
        this.Last_Name_Autor = Last_Name_Autor;
        this.Lan_Book = Lan_Book;
        this.Edit_Book = Edit_Book;
        this.Link_Book = Link_Book;
    }

    public int getId_Book() {
        return Id_Book;
    }

    public void setId_Book(int Id_Book) {
        this.Id_Book = Id_Book;
    }
    
    public String getTittle_Book() {
        return Tittle_Book;
    }

    public void setTittle_Book(String Tittle_Book) {
        this.Tittle_Book = Tittle_Book;
    }

    public String getName_Autor() {
        return Name_Autor;
    }

    public void setName_Autor(String Name_Autor) {
        this.Name_Autor = Name_Autor;
    }

    public String getLast_Name_Autor() {
        return Last_Name_Autor;
    }

    public void setLast_Name_Autor(String Last_Name_Autor) {
        this.Last_Name_Autor = Last_Name_Autor;
    }

    public String getLan_Book() {
        return Lan_Book;
    }

    public void setLan_Book(String Lan_Book) {
        this.Lan_Book = Lan_Book;
    }

    public String getEdit_Book() {
        return Edit_Book;
    }

    public void setEdit_Book(String Edit_Book) {
        this.Edit_Book = Edit_Book;
    }

    public String getLink_Book() {
        return Link_Book;
    }

    public void setLink_Book(String Link_Book) {
        this.Link_Book = Link_Book;
    }
}