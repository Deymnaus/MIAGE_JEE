/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.metier;

import fr.miage.entities.Competence;
import javax.ejb.Local;

/**
 *
 * @author ddias
 */
@Local
public interface MetierCompetenceLocal {
    
    public void creerCompetence(String nom, String description);
    public Competence getCompetence(long idCompetence);
    
}
