/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.exposition;

import fr.andrea.christophe.m1.jee.miage_jee.shr.interfremote.ExpoLrdRemote;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.*;
import fr.miage.entities.Candidat;
import fr.miage.entities.Competence;
import fr.miage.metier.GestionCandidatLocal;
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


    @Override
    public HashSet<DemandeCompetenceExport> listerCompetencesDemandeesEquipes() {
        return null;
    }

    @Override
    public HashSet<CompetenceExport> listerCompetencesCollaborateurs() {
        return null;
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
