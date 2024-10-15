package it.alfasoft.corso.negozio;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GestioneFornitore_Prodotto extends Gestione<Fornitore_prodotto> {

    GestioneFornitore_Prodotto(){
        super();
    }

    public int insert(Fornitore_prodotto fp) throws SQLException {
        return stmt.executeUpdate(
                "INSERT INTO negozio.fornitori_prodotti(id_fornitore, id_prodotto, quantita_stock) " +
                        "VALUES("  + fp.getId_fornitore() + "," + fp.getId_prodotto() + "," + fp.getQuantita_stock() + ")"
        );
    }

    public int update(int id, Fornitore_prodotto fp)throws SQLException {

        return 0;
    }

    public int update(int id1, int id2, int stock)throws SQLException {
        return stmt.executeUpdate(
                "UPDATE negozio.fornitori_prodotti " +
                        "SET quantita_stock = " + stock +
                        " WHERE id_fornitore = " + id1 + " AND id_prodotto = " + id2
        );
    }

    public int delete(int id) throws SQLException {


        return 0;
    }

    public int delete(int id1, int id2) throws SQLException {


       return stmt.executeUpdate("DELETE FROM negozio.fornitori_prodotti WHERE id_fornitore = " + id1 + " AND id_prodotto = " + id2);

    }

}
