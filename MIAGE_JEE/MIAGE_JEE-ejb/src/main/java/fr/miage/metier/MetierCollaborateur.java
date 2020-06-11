/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.metier;

import fr.miage.entities.Collaborateur;
import fr.miage.entities.Competence;
import fr.miage.entities.Equipe;
import fr.miage.facades.CandidatFacadeLocal;
import fr.miage.facades.CollaborateurFacadeLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;

/**
 *
 * @author ddias
 */
@Stateless
public class MetierCollaborateur implements MetierCollaborateurLocal {

    @EJB
    private CandidatFacadeLocal candidatFacade;

    @EJB
    private CollaborateurFacadeLocal collaborateurFacade;

    
    @Override
    public void creerCollaborateur(String nom, String prenom, boolean codir, boolean manager, Equipe equipe) {
        this.collaborateurFacade.creerCollaborateur(nom, prenom, codir, manager, equipe);
    }

    @Override
    public Collaborateur getCollaborateur(Long idCollaborateur) {
        return this.collaborateurFacade.find(idCollaborateur);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
