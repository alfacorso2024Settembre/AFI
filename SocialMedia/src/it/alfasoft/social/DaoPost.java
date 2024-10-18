package it.alfasoft.social;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.sql.Date;

public class DaoPost implements Dao<DTOpost,Integer>{
    @Override
    public int insert(DTOpost post) {
        int righe = 0;
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = connection.prepareStatement("INSERT INTO post (emailUtente, text,data, condivisioni) VALUES (?,?,?,?)")){
            ps.setString(1, post.getEmailUtente());
            ps.setString(2, post.getText());
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.setInt(4,post.getCondivisioni());

            righe = ps.executeUpdate();
            return righe;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return righe;
    }

    @Override
    public int delete(Integer id_post) {
        int nRow = -1;
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = connection.prepareStatement("DELETE FROM post WHERE id = ?");
            ){

            ps.setInt(1,id_post);
            nRow = ps.executeUpdate();

            return  nRow;



        }catch(SQLException e){
            e.printStackTrace();
            return nRow;
        }
    }

    @Override
    public int update(DTOpost post, Integer id_post) {
        int nRow = -1;
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = connection.prepareStatement("UPDATE post SET text = ? , data = ?  WHERE id = ?");
           )
           {


                ps.setString(1, post.getText());
                ps.setDate(2, Date.valueOf(LocalDate.now()));
                ps.setInt(3,id_post);

                nRow = ps.executeUpdate();


                return nRow ;



        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }


    }

    @Override
    public List<DTOpost> cerca(Integer integer) {
        return Collections.emptyList();
    }


    public List<DTOpost> cerca(String emailUtente) {
        List<DTOpost> result = new ArrayList<>();
        try(Connection c = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement ps = c.prepareStatement("SELECT * FROM post WHERE emailUtente = ? "))
        {
            ps.setString(1, emailUtente);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                result.add(new DTOpost(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getDate(4),rs.getInt(5)));

            }
            return result;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            return result;
        }
    }

    @Override
    public DTOpost cercaUno(Integer s) {
        return null;
    }


}
