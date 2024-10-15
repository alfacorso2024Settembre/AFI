package it.alfasoft.corso.negozio;

public class Fornitore_prodotto {
    int id_fornitore;
    int id_prodotto;
    int quantita_stock;

    public Fornitore_prodotto(int id_fornitore, int id_prodotto) {
        this.id_fornitore = id_fornitore;
        this.id_prodotto = id_prodotto;
    }

    public Fornitore_prodotto(int id_fornitore, int id_prodotto, int quantita_stock) {
        this.id_fornitore = id_fornitore;
        this.id_prodotto = id_prodotto;
        this.quantita_stock = quantita_stock;
    }

    public int getId_fornitore() {
        return id_fornitore;
    }

    public void setId_fornitore(int id_fornitore) {
        this.id_fornitore = id_fornitore;
    }

    public int getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(int id_prodotto) {
        this.id_prodotto = id_prodotto;
    }

    public int getQuantita_stock() {
        return quantita_stock;
    }

    public void setQuantita_stock(int quantita_stock) {
        this.quantita_stock = quantita_stock;
    }
}


