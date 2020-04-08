/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.facades;

import fr.miage.entities.Collaborateur;
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
public class CollaborateurFacade extends AbstractFacade<Collaborateur> implements CollaborateurFacadeLocal {

    @PersistenceContext(unitName = "fr.miage_MIAGE_JEE-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CollaborateurFacade() {
        super(Collaborateur.class);
    }

    @Override
    public void creerCollaborateur(String nom, String prenom, String status) {
        Collaborateur clb = new Collaborateur();
        clb.setNom(nom);
        clb.setPrenom(prenom);
        clb.setStatus(status);
        clb.setCompetences(new ArrayList<Competence>());
        this.create(clb);
    }
    
}
