package fr.miage.entities;

import fr.miage.entities.Candidature;
import fr.miage.entities.DemandeCompetence;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-11T19:00:33")
@StaticMetamodel(FichePoste.class)
public class FichePoste_ { 

    public static volatile SingularAttribute<FichePoste, DemandeCompetence> demandeCompetence;
    public static volatile ListAttribute<FichePoste, Candidature> candidatures;
    public static volatile SingularAttribute<FichePoste, String> presentationEntreprise;
    public static volatile SingularAttribute<FichePoste, Long> id;
    public static volatile SingularAttribute<FichePoste, String> presentationPoste;

}