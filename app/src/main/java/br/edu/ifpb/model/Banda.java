package br.edu.ifpb.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Banda implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String localDeOrigim;
    private String nomeFantansia;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "banda_id")
    private List<Integrante> integrantes = new ArrayList<>();

    public Banda(){
    }

    public Banda(int id, String localDeOrigim, String nomeFantansia) {
        this.id = id;
        this.localDeOrigim = localDeOrigim;
        this.nomeFantansia = nomeFantansia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalDeOrigim() {
        return localDeOrigim;
    }

    public void setLocalDeOrigim(String localDeOrigim) {
        this.localDeOrigim = localDeOrigim;
    }

    public String getNomeFantansia() {
        return nomeFantansia;
    }

    public void setNomeFantansia(String nomeFantansia) {
        this.nomeFantansia = nomeFantansia;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }
}