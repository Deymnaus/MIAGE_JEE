/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.metier;

import fr.miage.entities.Collaborateur;
import fr.miage.entities.Competence;
import fr.miage.facades.CollaborateurFacadeLocal;
import fr.miage.facades.CompetenceFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ddias
 */
@Stateless
public class MetierCompetence implements MetierCompetenceLocal {

    @EJB
    private CollaborateurFacadeLocal collaborateurFacade;

    @EJB
    private CompetenceFacadeLocal competenceFacade;

    
    @Override
    public void creerCompetence(String nom, String description) {
        
        Competence cpt = new Competence();
        cpt.setNom(nom);
        cpt.setDescription(description);
        
        this.competenceFacade.create(cpt);
    }

    @Override
    public Competence getCompetence(long idCompetence) {
        return this.competenceFacade.find(idCompetence);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
