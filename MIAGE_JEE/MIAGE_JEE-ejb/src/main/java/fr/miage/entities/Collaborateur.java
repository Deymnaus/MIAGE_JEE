package fr.miage.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Collaborateur extends Candidat implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean codir;

    private boolean manager;

    @JoinColumn(name = "EQUIPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Equipe equipe;

    public Collaborateur() {

    }

    public Collaborateur(boolean codir, boolean manager, Equipe equipe){
        this.codir = codir;
        this.manager = manager;
        this.equipe = equipe;
    }

    public boolean isCodir() {
        return codir;
    }

    public void setCodir(boolean codir) {
        this.codir = codir;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
