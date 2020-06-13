package fr.miage.facades;

import fr.miage.entities.Candidat;
import fr.miage.entities.Candidature;
import fr.miage.entities.FichePoste;
import fr.miage.entities.Statut;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.HashSet;

@Stateless
public class CandidatureFacade extends AbstractFacade<Candidature> implements CandidatureFacadeLocal {

    @PersistenceContext(unitName = "fr.miage_MIAGE_JEE-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CandidatureFacade() {
        super(Candidature.class);
    }

    @Override
    public Candidature creerCandidature(Candidat candidat, FichePoste fichePoste, Statut statut) {
        Candidature c = new Candidature();
        c.setCandidat(candidat);
        c.setFichePoste(fichePoste);
        c.setStatut(statut);
        this.create(c);
        return c;
    }

    @Override
    public HashSet<Candidature> getCandidaturesRetenues() {
        HashSet<Candidature> candidaturesRetenues = new HashSet<>();
        for(Candidature c : this.findAll()){
            if(c.getStatut() == Statut.Accepte)
                candidaturesRetenues.add(c);
        }
        return candidaturesRetenues;
    }
}
