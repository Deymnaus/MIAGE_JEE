package fr.miage.controllers;

import fr.andrea.christophe.m1.jee.miage_jee.shr.interfremote.ExpoLrdRemote;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.DemandeCompetenceExport;
import java.util.HashSet;
import javax.naming.Context;


public class CompetencesDemandesController{

    ExpoLrdRemote expo;
    
    public CompetencesDemandesController(ExpoLrdRemote expo){
        this.expo = expo;
    }
    
    public HashSet<DemandeCompetenceExport> listerCompetencesDemandeesEquipes(){
        return expo.listerCompetencesDemandeesEquipes();
    }
   
}
