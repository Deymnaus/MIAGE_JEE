package fr.miage.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity
public class DemandeCompetence implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Etat etat;

    @ManyToMany
    private List<Competence> competences;

    @OneToOne
    private Equipe equipe;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "demandeCompetence")
    private List<FichePoste> fichePostes;

    public DemandeCompetence() {
    }

    public DemandeCompetence(List<Competence> competences, Equipe equipe, Etat etat) {
        this.competences = competences;
        this.equipe = equipe;
        this.etat = etat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> listeCompetence) {
        this.competences = listeCompetence;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    @XmlTransient
    public List<FichePoste> getFichePostes() {
        return fichePostes;
    }

    public void setFichePostes(List<FichePoste> listeFichePoste) {
        this.fichePostes = listeFichePoste;
    }
}
