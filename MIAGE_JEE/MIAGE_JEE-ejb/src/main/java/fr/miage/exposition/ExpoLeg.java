/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.exposition;

import fr.miage.entities.Collaborateur;
import fr.miage.entities.Competence;
import fr.miage.metier.MetierCollaborateurLocal;
import fr.miage.metier.MetierCompetenceLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ddias
 */
@Stateless
public class ExpoLeg implements ExpoLegLocal {

    @EJB
    private MetierCollaborateurLocal metierCollaborateur;

    @EJB
    private MetierCompetenceLocal metierCompetence;

    @Override
    public void creerCollaborateur(String nom, String prenom, String status) {
        this.metierCollaborateur.creerCollaborateur(nom, prenom, status);
    }

    @Override
    public Collaborateur getCollaborateur(long idCollaborateur) {
        return this.metierCollaborateur.getCollaborateur(idCollaborateur);
    }

    @Override
    public void creerCompetence(String nom, String competence) {
        this.metierCompetence.creerCompetence(nom, competence);
    }

    @Override
    public Competence getCompetence(long idCompetence) {
        return this.metierCompetence.getCompetence(idCompetence);
    }
}
