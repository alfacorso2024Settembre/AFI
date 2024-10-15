package it.alfasoft.corso.negozio;

public class Prodotto_cliente {
    int id_cliente;
    int id_prodotto;
    int quantita;

    public Prodotto_cliente(int id_cliente, int id_prodotto,int quantita) {
        this.id_cliente = id_cliente;
        this.id_prodotto = id_prodotto;
        this.quantita = quantita;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(int id_prodotto) {
        this.id_prodotto = id_prodotto;
    }

    public int getQuantita() {
        return quantita;
    }
}
