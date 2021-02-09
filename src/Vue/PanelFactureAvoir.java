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

import com.toedter.calendar.JDateChooser;

import Database.ConnectionDB;
import Database.Requetes_SQL;
import Metier.Bon_reception;
import Metier.Facture_avoir;
import Metier.Facture_client_BL;
import Metier.Facture_fournisseur_BL;
import Metier.Ligne_BR;
import Metier.Produit;
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
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

public class PanelFactureAvoir extends JPanel {
	private JTextField text_code;
	private JTextField text_Matricule;
	private JTextField textFieldsearch;
	private JButton btnAdd = new JButton("Ajouter");
	DefaultTableModel model = new DefaultTableModel();
	static JTable table = new JTable();
	private JTextField textField_search;
	private JDateChooser txt_date;
	private JComboBox Combobox_Fournisseur = new JComboBox();
	 private boolean emptyTable = false;
	 private JComboBox comboboxsearch = new JComboBox();
	 
	 private JTextField text_QteRetour;
		private JTextField text_desigProd;
		private JTextField text_MTPayer;
		private JTextField text_MRetour;
		private JTextField text_MReste;
		private JTextField text_mAR;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	//private JTextField text_mAR;
	/*private JTextField text_mPayer;
	*/


	/**
	 * Create the panel.
	 */
	public PanelFactureAvoir() {
		updateTable();
		setBackground(new Color(192, 192, 192));
		setSize(1200, 533);
		setLayout(null);
		
		JPanel panelDevis = new JPanel();
		panelDevis.setForeground(new Color(0, 0, 0));
		panelDevis.setLayout(null);
		panelDevis.setOpaque(false);
		panelDevis.setBorder(new TitledBorder(UIManager
        		.getBorder("TitledBorder.border"), "Gestion Facture Clients",
        		TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelDevis.setBackground(new Color(0, 0, 0));
		panelDevis.setBounds(10, 11, 962, 225);
        add(panelDevis);
        
        JLabel lblCode = new JLabel("Code:");
        lblCode.setForeground(SystemColor.textHighlightText);
        lblCode.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblCode.setBounds(10, 21, 49, 25);
        panelDevis.add(lblCode);
		
		text_code = new JTextField();
		text_code.setBounds(50, 21, 66, 25);
		panelDevis.add(text_code);
		text_code.setColumns(10);
		
		JLabel lblDateFacture = new JLabel("Date_Facture:");
		lblDateFacture.setForeground(SystemColor.textHighlightText);
		lblDateFacture.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDateFacture.setBounds(269, 23, 89, 20);
		panelDevis.add(lblDateFacture);
		
		
		txt_date = new JDateChooser();
        txt_date.setDateFormatString("yyyy-MM-dd");
        Date date = new Date();
        txt_date.setDate(date);
        txt_date.setBounds(357, 21, 96, 20);
        panelDevis.add(txt_date);
		
		JLabel lblmodepayement = new JLabel("Mode_Payement:");
		lblmodepayement.setForeground(SystemColor.textHighlightText);
		lblmodepayement.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblmodepayement.setBounds(10, 57, 93, 25);
		panelDevis.add(lblmodepayement);
		
		JLabel lblClient = new JLabel("Client:");
		lblClient.setForeground(SystemColor.textHighlightText);
		lblClient.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblClient.setBounds(126, 21, 89, 25);
		panelDevis.add(lblClient);
		
		
		JComboBox Combobox_Client = new JComboBox();
	     
			try{
			
				String sql = "SELECT code_client FROM `bon_livraison` "; 
				Class.forName("com.mysql.jdbc.Driver");
    			String url = "jdbc:mysql://localhost:3306/gestion_entreprise";
    			Connection c = DriverManager.getConnection(url,"root","");
    			Statement stmt = c.createStatement();
    			
           		pst = c.prepareStatement(sql);
    			rs = pst.executeQuery();
           		while (rs.next()) {
           			int tf=rs.getInt("code_client");
	                Combobox_Client.addItem(String.valueOf(tf));
	              
	            }           
	        }catch(Exception e1){
	            JOptionPane.showMessageDialog(null,e1);
	        }
			Combobox_Client.setBounds(177, 23, 82, 20);
	     panelDevis.add(Combobox_Client);
	     
	     
	     JComboBox comboBoxmodepayment = new JComboBox(new String[] {"espece", "cheque", "virement"});
	     comboBoxmodepayment.setBounds(110, 59, 89, 20);
	     panelDevis.add(comboBoxmodepayment);
	     
	     JComboBox comboBox_codeC = new JComboBox();
	     try{
				String sql = "SELECT code FROM `facture_client_bl` "; 
				Class.forName("com.mysql.jdbc.Driver");
 			String url = "jdbc:mysql://localhost:3306/gestion_entreprise";
 			Connection c = DriverManager.getConnection(url,"root","");
 			Statement stmt = c.createStatement();
 			
        		pst = c.prepareStatement(sql);
 			rs = pst.executeQuery();
        		while (rs.next()) {
        			int tf=rs.getInt("code");
        			comboBox_codeC.addItem(String.valueOf(tf));
	              
	            }           
	        }catch(Exception e1){
	            JOptionPane.showMessageDialog(null,e1);
	        }
	     
	     comboBox_codeC.setBounds(297, 59, 96, 20);
	     panelDevis.add(comboBox_codeC);
		
		JLabel lblcode = new JLabel("Code_F_Client:");
		lblcode.setForeground(SystemColor.textHighlightText);
		lblcode.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblcode.setBounds(209, 57, 89, 25);
		panelDevis.add(lblcode);
		
		
		   text_QteRetour = new JTextField();
		     text_QteRetour.setColumns(10);
		     text_QteRetour.setBounds(480, 57, 66, 25);
		     panelDevis.add(text_QteRetour);
		     
		     JLabel lblDesigProd = new JLabel("Designation_Produit:");
		     lblDesigProd.setForeground(Color.WHITE);
		     lblDesigProd.setFont(new Font("Times New Roman", Font.BOLD, 13));
		     lblDesigProd.setBounds(10, 93, 124, 25);
		     panelDevis.add(lblDesigProd);
		     
		     
		     JLabel lblQteRetour = new JLabel("Qte_Retour:");
		     lblQteRetour.setForeground(Color.WHITE);
		     lblQteRetour.setFont(new Font("Times New Roman", Font.BOLD, 13));
		     lblQteRetour.setBounds(405, 57, 76, 25);
		     panelDevis.add(lblQteRetour);
		     
		     
		     JLabel lblmtpayer = new JLabel("M_T_Payer:");
		     lblmtpayer.setForeground(Color.WHITE);
		     lblmtpayer.setFont(new Font("Times New Roman", Font.BOLD, 13));
		     lblmtpayer.setBounds(219, 90, 112, 25);
		     panelDevis.add(lblmtpayer);
		     
		     
		     text_desigProd = new JTextField();
		     text_desigProd.addMouseListener(new MouseAdapter() {
			     	@Override
			     	public void mouseClicked(MouseEvent e) {
			     	        try {
			     	        	
			     	        	String sql="SELECT designation FROM ligne_bl where code_client="+Combobox_Client.getSelectedItem();
			     	        	
			     	        	pst= conn.prepareStatement(sql);
			     	        	rs=pst.executeQuery();
			     	        	  while(rs.next()) {
			     	        	        String a=rs.getString("designation");
			     	        	         System.out.println(a); 
			     	        	        text_desigProd.setText(a);
			     	        	   }
			     	        }
			     	       
			     	         catch(Exception e1){
			     	            JOptionPane.showMessageDialog(null,e1);
			     	            } 
			     	    
			     	}
			     });
		     text_desigProd.setColumns(10);
		     text_desigProd.setBounds(133, 93, 66, 25);
		     panelDevis.add(text_desigProd);
		     
		     text_MTPayer = new JTextField();
		     text_MTPayer.addMouseListener(new MouseAdapter() {
			     	@Override
			     	public void mouseClicked(MouseEvent e) {
			     	        try {
			     	        	
			     	        	String sql="SELECT m_total_Payer FROM facture_client_bl where code_client="+Combobox_Client.getSelectedItem();
			     	        	
			     	        	pst= conn.prepareStatement(sql);
			     	        	rs=pst.executeQuery();
			     	        	  while(rs.next()) {
			     	        	        Float a=rs.getFloat("m_total_Payer");
			     	        	         System.out.println(a); 
			     	        	        text_MTPayer.setText(String.valueOf(a));
			     	        	   }
			     	        }
			     	       
			     	         catch(Exception e1){
			     	            JOptionPane.showMessageDialog(null,e1);
			     	            } 
			     	    
			     	}
			     });
		     text_MTPayer.setColumns(10);
		     text_MTPayer.setBounds(297, 90, 66, 25);
		     panelDevis.add(text_MTPayer);
		     
		     JLabel lblMretour = new JLabel("M_Retour:");
		     lblMretour.setForeground(Color.WHITE);
		     lblMretour.setFont(new Font("Times New Roman", Font.BOLD, 13));
		     lblMretour.setBounds(373, 90, 82, 25);
		     panelDevis.add(lblMretour);
		     
		     text_MRetour = new JTextField();
		     text_MRetour.addMouseListener(new MouseAdapter() {
			     	@Override
			     	public void mouseClicked(MouseEvent e) {
			     	        try {
			     	        	
			     	        	String sql="SELECT PU_hors_TVA,TVA FROM ligne_bl where code_client="+Combobox_Client.getSelectedItem();
			     	        	
			     	        	pst= conn.prepareStatement(sql);
			     	        	rs=pst.executeQuery();
			     	        	  while(rs.next()) {
			     	        	        Float a=rs.getFloat("PU_hors_TVA");
			     	        	        Float b=rs.getFloat("TVA");
			     	        	         System.out.println(a); 
			     	        	        System.out.println(b);
			     	        	        Float M = (a * (Integer.parseInt(text_QteRetour.getText())))+((b*a)/100);
			     	        	       text_MRetour.setText(String.valueOf(M));
			     	        	   }
			     	        }
			     	       
			     	         catch(Exception e1){
			     	            JOptionPane.showMessageDialog(null,e1);
			     	            } 
			     	    
			     	}
			     });
		     text_MRetour.setColumns(10);
		     text_MRetour.setBounds(451, 90, 66, 25);
		     panelDevis.add(text_MRetour);
		     
		     JLabel lblMapresretour = new JLabel("M_Apres_Retour:");
		     lblMapresretour.setForeground(Color.WHITE);
		     lblMapresretour.setFont(new Font("Times New Roman", Font.BOLD, 13));
		     lblMapresretour.setBounds(10, 130, 112, 25);
		     panelDevis.add(lblMapresretour);
		     
		     text_mAR = new JTextField();
		     text_mAR.addMouseListener(new MouseAdapter() {
			     	@Override
			     	public void mouseClicked(MouseEvent e) {
			     	        
			     	        	float mtp = Float.parseFloat(text_MTPayer.getText());
			     	        	float mr = Float.parseFloat(text_MRetour.getText());
			     	        	text_mAR.setText(String.valueOf(mtp-mr));
			     	        	  
			     	        }
			     	     
			     });
		     text_mAR.setColumns(10);
		     text_mAR.setBounds(117, 130, 82, 25);
		     panelDevis.add(text_mAR);
		     
		     JPanel panel = new JPanel();
		     panel.setLayout(null);
		     panel.setOpaque(false);
		     panel.setForeground(Color.BLACK);
		     panel.setBorder(new TitledBorder(UIManager

		             		.getBorder("TitledBorder.border"), "",

		             		TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		     panel.setBackground(Color.BLACK);
		     panel.setBounds(615, 11, 337, 210);
		     panelDevis.add(panel);
		     
		    JTextArea textArea = new JTextArea();
			textArea.setBounds(10, 11, 317, 188);
			panel.add(textArea);
		   
	     
	     
	     JPanel panelboutons = new JPanel();
	     panelboutons.setForeground(new Color(0, 0, 0));
	     panelboutons.setLayout(null);
	     panelboutons.setOpaque(false);
	     panelboutons.setBorder(new LineBorder(Color.WHITE));
	     panelboutons.setBackground(new Color(0, 0, 0));
	     panelboutons.setBounds(50, 174, 555, 40);
	     panelDevis.add(panelboutons);
	     btnAdd.setBounds(10, 4, 116, 30);
	     btnAdd.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		
		     		try {
		     			
		     			ConnectionDB c = new ConnectionDB();
						Statement stmt = c.ConnectDb().createStatement();
						
						String date1 = ((JTextField) txt_date.getDateEditor()
								.getUiComponent()).getText();
						
						Facture_avoir factureAvoir = new Facture_avoir(Integer.parseInt(text_code.getText().toString()),
							Integer.parseInt(Combobox_Client.getSelectedItem().toString()),date1,
							comboBoxmodepayment.getSelectedItem().toString(),Integer.parseInt(comboBox_codeC.getSelectedItem().toString()),Integer.parseInt(text_QteRetour.getText().toString()),
							text_desigProd.getText(),Float.parseFloat(text_MTPayer.getText().toString()),Float.parseFloat(text_MRetour.getText().toString()),
							Float.parseFloat(text_mAR.getText().toString()));
						
						String req= Requetes_SQL.ajouter_facture_avoir(factureAvoir);
						
						
						int nb=stmt.executeUpdate(req);
						if(nb==0)
							JOptionPane.showMessageDialog(null, "ERREUR d'ajout","Ajout_FactureBL" , JOptionPane.OK_OPTION);
						else
							JOptionPane.showMessageDialog(null, "ajout avec succés!","Ajout_FactureBL" , JOptionPane.OK_OPTION);
						
						
						String sql4 = "Update produit set stock = stock+'"+text_QteRetour.getText()+"'  where  designation='"+text_desigProd.getText()+"'" ;  
	          			PreparedStatement pst4 = conn.prepareStatement(sql4);
	                	pst4.execute();
	                	pst4.close();
						
						table.setModel(model);
	           			DefaultTableModel model = (DefaultTableModel) table.getModel();
	           			model.addRow(new Object[] {
	           					text_code.getText(),
	           					Combobox_Client.getSelectedItem(), 					
	           					((JTextField) txt_date.getDateEditor().getUiComponent()).getText(),
	           					comboBoxmodepayment.getSelectedItem(),
	           					comboBox_codeC.getSelectedItem(),
	           					text_QteRetour.getText(),
	           					text_desigProd.getText(),
	           					text_MTPayer.getText(),
	           					text_MRetour.getText(),
	           					text_mAR.getText(),
	           					
	           					});
	           			
	           			textArea.setText("");
	   					textArea.append("                     Fiche Facture Avoir\n"
	   					+"       ******************************************************** \n"
	   					+"Code_FactureAvoir :\t"+text_code.getText()
	   					+"\nCode_Client :\t "+Combobox_Client.getSelectedItem()
	   					+"\nDate_Facture :\t "+((JTextField) txt_date.getDateEditor().getUiComponent()).getText()
	   					+"\nMode_Payement :\t "+comboBoxmodepayment.getSelectedItem()
	   					+"\nCodeFactureC :\t "+comboBox_codeC.getSelectedItem() 
	   					+"\nQte_Retour :\t "+text_QteRetour.getText()
	   					+"\nDesig_Prod :\t "+text_desigProd.getText()
	   					+"\nMTPayer :\t "+text_MTPayer.getText()
	   					+"\nMRetour :\t "+text_MRetour.getText()
	   					+"\nMAR :\t "+text_mAR.getText()
	   					+"\n");
	   					
	      				
	   					text_code.setText(null);
       					Combobox_Client.setSelectedItem(null); 					
       					comboBoxmodepayment.setSelectedItem(null);
       					comboBox_codeC.setSelectedItem(null);
       					text_QteRetour.setText(null);
       					text_desigProd.setText(null);
       					text_MTPayer.setText(null);
       					text_MRetour.setText(null);
       					text_mAR.setText(null);
       					
       					
	      				
       					updateTable("1=1");
					}
					
					catch (Exception event) {
						JOptionPane.showMessageDialog(null, event);
					}
				
		     	}
		     });
	     panelboutons.add(btnAdd);
	     btnAdd.setIcon(new ImageIcon(PanelClient.class.getResource("/image/add.png")));
	     
	     JButton btnModifier = new JButton("Modifier");
	     btnModifier.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		try {
		     			ConnectionDB c = new ConnectionDB();
						Statement stmt = c.ConnectDb().createStatement();
						
						String date1 = ((JTextField) txt_date.getDateEditor()
								.getUiComponent()).getText();
						
						Facture_avoir factureAvoir = new Facture_avoir(Integer.parseInt(text_code.getText().toString()),
								Integer.parseInt(Combobox_Client.getSelectedItem().toString()),date1,
								comboBoxmodepayment.getSelectedItem().toString(),Integer.parseInt(comboBox_codeC.getSelectedItem().toString()),Integer.parseInt(text_QteRetour.getText().toString()),
								text_desigProd.getText(),Float.parseFloat(text_MTPayer.getText().toString()),Float.parseFloat(text_MRetour.getText().toString()),
								Float.parseFloat(text_mAR.getText().toString()));
						
						String req= Requetes_SQL.modifier_facture_avoir(factureAvoir);
						PreparedStatement pst = conn.prepareStatement(req);
						pst.execute();
	                	JOptionPane.showMessageDialog(null, "Mise à jour de factureAvoir avec succés");
	                	pst.close();
	                	
	                	
	                	
	               
	           			
	           			textArea.setText("");
	   					textArea.append("                     Fiche Facture Avoir\n"
	   					+"       ******************************************************** \n"
	   					+"Code_FactureAvoir :\t"+text_code.getText()
	   					+"\nCode_Client :\t "+Combobox_Client.getSelectedItem()
	   					+"\nDate_Facture :\t "+((JTextField) txt_date.getDateEditor().getUiComponent()).getText()
	   					+"\nMode_Payement :\t "+comboBoxmodepayment.getSelectedItem()
	   					+"\nCodeFactureC :\t "+comboBox_codeC.getSelectedItem() 
	   					+"\nQte_Retour :\t "+text_QteRetour.getText()
	   					+"\nDesig_Prod :\t "+text_desigProd.getText()
	   					+"\nMTPayer :\t "+text_MTPayer.getText()
	   					+"\nMRetour :\t "+text_MRetour.getText()
	   					+"\nMAR :\t "+text_mAR.getText()
	   					+"\n");
	   					
	      				
	   					text_code.setText(null);
       					Combobox_Client.setSelectedItem(null); 					
       					comboBoxmodepayment.setSelectedItem(null);
       					comboBox_codeC.setSelectedItem(null);
       					text_QteRetour.setText(null);
       					text_desigProd.setText(null);
       					text_MTPayer.setText(null);
       					text_MRetour.setText(null);
       					text_mAR.setText(null);
       					
       					
	   					
	   					updateTable("1=1");
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
		           		String sql = "DELETE FROM `facture_avoir` WHERE code=" +value; 
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
		    						JOptionPane.showMessageDialog(null, "Aucune donnée pour supprimer" , "Gestion des facturesBL", JOptionPane.OK_OPTION);
		    					}
		    					else {
		    						JOptionPane.showMessageDialog(null, "Selectionner une ligne pour la supprimer" , "Gestion des facturesBL", JOptionPane.OK_OPTION);
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
	     
	     
	     JPanel paneltableau = new JPanel();
	     paneltableau.setForeground(new Color(0, 0, 0));
	     paneltableau.setLayout(null);
	     paneltableau.setBorder(new TitledBorder(UIManager
	        		.getBorder("TitledBorder.border"), "Liste Facture FournisseurBL",
	        		TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
	     paneltableau.setOpaque(false);
	     paneltableau.setBackground(new Color(0, 0, 0));
	     paneltableau.setBounds(10, 247, 962, 218);
	     add(paneltableau);
	     
	    
	     
	     JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 70, 931, 137);
			paneltableau.add(scrollPane);
	     
	     Object col []= {"code", "code_client", "date_facture","mode_payement","code_facture_client","qte_retour","desig_prod","MTPayer",
	    		 "MRetour","MAR"};
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
			           		String sql = "select * from facture_avoir WHERE code=" +code; 
			         
			           		pst = c.prepareStatement(sql);
			    			rs = pst.executeQuery();
			           		while (rs.next()) {
			           			
		                		text_code.setText(rs.getString("code").toString());
		                		Combobox_Client.setSelectedItem(rs.getString("code_client").toString());
		                		Date d = rs.getDate("date_facture");
		                		txt_date.setDate(d);
		                		comboBoxmodepayment.setSelectedItem(rs.getString("mode_payement").toString());
		                		comboBox_codeC.setSelectedItem(rs.getString("code_facture_client").toString());
		                		text_QteRetour.setText(rs.getString("qte_retour").toString());
		                		text_desigProd.setText(rs.getString("desig_prod").toString());
		                		text_MTPayer.setText(rs.getString("MTPayer").toString());
		                		text_MRetour.setText(rs.getString("MRetour").toString());
		                		text_mAR.setText(rs.getString("MAR").toString());
		                		
		                	
		                	}
							
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null,e1);
						}
				}
				
			});
			table.setModel(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(89);
			scrollPane.setViewportView(table);
			
			
			comboboxsearch.setModel(new DefaultComboBoxModel(new String[] {"code", "code_client", "date_facture","mode_payement","code_facture_client","qte_retour","desig_prod","MTPayer",
		    		 "MRetour","MAR"}));
			comboboxsearch.setForeground(Color.black);
			comboboxsearch.setBackground(new Color(255, 255, 255));
			comboboxsearch.setBounds(164, 27, 195, 25);
			paneltableau.add(comboboxsearch);
				
			JLabel lblRecherche = new JLabel("");
			lblRecherche.setBounds(369, 27, 39, 32);
			paneltableau.add(lblRecherche);
			lblRecherche.setVerticalAlignment(SwingConstants.TOP);
			lblRecherche.setIcon(new ImageIcon(PanelClient.class.getResource("/image/seo (1).png")));
			
			textField_search = new JTextField();
			textField_search.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					try {
						String selection = (String)comboboxsearch.getSelectedItem();
						String sql = "select * from facture_avoir where "+selection+"=?"; 
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
			textField_search.setBounds(418, 28, 234, 25);
			paneltableau.add(textField_search);
		     
		 
				
				
		setVisible(true);

	}
	
	public void updateTable() {
		conn = ConnectionDB.ConnectDb();	
		
		if(conn != null)
			{
			String sql = "select * from facture_avoir";
         try {
         	pst = conn.prepareStatement(sql);
         	rs = pst.executeQuery();
         	Object col []= {"code", "code_client", "date_facture","mode_payement","code_facture_client","qte_retour","desig_prod","MTPayer",
   	    		 "MRetour","MAR"};
 			model.setColumnIdentifiers(col);
 			table.setModel(model);
         	Object[] columnData = new Object[10];
         	
         
         	while (rs.next()) {
         		
         		columnData[0] = rs.getInt("code");
         		columnData[1] = rs.getInt("code_client");
         		columnData[2] = rs.getDate("date_facture");
         		columnData[3] = rs.getString("mode_payement");
         		columnData[4] = rs.getInt("code_facture_client");
         		columnData[5] = rs.getInt("qte_retour");
         		columnData[6] = rs.getString("desig_prod");
         		columnData[7] = rs.getFloat("MTPayer");
         		columnData[8] = rs.getFloat("MRetour");
         		columnData[9] = rs.getFloat("MAR");
         		
         		model.addRow(columnData);
         	}
         
         }
         catch(Exception e ) {
         	JOptionPane.showMessageDialog(null, e);
         	
         }
			}
}
	// update table
		public void updateTable(String sql) {

			try {
				String sql1 = "select * from facture_avoir"; 
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
	


