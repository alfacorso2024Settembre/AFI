package it.alfasoft.social;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSocial {
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        DaoUtenti dUtente = new DaoUtenti();
        DaoPost dPost = new DaoPost();
        UIsocial loop = new UIsocial();
        int input;
        int input2;

        System.out.println("Per iniziare devi fare il login:\nInserisci email:");
        String email = myScanner.nextLine();
        System.out.println("Inserisci password:");
        String password = myScanner.nextLine();
        DTOutente utente = dUtente.login(email, password);
        if(utente == null){
            System.out.println("hai sbagliato email o password");
            return;
        }

        do{
            input = loop.loopUtente(utente);
            switch(input){
                case 1:

                    System.out.println("Inserisci un username:");
                    String username = myScanner.nextLine();
                    System.out.println("Inserisci una email:");
                    String nuovaEmail = myScanner.nextLine();
                    System.out.println("Inserisci una password:");
                    String nuovaPassword = myScanner.nextLine();
                    DTOutente nuovoUtente = new DTOutente(username, nuovaEmail, nuovaPassword);
                    dUtente.insert(nuovoUtente);
                    break;

                case 2:
                    System.out.println("Inserisci la mail dell'utente da modificare");
                    email = myScanner.nextLine();
                    System.out.println("Inserisci la nuova username modificata");
                    String username1 = myScanner.nextLine();
                    System.out.println("Inserisci la nuova email modificata");
                    String email1 = myScanner.nextLine();
                    System.out.println("Inserisci la nuova password modificata");
                    String password1 = myScanner.nextLine();
                    nuovoUtente = new DTOutente(username1,email1,password1);
                    int righeModificate = dUtente.update(nuovoUtente, email);
                    break;

                case 3:
                    System.out.println("Inserisci l'username dell'utente da ricercare");
                    username = myScanner.nextLine();
                    List<DTOutente> listaRicercata = new ArrayList<>();
                    listaRicercata = dUtente.cerca(username);
                    listaRicercata.stream().forEach(u -> System.out.println(u.toString()));
                    break;

                case 4:
                    System.out.println("Digita l'email dell'utente da ricercare");
                    email = myScanner.nextLine();
                    nuovoUtente = dUtente.cercaUno(email);
                    System.out.println(nuovoUtente.toString());
                    break;

                case 5:
                    System.out.println("Inserisci la email dell'utente da eliminare:");
                    email = myScanner.nextLine();
                    int utentiEliminati = dUtente.delete(email);
                    System.out.println("Hai eliminato " + utentiEliminati + " utenti.");
                    break;
                case 6:
                    System.out.println("Inserisci la email dell'utente che vuoi aggiungere ai amici:");
                    email = myScanner.nextLine();
                    String amicizia = dUtente.creaAmicizia(utente,email);
                    System.out.println("Hai aggiuntio " + amicizia + " amicizia.");
                    break;
                case 7 :
                    System.out.println("Inserisci la email dell'utente da eliminare dagli amici:");
                    email = myScanner.nextLine();
                    String amicizia1 = dUtente.rimuoveAmicizia(utente,email);
                    System.out.println("Hai eliminato " + amicizia1 + " amicizia.");
                    break;

                case 8:
                    do{
                        input2 = loop.loopPost();
                        switch(input2){
                            case 1:
                                System.out.println("inserisci un nuovo testo:");
                                String text = myScanner.nextLine();
                                DTOpost nuovoPost = new DTOpost(utente.getEmail(), text, null, 1);
                                int nRighe = dPost.insert(nuovoPost);
                                System.out.println("Hai inserito" + nRighe + " nuovi post!");
                                break;
                            case 2:
                                System.out.println("Inserisci l'ID del post da modificare");
                                int idPost = myScanner.nextInt();
                                myScanner.nextLine();
                                System.out.println("Inserisci un nuovo testo:");
                                String nuovoTesto = myScanner.nextLine();
                                nuovoPost = new DTOpost(nuovoTesto);
                                nRighe = dPost.update(nuovoPost, idPost);
                                System.out.println("Hai inserito" + nRighe + " nuovi post!");
                                break;
                            case 3:
                                System.out.println("Inserisci l'email dell'utente di cui vuoi visualizzare il post");
                                email = myScanner.nextLine();
                                List<DTOpost> listaPost = dPost.cerca(email);
                                listaPost.stream().forEach(s -> System.out.println(s.toString()));
                                break;
                            case 4:
                                System.out.println("Inserisci l'ID del post da eliminare");
                                idPost = myScanner.nextInt();
                                myScanner.nextLine();
                                nRighe = dPost.delete(idPost);
                                System.out.println("Hai eliminato" + nRighe + " post!");
                                break;
                            case 0:
                                break;
                        }
                    }while(input2 != 0);
            }
        }while(input != 0);

    }
}
