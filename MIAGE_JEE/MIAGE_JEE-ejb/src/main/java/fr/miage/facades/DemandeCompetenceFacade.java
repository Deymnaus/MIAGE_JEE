package fr.miage.facades;

import fr.miage.entities.Competence;
import fr.miage.entities.DemandeCompetence;
import fr.miage.entities.Equipe;
import fr.miage.entities.Etat;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
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
    public DemandeCompetence creerDemandeCompetence(List<Competence> listeCompetence, Equipe equipe, Etat etat) {
        DemandeCompetence dc = new DemandeCompetence();
        dc.setCompetences(listeCompetence);
        dc.setEquipe(equipe);
        dc.setEtat(etat);
        this.create(dc);
        return dc;
    }

    @Override
    public HashSet<DemandeCompetence> getDemandeCompetenceEnSouffrance() {
        HashSet<DemandeCompetence> demandeCompetencesEnSouffrance = new HashSet<>();
        for (DemandeCompetence dc : this.findAll()) {
            if (dc.getEtat() == Etat.EnAttente)
                demandeCompetencesEnSouffrance.add(dc);
        }
        return demandeCompetencesEnSouffrance;
    }
}
