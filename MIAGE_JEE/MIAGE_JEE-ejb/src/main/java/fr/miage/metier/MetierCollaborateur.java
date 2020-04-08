/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.metier;

import fr.miage.entities.Collaborateur;
import fr.miage.facades.CollaborateurFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ddias
 */
@Stateless
public class MetierCollaborateur implements MetierCollaborateurLocal {

    @EJB
    private CollaborateurFacadeLocal collaborateurFacade;

    @Override
    public void creerCollaborateur(String nom, String prenom, String status) {
        this.collaborateurFacade.creerCollaborateur(nom, prenom, status);
    }

    @Override
    public Collaborateur getCollaborateur(long idCollaborateur) {
        return this.collaborateurFacade.find(idCollaborateur);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
