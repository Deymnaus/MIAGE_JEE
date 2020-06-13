package fr.miage.metier;

import fr.miage.facades.CandidatureFacadeLocal;
import fr.miage.facades.DemandeCompetenceFacadeLocal;
import fr.miage.facades.FichePosteFacadeLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class GestionStatistique implements GestionStatistiqueLocal {

    @EJB
    private DemandeCompetenceFacadeLocal demandeCompetenceFacade;

    @EJB
    private FichePosteFacadeLocal fichePosteFacade;

    @EJB
    private CandidatureFacadeLocal candidatureFacade;

    @Override
    public String recolterStatistiques() {
        String statistiques = "";

        statistiques += "- Nombre de demandes de compétences non servies : " + demandeCompetenceFacade.getDemandeCompetenceEnSouffrance().size() + "\n";
        statistiques += "- Nombre de postes proposés (non archivés / total) : " + fichePosteFacade.getPostesNonArchives().size() + "/" + fichePosteFacade.findAll().size() + "\n";
        statistiques += "- Nombre de candidatures (retenues / total) : " + candidatureFacade.getCandidaturesRetenues().size() + "/" + candidatureFacade.findAll().size() + "\n";

        return statistiques;
    }
}
