package it.alfasoft.studenti;

public class DtoStudente {
    private String email;
    private Long matricola;

    public DtoStudente() {
        this.email = Gestione_studenti_Main.sc.nextLine();
        this.matricola = 0L;
    }

    public DtoStudente(String email) {
        this.email = email;
    }

    public DtoStudente(String email, Long matricola) {
        this.email = email;
        this.matricola = matricola;
    }

    public String getEmail() {
        return email;
    }

    public Long getMatricola() {
        return matricola;
    }
}
