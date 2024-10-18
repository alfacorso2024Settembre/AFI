package it.alfasoft.Azienda;

public class DTOdipendente {
    String nome;
    String email;
    String ruolo;
    String nomeReparto;

    public DTOdipendente(String nome, String email, String ruolo, String nomeReparto) {
        this.nome = nome;
        this.email = email;
        this.ruolo = ruolo;
        this.nomeReparto = nomeReparto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getNomeReparto() {
        return nomeReparto;
    }

    public void setNomeReparto(String nomeReparto) {
        this.nomeReparto = nomeReparto;
    }
}
