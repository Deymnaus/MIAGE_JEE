/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.andrea.christophe.m1.jee.miage_jee.shr.utilities;

import java.io.Serializable;

/**
 *
 * @author andreachristophe
 */
public class CompetenceExport implements Serializable {
    
    private Long id;
    
    private String nom;
    
    private String description;

    public CompetenceExport() {
    }   

    public CompetenceExport(Long id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public CompetenceExport setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof CompetenceExport)) {
            return false;
        }
        CompetenceExport other = (CompetenceExport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fr.miage.entities.Competence[ id=" + id + " ]";
    }
}
