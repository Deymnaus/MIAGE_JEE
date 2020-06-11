package fr.miage.facades;

import fr.miage.entities.Competence;
import fr.miage.entities.DemandeCompetence;
import fr.miage.entities.Equipe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DemandeCompetenceFacade extends AbstractFacade<DemandeCompetence> implements DemandeCompetenceFacadeLocal {

    @PersistenceContext(unitName = "fr.miage_MIAGE_JEE-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DemandeCompetenceFacade() {
        super(DemandeCompetence.class);
    }

    @Override
    public void creerDemandeCompetence(List<Competence> listeCompetence, Equipe equipe) {
        DemandeCompetence dc = new DemandeCompetence();
        dc.setListeCompetence(listeCompetence);
        dc.setEquipe(equipe);
        this.create(dc);
    }
}
