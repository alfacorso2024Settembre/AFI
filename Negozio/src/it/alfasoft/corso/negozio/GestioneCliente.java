package it.alfasoft.corso.negozio;

import java.sql.SQLException;

public class GestioneCliente extends Gestione<Cliente> {

    GestioneCliente(){
        super();
    }

    public int insert(Cliente c) throws SQLException {
        return stmt.executeUpdate(
                "INSERT INTO negozio.clienti( nome, email) " +
                        "VALUES('"  + c.getNome() + "', '" + c.getEmail()+ "')"
        );
    }

    public int update( int id,Cliente cl)throws SQLException {
        return stmt.executeUpdate(
                "UPDATE negozio.clienti " +
                        "SET nome  =" + "\"" + cl.getNome() + "\"" + ","+
                            "email = "  + "\"" + cl.getEmail() + "\"" +
                        "WHERE id_cliente = " + id
        );
    }

    public int delete(int id) throws SQLException {


        int r =  stmt.executeUpdate("DELETE FROM negozio.prodotti_clienti WHERE id_cliente = " + id);


        return stmt.executeUpdate(
                "DELETE FROM negozio.clienti " +
                        "WHERE id_cliente = " + id
        );
    }

}
