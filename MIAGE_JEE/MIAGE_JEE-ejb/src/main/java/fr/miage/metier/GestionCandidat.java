/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.metier;

import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.*;
import fr.miage.entities.Candidat;
import fr.miage.entities.Candidature;
import fr.miage.entities.Equipe;
import fr.miage.entities.FichePoste;
import fr.miage.facades.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author ddias
 */
@Stateless
public class GestionCandidat implements GestionCandidatLocal {

    @EJB
    private CandidatFacadeLocal candidatFacade;

    @EJB
    private CollaborateurFacadeLocal collaborateurFacade;

    @EJB
    private CandidatureFacadeLocal candidatureFacade;

    @EJB
    private FichePosteFacadeLocal fichePosteFacade;

    @EJB
    private EquipeFacadeLocal equipeFacade;

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
            throw new CandidatInexistantException("Le candidat n'existe pas dans la base de données");

        FichePoste fp = fichePosteFacade.find(numFichePoste);
        if(fp == null)
            throw new FichePosteInexistanteException("Le poste à candidater n'existe pas");

        return candidatureFacade.creerCandidature(c, fp, Statut.EnAttente);
    }

    @Override
    public HashSet<Long> listerOffresDisponibles() {
        HashSet<Long> listeOffresDisponibles = new HashSet<>();

        for(FichePoste fp : fichePosteFacade.findAll()) {
            if(!fp.isArchivee())
                listeOffresDisponibles.add(fp.getId());
        }

        return listeOffresDisponibles;
    }

    @Override
    public FichePoste consulterDetailsOffre(Long idFichePoste) throws FichePosteInexistanteException {
        FichePoste fp = fichePosteFacade.find(idFichePoste);

        if(fp == null)
            throw new FichePosteInexistanteException("L'offre demandée n'existe pas");

        return fp;
    }

    @Override
    public List<Candidature> listerCandidatures() {
        return candidatureFacade.findAll();
    }

    @Override
    public Candidature sePrononcerSurCandidature(Long idCandidature, Statut statut) throws CandidatureInexistantException {
        Candidature cd = candidatureFacade.find(idCandidature);

        if(cd == null)
            throw new CandidatureInexistantException("La candidature n'existe pas dans la base de données");

        cd.setStatut(statut);
        return cd;
    }

    @Override
    public void changerStatutCandidature(Long idCandidature, Statut statut) throws CandidatureInexistantException {
        Candidature candidature = candidatureFacade.find(idCandidature);
        if(candidature == null)
            throw new CandidatureInexistantException("La candidature n'existe pas dans la base de données");

        candidature.setStatut(statut);
        candidatureFacade.edit(candidature);
    }

    @Override
    public List<Candidature> listerCandidaturesFeuVert() {
        ArrayList<Candidature> candidatures = new ArrayList<>();

        for(Candidature candidature : candidatureFacade.findAll()) {
            if(candidature.getStatut() == Statut.Accepte)
                candidatures.add(candidature);
        }

        return candidatures;
    }

    @Override
    public void concretiserEmbauche(Long idCandidature, Long idEquipe) throws CandidatureInexistantException, EquipeInexistanteException {
        Candidature candidature = candidatureFacade.find(idCandidature);
        if (candidature == null)
            throw new CandidatureInexistantException("La candidature n'existe pas dans la base de données");
        Equipe equipe = equipeFacade.find(idEquipe);
        if(equipe == null)
            throw new EquipeInexistanteException("L'équipe n'existe pas dans la base de données");

        candidature.getFichePoste().setArchivee(true);
        Candidat candidat = candidature.getCandidat();
        candidatFacade.remove(candidat);
        collaborateurFacade.creerCollaborateurFromCandidat(candidat, false, false, equipe);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
