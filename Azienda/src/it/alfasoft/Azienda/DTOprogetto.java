package it.alfasoft.Azienda;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DTOprogetto {
    int id = 0;
    Date data_inizio;
    Date data_fine;
    String descrizione;
    List<DTOreparto> reparti = new ArrayList<>();

    public DTOprogetto(Date data_inizio, Date data_fine, String descrizione) {
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.descrizione = descrizione;
        this.reparti = null;
    }

    public DTOprogetto(int id,Date data_inizio, Date data_fine, String descrizione) {
        this.id = id;
        this.data_inizio = data_inizio;
        this.data_fine = data_fine;
        this.descrizione = descrizione;
    }

    public DTOprogetto() throws ParseException, Exception {
        System.out.println("Inserire anno di inizio del progetto");
        String anno = GestioneAzienda.sc.nextLine();
        System.out.println("Inserire mese di inizio del progetto");
        String mese = GestioneAzienda.sc.nextLine();
        System.out.println("Inserire giorno di inizio del progetto");
        String giorno = GestioneAzienda.sc.nextLine();
        SimpleDateFormat obj = new SimpleDateFormat("dd-MM-yyyy");
        this.data_inizio = new java.sql.Date(obj.parse(giorno + "-" + mese + "-" + anno).getTime());

        System.out.println("Inserire anno di fine del progetto");
        anno = GestioneAzienda.sc.nextLine();
        System.out.println("Inserire mese di fine del progetto");
        mese = GestioneAzienda.sc.nextLine();
        System.out.println("Inserire giorno di fine del progetto");
        giorno = GestioneAzienda.sc.nextLine();
        obj = new SimpleDateFormat("dd-MM-yyyy");
        this.data_fine = new java.sql.Date(obj.parse(giorno + "-" + mese + "-" + anno).getTime());
        if(this.data_inizio.compareTo(data_fine) > 0)
        {
            throw new Exception("Il progetto finisce prima di quando inizia");
        }
        System.out.println("Inserire descrizione del progetto");
        this.descrizione = GestioneAzienda.sc.nextLine();

        boolean check = true;
        boolean check2 = true;
        DTOreparto reparto = null;
        while(check)
        {
            System.out.println("Inserire il nome di un reparto che lavora a questo progetto");
            reparto = new DTOreparto(GestioneAzienda.sc.nextLine());
            for(DTOreparto rep : this.reparti)
            {
                if(rep.getNome() == reparto.getNome())
                {
                    check2 = false;
                    break;
                }
            }

            if(check2)
            {
                this.reparti.add(reparto);
            }
            else
            {
                System.out.println("Reparto già inserito");
                check2 = true;
            }

            System.out.println("Ci sono altri reparti che lavorano a questo progetto?");
            System.out.println("Premere 0 per terminare o qualsiasi altro pulsante per inserire altri reparti");
            if(GestioneAzienda.sc.nextLine().equals("0"))
            {
                check = false;
            }
        }
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

    public List<DTOreparto> getReparti() {
        return reparti;
    }

    public void setReparti(List<DTOreparto> reparti) {
        this.reparti = reparti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
