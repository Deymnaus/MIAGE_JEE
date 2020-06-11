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
public class Candidat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nom;
    
    private String prenom;

    @ManyToMany
    private Collection<Competence> listeCompetences;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidat")
    private List<Candidature> listeCandidature;

    public Candidat() {
    }

    public Candidat(Long id, String nom, String prenom, Collection<Competence> listeCompetences) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.listeCompetences = listeCompetences;
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

    public Collection<Competence> getListeCompetences() {
        return listeCompetences;
    }

    public void setListeCompetences(Collection<Competence> listeCompetences) {
        this.listeCompetences = listeCompetences;
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
