package fr.andrea.christophe.m1.jee.miage_jee.shr.utilities;

import java.io.Serializable;
import java.util.Collection;

public class CollaborateurExport extends CandidatExport implements Serializable {

    private boolean codir;

    private boolean manager;

    private EquipeExport equipeExport;

    public CollaborateurExport() {
    }

    public CollaborateurExport(Long id, String nom, String prenom, Collection<CompetenceExport> competences, boolean codir, boolean manager, EquipeExport equipeExport) {
        super(id, nom, prenom, competences);
        this.codir = codir;
        this.manager = manager;
        this.equipeExport = equipeExport;
    }

    public boolean isCodir() {
        return codir;
    }

    public void setCodir(boolean codir) {
        this.codir = codir;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public EquipeExport getEquipeExport() {
        return equipeExport;
    }

    public void setEquipeExport(EquipeExport equipeExport) {
        this.equipeExport = equipeExport;
    }
}
