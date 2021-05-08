package br.edu.ifpb.controllers;

import br.edu.ifpb.model.Banda;
import br.edu.ifpb.model.Integrante;

import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
@Stateless
public class BandaController implements Serializable {
    private Banda banda = new Banda();

    @PersistenceContext(unitName="atividadedac")
    private EntityManager entityManager = Persistence
            .createEntityManagerFactory("atividadedac")
            .createEntityManager();

    public void criarIntegrante(){
        entityManager.getTransaction().begin();
        entityManager.persist(banda);
        entityManager.getTransaction().commit();
        this.banda = new Banda();
    }

    public List<Banda> listarBandas(){
        return new ArrayList<Banda>();
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
}
