package it.alfasoft.corso.negozio;

public class Cliente {
    int id_cliente;
    String nome;
    String email;

    public Cliente(int id_cliente, String nome, String email) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.email = email;
    }

    public Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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
}
