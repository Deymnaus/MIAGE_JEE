/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.metier;

import fr.miage.entities.Collaborateur;
import fr.miage.entities.Equipe;

import javax.ejb.Local;

/**
 *
 * @author ddias
 */
@Local
public interface MetierCollaborateurLocal {
    
    public void creerCollaborateur(String nom, String prenom, boolean codir, boolean manager, Equipe equipe);
    public Collaborateur getCollaborateur(Long idCollaborateur);
    
}
