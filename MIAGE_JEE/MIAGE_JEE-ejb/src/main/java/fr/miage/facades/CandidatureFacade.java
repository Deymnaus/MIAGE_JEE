package fr.miage.facades;

import fr.miage.entities.Candidat;
import fr.miage.entities.Candidature;
import fr.miage.entities.FichePoste;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public void creerCandidature(Candidat candidat, FichePoste fichePoste) {
        Candidature c = new Candidature();
        c.setCandidat(candidat);
        c.setFichePoste(fichePoste);
        this.create(c);
    }
}
