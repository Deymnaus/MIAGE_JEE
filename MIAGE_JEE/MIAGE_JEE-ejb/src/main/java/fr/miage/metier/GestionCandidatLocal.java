/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.metier;

import fr.miage.entities.Candidat;
import fr.miage.entities.Candidature;
import fr.miage.entities.FichePoste;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.Statut;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.CandidatInexistantException;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.CandidatureInexistantException;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.FichePosteInexistanteException;

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

    void changerStatutCandidature(Long idCandidature, Statut statut) throws CandidatureInexistantException;
}
