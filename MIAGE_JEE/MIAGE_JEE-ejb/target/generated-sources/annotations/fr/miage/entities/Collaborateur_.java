package fr.miage.entities;

import fr.miage.entities.Competence;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-08T17:47:56")
@StaticMetamodel(Collaborateur.class)
public class Collaborateur_ { 

    public static volatile CollectionAttribute<Collaborateur, Competence> competences;
    public static volatile SingularAttribute<Collaborateur, Long> id;
    public static volatile SingularAttribute<Collaborateur, String> nom;
    public static volatile SingularAttribute<Collaborateur, String> prenom;
    public static volatile SingularAttribute<Collaborateur, String> status;

}