/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.andrea.christophe.m1.jee.miage_jee.shr.utilities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.OneToMany;

/**
 *
 * @author andreachristophe
 */
public class CandidatExport implements Serializable {
    
    private Long id;
    
    private String nom;
    
    private String prenom;
    
    @OneToMany
    private Collection<CompetenceExport> competences;

    public CandidatExport() {
    }

    public CandidatExport(Long id, String nom, String prenom, Collection<CompetenceExport> competences) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.competences = competences;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Collection<CompetenceExport> getCompetences() {
        return competences;
    }

    public void setCompetences(Collection<CompetenceExport> competences) {
        this.competences = competences;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CandidatExport)) {
            return false;
        }
        CandidatExport other = (CandidatExport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.entities.Candidat[ id=" + id + " ]";
    }
}
