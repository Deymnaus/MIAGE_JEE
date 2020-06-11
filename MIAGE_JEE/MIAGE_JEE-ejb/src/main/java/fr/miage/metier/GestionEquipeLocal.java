/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.metier;

import fr.miage.entities.Competence;
import fr.miage.entities.Equipe;
import fr.miage.exception.EquipeInexistanteException;

import javax.ejb.Local;
import java.util.HashSet;

/**
 *
 * @author ddias
 */
@Local
public interface GestionEquipeLocal {
    
    public void creerEquipe(String nom);
    public Equipe getEquipe(Long idEquipe);

    HashSet<Competence> listerCompetence(Long numEquipe) throws EquipeInexistanteException;
}
