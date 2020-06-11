/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.facades;

import fr.miage.entities.Candidat;
import fr.miage.entities.Competence;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ddias
 */
@Stateless
public class CandidatFacade extends AbstractFacade<Candidat> implements CandidatFacadeLocal {

    @PersistenceContext(unitName = "fr.miage_MIAGE_JEE-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CandidatFacade() {
        super(Candidat.class);
    }

    @Override
    public void creerCandidat(String nom, String prenom) {
        Candidat cnd = new Candidat();
        cnd.setNom(nom);
        cnd.setPrenom(prenom);
        cnd.setCompetences(new ArrayList<Competence>());
        this.create(cnd);
    }
    
}
