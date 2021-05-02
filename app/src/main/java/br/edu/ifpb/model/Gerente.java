package br.edu.ifpb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Gerente implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private int nome;
    @OneToOne
    private Banda banda;
    private String email;
    private String cpf;

    public Gerente(int id, int nome, Banda banda, String email, String cpf) {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
