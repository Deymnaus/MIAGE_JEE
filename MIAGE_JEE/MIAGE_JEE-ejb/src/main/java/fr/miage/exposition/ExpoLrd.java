/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.exposition;

import fr.andrea.christophe.m1.jee.miage_jee.shr.interfremote.ExpoLrdRemote;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.*;
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
    private GestionDemandeCompetenceLocal gestionDemandeCompetence;

    @Override
    public HashSet<DemandeCompetenceExport> listerCompetencesDemandeesEquipes() {
        return gestionDemandeCompetence.listerCompetencesDemandeesEquipes();
    }

    @Override
    public HashMap<CollaborateurExport, ArrayList<CompetenceExport>> listerCompetencesCollaborateurs() {
        return gestionDemandeCompetence.listerCompetencesCollaborateurs();
    }

    @Override
    public void proposerFichePoste(Long idDemandeCompetence) {

    }

    @Override
    public HashSet<CandidatureExport> listerCandidatures() {
        return null;
    }

    @Override
    public void changerStatutCandidature(Long idCandidature, Statut statut) {

    }
}
