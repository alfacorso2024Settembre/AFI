package it.alfasoft.corso.negozio;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GestioneProdotto extends Gestione<Prodotto> {

    GestioneProdotto(){
        super();
    }

    public int insert(Prodotto p) throws SQLException {
        return stmt.executeUpdate(
                "INSERT INTO negozio.prodotti(nome, prezzo) " +
                        "VALUES('"  + p.getNome()+"'" + "," + p.getPrezzo() + ")"
        );
    }

    public int update(int id, Prodotto p)throws SQLException {

        return stmt.executeUpdate(
                "UPDATE negozio.prodotti " +
                        "SET nome  = " + "\"" + p.getNome() + "\"" + ", prezzo = " + p.getPrezzo() +
                        " WHERE id_Prodotto = " + id
        );
    }

    public int delete(int id) throws SQLException {


        stmt.executeUpdate("DELETE FROM negozio.fornitori_prodotti WHERE id_Prodotto = " + id);
        stmt.executeUpdate("DELETE FROM negozio.prodotti_clienti WHERE id_Prodotto = " + id);



        return stmt.executeUpdate(
                "DELETE FROM negozio.prodotti " +
                        "WHERE id_Prodotto = " + id
        );
    }

    public ResultSet selectById(int id) throws SQLException {
        return stmt.executeQuery(
                "SELECT id_prodotto FROM negozio.prodotti WHERE id_prodotto = " + id);
    }

}
