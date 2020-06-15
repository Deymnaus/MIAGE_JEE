package fr.miage.views;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import fr.andrea.christophe.m1.jee.miage_jee.shr.interfremote.ExpoLrdRemote;
import fr.andrea.christophe.m1.jee.miage_jee.shr.utilities.*;
import fr.miage.controllers.CandidatureController;
import fr.miage.controllers.CompetenceController;
import fr.miage.controllers.CompetencesDemandesController;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ddias
 */
public class MainFrame extends javax.swing.JFrame {

    CompetencesDemandesController competencesDemandesController;
    CompetenceController competenceController;
    CandidatureController candidatureController;
    UseCase action;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        try {
            InitialContext ctx = new InitialContext();
            ExpoLrdRemote expoLrdRemote = (ExpoLrdRemote) ctx.lookup("fr.andrea.christophe.m1.jee.miage_jee.shr.interfremote.ExpoLrdRemote");
            this.competencesDemandesController = new CompetencesDemandesController(expoLrdRemote);
            this.competenceController = new CompetenceController(expoLrdRemote);
            this.candidatureController = new CandidatureController(expoLrdRemote);
            this.action = UseCase.Accueil;
            initComponents();
            this.showForm(this.action);
        } catch (NamingException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showForm(UseCase action) {
        switch (action){
            case Accueil:
            case CompetenceCollaborateur:
                this.formPanel.setVisible(false);
                break;
            case Embauche:
                this.formPanel.setVisible(true);

                this.idTextField.setVisible(true);
                this.idLabel.setVisible(true);

                this.equipeTextField.setVisible(true);
                this.equipeLabel.setVisible(true);

                this.statutComboBox.setVisible(false);
                this.statutLabel.setVisible(false);

                this.presentationEntrepriseTextField.setVisible(false);
                this.presentationEntrepriseLabel.setVisible(false);

                this.presentationPosteTextField.setVisible(false);
                this.presentationPosteLabel.setVisible(false);

                this.actionLabel.setText("Concrétiser embauche");
                break;
            case Candidatures:
                this.formPanel.setVisible(true);

                this.idTextField.setVisible(true);
                this.idLabel.setVisible(true);

                this.equipeTextField.setVisible(false);
                this.equipeLabel.setVisible(false);

                this.statutComboBox.setVisible(true);
                this.statutLabel.setVisible(true);

                this.presentationEntrepriseTextField.setVisible(false);
                this.presentationEntrepriseLabel.setVisible(false);

                this.presentationPosteTextField.setVisible(false);
                this.presentationPosteLabel.setVisible(false);
                this.actionLabel.setText("Changer statut candidature");
                break;
            case DemandeCompetenceEquipe:

                this.formPanel.setVisible(true);

                this.idTextField.setVisible(true);
                this.idLabel.setVisible(true);

                this.equipeTextField.setVisible(false);
                this.equipeLabel.setVisible(false);

                this.statutComboBox.setVisible(false);
                this.statutLabel.setVisible(false);

                this.presentationEntrepriseTextField.setVisible(true);
                this.presentationEntrepriseLabel.setVisible(true);

                this.presentationPosteTextField.setVisible(true);
                this.presentationPosteLabel.setVisible(true);
                this.actionLabel.setText("Rédiger une fiche de poste");
                break;
        }
        this.pack();
    }

    private void onTextChange(){
        if(isLong(idTextField.getText())) {
            if(this.action == UseCase.DemandeCompetenceEquipe && !presentationPosteTextField.getText().isEmpty() && !presentationEntrepriseTextField.getText().isEmpty())
                validateButton.setEnabled(true);
            else if(this.action == UseCase.Embauche && isLong(equipeTextField.getText()))
                validateButton.setEnabled(true);
            else if(this.action == UseCase.Candidatures)
                validateButton.setEnabled(true);
            else
                validateButton.setEnabled(false);
        } else {
            validateButton.setEnabled(false);
        }
    }

    private boolean isLong(String string){
        try {
            Long l = Long.parseLong(string);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    private void initComponents() {

        listeCompetencesCollaborateurButton = new javax.swing.JButton();
        gererCandidaturesbutton = new javax.swing.JButton();
        listeDemandeCompetencesButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        formPanel = new javax.swing.JPanel();
        validateButton = new javax.swing.JButton();
        idTextField = new javax.swing.JTextField();
        statutComboBox = new javax.swing.JComboBox<>();
        actionLabel = new javax.swing.JLabel();
        presentationPosteTextField = new javax.swing.JTextField();
        presentationEntrepriseTextField = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        presentationPosteLabel = new javax.swing.JLabel();
        presentationEntrepriseLabel = new javax.swing.JLabel();
        statutLabel = new javax.swing.JLabel();
        infoText = new javax.swing.JLabel();
        concretiserEmbaucheButton = new javax.swing.JButton();
        equipeLabel = new javax.swing.JLabel();
        equipeTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        listeCompetencesCollaborateurButton.setText("Lister competences des collaborateurs");
        listeCompetencesCollaborateurButton.addActionListener(this::listeCompetencesCollaborateurButtonActionPerformed);

        gererCandidaturesbutton.setText("Gérer candidature");
        gererCandidaturesbutton.addActionListener(this::gererCandidaturesbuttonActionPerformed);

        listeDemandeCompetencesButton.setText("Lister demandes compétences des équipes");
        listeDemandeCompetencesButton.addActionListener(this::listeDemandeCompetencesButtonActionPerformed);

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        formPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        formPanel.setVisible(false);

        validateButton.setText("Valider");
        validateButton.setEnabled(false);
        validateButton.addActionListener(this::validateButtonActionPerformed);


        idTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onTextChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onTextChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onTextChange();
            }
        });

        statutComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new Statut[] {Statut.Accepte, Statut.EnAttente, Statut.Refuse}));

        presentationPosteTextField.setToolTipText("presentationPoste");
        presentationPosteTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onTextChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onTextChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onTextChange();
            }
        });

        presentationEntrepriseTextField.setToolTipText("presentationEntreprise");
        presentationEntrepriseTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onTextChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onTextChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onTextChange();
            }
        });

        equipeTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onTextChange();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onTextChange();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onTextChange();
            }
        });

        idLabel.setText("Id");

        presentationPosteLabel.setText("Présentation poste");

        presentationEntrepriseLabel.setText("Présentation entreprise");

        statutLabel.setText("Statut");

        equipeLabel.setText("Equipe");

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actionLabel)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLabel))
                        .addGap(45, 45, 45)
                        .addGroup(formPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(equipeTextField, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addComponent(equipeLabel))
                        .addGap(15, 15 ,15)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statutLabel)
                            .addComponent(statutComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(presentationPosteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(presentationPosteLabel))
                        .addGap(18, 18, 18)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(presentationEntrepriseLabel)
                            .addComponent(presentationEntrepriseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(validateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(actionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idLabel)
                            .addComponent(equipeLabel)
                            .addComponent(presentationPosteLabel)
                            .addComponent(presentationEntrepriseLabel)
                            .addComponent(statutLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(equipeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statutComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(presentationPosteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(presentationEntrepriseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(validateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        infoText.setMaximumSize(new java.awt.Dimension(250, 100));

        concretiserEmbaucheButton.setText("Concrétiser embauche");
        concretiserEmbaucheButton.addActionListener(this::concretiserEmbaucheButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(infoText, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(listeDemandeCompetencesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(listeCompetencesCollaborateurButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gererCandidaturesbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(concretiserEmbaucheButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listeDemandeCompetencesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(listeCompetencesCollaborateurButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(gererCandidaturesbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(concretiserEmbaucheButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(infoText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }

    private void validateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int result;
        switch (this.action){
            case Accueil:
            case CompetenceCollaborateur:
                break;
            case Embauche:
                result = candidatureController.concretiserEmbauche(Long.parseLong(idTextField.getText()), Long.parseLong(idTextField.getText()));
                if(result == 0)
                    infoText.setText("<html>ERREUR : La candidature n'a pas été trouvée dans la base de données</html>");
                else if (result == 2 )
                    infoText.setText("<html>ERREUR : L'équipe n'a pas été trouvée dans la base de données</html>");
                else
                    infoText.setText("<html>La candidature a bien été concrétisée</html>");
                this.concretiserEmbaucheButtonActionPerformed(evt);
                break;
            case Candidatures:
                result = candidatureController.changerStatutCandidature(Long.parseLong(idTextField.getText()), (Statut) statutComboBox.getSelectedItem());
                if(result == 0)
                    infoText.setText("<html>ERREUR : La candidature n'a pas été trouvée dans la base de données</html>");
                else
                    infoText.setText("<html>La candidature a bien été modifiée</html>");
                this.gererCandidaturesbuttonActionPerformed(evt);
                break;
            case DemandeCompetenceEquipe:
                result = competencesDemandesController.proposerFichePoste(Long.parseLong(idTextField.getText()), presentationPosteTextField.getText(), presentationEntrepriseTextField.getText());
                if(result == 0)
                    infoText.setText("<html>ERREUR : La demande de compétence n'a pas été trouvée dans la base de données</html>");
                else
                    infoText.setText("<html>La fiche de poste a bien été créée</html>");
                break;
        }
    }

    private void generateCandidatureTable(HashSet<CandidatureExport> candidatureExports) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Statut");
        model.addColumn("Nom candidat");
        model.addColumn("Prenom candidat");
        model.addColumn("Présentation poste");
        this.jTable1.setModel(model);

        for(CandidatureExport cue : candidatureExports){
            DefaultTableModel tableModel = (DefaultTableModel) this.jTable1.getModel();
            tableModel.addRow(new Object[]{cue.getId(), cue.getStatut(), cue.getCandidatExport().getNom(), cue.getCandidatExport().getPrenom(), cue.getFichePosteExport().getPrensentationPoste()});
        }
    }

    private void concretiserEmbaucheButtonActionPerformed(ActionEvent evt) {
        this.action = UseCase.Embauche;
        HashSet<CandidatureExport> candidatureExports = this.candidatureController.listerCandidaturesFeuVert();

        generateCandidatureTable(candidatureExports);

        this.infoText.setText("<html>La liste des candidatures avec feu vert a bien été chargé</html>");
        this.showForm(this.action);
    }

    private void gererCandidaturesbuttonActionPerformed(java.awt.event.ActionEvent evt) {
        this.action = UseCase.Candidatures;

        HashSet<CandidatureExport> candidatureExports = this.candidatureController.listerCandidatures();

        generateCandidatureTable(candidatureExports);

        this.infoText.setText("<html>La liste des candidatures a bien été chargé</html>");
        this.showForm(this.action);
    }


    private void listeCompetencesCollaborateurButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.action = UseCase.CompetenceCollaborateur;

        HashMap<CollaborateurExport, ArrayList<CompetenceExport>> listeCompetencesCollaborateurs = this.competenceController.listerCompetencesCollaborateurs();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Nom");
        model.addColumn("Prenom");
        model.addColumn("Competences");
        this.jTable1.setModel(model);

        for(CollaborateurExport cle : listeCompetencesCollaborateurs.keySet()){
            DefaultTableModel tableModel = (DefaultTableModel) this.jTable1.getModel();
            StringBuilder competences = new StringBuilder();
            for(CompetenceExport ce : listeCompetencesCollaborateurs.get(cle)){
                competences.append(ce.getNom()).append(" ; ");
            }
            tableModel.addRow(new Object[]{cle.getId(), cle.getNom(), cle.getPrenom(), competences.toString()});
        }
        this.infoText.setText("<html>La liste des collaborateurs et de leurs compétences a bien été chargé</html>");
        this.showForm(this.action);

    }

    private void listeDemandeCompetencesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.action = UseCase.DemandeCompetenceEquipe;

        HashSet<DemandeCompetenceExport> demandeCompetenceExports = this.competencesDemandesController.listerCompetencesDemandeesEquipes();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Etat");
        model.addColumn("DemandeCompetences");
        model.addColumn("Equipe");
        this.jTable1.setModel(model);

        for(DemandeCompetenceExport dce : demandeCompetenceExports){
            DefaultTableModel tableModel = (DefaultTableModel) this.jTable1.getModel();
            StringBuilder competences = new StringBuilder();
            for(CompetenceExport ce : dce.getCompetenceExportList()){
                competences.append(ce.getNom()).append(" ; ");
            }
            tableModel.addRow(new Object[]{dce.getId(), dce.getEtat(), competences.toString(), dce.getEquipeExport().getId()});
        }
        this.infoText.setText("<html>La liste des demandes de compétences a bien été chargé</html>");
        this.showForm(this.action);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JLabel actionLabel;
    private javax.swing.JButton concretiserEmbaucheButton;
    private javax.swing.JPanel formPanel;
    private javax.swing.JButton gererCandidaturesbutton;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel infoText;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel presentationPosteLabel;
    private javax.swing.JLabel presentationEntrepriseLabel;
    private javax.swing.JLabel statutLabel;
    private javax.swing.JLabel equipeLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton listeCompetencesCollaborateurButton;
    private javax.swing.JButton listeDemandeCompetencesButton;
    private javax.swing.JTextField presentationEntrepriseTextField;
    private javax.swing.JTextField presentationPosteTextField;
    private javax.swing.JTextField equipeTextField;
    private javax.swing.JComboBox<Statut> statutComboBox;
    private javax.swing.JButton validateButton;
    // End of variables declaration
}
