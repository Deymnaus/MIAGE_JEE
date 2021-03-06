/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.metier;

import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.*;
import fr.miage.entities.Competence;
import fr.miage.entities.DemandeCompetence;
import fr.miage.entities.Equipe;
import fr.miage.facades.*;
import fr.miage.utils.Traducteur;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author ddias
 */
@Stateless
public class GestionDemandeCompetence implements GestionDemandeCompetenceLocal {

    @EJB
    private DemandeCompetenceFacadeLocal demandeCompetenceFacade;

    @EJB
    private CompetenceFacadeLocal competenceFacade;

    @EJB
    private EquipeFacadeLocal equipeFacade;

    @EJB
    private CollaborateurFacadeLocal collaborateurFacade;

    @EJB
    private FichePosteFacadeLocal fichePosteFacade;

    
    @Override
    public void creerCompetence(String nom, String description) {
        
        Competence cpt = new Competence();
        cpt.setNom(nom);
        cpt.setDescription(description);
        
        this.competenceFacade.create(cpt);
    }

    @Override
    public Competence getCompetence(long idCompetence) {
        return this.competenceFacade.find(idCompetence);
    }

    @Override
    public DemandeCompetence demanderCompetence(Long numEquipe, ArrayList<Long> listeIdCompetence) throws EquipeInexistanteException, CompetenceInexistanteException {
        HashSet<Competence> listeCompetences = new HashSet<>();
        Competence c;
        Equipe eq = equipeFacade.find(numEquipe);

        if(eq == null)
            throw new EquipeInexistanteException("L'équipe n'existe pas dans la base de données");

        for(Long id : listeIdCompetence){
            c = competenceFacade.find(id);

            if(c == null){
                throw new CompetenceInexistanteException("La compétence ne fait pas partie de la base de données et ne peut pas être demandée");
            }

            listeCompetences.add(c);
        }

        return demandeCompetenceFacade.creerDemandeCompetence(new ArrayList<>(listeCompetences), eq, Etat.EnAttente);
    }

    @Override
    public HashSet<DemandeCompetence> listerCompetenceACombler() {
        HashSet<DemandeCompetence> listeCompetenceACombler = new HashSet<>();

        for (DemandeCompetence dc : demandeCompetenceFacade.findAll()){
            if(dc.getEtat() == Etat.EnAttente)
                listeCompetenceACombler.add(dc);
        }
        return listeCompetenceACombler;
    }

    @Override
    public DemandeCompetence comblerCompetence(Long idDemandeCompetence) throws DemandeCompetenceInexistanteException {
        DemandeCompetence dc = demandeCompetenceFacade.find(idDemandeCompetence);
        if(dc == null)
            throw new DemandeCompetenceInexistanteException("La demande de competence à combler est inconnue dans la base de données");

        dc.setEtat(Etat.Servie);
        return dc;
    }

    @Override
    public HashSet<DemandeCompetenceExport> listerCompetencesDemandeesEquipes() {
        return new HashSet<>(Traducteur.listeDemandeCompetenceToDemandeCompetenceExport(demandeCompetenceFacade.findAll()));
    }

    @Override
    public HashSet<CollaborateurExport> listerCompetencesCollaborateurs() {
        return new HashSet<>(Traducteur.listeCollaborateurToListeCollaborateurExport(collaborateurFacade.findAll()));
    }

    @Override
    public int proposerFichePoste(Long idDemandeCompetence, String presentationPoste, String presentationEntreprise){
        DemandeCompetence demandeCompetence = demandeCompetenceFacade.find(idDemandeCompetence);

        if(demandeCompetence == null){
            return 0;
        }

        demandeCompetence.setEtat(Etat.Servie);
        demandeCompetenceFacade.edit(demandeCompetence);
        fichePosteFacade.creerFichePoste(demandeCompetence, presentationEntreprise, presentationPoste);
        return 1;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
