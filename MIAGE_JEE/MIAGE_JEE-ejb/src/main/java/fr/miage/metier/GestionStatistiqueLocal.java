package fr.miage.metier;

import javax.ejb.Local;

@Local
public interface GestionStatistiqueLocal {
    String recolterStatistiques();
}
