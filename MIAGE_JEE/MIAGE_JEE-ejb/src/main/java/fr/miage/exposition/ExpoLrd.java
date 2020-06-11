/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.exposition;

import fr.andrea.christophe.m1.jee.miage_jee.shr.interfremote.ExpoLrdRemote;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.CandidatExport;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.CompetenceExport;
import fr.miage.entities.Candidat;
import fr.miage.entities.Competence;
import fr.miage.metier.MetierCandidatLocal;
import fr.miage.metier.GestionDemandeCompetenceLocal;
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
    private MetierCandidatLocal metierCandidat;

    @EJB
    private GestionDemandeCompetenceLocal metierCompetence;

    public void creerCandidat(String nom, String prenom) {
        this.metierCandidat.creerCandidat(nom, prenom);
    }

    public CandidatExport getCandidat(long idCandidat) {
        
        Candidat candidat = this.metierCandidat.getCandidat(idCandidat);
        
        List<CompetenceExport> competences = new ArrayList<CompetenceExport>();
        
        for (Competence competence: candidat.getListeCompetences()) {
            
            CompetenceExport c = new CompetenceExport();
            c.setId(competence.getId());
            c.setNom(competence.getNom());
            c.setDescription(competence.getDescription());
            
            competences.add(c);     
        }
        
        CandidatExport c = new CandidatExport();
        c.setId(candidat.getId());
        c.setNom(candidat.getNom());
        c.setPrenom(candidat.getPrenom());
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
