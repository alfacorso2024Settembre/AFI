package it.alfasoft.studenti;

import java.sql.SQLException;

public class DaoException extends SQLException {

    DaoException(){
        super("Error su dao gestione studenti");
    }
}
