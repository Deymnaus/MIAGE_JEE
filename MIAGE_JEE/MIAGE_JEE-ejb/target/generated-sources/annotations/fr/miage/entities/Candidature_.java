package fr.miage.entities;

import fr.miage.entities.Candidat;
import fr.miage.entities.FichePoste;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-11T01:46:00")
@StaticMetamodel(Candidature.class)
public class Candidature_ { 

    public static volatile SingularAttribute<Candidature, Candidat> candidat;
    public static volatile SingularAttribute<Candidature, Long> id;
    public static volatile SingularAttribute<Candidature, FichePoste> fichePoste;

}