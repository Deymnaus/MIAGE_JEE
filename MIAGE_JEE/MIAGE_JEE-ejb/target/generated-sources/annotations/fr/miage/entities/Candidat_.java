package fr.miage.entities;

import fr.miage.entities.Candidature;
import fr.miage.entities.Competence;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-11T02:57:33")
@StaticMetamodel(Candidat.class)
public class Candidat_ { 

    public static volatile CollectionAttribute<Candidat, Competence> listeCompetences;
    public static volatile ListAttribute<Candidat, Candidature> listeCandidature;
    public static volatile SingularAttribute<Candidat, Long> id;
    public static volatile SingularAttribute<Candidat, String> nom;
    public static volatile SingularAttribute<Candidat, String> prenom;

}