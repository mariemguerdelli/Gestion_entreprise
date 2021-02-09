package Vue;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Database.ConnectionDB;
import Database.Requetes_SQL;
import Metier.Client;
import Metier.Devis;
import Metier.Entreprise;
import Vue.PanelEntreprise;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class PanelClient extends JPanel {
	private JTextField text_code;
	private JTextField text_Matricule;
	private JTextField text_NomEntreprise;
	private JTextField text_Description;
	private JTextField text_Banque;
	private JTextField text_Agence;
	private JTextField text_Rib;
	private JTextField text_Num;
	private JTextField text_Rue;
	private JTextField text_Libelle;
	private JTextField text_CodePostale;
	private JTextField text_NomVille;
	private JTextField text_NumFixe;
	private JTextField text_NumMobile;
	private JTextField text_EtatFiscale;
	private JTextField text_Gouvernorat;
	private JLabel lblBanque;
	private JLabel lblAgence;
	private JLabel lblRib;
	private JLabel lblNum;
	private JLabel lblLibell;
	private JLabel lblNomDeVille;
	private JLabel lblCodePostale;
	private JLabel lblGouvernorat;
	private JLabel lblPays;
	private JTextField text_Pays;
	private JTextField textFieldsearch;
	private JButton btnAdd = new JButton("Ajouter");
	DefaultTableModel model = new DefaultTableModel();
	static JTable table = new JTable();
	private JTextField textField_search;
	private JTextField txt_email;
	private JTextField txt_site_web;
	private JTextField txt_fax;
	private JLabel lbl_rue;
	private boolean emptyTable = false;
	private JComboBox combobox = new JComboBox();
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	


	/**
	 * Create the panel.
	 */
	public PanelClient() {
		updateTable();
		setBackground(new Color(192, 192, 192));
		setSize(1200, 690);
		setLayout(null);
		
		JPanel panelClient = new JPanel();
		panelClient.setForeground(new Color(0, 0, 0));
        panelClient.setLayout(null);
        panelClient.setOpaque(false);
        panelClient.setBorder(new TitledBorder(UIManager
        		.getBorder("TitledBorder.border"), "Gestion Clients",
        		TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
        panelClient.setBackground(new Color(0, 0, 0));
        panelClient.setBounds(10, 11, 962, 361);
        add(panelClient);
        
        JLabel lblCode = new JLabel("Code:");
        lblCode.setForeground(SystemColor.textHighlightText);
        lblCode.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblCode.setBounds(10, 22, 49, 25);
		panelClient.add(lblCode);
		
		text_code = new JTextField();
		text_code.setBounds(79, 24, 67, 20);
		panelClient.add(text_code);
		text_code.setColumns(10);
		
		JLabel lblMatricule = new JLabel("Matricule Fiscale:");
		lblMatricule.setForeground(SystemColor.textHighlightText);
		lblMatricule.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMatricule.setBounds(160, 22, 105, 25);
		panelClient.add(lblMatricule);
		
		text_Matricule = new JTextField();
		text_Matricule.setBounds(274, 24, 67, 20);
		panelClient.add(text_Matricule);
		text_Matricule.setColumns(10);
		
		JLabel lblNomEntreprise = new JLabel("Nom Etreprise:");
		lblNomEntreprise.setForeground(SystemColor.textHighlightText);
		lblNomEntreprise.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNomEntreprise.setBounds(351, 22, 89, 25);
		panelClient.add(lblNomEntreprise);
		
		text_NomEntreprise = new JTextField();
		text_NomEntreprise.setColumns(10);
		text_NomEntreprise.setBounds(441, 24, 67, 20);
		panelClient.add(text_NomEntreprise);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setForeground(SystemColor.textHighlightText);
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblType.setBounds(518, 22, 35, 25);
		panelClient.add(lblType);
		
		JComboBox comboBox_Type = new JComboBox();
		comboBox_Type.setModel(new DefaultComboBoxModel(new String[] {"","physique", "morale"}));
		comboBox_Type.setBounds(604, 24, 67, 20);
		panelClient.add(comboBox_Type);
		
		JLabel lblDescriptionActivit = new JLabel("Description:");
		lblDescriptionActivit.setForeground(SystemColor.textHighlightText);
		lblDescriptionActivit.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDescriptionActivit.setBounds(10, 48, 76, 25);
		panelClient.add(lblDescriptionActivit);
		
		text_Description = new JTextField();   
		text_Description.setColumns(10);
		text_Description.setBounds(79, 50, 67, 20);
		panelClient.add(text_Description);
		
		text_Banque = new JTextField();
		text_Banque.setBounds(274, 50, 67, 20);
		panelClient.add(text_Banque);
		text_Banque.setColumns(10);
		
		text_Agence = new JTextField();
		text_Agence.setColumns(10);        
		text_Agence.setBounds(441, 48, 67, 20);
		panelClient.add(text_Agence);
		
		text_Rib = new JTextField();
		text_Rib.setColumns(10);
		text_Rib.setBounds(604, 50, 67, 20);
		panelClient.add(text_Rib);
		
		text_Num = new JTextField();  
		text_Num.setColumns(10);
		text_Num.setBounds(79, 81, 67, 20);
		panelClient.add(text_Num);
		
		text_Rue = new JTextField();  
		text_Rue.setColumns(10);
		text_Rue.setBounds(274, 81, 67, 20);
		panelClient.add(text_Rue);
		
		text_Libelle = new JTextField();
		text_Libelle.setColumns(10);
		text_Libelle.setBounds(437, 81, 67, 20);
		panelClient.add(text_Libelle);
		
		text_CodePostale = new JTextField();
		text_CodePostale.setColumns(10);
		text_CodePostale.setBounds(242, 114, 67, 20);
		panelClient.add(text_CodePostale); 
		 
		text_NomVille = new JTextField();
		text_NomVille.setColumns(10);
		text_NomVille.setBounds(604, 81, 67, 20);
		panelClient.add(text_NomVille);
		
		JLabel lblNumTlFixe = new JLabel("Num t\u00E9l fixe:");
		lblNumTlFixe.setForeground(SystemColor.textHighlightText);
		lblNumTlFixe.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNumTlFixe.setBounds(518, 112, 76, 25);
		panelClient.add(lblNumTlFixe);
		
		JLabel lblNumTlMobile = new JLabel("Num t\u00E9l mobile:");
		lblNumTlMobile.setForeground(SystemColor.textHighlightText);
		lblNumTlMobile.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNumTlMobile.setBounds(10, 139, 89, 25);
		panelClient.add(lblNumTlMobile);
		
		text_NumFixe = new JTextField();
		text_NumFixe.setColumns(10);
		text_NumFixe.setBounds(604, 114, 67, 20);
		panelClient.add(text_NumFixe);
		
		text_NumMobile = new JTextField();
		text_NumMobile.setColumns(10);
		text_NumMobile.setBounds(96, 141, 67, 20);
		panelClient.add(text_NumMobile);
		
		JLabel lblEtatFiscale = new JLabel("Etat Fiscale:");
		lblEtatFiscale.setForeground(SystemColor.textHighlightText);
		lblEtatFiscale.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEtatFiscale.setBounds(173, 144, 67, 25);
		panelClient.add(lblEtatFiscale);
		
		text_EtatFiscale = new JTextField();
		text_EtatFiscale.setColumns(10);
		text_EtatFiscale.setBounds(242, 144, 67, 20);
		panelClient.add(text_EtatFiscale);
		
		text_Gouvernorat = new JTextField();
		text_Gouvernorat.setColumns(10);
		text_Gouvernorat.setBounds(96, 112, 67, 20);
		panelClient.add(text_Gouvernorat);
		
		lblBanque = new JLabel("Banque:");
		lblBanque.setForeground(new Color(0, 51, 51));
		lblBanque.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblBanque.setBounds(180, 52, 49, 16);
		panelClient.add(lblBanque);
		
		lblAgence = new JLabel("Agence:");
		lblAgence.setForeground(new Color(0, 51, 51));
		lblAgence.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblAgence.setBounds(382, 48, 49, 16);
		panelClient.add(lblAgence);
		
		lblRib = new JLabel("RIB:");
		lblRib.setForeground(new Color(0, 51, 51));
		lblRib.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblRib.setBounds(524, 52, 35, 16);
		panelClient.add(lblRib);
		
		lblNum = new JLabel("Num:");
		lblNum.setForeground(new Color(0, 51, 51));
		lblNum.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNum.setBounds(10, 84, 76, 16);
		panelClient.add(lblNum);
		
		lblLibell = new JLabel("Libell\u00E9:");
		lblLibell.setForeground(new Color(0, 51, 51));
		lblLibell.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblLibell.setBounds(343, 83, 49, 16);
		panelClient.add(lblLibell);
		
		lblNomDeVille = new JLabel("Nom de Ville:");
		lblNomDeVille.setForeground(new Color(0, 51, 51));
		lblNomDeVille.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNomDeVille.setBounds(518, 85, 76, 16);
		panelClient.add(lblNomDeVille);
		
		lblCodePostale = new JLabel("Code Postal:");
		lblCodePostale.setForeground(new Color(0, 51, 51));
		lblCodePostale.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCodePostale.setBounds(173, 118, 76, 16);
		panelClient.add(lblCodePostale);
		
		lblGouvernorat = new JLabel("Gouvernorat:");
		lblGouvernorat.setForeground(new Color(0, 51, 51));
		lblGouvernorat.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblGouvernorat.setBounds(10, 114, 81, 16);
		panelClient.add(lblGouvernorat);
		
		lblPays = new JLabel("Pays:");
		lblPays.setForeground(new Color(0, 51, 51));
		lblPays.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblPays.setBounds(343, 116, 40, 16);
		panelClient.add(lblPays);
		
		text_Pays = new JTextField();
		text_Pays.setColumns(10);
		text_Pays.setBounds(437, 114, 67, 20);
		panelClient.add(text_Pays);
		
		 JPanel panelAffichage = new JPanel();
	     panelAffichage.setLayout(null);
	     panelAffichage.setOpaque(false);
	     panelAffichage.setForeground(Color.BLACK);
	     panelAffichage.setBorder(new TitledBorder(UIManager

	             		.getBorder("TitledBorder.border"), "",

	             		TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
	     panelAffichage.setBackground(Color.BLACK);
	     panelAffichage.setBounds(673, 11, 279, 339);
	     panelClient.add(panelAffichage);
	     
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 7, 259, 321);
		panelAffichage.add(textArea);
     
	     
	     JPanel panelboutons = new JPanel();
	     panelboutons.setForeground(new Color(0, 0, 0));
	     panelboutons.setLayout(null);
	     panelboutons.setOpaque(false);
	     panelboutons.setBorder(new LineBorder(Color.WHITE));
	     panelboutons.setBackground(new Color(0, 0, 0));
	     panelboutons.setBounds(66, 272, 555, 40);
	     panelClient.add(panelboutons);
	     btnAdd.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     	
	     		 if (text_code.getText().trim().isEmpty()||text_Matricule.getText().trim().isEmpty()||
	     				 text_NomEntreprise.getText().trim().isEmpty()||
	     				 text_Description.getText().trim().isEmpty()||
	     				 text_NumFixe.getText().trim().isEmpty()||text_NumMobile.getText().trim().isEmpty()||
	     				 txt_fax.getText().trim().isEmpty()||txt_email.getText().trim().isEmpty()||
	     				 txt_site_web.getText().trim().isEmpty()){
	                 JOptionPane.showMessageDialog(null,"veillez remplir les champs vides");
	             }
	             else {
	     		try {
	     			
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://localhost:3306/gestion_entreprise";
					Connection c = DriverManager.getConnection(url,"root","");
                     
					Statement stmt = c.createStatement();
					
					String adresse1 = Integer.parseInt(text_Num.getText())+"/"+text_Rue.getText()+"/"+text_Libelle.getText()
					+"/"+text_NomVille.getText()+"/"+Integer.parseInt( text_CodePostale.getText())+"/"+
							text_Gouvernorat.getText()+"/"+text_Pays.getText();
					
				
					String cb = text_Banque.getText()+"/"+text_Agence.getText()+"/"+Integer.parseInt(text_Rib.getText());
					String type = (String) comboBox_Type.getSelectedItem();
					Client client1 = new Client(Integer.parseInt(text_code.getText()),text_Matricule.getText().toString(),text_NomEntreprise.getText().toString(),
							type,
						text_Description.getText().toString(),cb,adresse1,
							Integer.parseInt(text_NumFixe.getText().toString()),Integer.parseInt(text_NumMobile.getText().toString()),
							Integer.parseInt(txt_fax.getText().toString()),txt_email.getText().toString(),txt_site_web.getText().toString(),text_EtatFiscale.getText().toString());
					
					
					String req= Requetes_SQL.ajouter_client(client1);
					int nb=stmt.executeUpdate(req);
					if(nb==0)
						JOptionPane.showMessageDialog(null, "ERREUR d'ajout","Ajout_client" , JOptionPane.OK_OPTION);
					else
						JOptionPane.showMessageDialog(null, "ajout avec succés!","Ajout_client" , JOptionPane.OK_OPTION);
					
				
					table.setModel(model);
           			DefaultTableModel model = (DefaultTableModel) table.getModel();
           			model.addRow(new Object[] {
           					text_code.getText(),
           					text_Matricule.getText(),
           					text_NomEntreprise.getText(),
           					(String) comboBox_Type.getSelectedItem(),
           					text_Description.getText(),
           					text_Banque.getText(),
           					text_Agence.getText(),
           					text_Rib.getText(),
           					text_Num.getText(),
           					text_Rue.getText(),
           					text_Libelle.getText(),
           					text_NomVille.getText(),
           					text_CodePostale.getText(),
							text_Gouvernorat.getText(),
							text_Pays.getText(),
           					text_NumFixe.getText(),
           					text_NumMobile.getText(),
           					txt_fax.getText(),
           					txt_email.getText(),
           					txt_site_web.getText(),
           					text_EtatFiscale.getText()
           					
           					
           					});
      				
           			textArea.setText("");
   					textArea.append(""
   					+"Code :\t"+text_code.getText()
   					+"\nMatricule :\t "+text_Matricule.getText()
   					+"\nNomEntrep :\t "+text_NomEntreprise.getText()
   					+"\nType :\t "+(String) comboBox_Type.getSelectedItem()
   					+"\nDescription :\t "+text_Description.getText()
   					+"\nBanque :\t "+text_Banque.getText()
   					+"\nAgence :\t "+text_Agence.getText()
   					+"\nRib : \t"+text_Rib.getText()
   					+"\nNum : \t"+text_Num.getText()
   					+"\nRue : \t"+text_Rue.getText()
   					+"\nLibelle \t: "+text_Libelle.getText()
   					+"\nNomVille \t: "+text_NomVille.getText()
   					+"\nCodePostale \t: "+text_CodePostale.getText()
   					+"\nGouvernorat \t: "+text_Gouvernorat.getText()
   					+"\nPays \t: "+text_Pays.getText()
   					+"\nNumFixe \t: "+text_NumFixe.getText()
   					+"\nNumMobile \t: "+text_NumMobile.getText()
   					+"\nFax \t: "+txt_fax.getText()
   					+"\nEmail \t: "+txt_email.getText()
   					+"\nNumMobile \t: "+txt_site_web.getText()
   					+"\nSite_web \t: "+text_EtatFiscale.getText()+"\n");
		      			
	     		
   					text_code.setText(null);
   					text_Matricule.setText(null);
   					text_NomEntreprise.setText(null);
   					comboBox_Type.setSelectedItem(null);
   					text_Description.setText(null);
   					text_Banque.setText(null);
   					text_Agence.setText(null);
   					text_Rib.setText(null);
   					text_Num.setText(null);
   					text_Rue.setText(null);
   					text_Libelle.setText(null);
   					text_NomVille.setText(null);
   					text_CodePostale.setText(null);
   					text_Gouvernorat.setText(null);
   					text_Pays.setText(null);
   					text_NumFixe.setText(null);
   					text_NumMobile.setText(null);
   					txt_fax.setText(null);
   					txt_email.setText(null);
   					txt_site_web.setText(null);
   					text_EtatFiscale.setText(null);
      				
				}
	             
				catch (Exception event) {
					JOptionPane.showMessageDialog(null,event);
				}
			
	             }
	     	}
	     	
	     });
	     btnAdd.setBounds(10, 4, 116, 30);
	     panelboutons.add(btnAdd);
	     btnAdd.setIcon(new ImageIcon(PanelClient.class.getResource("/image/add.png")));
	     
	     JButton btnModifier = new JButton("Modifier");
	     btnModifier.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		try {
		     			Class.forName("com.mysql.jdbc.Driver");
						String url = "jdbc:mysql://localhost:3306/gestion_entreprise";
						Connection c = DriverManager.getConnection(url,"root","");
	                     
						Statement stmt = c.createStatement();
						
						String adresse1 = Integer.parseInt(text_Num.getText())+"/"+text_Rue.getText()+"/"+text_Libelle.getText()
						+"/"+text_NomVille.getText()+"/"+Integer.parseInt( text_CodePostale.getText())+"/"+
								text_Gouvernorat.getText()+"/"+text_Pays.getText();
						
					
						
						String cb = text_Banque.getText()+"/"+text_Agence.getText()+"/"+Integer.parseInt(text_Rib.getText());
						
						String type = (String) comboBox_Type.getSelectedItem();
						
						Client client1 = new Client(Integer.parseInt(text_code.getText()),text_Matricule.getText().toString(),text_NomEntreprise.getText().toString(),
								type,
							text_Description.getText().toString(),cb,adresse1,
								Integer.parseInt(text_NumFixe.getText().toString()),Integer.parseInt(text_NumMobile.getText().toString()),
								Integer.parseInt(txt_fax.getText().toString()),txt_email.getText().toString(),txt_site_web.getText().toString(),text_EtatFiscale.getText().toString());
						
						
						String req= Requetes_SQL.modifier_client(client1);
						
						PreparedStatement pst = conn.prepareStatement(req);
						pst.execute();
			     	   JOptionPane.showMessageDialog(null, "Mise à jour avec succés");
			     	    pst.close();
						
						table.setModel(model);
	           			DefaultTableModel model = (DefaultTableModel) table.getModel();
	           			model.addRow(new Object[] {
	           					text_code.getText(),
	           					text_Matricule.getText(),
	           					text_NomEntreprise.getText(),
	           					(String) comboBox_Type.getSelectedItem(),
	           					text_Description.getText(),
	           					text_Banque.getText(),
	           					text_Agence.getText(),
	           					text_Rib.getText(),
	           					text_Num.getText(),
	           					text_Rue.getText(),
	           					text_Libelle.getText(),
	           					text_NomVille.getText(),
	           					text_CodePostale.getText(),
								text_Gouvernorat.getText(),
								text_Pays.getText(),
	           					text_NumFixe.getText(),
	           					text_NumMobile.getText(),
	           					txt_fax.getText(),
	           					txt_email.getText(),
	           					txt_site_web.getText(),
	           					text_EtatFiscale.getText()
	           					
	           					});
	      				
	           			textArea.setText("");
	   					textArea.append(""
	   					+"Code :\t"+text_code.getText()
	   					+"\nMatricule :\t "+text_Matricule.getText()
	   					+"\nNomEntrep :\t "+text_NomEntreprise.getText()
	   					+"\nType :\t "+(String) comboBox_Type.getSelectedItem()
	   					+"\nDescription :\t "+text_Description.getText()
	   					+"\nBanque :\t "+text_Banque.getText()
	   					+"\nAgence :\t "+text_Agence.getText()
	   					+"\nRib : \t"+text_Rib.getText()
	   					+"\nNum : \t"+text_Num.getText()
	   					+"\nRue : \t"+text_Rue.getText()
	   					+"\nLibelle \t: "+text_Libelle.getText()
	   					+"\nNomVille \t: "+text_NomVille.getText()
	   					+"\nCodePostale \t: "+text_CodePostale.getText()
	   					+"\nGouvernorat \t: "+text_Gouvernorat.getText()
	   					+"\nPays \t: "+text_Pays.getText()
	   					+"\nNumFixe \t: "+text_NumFixe.getText()
	   					+"\nNumMobile \t: "+text_NumMobile.getText()
	   					+"\nFax \t: "+txt_fax.getText()
	   					+"\nEmail \t: "+txt_email.getText()
	   					+"\netat_fiscale \t: "+txt_site_web.getText()
	   					+"\nSite_web \t: "+text_EtatFiscale.getText()+"\n");
			      			
		     		
	   					text_code.setText(null);
	   					text_Matricule.setText(null);
	   					text_NomEntreprise.setText(null);
	   					text_Description.setText(null);
	   					text_Banque.setText(null);
	   					text_Agence.setText(null);
	   					text_Rib.setText(null);
	   					text_Num.setText(null);
	   					text_Rue.setText(null);
	   					text_Libelle.setText(null);
	   					text_NomVille.setText(null);
	   					text_CodePostale.setText(null);
	   					text_Gouvernorat.setText(null);
	   					text_Pays.setText(null);
	   					text_NumFixe.setText(null);
	   					text_NumMobile.setText(null);
	   					txt_fax.setText(null);
	   					txt_email.setText(null);
	   					txt_site_web.setText(null);
	   					text_EtatFiscale.setText(null);
						
	   					updateTable("1=1 ");
			     	
			     	
		     		}
		     		catch (Exception event) {
						JOptionPane.showMessageDialog(null,event);
					}
						
		     }});
	     btnModifier.setIcon(new ImageIcon(PanelClient.class.getResource("/image/updated.png")));
	     btnModifier.setBounds(147, 4, 116, 30);
	     panelboutons.add(btnModifier);
	     
	     JButton btnSupprimer = new JButton("Supprimer");
	     btnSupprimer.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		try {
		           		int row = table.getSelectedRow();
		           		String value =  table.getModel().getValueAt(row, 0).toString();
		           		String sql = "DELETE FROM `client` WHERE code=" +value; 
		           		pst = conn.prepareStatement(sql);
		            	pst.execute();
		            	JOptionPane.showMessageDialog(null, "Données supprimés");
		            	pst.close();
		            	DefaultTableModel model = (DefaultTableModel) table.getModel();
		            	model.removeRow(table.getSelectedRow());}
		           		
		           		catch(Exception ex) {
		           			JOptionPane.showMessageDialog(null, ex);
		           			if(table.getSelectedRow() == -1) {
		    					if(table.getRowCount() == 0) {
		    						JOptionPane.showMessageDialog(null, "Aucune donnée pour supprimer" , "Gestion client", JOptionPane.OK_OPTION);
		    					}
		    					else {
		    						JOptionPane.showMessageDialog(null, "Selectionner une ligne pour la supprimer" , "Gestion client", JOptionPane.OK_OPTION);
		    					}
		    				}}

		     	}
		     });
	     btnSupprimer.setIcon(new ImageIcon(PanelClient.class.getResource("/image/delete (1).png")));
	     btnSupprimer.setBounds(282, 4, 123, 30);
	     panelboutons.add(btnSupprimer);
	     
	     JButton btnImprimer = new JButton("Imprimer");
	     btnImprimer.addActionListener(new ActionListener() {
	    	 public void actionPerformed(ActionEvent arg0) {
					try {
						textArea.print();					}
					catch(java.awt.print.PrinterException e)
					{
						System.err.format("No Printer found", e.getMessage());
					}
				}
	     	
	     });
	     btnImprimer.setIcon(new ImageIcon(PanelClient.class.getResource("/image/printer (1).png")));
	     btnImprimer.setBounds(429, 4, 116, 30);
	     panelboutons.add(btnImprimer);
	     
	     JLabel lblEmail = new JLabel("Email:");
	     lblEmail.setForeground(Color.WHITE);
	     lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 13));
	     lblEmail.setBounds(510, 148, 40, 25);
	     panelClient.add(lblEmail);
	     
	     txt_email = new JTextField();
	     txt_email.setColumns(10);
	     txt_email.setBounds(604, 150, 67, 20);
	     panelClient.add(txt_email);
	     
	     JLabel lblSiteWeb = new JLabel("Site Web:");
	     lblSiteWeb.setForeground(Color.WHITE);
	     lblSiteWeb.setFont(new Font("Times New Roman", Font.BOLD, 13));
	     lblSiteWeb.setBounds(10, 167, 61, 25);
	     panelClient.add(lblSiteWeb);
	     
	     txt_site_web = new JTextField();
	     txt_site_web.setColumns(10);
	     txt_site_web.setBounds(100, 169, 67, 20);
	     panelClient.add(txt_site_web);
	     
	     JLabel lblFax = new JLabel("Fax:");
	     lblFax.setForeground(Color.WHITE);
	     lblFax.setFont(new Font("Times New Roman", Font.BOLD, 13));
	     lblFax.setBounds(368, 145, 35, 25);
	     panelClient.add(lblFax);
	     
	     txt_fax = new JTextField();
	     txt_fax.setColumns(10);
	     txt_fax.setBounds(437, 144, 67, 20);
	     panelClient.add(txt_fax);
	     
	     lbl_rue = new JLabel("Rue:");
	     lbl_rue.setForeground(new Color(0, 51, 51));
	     lbl_rue.setFont(new Font("Times New Roman", Font.BOLD, 13));
	     lbl_rue.setBounds(205, 84, 76, 16);
	     panelClient.add(lbl_rue);
	     
	     
	     JPanel paneltableau = new JPanel();
	     paneltableau.setForeground(new Color(0, 0, 0));
	     paneltableau.setLayout(null);
	     paneltableau.setBorder(new TitledBorder(UIManager
	        		.getBorder("TitledBorder.border"), "",
	        		TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
	     paneltableau.setOpaque(false);
	     paneltableau.setBackground(new Color(0, 0, 0));
	     paneltableau.setBounds(10, 373, 962, 143);
	     add(paneltableau);
	     
	     combobox.setModel(new DefaultComboBoxModel(new String[] {"Code", "Client", "Date_bon","Date_livraison","Adresse_livraison","Info_bon",
				 "Ref","Designation","Unite_mesure",
	    		 "Qte_livr","PU_hors_TVA","TVA","PTotalHorsTVA"}));
			combobox.setForeground(Color.black);
			combobox.setBackground(new Color(255, 255, 255));
			combobox.setBounds(207, 7, 195, 25);
			paneltableau.add(combobox);
	     
	    
	     
	     JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 45, 931, 87);
			paneltableau.add(scrollPane);
	     
			Object col []= {"code", "matricule_fiscale", "raison_sociale","type","description",
       			 "Banque","Agence","Rib",
   	    		 "Num","Rue","Libelle","NomVille","codepostal","Gouvernorat","Pays",
   	    		 "num_tlf_fixe","num_tlf_mobile","fax"," email","site_web","etat_fiscale"};
			model.setColumnIdentifiers(col);
			table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!emptyTable)
					try {
						
						Class.forName("com.mysql.jdbc.Driver");
		    			String url = "jdbc:mysql://localhost:3306/gestion_entreprise";
		    			Connection c = DriverManager.getConnection(url,"root","");
		    			Statement stmt = c.createStatement();
		    	
						int row = table.getSelectedRow();
						int code = Integer.parseInt((table.getModel().getValueAt(row, 0))
								.toString());
		           		String sql = "SELECT * FROM `client` WHERE code=" +code; 
		                System.out.println(sql);
		           		pst = c.prepareStatement(sql);
		    			rs = pst.executeQuery();
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
	                		
	                		text_code.setText(rs.getString("code").toString());
	                		text_Matricule.setText(rs.getString("matricule_fiscale").toString());
	                		text_NomEntreprise.setText(rs.getString("raison_sociale").toString());
	                		comboBox_Type.getModel().setSelectedItem(rs.getString("type").toString());
	                		text_Description.setText(rs.getString("description").toString());
	                		text_Banque.setText(banque);
	                		text_Agence.setText(agence);
	                		text_Rib.setText(rib);
	                		text_Num.setText(Num);
	                		text_Rue.setText(rue);
	                		text_Libelle.setText(Libelle);
	                		text_NomVille.setText(NomVille);
	                		text_CodePostale.setText(codepostal);
	                		text_Gouvernorat.setText(Gouvernorat);
	                		text_Pays.setText(Pays);
	                		text_NumFixe.setText(rs.getString("num_tlf_fixe").toString());
	                		text_NumMobile.setText(rs.getString("num_tlf_mobile").toString());
	                		txt_fax.setText(rs.getString("fax").toString());
	                		txt_email.setText(rs.getString("email").toString());
	                		txt_site_web.setText(rs.getString("site_web").toString());
	                		text_EtatFiscale.setText(rs.getString("etat_fiscale").toString());
	                		
	                	}
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
			}
			});
			table.setModel(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(89);
			scrollPane.setViewportView(table);
			
			JLabel lblRecherche = new JLabel("");
			lblRecherche.setBounds(160, 7, 39, 32);
			paneltableau.add(lblRecherche);
			lblRecherche.setVerticalAlignment(SwingConstants.TOP);
			lblRecherche.setIcon(new ImageIcon(PanelClient.class.getResource("/image/seo (1).png")));
			
			textField_search = new JTextField();
			textField_search.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					try {
						String selection = (String)combobox.getSelectedItem();
						String sql = "select * from client where "+selection+"=?"; 
						PreparedStatement pst = conn.prepareStatement(sql);
						pst.setString(1,textField_search.getText());
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						pst.close();
						
						
					} catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				
			});
			textField_search.setColumns(10);
			textField_search.setBounds(412, 7, 234, 25);
			paneltableau.add(textField_search);
			
			
		setVisible(true);

	}
	public void updateTable() {
		conn = ConnectionDB.ConnectDb();	
		if(conn != null)
			{
			String sql = "SELECT * FROM `client`";
            try {
            	pst = conn.prepareStatement(sql);
            	rs = pst.executeQuery();
            	 Object col []= {"Code", "MatFisc", "raison_sociale","type","description",
            			 "Banque","Agence","Rib",
        	    		 "Num","Rue","Libelle","NomVille","codepostal","Gouvernorat","Pays",
        	    		 "NumTlfFix","NumTlfMobile"," Fax","Email","Site_web","etat_fiscale"};
    			model.setColumnIdentifiers(col);
    			table.setModel(model);
            	Object[] columnData = new Object[21];
      
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
            	
            		
            		columnData[0] = rs.getInt("code");
            		columnData[1] = rs.getString("matricule_fiscale");
            		columnData[2] = rs.getString("raison_sociale");
            		columnData[3] = rs.getString("type");
            		columnData[4] = rs.getString("description");
            		columnData[5] = banque;
            		columnData[6] = agence;
            		columnData[7] = rib;
            		columnData[8] = Num;
            		columnData[9] = rue;
            		columnData[10] = Libelle;
            		columnData[11] = NomVille;
            		columnData[12] = codepostal;
            		columnData[13] = Gouvernorat;
            		columnData[14] = Pays;
            		columnData[15] = rs.getInt("num_tlf_fixe");
            		columnData[16] = rs.getInt("num_tlf_mobile");
            		columnData[17] = rs.getString("etat_fiscale");
            		columnData[18] = rs.getInt("fax");
            		columnData[19] = rs.getString("email");
            		columnData[20] = rs.getString("site_web");
            		
            		 
            		model.addRow(columnData);
            	}
            
            }
            catch(Exception e ) {
            	JOptionPane.showMessageDialog(null, e);
            	
            }
			}
}
	
		public void updateTable(String sql) {

			try {
				String sql1 = "select * from client"; 
				PreparedStatement pst = conn.prepareStatement(sql1);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
        		
			
				if (!rs.first())
					emptyTable = true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	

}
	


