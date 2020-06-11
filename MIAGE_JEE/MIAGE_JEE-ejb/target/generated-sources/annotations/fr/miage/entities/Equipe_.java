package fr.miage.entities;

import fr.miage.entities.Collaborateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-11T17:19:29")
@StaticMetamodel(Equipe.class)
public class Equipe_ { 

    public static volatile SingularAttribute<Equipe, Long> id;
    public static volatile SingularAttribute<Equipe, String> nom;
    public static volatile ListAttribute<Equipe, Collaborateur> listeCollab;

}