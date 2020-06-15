/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.exposition;

import fr.andrea.christophe.m1.jee.miage_jee.shr.interfremote.ExpoLrdRemote;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.*;
import fr.miage.metier.GestionCandidatLocal;
import fr.miage.metier.GestionDemandeCompetenceLocal;
import fr.miage.utils.Traducteur;

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
    private GestionDemandeCompetenceLocal gestionDemandeCompetence;

    @EJB
    private GestionCandidatLocal gestionCandidat;

    @Override
    public HashSet<DemandeCompetenceExport> listerCompetencesDemandeesEquipes() {
        return gestionDemandeCompetence.listerCompetencesDemandeesEquipes();
    }

    @Override
    public HashSet<CollaborateurExport> listerCompetencesCollaborateurs() {
        return gestionDemandeCompetence.listerCompetencesCollaborateurs();
    }

    @Override
    public int proposerFichePoste(Long idDemandeCompetence, String presentationPoste, String presentationEntreprise) {
        return gestionDemandeCompetence.proposerFichePoste(idDemandeCompetence, presentationPoste, presentationEntreprise);
    }

    @Override
    public HashSet<CandidatureExport> listerCandidatures() {
        return new HashSet<>(Traducteur.listeCandidatureToCandidatureExport(gestionCandidat.listerCandidatures()));
    }

    @Override
    public int changerStatutCandidature(Long idCandidature, Statut statut) {
        return gestionCandidat.changerStatutCandidature(idCandidature, statut);
    }

    @Override
    public HashSet<CandidatureExport> listerCandidaturesFeuVert() {
        return new HashSet<>(Traducteur.listeCandidatureToCandidatureExport(gestionCandidat.listerCandidaturesFeuVert()));
    }

    @Override
    public int concretiserEmbauche(Long idCandidature, Long idEquipe) {
        return gestionCandidat.concretiserEmbauche(idCandidature, idEquipe);
    }
}
