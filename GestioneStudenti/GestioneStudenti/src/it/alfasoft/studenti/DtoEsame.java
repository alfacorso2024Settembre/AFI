package it.alfasoft.studenti;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class DtoEsame {
    int id_esame;
    int id_corso;
    int durata;
    String data;
    String ora;

    public DtoEsame(int id_esame, int id_corso, int durata, String data, String ora) {
        this.id_esame = id_esame;
        this.id_corso = id_corso;
        this.durata = durata;
        this.data = data;
        this.ora = ora;
    }

    public DtoEsame(int id_corso, int durata, String data, String ora) {
        this.id_corso = id_corso;
        this.durata = durata;
        this.data = data;
        this.ora = ora;
    }

    public int getDurata() {
        return durata;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public int getId_esame() {
        return id_esame;
    }

    public int getId_corso() {
        return id_corso;
    }
}
