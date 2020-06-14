package fr.miage.utils;

import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.*;
import fr.miage.entities.*;
import org.eclipse.persistence.jpa.jpql.tools.model.IConditionalExpressionStateObjectBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Traducteur {

    /**
     *
     * @param c
     * @return
     */
    public static CandidatExport candidatToCandidatExport(Candidat c){
        CandidatExport ce = new CandidatExport();
        ce.setId(c.getId());
        ce.setCompetences(Traducteur.listeCompetenceToListeCompetenceExport(c.getCompetences()));
        ce.setNom(c.getNom());
        ce.setPrenom(c.getPrenom());
        return ce;
    }

    /**
     *
     * @param co
     * @return
     */
    public static CompetenceExport competenceToCompetenceExport(Competence co) {
        CompetenceExport competenceExport = new CompetenceExport();
        competenceExport.setId(co.getId());
        competenceExport.setDescription(co.getDescription());
        competenceExport.setNom(co.getNom());
        return competenceExport;
    }

    /**
     *
     * @param eq
     * @return
     */
    public static EquipeExport equipeToEquipeExport(Equipe eq){
        EquipeExport equipeExport = new EquipeExport();
        equipeExport.setId(eq.getId());
        equipeExport.setNom(eq.getNom());

        ArrayList<CollaborateurExport> collaborateurExports = new ArrayList<>();
        for(Collaborateur collaborateur : eq.getCollaborateurs()){
            collaborateurExports.add(new CollaborateurExport(collaborateur.getId(), collaborateur.getNom(), collaborateur.getPrenom(), Traducteur.listeCompetenceToListeCompetenceExport(collaborateur.getCompetences()), collaborateur.isCodir(), collaborateur.isManager(), equipeExport));
        }
        equipeExport.setCollaborateurExports(collaborateurExports);

        return equipeExport;
    }

    /**
     *
     * @param dc
     * @return
     */
    public static DemandeCompetenceExport demandeCompetenceToDemandeCompetenceExport(DemandeCompetence dc){
        DemandeCompetenceExport demandeCompetenceExport = new DemandeCompetenceExport();
        demandeCompetenceExport.setId(dc.getId());
        demandeCompetenceExport.setEtat(dc.getEtat());
        demandeCompetenceExport.setCompetenceExportList(Traducteur.listeCompetenceToListeCompetenceExport(dc.getCompetences()));
        demandeCompetenceExport.setEquipeExport(Traducteur.equipeToEquipeExport(dc.getEquipe()));

        ArrayList<FichePosteExport> fichePosteExports = new ArrayList<>();
        ArrayList<CandidatureExport> candidatureExports = new ArrayList<>();

        for(FichePoste fp : dc.getFichePostes()){
            FichePosteExport fichePosteExport = new FichePosteExport();

            for(Candidature cu : fp.getCandidatures()){
                candidatureExports.add(new CandidatureExport(cu.getId(), cu.getStatut(), Traducteur.candidatToCandidatExport(cu.getCandidat()), fichePosteExport));
            }

            fichePosteExport.setId(fp.getId());
            fichePosteExport.setPresentationEntreprise(fp.getPresentationEntreprise());
            fichePosteExport.setPrensentationPoste(fp.getPresentationPoste());
            fichePosteExport.setDemandeCompetenceExport(demandeCompetenceExport);
            fichePosteExport.setArchivee(fp.isArchivee());
            fichePosteExport.setCandidatureExports(candidatureExports);

            fichePosteExports.add(fichePosteExport);
        }
        demandeCompetenceExport.setFichePosteExports(fichePosteExports);

        return demandeCompetenceExport;
    }

    /**
     *
     * @param fp
     * @return
     */
    public static FichePosteExport fichePosteToFichePosteExport(FichePoste fp) {
        FichePosteExport fichePosteExport = new FichePosteExport();
        fichePosteExport.setId(fp.getId());
        fichePosteExport.setArchivee(fp.isArchivee());

        ArrayList<CandidatureExport> candidatureExports = new ArrayList<>();
        for (Candidature candidature : fp.getCandidatures()){
            candidatureExports.add(new CandidatureExport(candidature.getId(), candidature.getStatut(), Traducteur.candidatToCandidatExport(candidature.getCandidat()), fichePosteExport));
        }
        fichePosteExport.setCandidatureExports(candidatureExports);

        fichePosteExport.setDemandeCompetenceExport(Traducteur.demandeCompetenceToDemandeCompetenceExport(fp.getDemandeCompetence()));
        fichePosteExport.setPrensentationPoste(fp.getPresentationPoste());
        fichePosteExport.setPresentationEntreprise(fp.getPresentationEntreprise());
        return fichePosteExport;
    }

    public static CandidatureExport candidatureToCandidatureExport(Candidature cu) {
        CandidatureExport candidatureExport = new CandidatureExport();
        candidatureExport.setId(cu.getId());
        candidatureExport.setStatut(cu.getStatut());
        candidatureExport.setCandidatExport(Traducteur.candidatToCandidatExport(cu.getCandidat()));
        candidatureExport.setFichePosteExport(Traducteur.fichePosteToFichePosteExport(cu.getFichePoste()));
        return candidatureExport;
    }

    public static CollaborateurExport collaborateurToCollaborateurExport(Collaborateur co) {
        CollaborateurExport collaborateurExport = new CollaborateurExport();
        collaborateurExport.setId(co.getId());
        collaborateurExport.setCodir(co.isCodir());
        collaborateurExport.setManager(co.isManager());
        collaborateurExport.setNom(co.getNom());
        collaborateurExport.setPrenom(co.getPrenom());
        collaborateurExport.setEquipeExport(Traducteur.equipeToEquipeExport(co.getEquipe()));
        collaborateurExport.setCompetences(Traducteur.listeCompetenceToListeCompetenceExport(co.getCompetences()));
        return collaborateurExport;
    }

    public static List<FichePosteExport> listeFichePosteToListeFichePosteExport(List<FichePoste> fichePostes) {
        ArrayList<FichePosteExport> fichePosteExports = new ArrayList<>();
        for(FichePoste fp : fichePostes){
            fichePosteExports.add(Traducteur.fichePosteToFichePosteExport(fp));
        }
        return fichePosteExports;
    }

    public static ArrayList<CompetenceExport> listeCompetenceToListeCompetenceExport(Collection<Competence> competences) {
        ArrayList<CompetenceExport> competenceExports = new ArrayList<>();
        for(Competence c : competences){
            competenceExports.add(Traducteur.competenceToCompetenceExport(c));
        }
        return competenceExports;
    }

    public static ArrayList<CollaborateurExport> listeCollaborateurToListeCollaborateurExport(List<Collaborateur> collaborateurs) {
        ArrayList<CollaborateurExport> collaborateurExports = new ArrayList<>();
        for(Collaborateur co : collaborateurs){
            collaborateurExports.add(Traducteur.collaborateurToCollaborateurExport(co));
        }
        return collaborateurExports;
    }

    public static List<CandidatureExport> listeCandidatureToCandidatureExport(List<Candidature> candidatures) {
        ArrayList<CandidatureExport> candidatureExports = new ArrayList<>();
        for(Candidature cu : candidatures){
            candidatureExports.add(Traducteur.candidatureToCandidatureExport(cu));
        }
        return candidatureExports;
    }

    public static List<CandidatExport> listeCandidatToCandidatExport(List<Candidat> candidats) {
        ArrayList<CandidatExport> candidatExports = new ArrayList<>();
        for(Candidat ca : candidats){
            candidatExports.add(Traducteur.candidatToCandidatExport(ca));
        }
        return candidatExports;
    }

    public static List<FichePosteExport> listeFichePosteToFichePosteExport(List<FichePoste> fichePostes) {
        ArrayList<FichePosteExport> fichePosteExports = new ArrayList<>();
        for(FichePoste fp : fichePostes){
            fichePosteExports.add(Traducteur.fichePosteToFichePosteExport(fp));
        }
        return fichePosteExports;
    }

    public static List<DemandeCompetenceExport> listeDemandeCompetenceToDemandeCompetenceExport(List<DemandeCompetence> demandeCompetences) {
        ArrayList<DemandeCompetenceExport> demandeCompetenceExports = new ArrayList<>();
        for(DemandeCompetence dc : demandeCompetences){
            demandeCompetenceExports.add(Traducteur.demandeCompetenceToDemandeCompetenceExport(dc));
        }
        return demandeCompetenceExports;
    }

    public static List<EquipeExport> listeEquipeToEquipeExport(List<Equipe> equipes) {
        ArrayList<EquipeExport> equipeExports = new ArrayList<>();
        for(Equipe eq : equipes){
            equipeExports.add(Traducteur.equipeToEquipeExport(eq));
        }
        return equipeExports;
    }
}
