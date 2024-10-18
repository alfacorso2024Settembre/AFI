package it.alfasoft.social;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaoUtenti implements Dao<DTOutente,String>{

    @Override
    public int insert(DTOutente utente) {
        int righe = 0;
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = connection.prepareStatement("INSERT INTO utenti (user, email, password) VALUES (?,?,?)")){
            ps.setString(1, utente.getUser());
            ps.setString(2, utente.getEmail());
            ps.setString(3, utente.getPassword());

            righe = ps.executeUpdate();
            return righe;
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException("error : utente non inserito");
        }

    }

    @Override
    public int delete(String s) {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = connection.prepareStatement("DELETE FROM post WHERE emailUtente = ?");
            PreparedStatement ps1 = connection.prepareStatement("DELETE  FROM amicizie WHERE emailUtente1 = ? OR emailUtente2 = ?");
            PreparedStatement ps2 = connection.prepareStatement("DELETE FROM utenti WHERE email = ?")){
            connection.setAutoCommit(false);
            try{

                ps.setString(1, s);
                ps1.setString(1, s);
                ps1.setString(2, s);
                ps2.setString(1, s);
                ps.executeUpdate();

                int nPostEleminati= ps.executeUpdate();
                System.out.println("N Eleminati post:"+ nPostEleminati);

                int nAmicizieEleminati= ps1.executeUpdate();
                System.out.println("N Eleminati amicizie:"+ nAmicizieEleminati);

                int utenteEleminato= ps2.executeUpdate();
                System.out.println("N Eleminati post:"+ utenteEleminato);

                connection.commit();
                return utenteEleminato;
            }catch(SQLException e){
                e.printStackTrace();
                connection.rollback();
                return -1;
            }



        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException("Error : utente non eleminato");

        }
    }

    @Override
    public int update(DTOutente utente, String s) {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = connection.prepareStatement("UPDATE post SET emailUtente = ?  WHERE emailUtente = ?");
            PreparedStatement ps1 = connection.prepareStatement("UPDATE amicizie Set emailUtente1 = ? WHERE emailUtente1 = ?");
            PreparedStatement ps3 = connection.prepareStatement("UPDATE amicizie Set emailUtente2 = ? WHERE emailUtente2 = ?");
            PreparedStatement ps2 = connection.prepareStatement("UPDATE utenti Set user = ? ,email = ?,password = ? WHERE email = ?")){
            connection.setAutoCommit(false);
            try{

                ps.setString(1, utente.getEmail());
                ps.setString(2,s);
                ps1.setString(1, utente.getEmail());
                ps1.setString(2, s);

                ps2.setString(1, utente.getUser());
                ps2.setString(2, utente.getEmail());
                ps2.setString(3,utente.getPassword());
                ps2.setString(4,s);

                ps3.setString(1,utente.getEmail());
                ps3.setString(2,s);



                int nPostEleminati= ps.executeUpdate();
                System.out.println("N aggiornati post:"+ nPostEleminati);

                int nAmicizieEleminati= ps1.executeUpdate();
                System.out.println("N aggiornati amicizie:"+ nAmicizieEleminati);

                int utenteEleminato= ps2.executeUpdate();
                System.out.println("N agiornati post:"+ utenteEleminato);

                connection.commit();
                return utenteEleminato;
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
    public List<DTOutente> cerca(String s) {
        List<DTOutente> result = new ArrayList<>();
        try(Connection c = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement ps = c.prepareStatement("SELECT * FROM utenti WHERE user = ?"))
        {
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                result.add(new DTOutente(rs.getString(1), rs.getString(2),rs.getString(3)));

            }
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  result;
        }
    }

    @Override
    public DTOutente cercaUno(String s) {
        DTOutente result = new DTOutente();
        try(Connection c = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement ps = c.prepareStatement("SELECT * FROM utenti WHERE email = ?"))
        {
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                result = new DTOutente(rs.getString(1), rs.getString(2),rs.getString(3));

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

    public String creaAmicizia(DTOutente untenteCorrente , String emailAmico) throws Exception {

        int nrows = 0;
        try(Connection c = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement ps = c.prepareStatement("Insert into amicizie(emailUtente1,emailUtente2) VALUES(?,?)"))
        {
            ps.setString(1, untenteCorrente.getEmail());
            ps.setString(2,emailAmico);
             nrows= ps.executeUpdate();

            System.out.println("Amicizia creato " + nrows);

            return untenteCorrente.getEmail() + emailAmico;

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw new Exception("Non potete essere amici");

        }

    }

    public String rimuoveAmicizia(DTOutente untenteCorrente , String emailAmico) throws Exception {

        int nrows = 0;
        try(Connection c = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement ps = c.prepareStatement("DELETE FROM amicizie WHERE (emailUtente1 = ? and emailUtente2 = ?) OR (emailUtente1 = ? and emailUtente2 = ?)  "))
        {
            ps.setString(1, untenteCorrente.getEmail());
            ps.setString(2,emailAmico);
            ps.setString(3, emailAmico);
            ps.setString(4,untenteCorrente.getEmail());
            nrows= ps.executeUpdate();

            System.out.println("Amicizia cancellato " + nrows);

            return untenteCorrente.getEmail() + emailAmico;

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            throw new Exception("Dovete restare amici");

        }

    }

    public DTOutente login(String email, String password) throws Exception {
        DTOutente nuovoUtente = new DTOutente();
        try(Connection c = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement ps = c.prepareStatement("SELECT * FROM utenti WHERE email = ?"))
            {
                ps.setString(1, email);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    nuovoUtente = new DTOutente(rs.getString(1), rs.getString(2), rs.getString(3));
                    System.out.println(nuovoUtente.toString());
                }

                if(password.equals(nuovoUtente.getPassword())){
                    System.out.println(nuovoUtente.toString());
                    return nuovoUtente;
                }else{
                    return null;
                }
        }catch (SQLException e)
        {
            e.printStackTrace();
            throw new Exception("Il login non puo essere fatto");

        }
    }

}

