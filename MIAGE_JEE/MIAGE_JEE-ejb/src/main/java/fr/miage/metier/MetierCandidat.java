/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.metier;

import fr.miage.entities.Candidat;
import fr.miage.facades.CandidatFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ddias
 */
@Stateless
public class MetierCandidat implements MetierCandidatLocal {

    @EJB
    private CandidatFacadeLocal candidatFacade;

    @Override
    public void creerCandidat(String nom, String prenom) {
        this.candidatFacade.creerCandidat(nom, prenom);
    }

    @Override
    public Candidat getCandidat(long idCandidat) {
        return this.candidatFacade.find(idCandidat);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
