package it.alfasoft.Azienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class DAOdipendente implements DAO<DTOdipendente, String> {


    @Override
    public int insert(DTOdipendente dipendente) throws SQLException {
        int righe = 0;
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = connection.prepareStatement("INSERT INTO DIPENDENTI (nome_dipendente, email, ruolo, nome_reparto) VALUES (?,?,?,?)")){
            ps.setString(1, dipendente.getNome());
            ps.setString(2, dipendente.getEmail());
            ps.setString(3, dipendente.getRuolo());
            ps.setString(4, dipendente.getNomeReparto());

            righe = ps.executeUpdate();
            return righe;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return righe;
    }

    public int insert(DTOdipendente dipendente, Connection connection) throws SQLException {
        int righe = 0;
        try(PreparedStatement ps = connection.prepareStatement("INSERT INTO DIPENDENTI (nome_dipendenti, email, ruolo, nome_reparto) VALUES (?,?,?,?)")){
            ps.setString(1, dipendente.getNome());
            ps.setString(2, dipendente.getEmail());
            ps.setString(3, dipendente.getRuolo());
            ps.setString(4, dipendente.getNomeReparto());

            righe = ps.executeUpdate();
            return righe;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return righe;
    }

    @Override
    public int delete(DTOdipendente dtOdipendente) {
        return 0;
    }

    public int delete(DTOdipendente dtOdipendente, Connection connection) {
        return 0;
    }

    @Override
    public int update(DTOdipendente dtOdipendente, String email) {
        return 0;
    }

    public int update(DTOdipendente dtOdipendente, String email, Connection connection) {
        return 0;
    }




    @Override
    public List<DTOdipendente> find(DTOdipendente dtOdipendente) {
        try{


        }PreparedStatement ps =
        return Collections.emptyList();
    }
}
