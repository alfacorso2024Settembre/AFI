package it.alfasoft.Azienda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GestioneAzienda{
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        boolean check = true;
        DAOreparto daoR= new DAOreparto();
        DAOdipendente daoD= new DAOdipendente();
        Daoprogetto daoP = new Daoprogetto();



        while(check)
        {
            op = scegliOp();
            switch (op)
            {

                case -1:
                    System.out.println("Input sbagliato");
                    break;

                case 0:
                    check = false;
                    break;

                case 1:
                    System.out.println("Inserire dati del nuovo dipendente");
                    daoD.insert(new DTOdipendente());
                    break;

                case 2:
                    System.out.println("Inserire la mail del dipendente da licenziare");
                    String email = sc.nextLine();
                    daoD.delete(email);
                    break;

                case 3:
                    System.out.println("Inserire il nome del nuovo reparto");
                    daoR.insert(new DTOreparto());
                    break;

                case 4:
                    System.out.println("Inserire il nome del reparto da eliminare");
                    daoR.delete(sc.nextLine());
                    break;

                case 5:
                    System.out.println("Inserire i dati del nuovo progetto");
                    try {
                        daoP.insert(new DTOprogetto());
                    }
                    catch(ParseException e)
                    {
                        System.out.println("Inserire una data nel formato corretto");
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;

                case 6:
                    System.out.println("Inserire id del progetto da eliminare");
                    int id = sc.nextInt();
                    sc.nextLine();
                    daoP.delete(id);
                    break;

                case 7:
                    System.out.println("Inserire nome del dipartimento do cui si vuole cambiare il nome");
                    String nome = sc.nextLine();
                    System.out.println("Inserire nuovi dati");
                    daoR.update(new DTOreparto(), nome);
                    break;
                case 8:
                    System.out.println("Inserire id del progetto da modificare");
                    int idProgetto = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Inserire nuovi dati");
                    try {
                        daoP.update(new DTOprogetto(), idProgetto);
                    }
                    catch (ParseException e)
                    {
                        System.out.println(e);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                case 9:
                    System.out.println("Inserire l'email del dipendente da modificare");
                    String dipEmail = sc.nextLine();
                    daoD.update(new DTOdipendente(), dipEmail);
                    break;

                case 10:
                    stampa(daoP, daoR, daoD);
                    break;
                default:
                    System.out.println("Operazione non esiste");
                    break;
            }

        }
    }

    public static int scegliOp()
    {
        System.out.println("Scegli operazione");
        System.out.println("0: exit");
        System.out.println("1: Assumi dipendente");
        System.out.println("2: Licenzia dipendente");
        System.out.println("3: Crea reparto");
        System.out.println("4: Elimina reparto");
        System.out.println("5: Inizia progetto");
        System.out.println("6: Elimina progetto");
        System.out.println("7: Modifica reparto");
        System.out.println("8: Modifica progetto");
        System.out.println("9: Modifica dipendente");
        System.out.println("10: stampa");



        try
        {
            return Integer.parseInt(sc.nextLine());
        }
        catch(NumberFormatException e)
        {
            return -1;
        }
    }

    public static int scegliStampa()
    {
        System.out.println("Scegli operazione");
        System.out.println("1: Stampa i dipendenti dell'azienda");
        System.out.println("2: Stampa i reparti dell'azienda");
        System.out.println("3: Stampa i progetti dell'azienda");
        System.out.println("4: Stampa tutti i dipendenti che lavorano in un reparto");
        System.out.println("5: Stampa tutti i progetti che un reparto gestisce");
        System.out.println("6: Stampa tutti i reparti che gestiscono un progetto");
        try
        {
            return Integer.parseInt(sc.nextLine());
        }
        catch(NumberFormatException e)
        {
            return -1;
        }
    }

    public static void stampa(Daoprogetto daoP, DAOreparto daoR, DAOdipendente daoD)
    {
        int op;






        op = scegliStampa();
        switch (op)
        {

            case -1:
                System.out.println("Input sbagliato");
                break;

            case 1:
                for(DTOdipendente dipendente : daoD.findAll())
                {
                    System.out.println("Email: " + dipendente.getEmail());
                    System.out.println("Nome: " + dipendente.getNome());
                    System.out.println("Ruolo: " + dipendente.getRuolo());
                    System.out.println("Nome reparto: " + dipendente.getNomeReparto());
                    System.out.println("-----------------------------------------------------");
                }
                break;

            case 2:
                for(DTOreparto reparto : daoR.findAll())
                {
                    System.out.println("Nome reparto: " + reparto.getNome());
                    System.out.println("-----------------------------------------------------");
                }
                break;

            case 3:
                for(DTOprogetto progetto : daoP.findAll())
                {
                    System.out.println("ID: " + progetto.getId());
                    System.out.println("Data inizio: " + progetto.getData_inizio());
                    System.out.println("Data fine: " + progetto.getData_fine());
                    System.out.println("Descrizione: " + progetto.getDescrizione());
                    System.out.println("-----------------------------------------------------");
                }
                break;

            case 4:
                System.out.println("Inserire il nome del reparto");
                for(DTOdipendente dipendente : daoD.findByReparto(sc.nextLine()))
                {
                    System.out.println("Email: " + dipendente.getEmail());
                    System.out.println("Nome: " + dipendente.getNome());
                    System.out.println("Ruolo: " + dipendente.getRuolo());
                    System.out.println("Nome reparto: " + dipendente.getNomeReparto());
                    System.out.println("-----------------------------------------------------");
                }
                break;

            case 5:
                System.out.println("Inserire il nome del reparto");
                for(DTOprogetto progetto : daoP.findByReparto(sc.nextLine()))
                {
                    System.out.println("ID: " + progetto.getId());
                    System.out.println("Data inizio: " + progetto.getData_inizio());
                    System.out.println("Data fine: " + progetto.getData_fine());
                    System.out.println("Descrizione: " + progetto.getDescrizione());
                    System.out.println("-----------------------------------------------------");
                }
                break;

            case 6:
                System.out.println("Inserire l'id del progetto");
                int id = sc.nextInt();
                sc.nextLine();
                for(DTOreparto reparto : daoR.findByProgetto(id))
                {
                    System.out.println("Nome reparto: " + reparto.getNome());
                    System.out.println("-----------------------------------------------------");
                }
                break;
            default:
                System.out.println("Operazione non esiste");
                break;
        }


    }


}