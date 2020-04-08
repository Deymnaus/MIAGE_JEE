/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.andrea.christophe.m1.jee.miage_jee.shr.interfremote;

import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.CollaborateurExport;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.CompetenceExport;
import javax.ejb.Remote;

/**
 *
 * @author andreachristophe
 */
@Remote
public interface ExpoLrdRemote {
    
    public void creerCollaborateur(String nom, String prenom, String status);
    public CollaborateurExport getCollaborateur(long idCollaborateur);
    public void creerCompetence(String nom, String competence);
    public CompetenceExport getCompetence(long idCompetence);
}
