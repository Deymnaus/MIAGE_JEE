package fr.miage.facades;

import fr.miage.entities.DemandeCompetence;
import fr.miage.entities.FichePoste;

import javax.ejb.Local;
import java.util.Collection;
import java.util.List;

@Local
public interface FichePosteFacadeLocal {

    void create(FichePoste fichePoste);

    void edit(FichePoste fichePoste);

    void remove(FichePoste fichePoste);

    FichePoste find(Object id);

    List<FichePoste> findAll();

    List<FichePoste> findRange(int[] range);

    int count();

    public void creerFichePoste(DemandeCompetence demandeCompetence, String presentationEntreprise, String presentationPoste);

    Collection<FichePoste> getPostesNonArchives();
}
