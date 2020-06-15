/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.metier;

import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.*;
import fr.miage.entities.Candidat;
import fr.miage.entities.Candidature;
import fr.miage.entities.FichePoste;

import javax.ejb.Local;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author ddias
 */
@Local
public interface GestionCandidatLocal {
    
    void creerCandidat(String nom, String prenom);
    
    Candidat getCandidat(long idCandidat);

    Candidature proposerCandidature(Long numCandidat, Long numFichePoste) throws CandidatInexistantException, FichePosteInexistanteException;

    HashSet<Long> listerOffresDisponibles();

    FichePoste consulterDetailsOffre(Long idFichePoste) throws FichePosteInexistanteException;

    List<Candidature> listerCandidatures();

    Candidature sePrononcerSurCandidature(Long idCandidature, Statut statut) throws CandidatureInexistantException;

    int changerStatutCandidature(Long idCandidature, Statut statut);

    List<Candidature> listerCandidaturesFeuVert();

    int concretiserEmbauche(Long idCandidature, Long idEquipe);
}
