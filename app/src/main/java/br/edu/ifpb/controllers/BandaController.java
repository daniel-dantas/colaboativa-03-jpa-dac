package br.edu.ifpb.controllers;

import br.edu.ifpb.model.Banda;
import br.edu.ifpb.model.Integrante;

import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
@Stateless
public class BandaController implements Serializable {
    private Banda banda = new Banda();

    private String searchLocalOrigem = "";

    private Banda resultBanda;


    @PersistenceContext(unitName="atividadedac")
    private EntityManager entityManager = Persistence
            .createEntityManagerFactory("atividadedac")
            .createEntityManager();

    public void criarBanda(){
        entityManager.getTransaction().begin();
        entityManager.persist(banda);
        entityManager.getTransaction().commit();
        this.banda = new Banda();
    }

    public List<Banda> listarLocalOrigens() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Banda> criteria = builder.createQuery(Banda.class);
        Root<Banda> root = criteria.from(Banda.class);
        criteria.select(root);

        TypedQuery<Banda> query = entityManager.createQuery(criteria);

        return query.getResultList();
    }

    public List<Banda> pesquisarPorLocalOrigem() {

        List<Banda> listaLocalOrigens = this.listarLocalOrigens();

        for(Banda banda : listaLocalOrigens){
            if(banda.getLocalDeOrigim().equals(this.searchLocalOrigem)){
                this.resultBanda = banda;
            }
        }

        return listaLocalOrigens;
    }

    public String getSearchLocalOrigem() {
        return searchLocalOrigem;
    }

    public Banda getResultBanda() {
        return resultBanda;
    }

    public void setResultBanda(Banda resultBanda) {
        this.resultBanda = resultBanda;
    }

    public void setSearchLocalOrigem(String searchLocalOrigem) {
        this.searchLocalOrigem = searchLocalOrigem;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
}
