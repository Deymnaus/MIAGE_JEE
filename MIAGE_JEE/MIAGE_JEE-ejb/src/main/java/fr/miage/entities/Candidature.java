package fr.miage.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Candidature implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "CANDIDAT_ID", referencedColumnName = "ID")
    @ManyToOne
    private Candidat candidat;

    @JoinColumn(name = "FICHEPOSTE_ID", referencedColumnName = "ID")
    @ManyToOne
    private FichePoste fichePoste;

    public Candidature() {
    }

    public Candidature(Candidat candidat, FichePoste fichePoste) {
        this.candidat = candidat;
        this.fichePoste = fichePoste;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public FichePoste getFichePoste() {
        return fichePoste;
    }

    public void setFichePoste(FichePoste fichePoste) {
        this.fichePoste = fichePoste;
    }
}
