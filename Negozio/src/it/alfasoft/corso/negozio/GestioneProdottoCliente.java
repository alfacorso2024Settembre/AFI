package it.alfasoft.corso.negozio;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GestioneProdottoCliente extends Gestione<Prodotto_cliente> {

    GestioneProdottoCliente(){
        super();
    }

    public int insert(Prodotto_cliente pc) throws SQLException {
        return stmt.executeUpdate(
                "INSERT INTO negozio.prodotti_clienti(id_cliente, id_prodotto, quantita) " +
                        "VALUES("  + pc.getId_cliente() + "," + pc.getId_prodotto() + "," + pc.getQuantita() + ")"
        );
    }

    public int update(int id, Prodotto_cliente pc)throws SQLException {

        return 0;
    }

    public int update(int id1, int id2, int quantita)throws SQLException {
        return stmt.executeUpdate(
                "UPDATE negozio.prodotti_clienti " +
                        "SET quantita = " +  quantita +
                        " WHERE id_cliente = " + id1 + " AND id_prodotto = " + id2
        );
    }

    public int delete(int id) throws SQLException {


        return 0;
    }

    public int delete(int id1, int id2) throws SQLException {


        return stmt.executeUpdate("DELETE FROM negozio.prodotti_clienti  WHERE id_cliente = " + id1 + " AND id_prodotto = " + id2);

    }

}