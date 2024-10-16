package it.alfasoft.studenti;

public class DtoInsegnante {
    private String nome;
    private String email;
    private int id_insegnante;

    public DtoInsegnante(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public DtoInsegnante(String nome, String email, int id_insegnante) {
        this.nome = nome;
        this.email = email;
        this.id_insegnante = id_insegnante;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getId_insegnante() {
        return id_insegnante;
    }
}
