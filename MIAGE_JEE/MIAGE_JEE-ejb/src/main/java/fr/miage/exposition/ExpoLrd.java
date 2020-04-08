/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.exposition;

import fr.andrea.christophe.m1.jee.miage_jee.shr.interfremote.ExpoLrdRemote;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.CollaborateurExport;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.CompetenceExport;
import fr.miage.entities.Collaborateur;
import fr.miage.entities.Competence;
import fr.miage.metier.MetierCollaborateurLocal;
import fr.miage.metier.MetierCompetenceLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.*;

/**
 *
 * @author andreachristophe
 */
@Stateless
public class ExpoLrd implements ExpoLrdRemote {

    @EJB
    private MetierCollaborateurLocal metierCollaborateur;

    @EJB
    private MetierCompetenceLocal metierCompetence;

    public void creerCollaborateur(String nom, String prenom, String status) {
        this.metierCollaborateur.creerCollaborateur(nom, prenom, status);
    }

    public CollaborateurExport getCollaborateur(long idCollaborateur) {
        
        Collaborateur collaborateur = this.metierCollaborateur.getCollaborateur(idCollaborateur);
        
        List<CompetenceExport> competences = new ArrayList<CompetenceExport>();
        
        for (Competence competence: collaborateur.getCompetences()) {
            
            CompetenceExport c = new CompetenceExport();
            c.setId(competence.getId());
            c.setNom(competence.getNom());
            c.setDescription(competence.getDescription());
            
            competences.add(c);     
        }
        
        CollaborateurExport c = new CollaborateurExport();
        c.setId(collaborateur.getId());
        c.setStatus(collaborateur.getStatus());
        c.setNom(collaborateur.getNom());
        c.setPrenom(collaborateur.getPrenom());
        c.setCompetences(competences);
        
        return c;
    }

    public void creerCompetence(String nom, String competence) {
        this.metierCompetence.creerCompetence(nom, competence);
    }

    public CompetenceExport getCompetence(long idCompetence) {
        Competence competence = this.metierCompetence.getCompetence(idCompetence);
        
        CompetenceExport c = new CompetenceExport();
        c.setId(competence.getId());
        c.setNom(competence.getNom());
        c.setDescription(competence.getDescription());
            
        return c;
    }
}
