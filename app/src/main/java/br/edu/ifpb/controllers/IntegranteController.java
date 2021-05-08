package br.edu.ifpb.controllers;

import br.edu.ifpb.model.Integrante;

import javax.ejb.Local;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SessionScoped
@Named
@Stateless
public class IntegranteController implements Serializable {
    private Integrante integrante = new Integrante();

    private Integrante resultIntegrante;

    private String searchCpf = "";

    @PersistenceContext(unitName="atividadedac")
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

    public List<Integrante> filtrarIntegrantes() {
        List<Integrante> result = new ArrayList<>();
        List<Integrante> integrantes = this.listarIntegrantes();

        for(Integrante inte : integrantes){
            if(inte.getDataDeNascimento().isAfter(LocalDate.of(2000, 01, 01)) && inte.getDataDeNascimento().isBefore(LocalDate.of(2016, 04, 20))){
                result.add(inte);
            }
        }

        return result;
    }

    public List<Integrante> pesquisarPorCpf() {

        List<Integrante> listaDeIntegrantes = this.listarIntegrantes();

        for(Integrante inte : listaDeIntegrantes){
            if(inte.getCpf().equals(this.searchCpf)){
                this.resultIntegrante = inte;
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
