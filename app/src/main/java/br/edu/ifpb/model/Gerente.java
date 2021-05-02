package br.edu.ifpb.model;

public class Gerente {
    private int id;
    private int nome;
    private Banda banda;
    private String email;
    private CPF cpf = new CPF("");

    public Gerente(int id, int nome, Banda banda, String email, CPF cpf) {
        this.id = id;
        this.nome = nome;
        this.banda = banda;
        this.email = email;
        this.cpf = cpf;
    }

    public Gerente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }
}
