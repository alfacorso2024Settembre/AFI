package it.alfasoft.studenti;

public class DtoCorso {

    private String nome;
    int crediti;

    public DtoCorso(int crediti, String nome) {
        this.crediti = crediti;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getCrediti() {
        return crediti;
    }
}
