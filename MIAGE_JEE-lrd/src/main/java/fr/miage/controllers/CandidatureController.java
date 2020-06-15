package fr.miage.controllers;

import fr.andrea.christophe.m1.jee.miage_jee.shr.interfremote.ExpoLrdRemote;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.CandidatureExport;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.Statut;

import java.util.HashSet;

public class CandidatureController {

    ExpoLrdRemote expoLrd;

    public CandidatureController(ExpoLrdRemote expoLrdRemote) {
        this.expoLrd = expoLrdRemote;
    }


    public HashSet<CandidatureExport> listerCandidatures() {
        return expoLrd.listerCandidatures();
    }

    public int changerStatutCandidature(Long idCandidature, Statut statut) {
        return expoLrd.changerStatutCandidature(idCandidature, statut);
    }

    public HashSet<CandidatureExport> listerCandidaturesFeuVert() {
        return expoLrd.listerCandidaturesFeuVert();
    }

    public int concretiserEmbauche(Long idCandidature, Long idEquipe) {
        return expoLrd.concretiserEmbauche(idCandidature, idEquipe);
    }
}
