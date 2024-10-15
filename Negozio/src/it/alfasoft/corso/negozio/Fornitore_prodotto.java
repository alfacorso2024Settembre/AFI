package it.alfasoft.corso.negozio;

public class Fornitore_prodotto {
    int id_fornitore;
    int id_prodotto;

    public Fornitore_prodotto(int id_fornitore, int id_prodotto) {
        this.id_fornitore = id_fornitore;
        this.id_prodotto = id_prodotto;
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
}


