/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.exposition;

import fr.miage.entities.Collaborateur;
import fr.miage.entities.Competence;
import javax.ejb.Local;

/**
 *
 * @author ddias
 */
@Local
public interface ExpoLegLocal {
    
    public void creerCollaborateur(String nom, String prenom, String status);
    public Collaborateur getCollaborateur(long idCollaborateur);
    public void creerCompetence(String nom, String competence);
    public Competence getCompetence(long idCompetence);
    
}
