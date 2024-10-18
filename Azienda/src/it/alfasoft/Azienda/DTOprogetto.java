package it.alfasoft.Azienda;
import java.sql.Date;

public class DTOprogetto {
    Date data_inizio;
    Date data_fine;
    String descrizione;

    public DTOprogetto(Date data_inizio, Date data_fine, String descrizione) {
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.descrizione = descrizione;
    }

    public Date getData_inizio() {
        return data_inizio;
    }

    public void setData_inizio(Date data_inizio) {
        this.data_inizio = data_inizio;
    }

    public Date getData_fine() {
        return data_fine;
    }

    public void setData_fine(Date data_fine) {
        this.data_fine = data_fine;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
