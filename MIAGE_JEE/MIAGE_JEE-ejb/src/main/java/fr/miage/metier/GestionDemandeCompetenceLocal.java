/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.metier;

import fr.miage.entities.Competence;
import fr.miage.entities.DemandeCompetence;
import fr.miage.exception.CompetenceInexistanteException;
import fr.miage.exception.DemandeCompetenceInexistanteException;
import fr.miage.exception.EquipeInexistanteException;

import javax.ejb.Local;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author ddias
 */
@Local
public interface GestionDemandeCompetenceLocal {
    
    public void creerCompetence(String nom, String description);
    public Competence getCompetence(long idCompetence);

    DemandeCompetence demanderCompetence(Long numEquipe, ArrayList<Long> listeIdCompetence) throws EquipeInexistanteException, CompetenceInexistanteException;

    HashSet<DemandeCompetence> listerCompetenceACombler();

    DemandeCompetence comblerCompetence(Long idDemandeCompetence) throws DemandeCompetenceInexistanteException;
}
