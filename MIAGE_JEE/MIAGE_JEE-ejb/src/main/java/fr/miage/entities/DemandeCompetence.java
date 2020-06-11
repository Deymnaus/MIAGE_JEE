package fr.miage.entities;

import javax.persistence.*;
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
    private List<Competence> listeCompetence;

    @OneToOne
    private Equipe equipe;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "demandeCompetence")
    private List<FichePoste> listeFichePoste;

    public DemandeCompetence() {
    }

    public DemandeCompetence(List<Competence> listeCompetence, Equipe equipe, Etat etat) {
        this.listeCompetence = listeCompetence;
        this.equipe = equipe;
        this.etat = etat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Competence> getListeCompetence() {
        return listeCompetence;
    }

    public void setListeCompetence(List<Competence> listeCompetence) {
        this.listeCompetence = listeCompetence;
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

    public List<FichePoste> getListeFichePoste() {
        return listeFichePoste;
    }

    public void setListeFichePoste(List<FichePoste> listeFichePoste) {
        this.listeFichePoste = listeFichePoste;
    }
}
