package fr.miage.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
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
    private List<Collaborateur> collaborateurs;

    public Equipe(){

    }

    public Equipe(Long id, String nom, List<Collaborateur> collaborateurs){
        this.id = id;
        this.nom = nom;
        this.collaborateurs = collaborateurs;
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

    @XmlTransient
    public List<Collaborateur> getCollaborateurs() {
        return collaborateurs;
    }

    public void setCollaborateurs(List<Collaborateur> listeCollab) {
        this.collaborateurs = listeCollab;
    }
}
