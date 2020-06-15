/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author ddias
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Candidat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    private String nom;
    
    private String prenom;

    @ManyToMany
    private Collection<Competence> competences;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidat")
    private List<Candidature> candidatures;

    public Candidat() {
    }

    public Candidat(Long id, String nom, String prenom, Collection<Competence> competences) {
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

    public Collection<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(Collection<Competence> listeCompetences) {
        this.competences = listeCompetences;
    }

    public Long getId() {
        return id;
    }

    public Candidat setId(Long id) {
        this.id = id;
        return this;
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
        if (!(object instanceof Candidat)) {
            return false;
        }
        Candidat other = (Candidat) object;
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
