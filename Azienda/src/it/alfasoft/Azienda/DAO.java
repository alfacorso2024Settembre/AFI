package it.alfasoft.Azienda;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T, I>{
    String URL = "jdbc:mysql://localhost:3306/gestioneazienda";
    String USER = "root";
    String PASSWORD = "utente";

    int insert(T t) throws SQLException;
    int delete(I i);
    int update(T t, I i);
    T find(I i);
    List<T> findAll();
}
