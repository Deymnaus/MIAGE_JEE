/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.exposition;

import fr.miage.entities.Candidature;
import fr.miage.entities.Competence;
import fr.miage.entities.DemandeCompetence;
import fr.miage.entities.FichePoste;
import fr.miage.exception.*;
import fr.miage.metier.*;

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
    private GestionCandidatLocal gestionCandidat;

    @EJB
    private GestionEquipeLocal gestionEquipe;

    @EJB
    private GestionDemandeCompetenceLocal gestionDemandeCompetence;

    @EJB
    private GestionStatistiqueLocal gestionStatistique;


    // Manager

    /**
     *
     * @param numEquipe
     * @return
     */
    @Override
    public HashSet<Competence> listerCompetence(Long numEquipe) {
        HashSet<Competence> listeCompetence = new HashSet<>();
        try {
            listeCompetence = gestionEquipe.listerCompetence(numEquipe);
        } catch (EquipeInexistanteException e) {
            e.printStackTrace();
        }
        return listeCompetence;
    }

    /**
     *
     * @param numEquipe
     * @param listeIdCompetence
     * @return
     */
    @Override
    public DemandeCompetence demanderCompetence(Long numEquipe, ArrayList<Long> listeIdCompetence) {
        DemandeCompetence dc = new DemandeCompetence();
        try {
            dc =  gestionDemandeCompetence.demanderCompetence(numEquipe, listeIdCompetence);
        } catch (EquipeInexistanteException | CompetenceInexistanteException e) {
            e.printStackTrace();
        }
        return dc;

    }

    // Codir

    @Override
    public HashSet<DemandeCompetence> listerCompetenceACombler() {
        return gestionDemandeCompetence.listerCompetenceACombler();
    }

    @Override
    public DemandeCompetence comblerCompetence(Long idDemandeCompetence) {
        DemandeCompetence dc = new DemandeCompetence();
        try{
            dc = gestionDemandeCompetence.comblerCompetence(idDemandeCompetence);
        } catch (DemandeCompetenceInexistanteException e){
            e.printStackTrace();
        }
        return dc;
    }

    // Candidat

    @Override
    public Candidature proposerCandidature(Long numCandidat, Long numFichePoste) {
        Candidature c = new Candidature();
        try {
            c = gestionCandidat.proposerCandidature(numCandidat, numFichePoste);
        } catch (CandidatInexistantException | FichePosteInexistanteException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public HashSet<Long> listerOffresDisponibles() {
        return gestionCandidat.listerOffresDisponibles();
    }

    @Override
    public FichePoste consulterDetailsOffre(Long idFichePoste) {
        FichePoste fp = new FichePoste();
        try {
            fp = gestionCandidat.consulterDetailsOffre(idFichePoste);
        } catch (FichePosteInexistanteException e) {
            e.printStackTrace();
        }
        return fp;
    }

    // Manager
    @Override
    public String recolterStatistiques() {
        return gestionStatistique.recolterStatistiques();
    }

    // CEO

}
