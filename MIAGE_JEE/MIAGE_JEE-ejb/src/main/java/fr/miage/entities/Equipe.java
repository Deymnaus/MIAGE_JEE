package fr.miage.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Equipe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipe")
    private List<Collaborateur> listeCollab;

    public Equipe(){

    }

    public Equipe(Long id, String nom, List<Collaborateur> listeCollab){
        this.id = id;
        this.nom = nom;
        this.listeCollab = listeCollab;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Collaborateur> getListeCollab() {
        return listeCollab;
    }

    public void setListeCollab(List<Collaborateur> listeCollab) {
        this.listeCollab = listeCollab;
    }
}
