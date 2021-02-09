package Vue;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import Database.Requetes_SQL;
import Metier.Entreprise;
import Vue.PanelEntreprise;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PanelModifier extends JPanel  implements  ActionListener {
	private JTextField txt_Matricule;
	private JTextField txt_NomEntreprise;
	private JTextField txt_Description;
	private JTextField txt_Banque;
	private JTextField txt_Agence;
	private JTextField txt_Rib;
	private JTextField txt_Num;
	private JTextField txt_rue;
	private JTextField txt_Libelle;
	private JTextField txt_NomVille;
	private JTextField txt_codepostal;
	private JTextField txt_Gouvernorat;
	private JTextField txt_Pays;
	private JTextField txt_NumFixe;
	private JTextField txt_NumMobile;
	private JTextField txt_EtatFiscale;
	private JTextField txt_fax;
	private JTextField txt_email;
	private JTextField txt_site_web;
	private JLabel lblBanque;
	private JLabel lblAgence;
	private JLabel lblRib;
	private JLabel lblNumero;
	private JLabel lblLibell;
	private JLabel lblNomDeVille;
	private JLabel lblCodePostale;
	private JLabel lblGouvernorat;
	private JLabel lblPays;
	
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JButton btnValider = new JButton("Valider");
	private JComboBox comboBox_Type = new JComboBox();
	
	


	/**
	 * Create the panel.
	 */
	public PanelModifier() {
		setBackground(new Color(192, 192, 192));
		setSize(856, 674);
		setLayout(null);
		
		JLabel lblMatricule = new JLabel("Matricule Fiscale:");
		lblMatricule.setForeground(SystemColor.textHighlightText);
		lblMatricule.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMatricule.setBounds(10, 43, 161, 25);
		add(lblMatricule);
		
		txt_Matricule = new JTextField();
		txt_Matricule.setBounds(228, 45, 212, 25);
		add(txt_Matricule);
		txt_Matricule.setColumns(10);
		
		JLabel lblNomEntreprise = new JLabel("Nom Etreprise:");
		lblNomEntreprise.setForeground(SystemColor.textHighlightText);
		lblNomEntreprise.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNomEntreprise.setBounds(10, 79, 161, 25);
		add(lblNomEntreprise);
		
		txt_NomEntreprise = new JTextField();
		txt_NomEntreprise.setColumns(10);
		txt_NomEntreprise.setBounds(228, 80, 212, 25);
		add(txt_NomEntreprise);
		
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
		
		txt_Description = new JTextField();
		txt_Description.setColumns(10);
		txt_Description.setBounds(228, 152, 212, 25);
		add(txt_Description);
		
		JLabel lblCompteBancaire = new JLabel("Compte Bancaire:");
		lblCompteBancaire.setForeground(SystemColor.textHighlightText);
		lblCompteBancaire.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCompteBancaire.setBounds(10, 187, 131, 25);
		add(lblCompteBancaire);
		
		txt_Banque = new JTextField();
		txt_Banque.setBounds(228, 188, 123, 25);
		add(txt_Banque);
		txt_Banque.setColumns(10);
		
		txt_Agence = new JTextField();
		txt_Agence.setColumns(10);
		txt_Agence.setBounds(424, 189, 123, 25);
		add(txt_Agence);
		
		txt_Rib = new JTextField();
		txt_Rib.setColumns(10);
		txt_Rib.setBounds(610, 189, 212, 25);
		add(txt_Rib);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setForeground(SystemColor.textHighlightText);
		lblAdresse.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblAdresse.setBounds(10, 237, 69, 25);
		add(lblAdresse);
		
		txt_Num = new JTextField();
		txt_Num.setColumns(10);
		txt_Num.setBounds(278, 237, 96, 25);
		add(txt_Num);
		
		txt_Libelle = new JTextField();
		txt_Libelle.setColumns(10);
		txt_Libelle.setBounds(696, 237, 96, 25);
		add(txt_Libelle);
		
		
		txt_NomVille = new JTextField();
		txt_NomVille.setColumns(10);
		txt_NomVille.setBounds(278, 273, 96, 25);
		add(txt_NomVille);
		
		JLabel lblNumTlFixe = new JLabel("Num t\u00E9l fixe:");
		lblNumTlFixe.setForeground(SystemColor.textHighlightText);
		lblNumTlFixe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNumTlFixe.setBounds(10, 361, 131, 25);
		add(lblNumTlFixe);
		
		JLabel lblNumTlMobile = new JLabel("Num t\u00E9l mobile:");
		lblNumTlMobile.setForeground(SystemColor.textHighlightText);
		lblNumTlMobile.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNumTlMobile.setBounds(395, 361, 131, 25);
		add(lblNumTlMobile);
		
		txt_NumFixe = new JTextField();
		txt_NumFixe.setColumns(10);
		txt_NumFixe.setBounds(158, 363, 212, 25);
		add(txt_NumFixe);
		
		txt_NumMobile = new JTextField();
		txt_NumMobile.setColumns(10);
		txt_NumMobile.setBounds(542, 363, 212, 25);
		add(txt_NumMobile);
		
		JLabel lblEtatFiscale = new JLabel("Etat Fiscale:");
		lblEtatFiscale.setForeground(SystemColor.textHighlightText);
		lblEtatFiscale.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEtatFiscale.setBounds(10, 409, 108, 25);
		add(lblEtatFiscale);
		
		txt_EtatFiscale = new JTextField();
		txt_EtatFiscale.setColumns(10);
		txt_EtatFiscale.setBounds(158, 411, 212, 25);
		add(txt_EtatFiscale);
		
		txt_Gouvernorat = new JTextField();
		txt_Gouvernorat.setColumns(10);
		txt_Gouvernorat.setBounds(278, 309, 96, 25);
		add(txt_Gouvernorat);
		
		lblBanque = new JLabel("Banque:");
		lblBanque.setForeground(new Color(0, 51, 51));
		lblBanque.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBanque.setBounds(158, 192, 60, 16);
		add(lblBanque);
		
		lblAgence = new JLabel("Agence:");
		lblAgence.setForeground(new Color(0, 51, 51));
		lblAgence.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAgence.setBounds(364, 195, 60, 16);
		add(lblAgence);
		
		lblRib = new JLabel("RIB:");
		lblRib.setForeground(new Color(0, 51, 51));
		lblRib.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblRib.setBounds(572, 191, 41, 16);
		add(lblRib);
		
		lblNumero = new JLabel("Num\u00E9ro:");
		lblNumero.setForeground(new Color(0, 51, 51));
		lblNumero.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNumero.setBounds(151, 241, 96, 16);
		add(lblNumero);
		
		lblLibell = new JLabel("Libell\u00E9:");
		lblLibell.setForeground(new Color(0, 51, 51));
		lblLibell.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblLibell.setBounds(626, 242, 60, 16);
		add(lblLibell);
		
		lblNomDeVille = new JLabel("Nom de Ville:");
		lblNomDeVille.setForeground(new Color(0, 51, 51));
		lblNomDeVille.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNomDeVille.setBounds(151, 277, 96, 16);
		add(lblNomDeVille);
		
		lblCodePostale = new JLabel("Code Postale:");
		lblCodePostale.setForeground(new Color(0, 51, 51));
		lblCodePostale.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCodePostale.setBounds(395, 277, 96, 16);
		add(lblCodePostale);
		
		lblGouvernorat = new JLabel("Gouvernorat:");
		lblGouvernorat.setForeground(new Color(0, 51, 51));
		lblGouvernorat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGouvernorat.setBounds(151, 313, 96, 16);
		add(lblGouvernorat);
		
		lblPays = new JLabel("Pays:");
		lblPays.setForeground(new Color(0, 51, 51));
		lblPays.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPays.setBounds(395, 313, 96, 16);
		add(lblPays);
		
		txt_Pays = new JTextField();
		txt_Pays.setColumns(10);
		txt_Pays.setBounds(522, 309, 96, 25);
		add(txt_Pays);
		
		btnValider.setBounds(290, 493, 116, 23);
		btnValider.addActionListener(this);
	    add(btnValider);
	    btnValider.setIcon(new ImageIcon(PanelAjouter.class
	                .getResource("/image/ok.png")));
	        
	        JButton recuper = new JButton("R\u00E9cup\u00E9rer les donn\u00E9es");
	        recuper.setBackground(new Color(192, 192, 192));
	        recuper.setForeground(new Color(0, 128, 128));
	        recuper.setIcon(new ImageIcon(PanelModifier.class.getResource("/image/ok.png")));
	        recuper.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String sql = "SELECT *  FROM entreprise";
		       		try {
		       			
			       			Class.forName("com.mysql.jdbc.Driver");
			    			String url = "jdbc:mysql://localhost:3306/gestion_entreprise";
			    			Connection c = DriverManager.getConnection(url,"root","");
			    			Statement stmt = c.createStatement();
			    			pst = c.prepareStatement(sql);
			    			rs = pst.executeQuery();
			    		
				      		System.out.println("requette execute");
		                	while (rs.next()) {
		                		
		                		String tab[];
		                		String cb = rs.getString("compte_bancaire").toString();
		                		tab = cb.split("/");
		                		String banque = tab[0];
		                		String agence = tab[1];
		                		String rib = tab[2];
		                		
		                		String tab1[];
		                		String ad = rs.getString("adresse").toString();
		                		tab1 = ad.split("/");
		                		String Num = tab1[0];
		                		String rue = tab1[1];
		                		String Libelle = tab1[2];
		                		String NomVille = tab1[3];
		                		String codepostal = tab1[4];
		                		String Gouvernorat = tab1[5];
		                		String Pays = tab1[6];
		                		
		                	
		                		txt_Matricule.setText(rs.getString("matricule_fiscale").toString());
		                		txt_NomEntreprise.setText(rs.getString("raison_sociale").toString());
		                		comboBox_Type.getModel().setSelectedItem(rs.getString("type").toString());
		                		txt_Description.setText(rs.getString("description_activite").toString());
		                		txt_Banque.setText(banque);
		                		txt_Agence.setText(agence);
		                		txt_Rib.setText(rib);
		                		txt_Num.setText(Num);
		                		txt_rue.setText(rue);
		                		txt_Libelle.setText(Libelle);
		                		txt_NomVille.setText(NomVille);
		                		txt_codepostal.setText(codepostal);
		                		txt_Gouvernorat.setText(Gouvernorat);
		                		txt_Pays.setText(Pays);
		                		txt_NumFixe.setText(rs.getString("num_tel_fixe").toString());
		                		txt_NumMobile.setText(rs.getString("num_tel_mobile").toString());
		                		txt_EtatFiscale.setText(rs.getString("etat_fiscale").toString());
		                		txt_fax.setText(rs.getString("fax").toString());
		                		txt_email.setText(rs.getString("email").toString());
		                		txt_site_web.setText(rs.getString("site_web").toString());
		                		
		                	
		                	}
				}
		       	 catch(Exception event){
		       		JOptionPane.showMessageDialog(null,event);
		      		}
	        	}
	        });
	        recuper.setBounds(599, 60, 210, 33);
	        add(recuper);
	        
	        JLabel lbl_rue = new JLabel("Rue:");
	        lbl_rue.setForeground(new Color(0, 51, 51));
	        lbl_rue.setFont(new Font("Times New Roman", Font.BOLD, 15));
	        lbl_rue.setBounds(395, 242, 69, 16);
	        add(lbl_rue);
	        
	        txt_rue = new JTextField();
	        txt_rue.setColumns(10);
	        txt_rue.setBounds(522, 239, 96, 25);
	        add(txt_rue);
	        
	        JLabel lbl_fax = new JLabel("Fax:");
	        lbl_fax.setForeground(Color.WHITE);
	        lbl_fax.setFont(new Font("Times New Roman", Font.BOLD, 16));
	        lbl_fax.setBounds(395, 409, 108, 25);
	        add(lbl_fax);
	        
	        txt_fax = new JTextField();
	        txt_fax.setColumns(10);
	        txt_fax.setBounds(543, 411, 212, 25);
	        add(txt_fax);
	        
	        JLabel lblEmail = new JLabel("Email:");
	        lblEmail.setForeground(Color.WHITE);
	        lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
	        lblEmail.setBounds(10, 455, 108, 25);
	        add(lblEmail);
	        
	        txt_email = new JTextField();
	        txt_email.setColumns(10);
	        txt_email.setBounds(158, 457, 212, 25);
	        add(txt_email);
	        
	        JLabel lblSiteWeb = new JLabel("Site Web:");
	        lblSiteWeb.setForeground(Color.WHITE);
	        lblSiteWeb.setFont(new Font("Times New Roman", Font.BOLD, 16));
	        lblSiteWeb.setBounds(395, 455, 108, 25);
	        add(lblSiteWeb);
	        
	        txt_site_web = new JTextField();
	        txt_site_web.setColumns(10);
	        txt_site_web.setBounds(543, 457, 212, 25);
	        add(txt_site_web);
	        
	        txt_codepostal = new JTextField();
	        txt_codepostal.setColumns(10);
	        txt_codepostal.setBounds(522, 275, 96, 25);
	        add(txt_codepostal);
	        
	        
		
		setVisible(true);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== btnValider) {
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				String url = "jdbc:mysql://localhost:3306/gestion_entreprise";
				Connection c = DriverManager.getConnection(url,"root","");

				Statement stmt = c.createStatement();
				
				String adresse1 = Integer.parseInt(txt_Num.getText())+"/"+txt_rue.getText()+"/"+txt_Libelle.getText()
				+"/"+txt_NomVille.getText()+"/"+Integer.parseInt( txt_codepostal.getText())+"/"+
						txt_Gouvernorat.getText()+"/"+txt_Pays.getText();
				
				String Vcp = txt_Banque.getText()+'/'+txt_Agence.getText()+'/'+Integer.parseInt(txt_Rib.getText());
				
				String type = (String) comboBox_Type.getSelectedItem();
				
				Entreprise entrepUp = new Entreprise(txt_Matricule.getText().toString(),txt_NomEntreprise.getText().toString(),
				type,txt_Description.getText().toString(),Vcp,adresse1,Integer.parseInt(txt_NumFixe.getText().toString()),
				Integer.parseInt(txt_NumMobile.getText().toString()),Integer.parseInt(txt_fax.getText().toString()),
				txt_email.getText().toString(),txt_site_web.getText().toString(),txt_EtatFiscale.getText().toString());
				
				
				String req= Requetes_SQL.modifier_entreprise(entrepUp);
				
				Class.forName("com.mysql.jdbc.Driver");
      			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_entreprise","root","");
      			PreparedStatement pst = conn.prepareStatement(req);
            	pst.execute();
            	JOptionPane.showMessageDialog(null, "Mise à jour de données avec succés");
            	pst.close();
    			
			}
			
			catch (Exception event) {
				JOptionPane.showMessageDialog(null,event);
			}
				
		
		
		
	}
}
	
	
}
	

