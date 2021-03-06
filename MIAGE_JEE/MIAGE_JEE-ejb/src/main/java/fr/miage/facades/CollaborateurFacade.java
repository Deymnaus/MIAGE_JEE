package fr.miage.facades;

import fr.miage.entities.Candidat;
import fr.miage.entities.Collaborateur;
import fr.miage.entities.Competence;
import fr.miage.entities.Equipe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Stateless
public class CollaborateurFacade extends AbstractFacade<Collaborateur> implements CollaborateurFacadeLocal {

    @PersistenceContext(unitName = "fr.miage_MIAGE_JEE-ejb_ejb_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CollaborateurFacade() {
        super(Collaborateur.class);
    }

    @Override
    public void creerCollaborateur(String nom, String prenom, boolean codir, boolean manager, Equipe equipe) {
        Collaborateur clb = new Collaborateur();
        clb.setNom(nom);
        clb.setPrenom(prenom);
        clb.setCompetences(new ArrayList<Competence>());
        clb.setCodir(codir);
        clb.setManager(manager);
        clb.setEquipe(equipe);
        this.create(clb);
    }

    @Override
    public void creerCollaborateurFromCandidat(Candidat candidat, boolean codir, boolean manager, Equipe equipe){
        Collaborateur clb = new Collaborateur();
        clb.setId(candidat.getId());
        clb.setNom(candidat.getNom());
        clb.setPrenom(candidat.getPrenom());
        clb.setCompetences(candidat.getCompetences());
        clb.setCodir(codir);
        clb.setManager(manager);
        clb.setEquipe(equipe);
        this.create(clb);
    }

    @Override
    public ArrayList<Competence> listerCompetence(Collaborateur collaborateur) {
        return new ArrayList<>(collaborateur.getCompetences());
    }
}
