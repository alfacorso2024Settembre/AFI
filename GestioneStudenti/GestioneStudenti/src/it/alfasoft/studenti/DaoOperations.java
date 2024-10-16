package it.alfasoft.studenti;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract class DaoOperations<T,I> implements Dao<T,I>{

    final static String URL = "jdbc:mysql://localhost:3306/";
    final static String USER = "root";
    final static String PASSWORD = "utente";


    Connection c;




    DaoOperations(){
        this.setConnection();
    }


    public void setConnection(){
        try{
            this.c = DriverManager.getConnection(URL, USER, PASSWORD);

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    }







