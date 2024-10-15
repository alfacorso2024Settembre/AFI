package it.alfasoft.corso.negozio;

public class Prodotto {
    int id_prodotto;
    String nome;
    int prezzo;

    public Prodotto(int id_prodotto, String nome, int prezzo) {
        this.id_prodotto = id_prodotto;
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public Prodotto(String nome, int prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public int getId_prodotto() {
        return id_prodotto;
    }

    public void setId_prodotto(int id_prodotto) {
        this.id_prodotto = id_prodotto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }
}
