package it.alfasoft.social;

import java.util.List;

public interface Dao<T,I> {

    String URL = "jdbc:mysql://localhost:3306/social_media";
    String USER = "root";
    String PASSWORD = "CORSO";

    int insert(T t);
    int delete(I i);
    int update(T t,I i);
    List<T> cerca(I i );
    T cercaUno(I i);
}
