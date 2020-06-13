/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.ws;

import fr.miage.entities.*;
import fr.miage.exposition.ExpoLegLocal;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author ddias
 */
@WebService(serviceName = "WSLeg")
public class WSLeg {

    @EJB
    private ExpoLegLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    // Manager
    @WebMethod(operationName = "listerCompetence")
    public HashSet<Competence> listerCompetence(@WebParam(name = "numEquip") Long numEquipe) {
        return ejbRef.listerCompetence(numEquipe);
    }

    @WebMethod(operationName = "demanderCompetence")
    public DemandeCompetence demandeCompetence(@WebParam(name = "numEquip") Long numEquip, @WebParam(name = "idCompetences") ArrayList<Long> listCompetences){
        return ejbRef.demanderCompetence(numEquip, listCompetences);
    }

    // Codir
    @WebMethod(operationName = "listerCompetenceACombler")
    public HashSet<DemandeCompetence> listerCompetenceACombler() {
        return ejbRef.listerCompetenceACombler();
    }

    @WebMethod(operationName = "comblerCompetence")
    public DemandeCompetence comblerCompetence(@WebParam(name = "idDemandeCompetence") Long idDemandeCompetence){
        return ejbRef.comblerCompetence(idDemandeCompetence);
    }

    @WebMethod(operationName = "listerCandidatures")
    public List<Candidature> listerCandidatures(){
        return ejbRef.listerCandidatures();
    }

    @WebMethod(operationName = "sePrononcerSurCandidature")
    public Candidature sePrononcerSurCandidature(@WebParam(name = "idCandidature") Long idCandidature, @WebParam(name = "statut") Statut statut){
        return ejbRef.sePrononcerSurCandidature(idCandidature, statut);
    }

    // Candidat
    @WebMethod(operationName = "proposerCandidature")
    public Candidature proposerCandidature(@WebParam(name = "numCandidat") Long numCandidat, @WebParam(name = "numFichePoste") Long numFichePoste){
        return ejbRef.proposerCandidature(numCandidat, numFichePoste);
    }

    @WebMethod(operationName = "listerOffresDisponibles")
    public HashSet<Long> listerOffresDisponibles(){
        return ejbRef.listerOffresDisponibles();
    }

    @WebMethod(operationName = "consulterDetailsOffre")
    public FichePoste consulterDetailsOffre(@WebParam(name = "idFichePoste") Long idFichePoste){
        return ejbRef.consulterDetailsOffre(idFichePoste);
    }

    // CEO
    @WebMethod(operationName = "recolterStatistiques")
    public String recolterStatistiques(){
        return ejbRef.recolterStatistiques();
    }
}
