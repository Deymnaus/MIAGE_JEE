package fr.miage.facades;

import fr.miage.entities.Candidat;
import fr.miage.entities.Candidature;
import fr.miage.entities.FichePoste;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CandidatureFacadeLocal {

    void create(Candidature candidature);

    void edit(Candidature candidature);

    void remove(Candidature candidature);

    Candidature find(Object id);

    List<Candidature> findAll();

    List<Candidature> findRange(int[] range);

    int count();

    public void creerCandidature(Candidat candidat, FichePoste fichePoste);

}
