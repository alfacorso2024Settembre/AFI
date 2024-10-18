package it.alfasoft.Azienda;

import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DAOreparto implements DAO<DTOreparto, String> {

    @Override
    public int insert(DTOreparto dtOreparto) throws SQLException {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = connection.prepareStatement("INSERT INTO reparti (nome) VALUES (?)");
            PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM dipendenti WHERE email = ?")){
            connection.setAutoCommit(false);
            try{
                ResultSet rs;
                DAOdipendente daoD = new DAOdipendente();
                ps.setString(1, dtOreparto.getNome());
                int result = ps.executeUpdate();
                int righe = ps.executeUpdate();
               for(DTOdipendente dipendenti : dtOreparto.getListaDipendenti()){
                   ps1.setString(1, dipendenti.getEmail());
                   rs = ps1.executeQuery();
                   if(!rs.next())
                   {
                       daoD.insert(dipendenti, connection);
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
    public int delete(String nome) {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = connection.prepareStatement("DELETE FROM reparti_progetti WHERE nome_reparto = ?");
            PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM dipendenti WHERE nome_reparto = ?");
            PreparedStatement ps2 = connection.prepareStatement("DELETE FROM reparti WHERE nome_reparto = ?")){
            connection.setAutoCommit(false);
            try{
                DAOdipendente daoD = new DAOdipendente();
                ps.setString(1, nome);
                ps1.setString(1, nome);
                ps2.setString(1, nome);
                ps.executeUpdate();
                ResultSet rs = ps1.executeQuery();
                while(rs.next())
                {
                    daoD.delete(new DTOdipendente(rs.getString(2), rs.getString(1), rs.getString(3), rs.getString(4)), connection);
                }
                int result = ps2.executeUpdate();
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
    public int update(DTOreparto reparto, String nome) {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = connection.prepareStatement("UPDATE reparti_progetti SET nome_reparto = ? WHERE nome_reparto = ?");
            PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM dipendenti WHERE nome_reparto = ?");
            PreparedStatement ps2 = connection.prepareStatement("UPDATE reparti SET nome_reparto = ? WHERE nome_reparto = ?")){
            connection.setAutoCommit(false);
            try{
                DAOdipendente daoD = new DAOdipendente();
                ps.setString(1, reparto.getNome());
                ps.setString(2, nome);
                ps1.setString(1, reparto.getNome());
                ps2.setString(1, reparto.getNome());
                ps2.setString(2, nome);
                ps.executeUpdate();
                ResultSet rs = ps1.executeQuery();
                while (rs.next())
                {
                    daoD.update(new DTOdipendente(rs.getString(2), rs.getString(1), rs.getString(3), nome), rs.getString(1),connection);
                }
                int result = ps2.executeUpdate();
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
    public List<DTOreparto> find(String nome) {
        List<DTOreparto> result = new ArrayList<>();
        try(Connection c = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement ps = c.prepareStatement("SELECT * FROM reparti WHERE nome_reparto = ?"))
        {
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                result.add(new DTOreparto(rs.getString(1)));
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



}
