package it.alfasoft.corso.negozio;

public class Fornitore {
    int id_fornitore;
    String nome;

    public Fornitore(int id_fornitore, String nome) {
        this.id_fornitore = id_fornitore;
        this.nome = nome;
    }

    public Fornitore(String nome) {
        this.nome = nome;
    }

    public int getId_fornitore() {
        return id_fornitore;
    }

    public void setId_fornitore(int id_fornitore) {
        this.id_fornitore = id_fornitore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
