/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.andrea.christophe.m1.jee.miage_jee.shr.interfremote;

import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.CandidatExport;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.CompetenceExport;
import javax.ejb.Remote;

/**
 *
 * @author andreachristophe
 */
@Remote
public interface ExpoLrdRemote {
    
    public void creerCandidat(String nom, String prenom);
    public CandidatExport getCandidat(long idCandidat);
    public void creerCompetence(String nom, String competence);
    public CompetenceExport getCompetence(long idCompetence);
}
