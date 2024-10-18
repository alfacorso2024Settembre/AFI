package it.alfasoft.Azienda;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Daoprogetto implements  DAO<DTOprogetto, Integer>{
    @Override
    public int insert(DTOprogetto progetto){
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM reparti WHERE nome_reparto = ?");
            PreparedStatement ps1 = connection.prepareStatement("INSERT INTO progetti(data_inizio, data_fine, descrizione) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            PreparedStatement ps2 = connection.prepareStatement("INSERT INTO reparti_progetti(nome_reparto, id_progetto) VALUES(?, ?)")){
            connection.setAutoCommit(false);
            try{
                ResultSet rs;
                int result = -1;
                ps1.setDate(1,progetto.getData_inizio());
                ps1.setDate(2,progetto.getData_fine());
                ps1.setString(3,progetto.getDescrizione());
                ps1.executeUpdate();
                rs = ps1.getGeneratedKeys();
                rs.next();
                int id_progetto = rs.getInt(1);
               for(DTOreparto reparto : progetto.getReparti())
               {
                   ps.setString(1, reparto.getNome());


                   rs = ps.executeQuery();
                   if(!rs.next())
                   {
                       System.out.print("Il reparto " + reparto.getNome() + " non esiste");
                       throw new SQLException();
                   }
                   else
                   {
                       ps2.setString(1, reparto.getNome());
                       ps2.setInt(2, id_progetto);
                       result = ps2.executeUpdate();
                   }


               }


                connection.commit();
                return result;
            }catch(SQLException e){
                e.printStackTrace();
                connection.rollback();
                return -1;
            }



        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int delete(Integer id) {
        int righe = 0;
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = connection.prepareStatement("DELETE FROM reparti_progetti WHERE id_progetto = ?");
            PreparedStatement ps2 = connection.prepareStatement("DELETE FROM progetti WHERE id_progetto = ?")){
            try {
                connection.setAutoCommit(false);
                ps.setInt(1, id);
                ps2.setInt(1, id);
                ps.executeUpdate();
                righe = ps2.executeUpdate();
                connection.commit();
            }catch (SQLException e)
            {
                e.printStackTrace();
                connection.rollback();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            return righe;
        }

    }


    @Override
    public int update(DTOprogetto progetto, Integer id) {
        int righe = 0;
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement ps = connection.prepareStatement("UPDATE progetti SET data_inizio = ?, data_fine = ?, descrizione = ? WHERE id_progetto = ?")){
            ps.setDate(1, progetto.getData_inizio());
            ps.setDate(2, progetto.getData_fine());
            ps.setString(3, progetto.getDescrizione());
            ps.setInt(4, id);
            righe = ps.executeUpdate();
            return righe;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return righe;
    }


    @Override
    public DTOprogetto find(Integer id) {
        DTOprogetto result = null;
        try(Connection c = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement ps = c.prepareStatement("SELECT * FROM progetto WHERE id_progetto = ?"))
        {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                result = new DTOprogetto(rs.getDate(1), rs.getDate(2), rs.getString(3));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            return result;
        }
    }

    public List<DTOprogetto> findAll()
    {
        List<DTOprogetto> results = new ArrayList<>();
        try(Connection c = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement s = c.createStatement())
        {
            ResultSet rs = s.executeQuery("SELECT * FROM progetti");
            while (rs.next())
            {
                results.add(new DTOprogetto(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getString(4)));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            return results;
        }

    }
    public List<DTOprogetto> findByReparto(String reparto) {
        List<DTOprogetto> result = new ArrayList<>();
        ResultSet rs = null;
        ResultSet rs2 = null;
        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = c.prepareStatement("SELECT id_progetto FROM reparti_progetti WHERE nome_reparto = ?");
             PreparedStatement ps2 = c.prepareStatement("SELECT * FROM progetti WHERE id_progetto = ?")) {
            try {
                ps.setString(1, reparto);
                rs = ps.executeQuery();
                while (rs.next()) {
                    ps2.setInt(1,rs.getInt(1));
                    rs2 = ps2.executeQuery();
                    if(rs2.next())
                    {
                        result.add(new DTOprogetto(rs2.getInt(1), rs2.getDate(2), rs2.getDate(3), rs2.getString(4)));
                }   }

            }catch (SQLException e)
            {
                e.printStackTrace();
                c.rollback();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}
