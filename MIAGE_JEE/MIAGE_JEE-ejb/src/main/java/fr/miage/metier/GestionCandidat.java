/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.metier;

import fr.miage.entities.Candidat;
import fr.miage.entities.Candidature;
import fr.miage.entities.FichePoste;
import fr.miage.entities.Statut;
import fr.miage.exception.CandidatInexistantException;
import fr.miage.exception.FichePosteInexistanteException;
import fr.miage.facades.CandidatFacadeLocal;
import fr.miage.facades.CandidatureFacadeLocal;
import fr.miage.facades.FichePosteFacadeLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ddias
 */
@Stateless
public class GestionCandidat implements GestionCandidatLocal {

    @EJB
    private CandidatFacadeLocal candidatFacade;

    @EJB
    private CandidatureFacadeLocal candidatureFacade;

    @EJB
    private FichePosteFacadeLocal fichePosteFacade;

    @Override
    public void creerCandidat(String nom, String prenom) {
        this.candidatFacade.creerCandidat(nom, prenom);
    }

    @Override
    public Candidat getCandidat(long idCandidat) {
        return this.candidatFacade.find(idCandidat);
    }

    @Override
    public Candidature proposerCandidature(Long numCandidat, Long numFichePoste) throws CandidatInexistantException, FichePosteInexistanteException {
        Candidat c = candidatFacade.find(numCandidat);
        if(c == null)
            throw new CandidatInexistantException("Le candidat n\'existe pas dans la base de données");

        FichePoste fp = fichePosteFacade.find(numFichePoste);
        if(fp == null)
            throw new FichePosteInexistanteException("Le poste à candidater n\'existe pas");

        return candidatureFacade.creerCandidature(c, fp, Statut.EnAttente);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
