package fr.miage.facades;

import fr.miage.entities.Collaborateur;
import fr.miage.entities.Equipe;
import fr.miage.entities.Equipe;

import javax.ejb.Local;
import java.util.ArrayList;
import java.util.List;

@Local
public interface EquipeFacadeLocal {

    void create(Equipe equipe);

    void edit(Equipe equipe);

    void remove(Equipe equipe);

    Equipe find(Object id);

    List<Equipe> findAll();

    List<Equipe> findRange(int[] range);

    int count();

    public void creerEquipe(String nom);

    ArrayList<Collaborateur> listerCollaborateur(Equipe eq);
}
