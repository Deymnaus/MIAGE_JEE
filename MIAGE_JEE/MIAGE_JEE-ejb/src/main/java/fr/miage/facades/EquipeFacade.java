package fr.miage.facades;

import fr.miage.entities.Collaborateur;
import fr.miage.entities.Equipe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Stateless
public class EquipeFacade extends AbstractFacade<Equipe> implements EquipeFacadeLocal {

    @PersistenceContext(unitName = "fr.miage_MIAGE_JEE-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipeFacade() {
        super(Equipe.class);
    }

    @Override
    public void creerEquipe(String nom) {
        Equipe e = new Equipe();
        e.setNom(nom);
        e.setListeCollab(new ArrayList<Collaborateur>());
        this.create(e);
    }

    @Override
    public ArrayList<Collaborateur> listerCollaborateur(Equipe eq) {
        return new ArrayList<>(eq.getListeCollab());
    }
}
