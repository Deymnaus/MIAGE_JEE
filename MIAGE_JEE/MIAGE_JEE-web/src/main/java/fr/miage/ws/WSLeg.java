/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.miage.ws;

import fr.miage.entities.Competence;
import fr.miage.entities.DemandeCompetence;
import fr.miage.exposition.ExpoLegLocal;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author ddias
 */
@WebService(serviceName = "WSLeg")
public class WSLeg {

    @EJB
    private ExpoLegLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "listerCompetence")
    public HashSet<Competence> listerCompetence(Long numEquipe) {
        return ejbRef.listerCompetence(numEquipe);
    }

    @WebMethod(operationName = "demanderCompetence")
    public DemandeCompetence demandeCompetence(Long numEquip, ArrayList<Long> listCompetences){
        return ejbRef.demanderCompetence(numEquip, listCompetences);
    }
}
