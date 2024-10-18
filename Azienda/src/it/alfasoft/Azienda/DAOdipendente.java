package it.alfasoft.Azienda;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DAOdipendente implements DAO<DTOdipendente, String> {


    @Override
    public int insert(DTOdipendente dipendente) {
        int righe = 0;
        System.out.println(dipendente.getNomeReparto());
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = connection.prepareStatement("INSERT INTO DIPENDENTI (nome_dipendente, email, ruolo, nome_reparto) VALUES (?,?,?,?)");
             PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM dipendenti WHERE email = ?")) {
            ps1.setString(1, dipendente.getEmail());
            if (ps1.executeQuery().next()) {
                System.out.println("Esiste già un dipendente con questa mail");
                throw new SQLException();
            } else {
                DAOreparto daoR = new DAOreparto();

                if (daoR.find(dipendente.getNomeReparto()) == null) {
                    System.out.println("Questo reparto non esiste");
                    throw new SQLException();
                }
                ps.setString(1, dipendente.getNome());
                ps.setString(2, dipendente.getEmail());
                ps.setString(3, dipendente.getRuolo());
                ps.setString(4, dipendente.getNomeReparto());

                righe = ps.executeUpdate();
                return righe;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return righe;
    }

    public int insert(DTOdipendente dipendente, Connection connection) throws SQLException {
        int righe = 0;
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO DIPENDENTI (nome_dipendenti, email, ruolo, nome_reparto) VALUES (?,?,?,?)")) {
            ps.setString(1, dipendente.getNome());
            ps.setString(2, dipendente.getEmail());
            ps.setString(3, dipendente.getRuolo());
            ps.setString(4, dipendente.getNomeReparto());

            righe = ps.executeUpdate();
            return righe;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return righe;
    }

    @Override
    public int delete(String email) {
        int righe = 0;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement ps = connection.prepareStatement("DELETE FROM dipendenti WHERE email = ?")) {
            ps.setString(1, email);
            righe = ps.executeUpdate();
            return righe;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return righe;
    }

    public int delete(String email, Connection connection) {
        int righe = 0;
        try (PreparedStatement ps = connection.prepareStatement("DELETE FROM dipendenti WHERE email = ?")) {
            ps.setString(1, email);
            righe = ps.executeUpdate();
            return righe;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return righe;
    }

    @Override
    public int update(DTOdipendente dtOdipendente, String email) {
        int righe = 0;
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement ps = connection.prepareStatement("UPDATE dipendenti SET email = ?, nome_dipendente = ?, ruolo = ?, nome_reparto = ? WHERE email = ?")) {
            ps.setString(1, dtOdipendente.getEmail());
            ps.setString(2, dtOdipendente.getNome());
            ps.setString(3, dtOdipendente.getRuolo());
            ps.setString(4, dtOdipendente.getNomeReparto());
            ps.setString(5, email);
            righe = ps.executeUpdate();
            return righe;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return righe;
    }

    public int update(DTOdipendente dtOdipendente, String email, Connection connection) {
        int righe = 0;
        try (PreparedStatement ps = connection.prepareStatement("UPDATE dipendenti SET email = ?, nome_dipendente = ?, ruolo = ?, nome_reparto = ? WHERE email = ?")) {
            ps.setString(1, dtOdipendente.getEmail());
            ps.setString(2, dtOdipendente.getNome());
            ps.setString(3, dtOdipendente.getRuolo());
            ps.setString(4, dtOdipendente.getNomeReparto());
            ps.setString(5, email);
            righe = ps.executeUpdate();
            return righe;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return righe;
    }


    @Override
    public DTOdipendente find(String email) {
        DTOdipendente result = null;
        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement ps = c.prepareStatement("SELECT * FROM dipendenti WHERE email = ?")) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = new DTOdipendente(rs.getString(2), rs.getString(1), rs.getString(3), rs.getString(4));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    public List<DTOdipendente> findAll()
    {
        List<DTOdipendente> results = new ArrayList<>();
        try(Connection c = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement s = c.createStatement())
        {
            ResultSet rs = s.executeQuery("SELECT * FROM dipendenti");
            while (rs.next())
            {
                results.add(new DTOdipendente(rs.getString(2), rs.getString(1), rs.getString(3), rs.getString(4)));
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

    public List<DTOdipendente> findByReparto(String reparto) {
        List<DTOdipendente> result = new ArrayList<>();
        try (Connection c = DriverManager.getConnection(URL, USER, PASSWORD); PreparedStatement ps = c.prepareStatement("SELECT * FROM dipendenti WHERE nome_reparto = ?")) {
            ps.setString(1, reparto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new DTOdipendente(rs.getString(2), rs.getString(1), rs.getString(3), rs.getString(4)));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}

