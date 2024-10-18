package it.alfasoft.social;

import java.sql.Date;

public class DTOpost {
    int id ;
    String emailUtente;
    String text;
    Date data;
    int condivisioni;

    public DTOpost(int id, String emailUtente, String text, Date data, int condivisioni) {
        this.id = id;
        this.emailUtente = emailUtente;
        this.text = text;
        this.data = data;
        this.condivisioni = condivisioni;
    }

    public DTOpost(String emailUtente, String text, Date data, int condivisioni) {
        this.emailUtente = emailUtente;
        this.text = text;
        this.data = data;
        this.condivisioni = condivisioni;
    }

    public DTOpost(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "DTOpost{" +
                "id=" + id +
                ", emailUtente='" + emailUtente + '\'' +
                ", text='" + text + '\'' +
                ", data=" + data +
                ", condivisioni=" + condivisioni +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getEmailUtente() {
        return emailUtente;
    }

    public String getText() {
        return text;
    }

    public Date getData() {
        return data;
    }

    public int getCondivisioni() {
        return condivisioni;
    }
}
