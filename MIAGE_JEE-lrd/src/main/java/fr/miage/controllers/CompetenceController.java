package fr.miage.controllers;

import fr.andrea.christophe.m1.jee.miage_jee.shr.interfremote.ExpoLrdRemote;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.CollaborateurExport;

import java.util.HashSet;

public class CompetenceController {

    ExpoLrdRemote expo;

    public CompetenceController(ExpoLrdRemote expo){
        this.expo = expo;
    }

    public HashSet<CollaborateurExport> listerCompetencesCollaborateurs(){
        return expo.listerCompetencesCollaborateurs();
    }
}
