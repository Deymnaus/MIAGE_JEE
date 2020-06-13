package fr.andrea.christophe.m1.jee.miage_jee.shr.utilities;

import java.io.Serializable;
import java.util.List;

public class EquipeExport implements Serializable {

    private Long id;

    private String nom;

    private List<CollaborateurExport> collaborateurExports;

    public EquipeExport() {
    }

    public EquipeExport(Long id, String nom, List<CollaborateurExport> collaborateurExports) {
        this.id = id;
        this.nom = nom;
        this.collaborateurExports = collaborateurExports;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<CollaborateurExport> getCollaborateurExports() {
        return collaborateurExports;
    }

    public void setCollaborateurExports(List<CollaborateurExport> collaborateurExports) {
        this.collaborateurExports = collaborateurExports;
    }
}
