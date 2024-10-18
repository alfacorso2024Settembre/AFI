package it.alfasoft.social;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UIsocial {
    Scanner myScanner = new Scanner(System.in);

    public int loopUtente(DTOutente utente){
        int input = -1;

            System.out.println("Seleziona:\n(1) per creare un nuovo utente\n(2) per modificare un utente\n(3) per cercare una lista di utenti\n(4) per cercare un utente\n(5) per rimuovere un utente\n(6) per inviare una richiesta di amicizia\n(7) per rimuovere un utente dalle tue amicizie\n(8) per entrare nella sezione Post\n(0) per uscire dal menu");
            input = myScanner.nextInt();
            myScanner.nextLine();
            return input;



    }

    public int loopPost(){
        int input = -1;
        System.out.println("Seleziona:\n(1) per creare un nuovo post\n(2) per modificare un post\n(3) per cercare una lista di post\n(4) per eliminare un post\n(0) per uscire dal menu");
        input = myScanner.nextInt();
        myScanner.nextLine();
        return input;

    }


}
