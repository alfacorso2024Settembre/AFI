package it.alfasoft.studenti;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoEsame extends DaoOperations<DtoEsame, Integer>{

    DaoEsame(){
        super();
    }

    public Integer create (DtoEsame e) throws SQLException {

        PreparedStatement ps =  c.prepareStatement("Insert into GestioneStudenti.esami(id_corso, durata, data, ora_inizio) "
                +"VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS
        );
        ps.setInt(1, e.getId_corso());
        ps.setInt(2, e.getDurata());
        ps.setString(3, e.getData());
        ps.setString(4, e.getOra());
        ps.executeUpdate();
        ResultSet rs =  ps.getGeneratedKeys();
        if(rs.next()){ return rs.getInt(1); }


        return Integer.valueOf(0);
    }

    public List<DtoEsame> read() throws SQLException{
        List<DtoEsame> esami = new ArrayList<>();
        PreparedStatement ps =  c.prepareStatement("SELECT * FROM GestioneStudenti.esami LIMIT 10", Statement.RETURN_GENERATED_KEYS
        );

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            esami.add(new DtoEsame(rs.getInt("id_esame"), rs.getInt("id_corso"), rs.getInt("durata"), rs.getString("data"), rs.getString("ora")));
        }
        return  esami;
    }

    public int update(Integer id, DtoEsame e) throws SQLException{
        PreparedStatement ps = c.prepareStatement("UPDATE GestioneStudenti.esami " +
                "SET durata = ?, data = ?, ora_inizio = ?" + "WHERE id_esame = ? ");

        ps.setInt(1, e.getDurata());
        ps.setString(2, e.getData());
        ps.setString(3, e.getOra());
        ps.setInt(4, e.getId_esame());

        return ps.executeUpdate();


    }

    public int delete(Integer id) throws SQLException{
        PreparedStatement ps = c.prepareStatement("DELETE FROM GestioneStudenti.esami "
                + "WHERE id_esame = ? ");
        ps.setInt(1, id);
        return ps.executeUpdate();

    }
    public DtoEsame getById(Integer id) throws SQLException
    {
        PreparedStatement ps =  c.prepareStatement("SELECT * FROM GestioneStudenti.esami WHERE id_esame = ? LIMIT 10", Statement.RETURN_GENERATED_KEYS
        );
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return  new DtoEsame(rs.getInt("id_esame"), rs.getInt("id_corso"), rs.getInt("durata"), rs.getString("data"), rs.getString("ora"));
    }

    public List<DtoEsame> find(String searchText) throws SQLException
    {
        return null;
    }


    public List<DtoEsame> find(DtoEsame searchText) throws SQLException
    {
        List<DtoEsame> result = new ArrayList<>();
        PreparedStatement ps =  c.prepareStatement("SELECT * FROM GestioneStudenti.esami WHERE (data = ? AND ora = ?) OR id_corso = ? LIMIT 10", Statement.RETURN_GENERATED_KEYS
        );


        ps.setString(1, searchText.getData());
        ps.setString(2, searchText.getOra());
        ps.setInt(3, searchText.getId_corso());
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            result.add(new DtoEsame(rs.getInt("id_esame"), rs.getInt("id_corso"), rs.getInt("durata"), rs.getString("data"), rs.getString("ora")));
        }
        return result;
    }



}
