package fr.miage.facades;

import fr.miage.entities.Competence;
import fr.miage.entities.DemandeCompetence;
import fr.miage.entities.Equipe;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DemandeCompetenceFacadeLocal {

    void create(DemandeCompetence demandeCompetence);

    void edit(DemandeCompetence demandeCompetence);

    void remove(DemandeCompetence demandeCompetence);

    DemandeCompetence find(Object id);

    List<DemandeCompetence> findAll();

    List<DemandeCompetence> findRange(int[] range);

    int count();

    public void creerDemandeCompetence(List<Competence> listeCompetence, Equipe equipe);

}
