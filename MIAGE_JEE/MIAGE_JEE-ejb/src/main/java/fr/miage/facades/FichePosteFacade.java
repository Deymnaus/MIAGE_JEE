package fr.miage.facades;

import fr.miage.entities.Collaborateur;
import fr.miage.entities.DemandeCompetence;
import fr.miage.entities.FichePoste;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@Stateless
public class FichePosteFacade extends AbstractFacade<FichePoste> implements FichePosteFacadeLocal {

    @PersistenceContext(unitName = "fr.miage_MIAGE_JEE-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FichePosteFacade() {
        super(FichePoste.class);
    }

    @Override
    public void creerFichePoste(DemandeCompetence demandeCompetence, String presentationEntreprise, String presentationPoste) {
        FichePoste fp = new FichePoste();
        fp.setDemandeCompetence(demandeCompetence);
        fp.setPresentationEntreprise(presentationEntreprise);
        fp.setPresentationPoste(presentationPoste);
        this.create(fp);
    }

    @Override
    public HashSet<FichePoste> getPostesNonArchives() {
        HashSet<FichePoste> postesNonArchives = new HashSet<>();
        for(FichePoste fp : this.findAll()){
            if(!fp.isArchivee())
                postesNonArchives.add(fp);
        }

        return postesNonArchives;
    }
}
