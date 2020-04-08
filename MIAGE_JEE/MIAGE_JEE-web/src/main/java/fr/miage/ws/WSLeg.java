/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.ws;

import fr.miage.entities.Collaborateur;
import fr.miage.entities.Competence;
import fr.miage.exposition.ExpoLegLocal;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author ddias
 */
@WebService(serviceName = "WSLeg")
public class WSLeg {

    @EJB
    private ExpoLegLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "creerCollaborateur")
    @Oneway
    public void creerCollaborateur(@WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom, @WebParam(name = "status") String status) {
        ejbRef.creerCollaborateur(nom, prenom, status);
    }

    @WebMethod(operationName = "getCollaborateur")
    public Collaborateur getCollaborateur(@WebParam(name = "idCollaborateur") String idCollaborateur) {
        Long idc = Long.parseLong(idCollaborateur);
        return ejbRef.getCollaborateur(idc);
    }

    @WebMethod(operationName = "creerCompetence")
    @Oneway
    public void creerCompetence(@WebParam(name = "nom") String nom, @WebParam(name = "competence") String competence) {
        ejbRef.creerCompetence(nom, competence);
    }

    @WebMethod(operationName = "getCompetence")
    public Competence getCompetence(@WebParam(name = "idCompetence") String idCompetence) {
        Long idc = Long.parseLong(idCompetence);
        return ejbRef.getCompetence(idc);
    }
    
}
