package it.alfasoft.corso.negozio;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GestioneFornitore extends Gestione<Fornitore> {

    GestioneFornitore(){
        super();
    }

    public int insert(Fornitore f) throws SQLException {
        return stmt.executeUpdate(
                "INSERT INTO negozio.fornitori(nome) " +
                        "VALUES('"  + f.getNome() + "')"
        );
    }

    public int update(int id, Fornitore cl)throws SQLException {

        return stmt.executeUpdate(
                "UPDATE negozio.fornitori " +
                        "SET nome  = " + "\"" + cl.getNome() + "\"" +
                        "WHERE id_Fornitore = " + id
        );
    }

    public int delete(int id) throws SQLException {


        int r =  stmt.executeUpdate("DELETE FROM negozio.fornitori_prodotti WHERE id_fornitore = " + id);


        return stmt.executeUpdate(
                "DELETE FROM negozio.fornitori " +
                        "WHERE id_fornitore = " + id
        );
    }

    public ResultSet selectById(int id) throws SQLException {
        return stmt.executeQuery(
                "SELECT id_fornitore FROM negozio.fornitori WHERE id_fornitore = " + id);
    }

}
