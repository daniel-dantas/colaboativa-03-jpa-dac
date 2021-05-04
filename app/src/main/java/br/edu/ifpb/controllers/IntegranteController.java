package br.edu.ifpb.controllers;

import br.edu.ifpb.model.Integrante;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named
public class IntegranteController implements Serializable {
    private Integrante integrante = new Integrante();

    private Integrante resultIntegrante;

    private String searchCpf = "";

    private EntityManager entityManager = Persistence
            .createEntityManagerFactory("atividadedac")
            .createEntityManager();

    public void criarIntegrante() {

        entityManager.getTransaction().begin();
        entityManager.persist(integrante);
        entityManager.getTransaction().commit();

        this.integrante = new Integrante();
    }

    public List<Integrante> listarIntegrantes() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Integrante> criteria = builder.createQuery(Integrante.class);
        Root<Integrante> root = criteria.from(Integrante.class);
        criteria.select(root);

        TypedQuery<Integrante> query = entityManager.createQuery(criteria);

        return query.getResultList();
    }

    public List<Integrante> pesquisarPorCpf() {

        List<Integrante> listaDeIntegrantes = this.listarIntegrantes();

        for(Integrante inte : listaDeIntegrantes){
            if(inte.getCpf().equals(this.searchCpf)){
                this.integrante = inte;
            }
        }

        return listaDeIntegrantes;
    }

    public Integrante getIntegrante() {
        return integrante;
    }

    public String getSearchCpf() {
        return searchCpf;
    }

    public void setSearchCpf(String searchCpf) {
        this.searchCpf = searchCpf;
    }

    public Integrante getResultIntegrante() {
        return resultIntegrante;
    }

    public void setResultIntegrante(Integrante resultIntegrante) {
        this.resultIntegrante = resultIntegrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }
}
