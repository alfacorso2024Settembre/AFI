package it.alfasoft.Azienda;

import java.util.ArrayList;
import java.util.List;

public class DTOreparto {
    String nome;
    List<DTOdipendente> listaDipendenti = new ArrayList<>();

    public DTOreparto(String nome) {
        this.nome = nome;
    }

    public DTOreparto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<DTOdipendente> getListaDipendenti() {
        return listaDipendenti;
    }

    public void setListaDipendenti(List<DTOdipendente> listaDipendenti) {
        this.listaDipendenti = listaDipendenti;
    }
}
