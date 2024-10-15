package it.alfasoft.corso.negozio;

import java.sql.*;
import java.util.ArrayList;


public abstract class Gestione<T>{

    final static String URL = "jdbc:mysql://localhost:3306/";
    final static String USER = "root";
    final static String PASSWORD = "utente";


    Connection c;
    Statement stmt;

    Gestione(){
        this.setConnection();
    }


    public void setConnection(){
        try{
            this.c = DriverManager.getConnection(URL, USER, PASSWORD);
            this.stmt = c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void stampa(String tabella) throws Exception{

        ArrayList<Object> row = new ArrayList<>();
        ResultSet rs = this.stmt.executeQuery("SELECT * FROM " + "negozio."+tabella+ " LIMIT 10");

        while (rs.next()) {
            ResultSetMetaData rsmd = rs.getMetaData();
            for(int i = 1 ; i<= rsmd.getColumnCount();i++){
                row.add(rs.getObject(i));
            }
            System.out.println(row);
            row.clear();
        }
    }


    abstract public int insert(T elemento)throws Exception;
    abstract public int delete(int id)throws Exception;
    abstract public int update(int id,T t)throws Exception;





}
