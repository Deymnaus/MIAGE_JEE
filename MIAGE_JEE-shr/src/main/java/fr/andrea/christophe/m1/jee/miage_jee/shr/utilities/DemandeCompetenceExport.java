package fr.andrea.christophe.m1.jee.miage_jee.shr.utilities;

import java.io.Serializable;
import java.util.List;

public class DemandeCompetenceExport implements Serializable {

    private Long id;

    private Etat etat;

    private List<CompetenceExport> competenceExportList;

    private EquipeExport equipeExport;

    private List<FichePosteExport> fichePosteExports;

    public DemandeCompetenceExport() {
    }

    public DemandeCompetenceExport(Long id, Etat etat, List<CompetenceExport> competenceExportList, EquipeExport equipeExport, List<FichePosteExport> fichePosteExports) {
        this.id = id;
        this.etat = etat;
        this.competenceExportList = competenceExportList;
        this.equipeExport = equipeExport;
        this.fichePosteExports = fichePosteExports;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public List<CompetenceExport> getCompetenceExportList() {
        return competenceExportList;
    }

    public void setCompetenceExportList(List<CompetenceExport> competenceExportList) {
        this.competenceExportList = competenceExportList;
    }

    public EquipeExport getEquipeExport() {
        return equipeExport;
    }

    public void setEquipeExport(EquipeExport equipeExport) {
        this.equipeExport = equipeExport;
    }

    public List<FichePosteExport> getFichePosteExports() {
        return fichePosteExports;
    }

    public void setFichePosteExports(List<FichePosteExport> fichePosteExports) {
        this.fichePosteExports = fichePosteExports;
    }
}
