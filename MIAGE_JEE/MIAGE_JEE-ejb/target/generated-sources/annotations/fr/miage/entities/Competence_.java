package fr.miage.entities;

import fr.miage.entities.Candidat;
import fr.miage.entities.DemandeCompetence;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-11T19:00:33")
@StaticMetamodel(Competence.class)
public class Competence_ { 

    public static volatile CollectionAttribute<Competence, Candidat> candidats;
    public static volatile CollectionAttribute<Competence, DemandeCompetence> demandeCompetences;
    public static volatile SingularAttribute<Competence, String> description;
    public static volatile SingularAttribute<Competence, Long> id;
    public static volatile SingularAttribute<Competence, String> nom;

}