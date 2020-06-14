package fr.miage.controllers;

import fr.andrea.christophe.m1.jee.miage_jee.shr.interfremote.ExpoLrdRemote;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.CollaborateurExport;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.CompetenceExport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CompetenceController {
    ExpoLrdRemote expo;

    public CompetenceController(ExpoLrdRemote expo){
        this.expo = expo;
    }

    public HashMap<CollaborateurExport, ArrayList<CompetenceExport>> listerCompetencesCollaborateurs(){
        return expo.listerCompetencesCollaborateurs();
    }
}
