package fr.andrea.christophe.m1.jee.miage_jee.shr.utilities;

import java.io.Serializable;
import java.util.List;

public class FichePosteExport implements Serializable {

    private Long id;

    private DemandeCompetenceExport demandeCompetenceExport;

    private String presentationEntreprise;

    private String prensentationPoste;

    private boolean archivee;

    private List<CandidatureExport> candidatureExports;

    public FichePosteExport() {
    }

    public FichePosteExport(Long id, DemandeCompetenceExport demandeCompetenceExport, String presentationEntreprise, String prensentationPoste, boolean archivee, List<CandidatureExport> candidatureExports) {
        this.id = id;
        this.demandeCompetenceExport = demandeCompetenceExport;
        this.presentationEntreprise = presentationEntreprise;
        this.prensentationPoste = prensentationPoste;
        this.archivee = archivee;
        this.candidatureExports = candidatureExports;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DemandeCompetenceExport getDemandeCompetenceExport() {
        return demandeCompetenceExport;
    }

    public void setDemandeCompetenceExport(DemandeCompetenceExport demandeCompetenceExport) {
        this.demandeCompetenceExport = demandeCompetenceExport;
    }

    public String getPresentationEntreprise() {
        return presentationEntreprise;
    }

    public void setPresentationEntreprise(String presentationEntreprise) {
        this.presentationEntreprise = presentationEntreprise;
    }

    public String getPrensentationPoste() {
        return prensentationPoste;
    }

    public void setPrensentationPoste(String prensentationPoste) {
        this.prensentationPoste = prensentationPoste;
    }

    public boolean isArchivee() {
        return archivee;
    }

    public void setArchivee(boolean archivee) {
        this.archivee = archivee;
    }

    public List<CandidatureExport> getCandidatureExports() {
        return candidatureExports;
    }

    public void setCandidatureExports(List<CandidatureExport> candidatureExports) {
        this.candidatureExports = candidatureExports;
    }
}
