package fr.miage.entities;

import fr.miage.entities.Competence;
import fr.miage.entities.Equipe;
import fr.miage.entities.Etat;
import fr.miage.entities.FichePoste;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-11T16:45:31")
@StaticMetamodel(DemandeCompetence.class)
public class DemandeCompetence_ { 

    public static volatile ListAttribute<DemandeCompetence, Competence> listeCompetence;
    public static volatile ListAttribute<DemandeCompetence, FichePoste> listeFichePoste;
    public static volatile SingularAttribute<DemandeCompetence, Long> id;
    public static volatile SingularAttribute<DemandeCompetence, Etat> etat;
    public static volatile SingularAttribute<DemandeCompetence, Equipe> equipe;

}