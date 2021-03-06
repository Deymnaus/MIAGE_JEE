/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.andrea.christophe.m1.jee.miage_jee.shr.interfremote;

import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.*;

import javax.ejb.Remote;
import java.util.HashSet;

/**
 *
 * @author andreachristophe
 */
@Remote
public interface ExpoLrdRemote {
     HashSet<DemandeCompetenceExport> listerCompetencesDemandeesEquipes();

     HashSet<CollaborateurExport> listerCompetencesCollaborateurs();

     int proposerFichePoste(Long idDemandeCompetence, String presentationPoste, String presentationEntreprise);

     HashSet<CandidatureExport> listerCandidatures();

     int changerStatutCandidature(Long idCandidature, Statut statut);

     HashSet<CandidatureExport> listerCandidaturesFeuVert();

     int concretiserEmbauche(Long idCandidature, Long idEquipe);
}
