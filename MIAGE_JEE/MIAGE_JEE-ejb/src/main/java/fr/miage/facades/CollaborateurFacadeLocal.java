package fr.miage.facades;

import fr.miage.entities.Collaborateur;
import fr.miage.entities.Competence;
import fr.miage.entities.Equipe;

import javax.ejb.Local;
import java.util.ArrayList;
import java.util.List;

@Local
public interface CollaborateurFacadeLocal{
    void create(Collaborateur collaborateur);

    void edit(Collaborateur collaborateur);

    void remove(Collaborateur collaborateur);

    Collaborateur find(Object id);

    List<Collaborateur> findAll();

    List<Collaborateur> findRange(int[] range);

    int count();

    public void creerCollaborateur(String nom, String prenom, boolean codir, boolean manager, Equipe equipe);

    ArrayList<Competence> listerCompetence(Collaborateur collaborateur);
}
