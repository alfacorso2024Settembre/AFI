package it.alfasoft.studenti;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoStudente extends DaoOperations<DtoStudente,Long>{

    DaoStudente(){
        super();
    }

    public Long create (DtoStudente s) throws SQLException {

            PreparedStatement ps =  c.prepareStatement("Insert into GestioneStudenti.studenti(email) "
            +"VALUES(?)", Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1,s.getEmail());
            ps.executeUpdate();
            ResultSet rs =  ps.getGeneratedKeys();
            if(rs.next()){ return rs.getLong(1); }


    return Long.valueOf(0);
    }

    public List<DtoStudente> read() throws SQLException{
        List<DtoStudente> studenti = new ArrayList<>();
        PreparedStatement ps =  c.prepareStatement("SELECT * FROM GestioneStudenti.studenti LIMIT 10", Statement.RETURN_GENERATED_KEYS
        );

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            studenti.add(new DtoStudente(rs.getString("email"), rs.getLong("matricola")));
        }
        return  studenti;
    }

    public int update(Long id, DtoStudente s) throws SQLException{
        PreparedStatement ps = c.prepareStatement("UPDATE GestioneStudenti.studenti " +
                "SET email = ?" + "WHERE matricola = ? ");

        ps.setLong(2,id);
        ps.setString(1,s.getEmail());
        return ps.executeUpdate();


    }

    public int delete(Long id) throws SQLException{
        PreparedStatement ps = c.prepareStatement("DELETE FROM GestioneStudenti.studenti "
                + "WHERE matricola = ? ");
        ps.setLong(1,id);
        return ps.executeUpdate();

    }
    public DtoStudente getById(Long id) throws SQLException
    {
        PreparedStatement ps =  c.prepareStatement("SELECT * FROM GestioneStudenti.studenti WHERE matricola = ? LIMIT 10", Statement.RETURN_GENERATED_KEYS
        );
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return  new DtoStudente(rs.getString("email"), rs.getLong("matricola"));
    }
    public List<DtoStudente> find(String searchText) throws SQLException
    {
        List<DtoStudente> result = new ArrayList<>();
        PreparedStatement ps =  c.prepareStatement("SELECT * FROM GestioneStudenti.studenti WHERE email = ? LIMIT 10", Statement.RETURN_GENERATED_KEYS
        );
        ps.setString(1, searchText);
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            result.add(new DtoStudente(rs.getString("email"), rs.getLong("matricola")));
        }    
        return result;
    }
    
    
    public List<DtoStudente> find(DtoStudente searchText) throws SQLException
    {
        List<DtoStudente> result = new ArrayList<>();
        PreparedStatement ps =  c.prepareStatement("SELECT * FROM GestioneStudenti.studenti WHERE email = ? LIMIT 10", Statement.RETURN_GENERATED_KEYS
        );
        ps.setString(1, searchText.getEmail());
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            result.add(new DtoStudente(rs.getString("email"), rs.getLong("matricola")));
        }
        return result;
    }



}
