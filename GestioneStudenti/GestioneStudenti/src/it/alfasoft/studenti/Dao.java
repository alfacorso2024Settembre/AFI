package it.alfasoft.studenti;

import java.sql.SQLException;
import java.util.List;


public interface Dao<T,I> {
    I create(T elemento) throws SQLException;
    List<T> read() throws SQLException;
    int update(I id, T elemento) throws SQLException;
    int delete(I id) throws SQLException;
    T getById(I indice) throws SQLException;
    List<T> find(String searchText) throws SQLException;
    List<T> find(T searchText) throws SQLException;
}