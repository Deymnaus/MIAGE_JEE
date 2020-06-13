/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.metier;

import fr.miage.entities.Collaborateur;
import fr.miage.entities.Competence;
import fr.miage.entities.Equipe;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.EquipeInexistanteException;
import fr.miage.facades.CollaborateurFacadeLocal;
import fr.miage.facades.EquipeFacadeLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author ddias
 */
@Stateless
public class GestionEquipe implements GestionEquipeLocal {

    @EJB
    private EquipeFacadeLocal equipeFacade;

    @EJB
    private CollaborateurFacadeLocal collaborateurFacade;


    @Override
    public void creerEquipe(String nom) {
        Equipe eq = new Equipe();
        eq.setNom(nom);

        this.equipeFacade.create(eq);
    }

    @Override
    public Equipe getEquipe(Long idEquipe) {
        return this.equipeFacade.find(idEquipe);
    }

    @Override
    public HashSet<Competence> listerCompetence(Long numEquipe) throws EquipeInexistanteException {
        HashSet<Competence> listCompetence = new HashSet<>();
        Equipe eq = getEquipe(numEquipe);

        if(eq == null)
            throw new EquipeInexistanteException("L\'équipe n\'existe pas dans la base de données");

        ArrayList<Collaborateur> listCollab = equipeFacade.listerCollaborateur(eq);
        for(Collaborateur c : listCollab){
            listCompetence.addAll(collaborateurFacade.listerCompetence(c));
        }

        return listCompetence;
    }


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
