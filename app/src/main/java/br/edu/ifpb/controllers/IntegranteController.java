package br.edu.ifpb.controllers;

import br.edu.ifpb.model.Integrante;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named
public class IntegranteController implements Serializable {
    private Integrante integrante = new Integrante();

    private EntityManager entityManager = Persistence
            .createEntityManagerFactory("atividadedac")
            .createEntityManager();

    public void criarIntegrante(){

        entityManager.getTransaction().begin();
        entityManager.persist(integrante);
        entityManager.getTransaction().commit();

        this.integrante = new Integrante();
    }

    public List<Integrante> listarIntegrantes() {
        return new ArrayList<Integrante>();
    }

    public Integrante getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }
}
