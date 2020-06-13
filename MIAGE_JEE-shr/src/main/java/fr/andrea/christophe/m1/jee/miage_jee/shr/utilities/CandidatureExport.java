package fr.andrea.christophe.m1.jee.miage_jee.shr.utilities;

import java.io.Serializable;

public class CandidatureExport implements Serializable {

    private Long id;

    private Statut statut;

    private CandidatExport candidatExport;

    private FichePosteExport fichePosteExport;

    public CandidatureExport() {
    }

    public CandidatureExport(Long id, Statut statut, CandidatExport candidatExport, FichePosteExport fichePosteExport) {
        this.id = id;
        this.statut = statut;
        this.candidatExport = candidatExport;
        this.fichePosteExport = fichePosteExport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public CandidatExport getCandidatExport() {
        return candidatExport;
    }

    public void setCandidatExport(CandidatExport candidatExport) {
        this.candidatExport = candidatExport;
    }

    public FichePosteExport getFichePosteExport() {
        return fichePosteExport;
    }

    public void setFichePosteExport(FichePosteExport fichePosteExport) {
        this.fichePosteExport = fichePosteExport;
    }
}
