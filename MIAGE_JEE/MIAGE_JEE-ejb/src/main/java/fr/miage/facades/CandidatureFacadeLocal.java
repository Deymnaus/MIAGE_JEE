package fr.miage.facades;

import fr.miage.entities.Candidat;
import fr.miage.entities.Candidature;
import fr.miage.entities.FichePoste;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.Statut;

import javax.ejb.Local;
import java.util.Collection;
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

    public Candidature creerCandidature(Candidat candidat, FichePoste fichePoste, Statut statut);

    Collection<Candidature> getCandidaturesRetenues();
}
