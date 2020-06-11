package fr.miage.entities;

import fr.miage.entities.Equipe;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-11T18:58:09")
@StaticMetamodel(Collaborateur.class)
public class Collaborateur_ extends Candidat_ {

    public static volatile SingularAttribute<Collaborateur, Boolean> manager;
    public static volatile SingularAttribute<Collaborateur, Boolean> codir;
    public static volatile SingularAttribute<Collaborateur, Equipe> equipe;

}