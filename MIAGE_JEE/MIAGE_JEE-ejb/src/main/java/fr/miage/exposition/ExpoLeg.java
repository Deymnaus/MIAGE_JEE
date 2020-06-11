/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.exposition;

import fr.miage.entities.Competence;
import fr.miage.entities.DemandeCompetence;
import fr.miage.entities.Equipe;
import fr.miage.metier.MetierCandidatLocal;
import fr.miage.metier.MetierCollaborateurLocal;
import fr.miage.metier.MetierCompetenceLocal;
import fr.miage.metier.GestionEquipeLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author ddias
 */
@Stateless
public class ExpoLeg implements ExpoLegLocal {

    @EJB
    private MetierCandidatLocal metierCandidat;

    @EJB
    private MetierCompetenceLocal metierCompetence;

    @EJB
    private MetierCollaborateurLocal metierCollaborateur;

    @EJB
    private GestionEquipeLocal gestionEquipe;


    // Manager

    /**
     *
     * @param numEquipe
     * @return
     */
    @Override
    public HashSet<Competence> listerCompetence(Long numEquipe) {
        return gestionEquipe.listerCompetence(numEquipe);
    }

    /**
     *
     * @param numEquipe
     * @param listeIdCompetence
     * @return
     */
    @Override
    public DemandeCompetence demanderCompetence(Long numEquipe, ArrayList<Integer> listeIdCompetence) {
        return null;
    }

    // Codir

    // Candidat

    // CEO

}
