package it.alfasoft.corso.negozio;

import java.sql.ResultSet;
import java.util.Scanner;

public class NegozioMain {


    public static void main(String ...args) {
        GestioneCliente gc = new GestioneCliente();
        GestioneFornitore gf = new GestioneFornitore();
        GestioneFornitore_Prodotto gfp = new GestioneFornitore_Prodotto();
        GestioneProdotto gp = new GestioneProdotto();
        GestioneProdottoCliente gpc = new GestioneProdottoCliente();
        Scanner sc = new Scanner(System.in);
        ResultSet rs;

        try {

            int scelta =9;
            int secondaScelta = 9;
            while(scelta != 0) {
                System.out.println("Vuoi gestire (1)Clienti , (2)Prodotti , (3)Fornitori,(4) fornitori-prodotti ,Exit(0)");
                scelta = sc.nextInt();
                sc.nextLine();

                if(scelta == 1) {
                    secondaScelta = 9;
                    while (secondaScelta != 0) {
                        System.out.println("Gestione Clienti");
                        System.out.println("Stampa(1),Insert(2),Update(3),Delete(4),Go back(0)");
                        secondaScelta = sc.nextInt();
                        sc.nextLine();

                        if (secondaScelta == 1) {
                            gc.stampa("clienti");
                        } else if (secondaScelta == 2) {
                            System.out.println("Inserisci nome");
                            String nome = sc.nextLine();

                            System.out.println("Inserisci email");
                            String email = sc.nextLine();


                            Cliente c = new Cliente(nome,email);

                            int n = gc.insert(c);
                            System.out.println(n + " rows affected");

                        }else if(secondaScelta == 3){
                            System.out.println("Inserisci id di cliente ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Inserisci nuovo nome");
                            String nome = sc.nextLine();

                            System.out.println("Inserisci nuovo email");
                            String email = sc.nextLine();


                            Cliente c = new Cliente(nome,email);

                            int n = gc.update(id,c);
                            System.out.println(n + " rows affected");
                        }else if(secondaScelta == 4){
                            System.out.println("Inserisci id di cliente da eliminare ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            int n = gc.delete(id);
                            System.out.println(n + "rows affected.");
                        }


                        else{
                        continue;
                        }
                    }
                }else if( scelta == 2){
                    secondaScelta = 9;
                    while (secondaScelta != 0) {
                        System.out.println("Gestione Prodotti");
                        System.out.println("Stampa(1),Insert(2),Update(3),Delete(4),Go back(0)");
                        secondaScelta = sc.nextInt();
                        sc.nextLine();

                        if (secondaScelta == 1) {
                            gc.stampa("prodotti");
                        } else if (secondaScelta == 2) {
                            System.out.println("Inserisci nome");
                            String nome = sc.nextLine();
                            sc.nextLine();
                            System.out.println("Inserisci prezzo");
                            int prezzo = sc.nextInt();
                            sc.nextLine();

                            Prodotto p = new Prodotto(nome,prezzo);

                            int n = gp.insert(p);
                            System.out.println(n + " rows affected");

                        }else if(secondaScelta == 3){
                            System.out.println("Inserisci id di prodotto ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Inserisci nuovo nome");
                            String nome = sc.nextLine();
                            sc.nextLine();
                            System.out.println("Inserisci nuovo prezzo");
                            int prezzo = sc.nextInt();
                            sc.nextLine();

                            Prodotto p = new Prodotto(nome,prezzo);

                            int n = gp.update(id,p);
                            System.out.println(n + " rows affected");
                        }else if(secondaScelta == 4){
                            System.out.println("Inserisci id di cliente da eliminare ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            int n = gp.delete(id);
                            System.out.println(n + "rows affected.");
                        }


                        else{
                            continue;
                        }
                    }
                }else if(scelta == 3) {
                    secondaScelta = 9;
                    while (secondaScelta != 0) {
                        System.out.println("Gestione Fornitori");
                        System.out.println("Stampa(1),Insert(2),Update(3),Delete(4),Go back(0)");
                        secondaScelta = sc.nextInt();
                        sc.nextLine();

                        if (secondaScelta == 1) {
                            gf.stampa("fornitori");
                        } else if (secondaScelta == 2) {
                            System.out.println("Inserisci nome");
                            String nome = sc.nextLine();
                            sc.nextLine();

                            Fornitore f = new Fornitore(nome);

                            int n = gf.insert(f);
                            System.out.println(n + " rows affected");

                        }else if(secondaScelta == 3){
                            System.out.println("Inserisci id di fornitore ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Inserisci nuovo nome");
                            String nome = sc.nextLine();
                            sc.nextLine();

                            Fornitore f = new Fornitore(nome);

                            int n = gf.update(id,f);
                            System.out.println(n + " rows affected");
                        }else if(secondaScelta == 4){
                            System.out.println("Inserisci id di fornitore da eliminare ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            int n = gf.delete(id);
                            System.out.println(n + "rows affected.");
                        }
                        }

                }else
                {
                    if(scelta == 4)
                    {
                        secondaScelta = 9;
                        while (secondaScelta != 0) {
                            System.out.println("Gestione Fornitori-Prodotti");
                            System.out.println("Stampa(1),Insert(2),Update(3),Delete(4),Go back(0)");
                            secondaScelta = sc.nextInt();
                            sc.nextLine();

                            if (secondaScelta == 1) {
                                gfp.stampa("fornitori_prodotti");
                            } else if (secondaScelta == 2) {
                                System.out.println("Inserisci id prodotti");
                                int id_prod = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Inserisci id prodotti");
                                int id_forn = sc.nextInt();
                                sc.nextLine();
                                rs = gf.selectById(id_forn);
                                if(!rs.next())
                                {
                                    System.out.println("Fornitore non esiste");
                                }
                                else {
                                    rs = gp.selectById(id_prod);
                                    if (!rs.next())
                                    {
                                        System.out.println("Prodotto non esiste");
                                    }
                                    else {
                                        System.out.println("Inserire quantità del prodotto che il fornitore ha in stock");
                                        int quantita = sc.nextInt();
                                        sc.nextLine();
                                        int n = gfp.insert(new Fornitore_prodotto(id_forn, id_prod, quantita));
                                        System.out.println(n + " rows affected");
                                    }
                                }



                            }else if(secondaScelta == 3){
                                System.out.println("Inserisci id prodotti");
                                int id_prod = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Inserisci id fornitori");
                                int id_forn = sc.nextInt();
                                sc.nextLine();
                                rs = gf.selectById(id_forn);
                                if(!rs.next())
                                {
                                    System.out.println("Fornitore non esiste");
                                }
                                else {
                                    rs = gp.selectById(id_prod);
                                    if (!rs.next())
                                    {
                                        System.out.println("Prodotto non esiste");
                                    }
                                    else {
                                        System.out.println("Inserire nuova quantità del prodotto in stock");
                                        int quantita = sc.nextInt();
                                        sc.nextLine();
                                        int n = gfp.update(id_forn, id_prod, quantita);
                                        System.out.println(n + " rows affected");
                                    }
                                }
                            }else if(secondaScelta == 4){
                                System.out.println("Inserisci id prodotti");
                                int id_prod = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Inserisci id fornitori");
                                int id_forn = sc.nextInt();
                                sc.nextLine();
                                rs = gf.selectById(id_forn);
                                if(!rs.next())
                                {
                                    System.out.println("Fornitore non esiste");
                                }
                                else {
                                    rs = gp.selectById(id_prod);
                                    if (!rs.next())
                                    {
                                        System.out.println("Prodotto non esiste");
                                    }
                                    else {
                                        int n = gfp.delete(id_forn, id_prod);
                                        System.out.println(n + " rows affected");
                                    }
                                }
                            }
                        }
                    }
                }if(scelta == 5){
                    secondaScelta = 9;
                    while (secondaScelta != 0) {
                        System.out.println("Gestione prodotti-clienti");
                        System.out.println("Stampa(1),Insert(2),Update(3),Delete(4),Go back(0)");
                        secondaScelta = sc.nextInt();
                        sc.nextLine();

                        if (secondaScelta == 1) {
                            gf.stampa("prodotti_clienti");
                        } else if (secondaScelta == 2) {
                            System.out.println("Inserisci id_prodotto");
                            int id_prodotto = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Inserisci id di cliente");
                            int id_cliente = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Inserisci quantita");
                            int quantita = sc.nextInt();
                            sc.nextLine();


                            Prodotto_cliente pc = new Prodotto_cliente(id_cliente,id_prodotto,quantita);

                            int n = gpc.insert(pc);
                            System.out.println(n + " rows affected");

                        }else if(secondaScelta == 3){
                            System.out.println("Inserisci id_prodotto");
                            int id_prodotto = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Inserisci id di cliente");
                            int id_cliente = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Inserisci nuova quantita");
                            int quantita = sc.nextInt();
                            sc.nextLine();


                            Prodotto_cliente pc = new Prodotto_cliente(id_cliente,id_prodotto,quantita);

                            int n = gpc.update(id_cliente,id_prodotto,quantita);
                            System.out.println(n + " rows affected");
                        } else if (secondaScelta == 4) {
                            System.out.println("Inserisci id_prodotto");
                            int id_prodotto = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Inserisci id di cliente");
                            int id_cliente = sc.nextInt();
                            sc.nextLine();

                            gpc.delete(id_cliente,id_prodotto);

                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            sc.close();
        };
    }
}
