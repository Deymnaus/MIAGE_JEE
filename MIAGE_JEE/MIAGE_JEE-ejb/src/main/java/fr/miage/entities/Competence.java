/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author ddias
 */
@Entity
public class Competence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nom;
    
    private String description;

    @ManyToMany(mappedBy = "listeCompetences")
    private Collection<Candidat> listeCandidat;

    @ManyToMany(mappedBy = "listeCompetence")
    private Collection<DemandeCompetence> listeDemandeCompetence;

    public Competence() {
    }

    public Competence(Long id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nomCompetence) {
        this.nom = nomCompetence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descriptionCompetence) {
        this.description = descriptionCompetence;
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
        if (!(object instanceof Competence)) {
            return false;
        }
        Competence other = (Competence) object;
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
