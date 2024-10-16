package it.alfasoft.studenti;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestione_studenti_Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String args[])
    {

        boolean check = true;
        int op ;

        while(check)
        {
            try
            {
                op = scegliOp();
                switch (op)
                {
                    case 0:
                        check = false;
                        break;
                    case 1:
                        studentiLoop();
                        break;
                    case 2:
                        insegnantiLoop();
                        break;
                    case 3:
                        //corsoLoop();
                        break;
                    case 4:
                        esamiLoop();
                        break;
                }
            }
            catch (NumberFormatException | SQLException e)
            {
                System.out.println("Input sbagliato");
            }


        }
    }

    public static int scegliOp() throws NumberFormatException
    {
        System.out.println("Scegli su che tabella vuoi lavorare");
        System.out.println("0:Exit");
        System.out.println("1:Studenti");
        System.out.println("2:Insegnanti");
        System.out.println("3:Corso");
        System.out.println("4:Esami");
        return Integer.parseInt(sc.nextLine());

    }

    public static int scegliOpStudenti() throws NumberFormatException
    {
        System.out.println("Scegli Operazione");
        System.out.println("0:Go back");
        System.out.println("1:Insert studente");
        System.out.println("2:Delete studente");
        System.out.println("3:Modifica studente");
        System.out.println("4:Ricerca tutti gli studenti");
        System.out.println("5:Ricerca studenti con id");
        System.out.println("6:Ricerca studenti con email");
        System.out.println("7:Ricerca studenti per campi");
        return Integer.parseInt(sc.nextLine());

    }

    public static int scegliOpInsegnanti() throws NumberFormatException
    {
        System.out.println("Scegli Operazione");
        System.out.println("0:Go back");
        System.out.println("1:Insert insegnante");
        System.out.println("2:Delete insegnante");
        System.out.println("3:Modifica insegnante");
        System.out.println("4:Ricerca tutti gli insegnanti");
        System.out.println("5:Ricerca insegnanti con id");
        System.out.println("6:Ricerca insegnanti con email");
        return Integer.parseInt(sc.nextLine());

    }

    public static int scegliOpEsami() throws NumberFormatException
    {
        System.out.println("Scegli Operazione");
        System.out.println("0:Go back");
        System.out.println("1:Insert esame");
        System.out.println("2:Delete esame");
        System.out.println("3:Modifica esame");
        System.out.println("4:Ricerca tutti gli esami");
        System.out.println("5:Ricerca esami con id");
        System.out.println("6:Ricerca esami con data, ora o ID corso");
        return Integer.parseInt(sc.nextLine());

    }

    public static void studentiLoop() throws SQLException, NumberFormatException {
        DaoStudente ds = new DaoStudente();
        List<DtoStudente> lds = new ArrayList<>();
        Long id = 0L;
        boolean check = true;
        while(check) {
            int op = scegliOpStudenti();
            switch (op)
            {
                case 0:
                    check = false;
                    break;
                case 1:
                    System.out.println("Inserire email dello studente da aggiungere");
                    ds.create(new DtoStudente());
                    break;
                case 2:

                    System.out.println("Inserire id dello studente da cancellare");
                    ds.delete(Long.parseLong(sc.nextLine()));
                    break;
                case 3:
                    System.out.println("Inserire id dello studente da modificare");
                    id = Long.parseLong(sc.nextLine());
                    System.out.println("Inserire nuova email");
                    ds.update(id, new DtoStudente());
                    break;

                case 4:
                    lds = ds.read();
                    for(DtoStudente st : lds)
                    {
                        System.out.println("Matricola: " + st.getMatricola() + " Email: " + st.getEmail());
                    }
                    break;
                case 5:

                    System.out.println("Inserire id dello studente da modificare");
                    id = Long.parseLong(sc.nextLine());
                    DtoStudente sd = ds.getById(id);
                    System.out.println("Matricola: " + sd.getMatricola() + " Email: " + sd.getEmail());
                    break;
                case 6:

                    System.out.println("Inserire email dello studente da cercare");

                    lds = ds.find(sc.nextLine());
                    for(DtoStudente st : lds)
                    {
                        System.out.println("Matricola: " + st.getMatricola() + " Email: " + st.getEmail());
                    }
                    break;
                case 7:

                    System.out.println("Inserire email dello studente da cercare");

                    lds = ds.find(new DtoStudente());
                    for(DtoStudente st : lds)
                    {
                        System.out.println("Matricola: " + st.getMatricola() + " Email: " + st.getEmail());
                    }
                    break;
            }
        }

    }


    public static void insegnantiLoop() throws SQLException, NumberFormatException {
        DaoInsegnante di = new DaoInsegnante();
        List<DtoInsegnante> ldi = new ArrayList<>();
        Integer id = 0;
        boolean check = true;
        while(check) {
            int op = scegliOpInsegnanti();
            switch (op)
            {
                case 0:
                    check = false;
                    break;
                case 1:
                    System.out.println("Inserire email dell'insegnante da aggiungere");
                    String email = sc.nextLine();
                    System.out.println("Inserire nome dell'insegnante da aggiungere");
                    String nome = sc.nextLine();
                    di.create(new DtoInsegnante(nome, email));
                    break;
                case 2:

                    System.out.println("Inserire id dell'insegnante da cancellare");
                    di.delete(Integer.parseInt(sc.nextLine()));
                    break;
                case 3:
                    System.out.println("Inserire id dell'insegnante da modificare");
                    id = Integer.parseInt(sc.nextLine());
                    System.out.println("Inserire nuovo nome");
                    nome = sc.nextLine();
                    System.out.println("Inserire nuova email");
                    email = sc.nextLine();
                    di.update(id, new DtoInsegnante(nome, email, id));
                    break;

                case 4:
                    ldi = di.read();
                    for(DtoInsegnante dti : ldi)
                    {
                        System.out.println("ID insegnante: " + dti.getId_insegnante() + " Nome: " + dti.getNome() + " Email: " + dti.getEmail());
                    }
                    break;

                case 5:
                    System.out.println("Inserire id dell'insegnante da modificare");
                    id = Integer.parseInt(sc.nextLine());
                    DtoInsegnante dti = di.getById(id);
                    System.out.println("ID insegnante: " + dti.getId_insegnante() + " Nome: " + dti.getNome() + " Email: " + dti.getEmail());
                    break;

                case 6:
                    System.out.println("Inserire email o nome dell'insegnante da cercare");

                    ldi = di.find(sc.nextLine());
                    for(DtoInsegnante insegnante : ldi)
                    {
                        System.out.println("ID insegnante: " + insegnante.getId_insegnante() + " Nome: " + insegnante.getNome() + " Email: " + insegnante.getEmail());
                    }
                    break;

            }
        }

    }


    public static void esamiLoop() throws SQLException, NumberFormatException {
        DaoEsame de = new DaoEsame();
        List<DtoEsame> lde = new ArrayList<>();
        Integer id = 0;
        boolean check = true;
        while(check) {
            int op = scegliOpEsami();
            switch (op)
            {
                case 0:
                    check = false;
                    break;
                case 1:
                    System.out.println("Inserire ID corso, durata, data e ora dell'esame da aggiungere");
                    System.out.println("Inserire id_corso dell'esame da aggiungere");
                    int id_corso = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Inserire data(YYYY-MM-DD)dell'esame da aggiungere");
                    String data = sc.nextLine();
                    System.out.println("Inserire ora(HH:mm:ss)dell'esame da aggiungere");
                    String ora = sc.nextLine();
                    System.out.println("Inserire durata dell'esame da aggiungere");
                    int durata = sc.nextInt();
                    sc.nextLine();
                    de.create(new DtoEsame(id_corso, durata, data, ora));
                    break;

                case 2:
                    System.out.println("Inserire id dell'esame da cancellare");
                    de.delete(Integer.parseInt(sc.nextLine()));
                    break;

                case 3:
                    System.out.println("Inserire id dell'esame da modificare");
                    id = Integer.parseInt(sc.nextLine());
                    System.out.println("Inserire nuova durata");
                    durata = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Inserire nuova data");
                    data = sc.nextLine();
                    System.out.println("Inserire nuova ora");
                    ora = sc.nextLine();
                    de.update(id, new DtoEsame(id, 0, durata, data, ora));
                    break;

                case 4:
                    lde = de.read();
                    for(DtoEsame dte : lde)
                    {
                        System.out.println("ID esame: " + dte.getId_esame() + "ID corso: " + dte.getId_corso() + "Durata: " + dte.getDurata() + "Data: " + dte.getData() + "Ora: " + dte.getOra());
                    }
                    break;

                case 5:
                    System.out.println("Inserire id dell'esame da ricercare");
                    id = Integer.parseInt(sc.nextLine());
                    DtoEsame dte = de.getById(id);
                    System.out.println("ID esame: " + dte.getId_esame() + "ID corso: " + dte.getId_corso() + "Durata: " + dte.getDurata() + "Data: " + dte.getData() + "Ora: " + dte.getOra());
                    break;

                case 6:
                    System.out.println("Inserire email o nome dell'insegnante da cercare");

                    lde = de.find(sc.nextLine());
                    for(DtoEsame esame : lde)
                    {
                        System.out.println("ID esame: " + esame.getId_esame() + "ID corso: " + esame.getId_corso() + "Durata: " + esame.getDurata() + "Data: " + esame.getData() + "Ora: " + esame.getOra());
                    }
                    break;

            }
        }

    }



}
