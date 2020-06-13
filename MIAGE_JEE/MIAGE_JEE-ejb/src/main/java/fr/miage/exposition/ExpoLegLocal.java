/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.exposition;

import fr.miage.entities.*;

import javax.ejb.Local;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author ddias
 */
@Local
public interface ExpoLegLocal {

    // Manager
    HashSet<Competence> listerCompetence(Long numEquipe);
    DemandeCompetence demanderCompetence(Long numEquipe, ArrayList<Long> listCompetences);

    HashSet<DemandeCompetence> listerCompetenceACombler();

    Candidature proposerCandidature(Long numCandidat, Long numFichePoste);

    DemandeCompetence comblerCompetence(Long idDemandeCompetence);

    HashSet<Long> listerOffresDisponibles();

    FichePoste consulterDetailsOffre(Long idFichePoste);

    String recolterStatistiques();

    List<Candidature> listerCandidatures();

    Candidature sePrononcerSurCandidature(Long idCandidature, Statut statut);
}
