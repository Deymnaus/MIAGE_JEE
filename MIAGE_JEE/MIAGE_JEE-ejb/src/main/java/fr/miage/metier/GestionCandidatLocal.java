/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.metier;

import fr.miage.entities.Candidat;
import fr.miage.entities.Candidature;
import fr.miage.entities.FichePoste;
import fr.miage.exception.CandidatInexistantException;
import fr.miage.exception.FichePosteInexistanteException;

import javax.ejb.Local;
import java.util.HashSet;

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
}
