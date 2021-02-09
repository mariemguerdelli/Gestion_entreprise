package Vue;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Database.Requetes_SQL;
import Metier.Entreprise;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PanelAjouter extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField text_Matricule;
	private JTextField text_NomEntreprise;
	private JTextField text_Description;
	private JTextField text_Num;
	private JTextField text_Libelle;
	private JTextField text_CodePostale;
	private JTextField text_NomVille;
	private JTextField text_NumFixe;
	private JTextField text_NumMobile;
	private JTextField text_EtatFiscale;
	private JTextField text_Gouvernorat;
	private JLabel lblNumero;
	private JLabel lblLibell;
	private JLabel lblNomDeVille;
	private JLabel lblCodePostale;
	private JLabel lblGouvernorat;
	private JLabel lblPays;
	private JTextField text_Pays;
	private JTextField text_Email;
	private JTextField text_Fax;
	private JTextField text_Site;
	private JTextField text_rue;
	private JComboBox comboBox_Type = new JComboBox();
	  	    
	private JButton btnvalider = new JButton("Valider");
	private JButton btnAjouter = new JButton("Ajouter");
	
	
	private JTextField txt_nombanque;
	private JTextField txt_agence;
	private JTextField txt_Rib;


	/**
	 * Create the panel.
	 */
	public PanelAjouter() {
		setBackground(new Color(192, 192, 192));
		setSize(856, 674);
		setLayout(null);
		
		JLabel lblMatricule = new JLabel("Matricule Fiscale:");
		lblMatricule.setForeground(SystemColor.textHighlightText);
		lblMatricule.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMatricule.setBounds(10, 43, 161, 25);
		add(lblMatricule);
		
		text_Matricule = new JTextField();
		text_Matricule.setBounds(228, 45, 212, 25);
		add(text_Matricule);
		text_Matricule.setColumns(10);
		
		JLabel lblNomEntreprise = new JLabel("Nom Etreprise:");
		lblNomEntreprise.setForeground(SystemColor.textHighlightText);
		lblNomEntreprise.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNomEntreprise.setBounds(10, 79, 161, 25);
		add(lblNomEntreprise);
		
		text_NomEntreprise = new JTextField();
		text_NomEntreprise.setColumns(10);
		text_NomEntreprise.setBounds(228, 80, 212, 25);
		add(text_NomEntreprise);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setForeground(SystemColor.textHighlightText);
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblType.setBounds(10, 115, 161, 25);
		add(lblType);
		
		
		
		comboBox_Type.setModel(new DefaultComboBoxModel(new String[] {"","physique", "morale"}));
		comboBox_Type.setBounds(228, 118, 131, 20);
		add(comboBox_Type);
		
		JLabel lblDescriptionActivit = new JLabel("Description Activit\u00E9:");
		lblDescriptionActivit.setForeground(SystemColor.textHighlightText);
		lblDescriptionActivit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDescriptionActivit.setBounds(10, 151, 161, 25);
		add(lblDescriptionActivit);
		
		text_Description = new JTextField();
		text_Description.setColumns(10);
		text_Description.setBounds(228, 152, 212, 25);
		add(text_Description);
		
		JLabel lblCompteBancaire = new JLabel("Compte Bancaire:");
		lblCompteBancaire.setForeground(SystemColor.textHighlightText);
		lblCompteBancaire.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCompteBancaire.setBounds(10, 187, 131, 25);
		add(lblCompteBancaire);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setForeground(SystemColor.textHighlightText);
		lblAdresse.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAdresse.setBounds(10, 237, 69, 25);
		add(lblAdresse);
		
		text_Num = new JTextField();
		text_Num.setColumns(10);
		text_Num.setBounds(278, 237, 96, 25);
		add(text_Num);
		
		text_Libelle = new JTextField();
		text_Libelle.setColumns(10);
		text_Libelle.setBounds(726, 237, 96, 25);
		add(text_Libelle);
		
		text_CodePostale = new JTextField();
		text_CodePostale.setColumns(10);
		text_CodePostale.setBounds(538, 273, 96, 25);
		add(text_CodePostale);
		
		
		
		text_NomVille = new JTextField();
		text_NomVille.setColumns(10);
		text_NomVille.setBounds(278, 273, 96, 25);
		add(text_NomVille);
		
		JLabel lblNumTlFixe = new JLabel("Num t\u00E9l fixe:");
		lblNumTlFixe.setForeground(SystemColor.textHighlightText);
		lblNumTlFixe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNumTlFixe.setBounds(10, 361, 131, 25);
		add(lblNumTlFixe);
		
		JLabel lblNumTlMobile = new JLabel("Num t\u00E9l mobile:");
		lblNumTlMobile.setForeground(SystemColor.textHighlightText);
		lblNumTlMobile.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNumTlMobile.setBounds(397, 361, 131, 25);
		add(lblNumTlMobile);
		
		text_NumFixe = new JTextField();
		text_NumFixe.setColumns(10);
		text_NumFixe.setBounds(151, 363, 212, 25);
		add(text_NumFixe);
		
		text_NumMobile = new JTextField();
		text_NumMobile.setColumns(10);
		text_NumMobile.setBounds(538, 363, 212, 25);
		add(text_NumMobile);
		
		JLabel lblEtatFiscale = new JLabel("Etat Fiscale:");
		lblEtatFiscale.setForeground(SystemColor.textHighlightText);
		lblEtatFiscale.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEtatFiscale.setBounds(10, 397, 131, 25);
		add(lblEtatFiscale);
		
		text_EtatFiscale = new JTextField();
		text_EtatFiscale.setColumns(10);
		text_EtatFiscale.setBounds(151, 399, 212, 25);
		add(text_EtatFiscale);
		
		text_Gouvernorat = new JTextField();
		text_Gouvernorat.setColumns(10);
		text_Gouvernorat.setBounds(278, 309, 96, 25);
		add(text_Gouvernorat);
		
		lblNumero = new JLabel("Num\u00E9ro:");
		lblNumero.setForeground(new Color(0, 51, 51));
		lblNumero.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNumero.setBounds(151, 241, 96, 16);
		add(lblNumero);
		
		lblLibell = new JLabel("Libell\u00E9:");
		lblLibell.setForeground(new Color(0, 51, 51));
		lblLibell.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLibell.setBounds(634, 242, 60, 16);
		add(lblLibell);
		
		lblNomDeVille = new JLabel("Nom de Ville:");
		lblNomDeVille.setForeground(new Color(0, 51, 51));
		lblNomDeVille.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNomDeVille.setBounds(151, 277, 96, 16);
		add(lblNomDeVille);
		
		lblCodePostale = new JLabel("Code Postale:");
		lblCodePostale.setForeground(new Color(0, 51, 51));
		lblCodePostale.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCodePostale.setBounds(411, 277, 96, 16);
		add(lblCodePostale);
		
		lblGouvernorat = new JLabel("Gouvernorat:");
		lblGouvernorat.setForeground(new Color(0, 51, 51));
		lblGouvernorat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGouvernorat.setBounds(151, 313, 96, 16);
		add(lblGouvernorat);
		
		lblPays = new JLabel("Pays:");
		lblPays.setForeground(new Color(0, 51, 51));
		lblPays.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPays.setBounds(411, 313, 96, 16);
		add(lblPays);
		
		text_Pays = new JTextField();
		text_Pays.setColumns(10);
		text_Pays.setBounds(538, 309, 96, 25);
		add(text_Pays);
		
		btnvalider.setBounds(295, 491, 116, 23);
		btnvalider.addActionListener(this);
	    add(btnvalider);
	    btnvalider.setIcon(new ImageIcon(PanelAjouter.class
	                .getResource("/image/ok.png")));
	    
	    JLabel lblFax = new JLabel("Fax:");
	    lblFax.setForeground(Color.WHITE);
	    lblFax.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    lblFax.setBounds(397, 397, 131, 25);
	    add(lblFax);
	    
	    text_Fax = new JTextField();
	    text_Fax.setColumns(10);
	    text_Fax.setBounds(538, 399, 212, 25);
	    add(text_Fax);
	    
	    JLabel lblEmail = new JLabel("Email:");
	    lblEmail.setForeground(Color.WHITE);
	    lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    lblEmail.setBounds(10, 433, 131, 25);
	    add(lblEmail);
	    
	    text_Email = new JTextField();
	    text_Email.setColumns(10);
	    text_Email.setBounds(151, 435, 212, 25);
	    add(text_Email);
	    
	    JLabel lblSiteWeb = new JLabel("Site Web:");
	    lblSiteWeb.setForeground(Color.WHITE);
	    lblSiteWeb.setFont(new Font("Times New Roman", Font.BOLD, 16));
	    lblSiteWeb.setBounds(397, 433, 131, 25);
	    add(lblSiteWeb);
	    
	    text_Site = new JTextField();
	    text_Site.setColumns(10);
	    text_Site.setBounds(538, 435, 212, 25);
	    add(text_Site);
	    
	    
	    JLabel lblrue = new JLabel("Rue:");
	    lblrue.setForeground(new Color(0, 51, 51));
	    lblrue.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lblrue.setBounds(397, 241, 96, 16);
	    add(lblrue);
	    
	    text_rue = new JTextField();
	    text_rue.setColumns(10);
	    text_rue.setBounds(524, 237, 96, 25);
	    add(text_rue);
	    
	    txt_nombanque = new JTextField();
	    txt_nombanque.setColumns(10);
	    txt_nombanque.setBounds(228, 188, 96, 25);
	    add(txt_nombanque);
	    
	    txt_agence = new JTextField();
	    txt_agence.setColumns(10);
	    txt_agence.setBounds(344, 188, 96, 25);
	    add(txt_agence);
	    
	    txt_Rib = new JTextField();
	    txt_Rib.setColumns(10);
	    txt_Rib.setBounds(460, 187, 96, 25);
	    add(txt_Rib);
	   
		
		setVisible(true);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		
		
		if(event.getSource()== btnvalider) {
			 if (text_Matricule.getText().trim().isEmpty()||
     				 text_NomEntreprise.getText().trim().isEmpty()||
     				 text_Description.getText().trim().isEmpty()||
     				 text_NumFixe.getText().trim().isEmpty()||text_NumMobile.getText().trim().isEmpty()||
     				text_Fax.getText().trim().isEmpty()||text_Email.getText().trim().isEmpty()||
     				text_Site.getText().trim().isEmpty()){
                 JOptionPane.showMessageDialog(null,"veillez remplir les champs vides");
             }
             else {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/gestion_entreprise";
			Connection c = DriverManager.getConnection(url,"root","");

			Statement stmt = c.createStatement();
			
			String adresse1 = Integer.parseInt(text_Num.getText())+"/"+text_rue.getText()+"/"+text_Libelle.getText()
			+"/"+text_NomVille.getText()+"/"+Integer.parseInt( text_CodePostale.getText())+"/"+
					text_Gouvernorat.getText()+"/"+text_Pays.getText();
		
			String Vcp = txt_nombanque.getText()+'/'+txt_agence.getText()+'/'+Integer.parseInt(txt_Rib.getText());
			
			String type = (String) comboBox_Type.getSelectedItem();
			
			Entreprise entrep1 = new Entreprise(text_Matricule.getText().toString(),text_NomEntreprise.getText().toString(),
					type,
				text_Description.getText().toString(),Vcp,adresse1,
					Integer.parseInt(text_NumFixe.getText().toString()),Integer.parseInt(text_NumMobile.getText().toString()),
					Integer.parseInt(text_Fax.getText().toString()),text_Email.getText().toString(),text_Site.getText().toString(),text_EtatFiscale.getText().toString());
			
			String req= Requetes_SQL.ajouter_entreprise(entrep1);
			
			
			int nb=stmt.executeUpdate(req);
			if(nb==0)
				JOptionPane.showMessageDialog(null, "ERREUR d'ajout","Ajout_entreprise" , JOptionPane.OK_OPTION);
			else
				JOptionPane.showMessageDialog(null, "ajout avec succés!","Ajout_entreprise" , JOptionPane.OK_OPTION);
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
			
  		
			
             }
	}
	
}
}
	

