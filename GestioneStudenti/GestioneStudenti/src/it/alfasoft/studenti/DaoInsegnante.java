package it.alfasoft.studenti;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoInsegnante extends DaoOperations<DtoInsegnante, Integer>{

    DaoInsegnante(){
        super();
    }

    public Integer create (DtoInsegnante i) throws SQLException {

        PreparedStatement ps =  c.prepareStatement("Insert into GestioneStudenti.insegnanti(nome, email) "
                +"VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS
        );
        ps.setString(1,i.getNome());
        ps.setString(2,i.getEmail());
        ps.executeUpdate();
        ResultSet rs =  ps.getGeneratedKeys();
        if(rs.next()){ return rs.getInt(1); }


    return Integer.valueOf(0);
    }

    public List<DtoInsegnante> read() throws SQLException{
        List<DtoInsegnante> insegnanti = new ArrayList<>();
        PreparedStatement ps =  c.prepareStatement("SELECT * FROM GestioneStudenti.insegnanti LIMIT 10", Statement.RETURN_GENERATED_KEYS
        );

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            insegnanti.add(new DtoInsegnante(rs.getString("nome"), rs.getString("email"), rs.getInt("id_insegnante")));
        }
        return  insegnanti;
    }

    public int update(Integer id, DtoInsegnante i) throws SQLException{
        PreparedStatement ps = c.prepareStatement("UPDATE GestioneStudenti.insegnanti " +
                "SET email = ?, nome = ? " + "WHERE id_insegnante = ? ");

        ps.setInt(3,id);
        ps.setString(2, i.getNome());
        ps.setString(1, i.getEmail());
        return ps.executeUpdate();


    }

    public int delete(Integer id) throws SQLException{
        PreparedStatement ps = c.prepareStatement("DELETE FROM GestioneStudenti.insegnanti "
                + "WHERE id_insegnante = ? ");
        ps.setInt(1, id);
        return ps.executeUpdate();

    }
    public DtoInsegnante getById(Integer id) throws SQLException
    {
        PreparedStatement ps =  c.prepareStatement("SELECT * FROM GestioneStudenti.insegnanti WHERE id_insegnante = ? LIMIT 10", Statement.RETURN_GENERATED_KEYS
        );
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return new DtoInsegnante(rs.getString("nome"), rs.getString("email"), rs.getInt("id_insegnante"));
    }
    public List<DtoInsegnante> find(String searchText) throws SQLException
    {
        List<DtoInsegnante> result = new ArrayList<>();
        PreparedStatement ps =  c.prepareStatement("SELECT * FROM GestioneStudenti.insegnanti WHERE email = ? OR nome = ? LIMIT 10", Statement.RETURN_GENERATED_KEYS
        );
        ps.setString(1, searchText);
        ps.setString(2, searchText);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            result.add(new DtoInsegnante(rs.getString("nome"), rs.getString("email"), rs.getInt("id_insegnante")));
        }
        return result;
    }


    public List<DtoInsegnante> find(DtoInsegnante searchText) throws SQLException
    {
        List<DtoInsegnante> result = new ArrayList<>();
        PreparedStatement ps =  c.prepareStatement("SELECT * FROM GestioneStudenti.insegnanti WHERE email = ? OR nome = ? LIMIT 10", Statement.RETURN_GENERATED_KEYS
        );
        ps.setString(1, searchText.getEmail());
        ps.setString(2, searchText.getNome());
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            result.add(new DtoInsegnante(rs.getString("nome"), rs.getString("email"), rs.getInt("id_insegnante")));
        }
        return result;
    }



}
