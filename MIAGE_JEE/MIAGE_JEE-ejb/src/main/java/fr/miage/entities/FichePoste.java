package fr.miage.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class FichePoste implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "DEMANDECOMPETENCE_ID", referencedColumnName = "ID")
    @ManyToOne
    private DemandeCompetence demandeCompetence;

    private String presentationEntreprise;

    private String presentationPoste;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fichePoste")
    private List<Candidature> listeCandidature;

    public FichePoste() {
    }

    public FichePoste(DemandeCompetence demandeCompetence, String presentationEntreprise, String presentationPoste) {
        this.demandeCompetence = demandeCompetence;
        this.presentationEntreprise = presentationEntreprise;
        this.presentationPoste = presentationPoste;
    }

    public String getPresentationEntreprise() {
        return presentationEntreprise;
    }

    public void setPresentationEntreprise(String presentationEntreprise) {
        this.presentationEntreprise = presentationEntreprise;
    }

    public String getPresentationPoste() {
        return presentationPoste;
    }

    public void setPresentationPoste(String presentationPoste) {
        this.presentationPoste = presentationPoste;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DemandeCompetence getDemandeCompetence() {
        return demandeCompetence;
    }

    public void setDemandeCompetence(DemandeCompetence demandeCompetence) {
        this.demandeCompetence = demandeCompetence;
    }
}