/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.exposition;

import fr.andrea.christophe.m1.jee.miage_jee.shr.interfremote.ExpoLrdRemote;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.*;
import fr.miage.entities.Candidature;
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
    public HashMap<CollaborateurExport, ArrayList<CompetenceExport>> listerCompetencesCollaborateurs() {
        return gestionDemandeCompetence.listerCompetencesCollaborateurs();
    }

    @Override
    public int proposerFichePoste(Long idDemandeCompetence, String presentationPoste, String presentationEntreprise) {
        int result = 0;
        try {
            gestionDemandeCompetence.proposerFichePoste(idDemandeCompetence, presentationPoste, presentationEntreprise);
            result = 1;
        } catch (DemandeCompetenceInexistanteException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public HashSet<CandidatureExport> listerCandidatures() {
        return new HashSet<>(Traducteur.listeCandidatureToCandidatureExport(gestionCandidat.listerCandidatures()));
    }

    @Override
    public int changerStatutCandidature(Long idCandidature, Statut statut) {
        int result = 0;
        try{
            gestionCandidat.changerStatutCandidature(idCandidature, statut);
            result = 1;
        } catch (CandidatureInexistantException e){
            e.printStackTrace();
        }
        return result;
    }
}
