package Vue;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
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
import Metier.Devis;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class PanelProduitAchat extends JPanel  implements  ActionListener {
	private JTextField text_ref;
	private JTextField text_Matricule;
	private JTextField text_CodeFP;
	private JTextField text_Designation;
	private JTextField text_designationFP;

	private JTextField text_TVA;
	private JTextField textFieldsearch;
	private JButton btnLogin = new JButton("Ajouter");
	DefaultTableModel model = new DefaultTableModel();
	static JTable table = new JTable();
	private JTextField textField_search;
	private JTextField text_stockmin;
	private JTextField text_PUHorsTaxe;
	private JTextField text_code;
	private JTextField text_fournisseur;
    private boolean emptyTable = false;
    
    private JComboBox combobox = new JComboBox();
    private JComboBox text_unitemesure = new JComboBox();
    private JSpinner text_Stock = new JSpinner(new SpinnerNumberModel(0, 0, 50, 1));
   
	
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	


	/**
	 * Create the panel.
	 */
	public PanelProduitAchat() {
		updateTable();
		setBackground(new Color(192, 192, 192));
		setSize(1200, 533);
		setLayout(null);
		
		JPanel panelProduits = new JPanel();
		panelProduits.setForeground(new Color(0, 0, 0));
		panelProduits.setLayout(null);
		panelProduits.setOpaque(false);
		panelProduits.setBorder(new TitledBorder(UIManager
        		.getBorder("TitledBorder.border"), "Gestion Produits",
        		TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelProduits.setBackground(new Color(0, 0, 0));
		panelProduits.setBounds(10, 11, 962, 232);
        add(panelProduits);
        
        JLabel lblcode = new JLabel("Code:");
        lblcode.setForeground(SystemColor.textHighlightText);
        lblcode.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblcode.setBounds(10, 22, 49, 25);
        panelProduits.add(lblcode);
        
        JLabel lblRef = new JLabel("R\u00E9f:");
        lblRef.setForeground(SystemColor.textHighlightText);
        lblRef.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblRef.setBounds(238, 22, 49, 25);
        panelProduits.add(lblRef);
		
		text_ref = new JTextField();
		text_ref.setBounds(310, 22, 95, 25);
		panelProduits.add(text_ref);
		text_ref.setColumns(10);
		
		JLabel lblUnitemesure = new JLabel("Unit\u00E9 m\u00E9sure:");
		lblUnitemesure.setForeground(SystemColor.textHighlightText);
		lblUnitemesure.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblUnitemesure.setBounds(10, 65, 88, 25);
		panelProduits.add(lblUnitemesure);
		
		
		
		text_unitemesure.setModel(new DefaultComboBoxModel(new String[] {"Piece", "Kg", "L"}));
		text_unitemesure.setForeground(Color.black);
		text_unitemesure.setBackground(new Color(255, 255, 255));
		text_unitemesure.setBounds(123, 69, 88, 25);
		panelProduits.add(text_unitemesure);
		
		JLabel lblCode = new JLabel("Code_FP:");
		lblCode.setForeground(SystemColor.textHighlightText);
		lblCode.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCode.setBounds(428, 65, 55, 25);
		panelProduits.add(lblCode);
		
		text_CodeFP = new JTextField();   
		text_CodeFP.setColumns(10);
		text_CodeFP.setBounds(519, 65, 95, 25);
		panelProduits.add(text_CodeFP);
		
		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setForeground(SystemColor.textHighlightText);
		lblDesignation.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDesignation.setBounds(428, 22, 82, 25);
		panelProduits.add(lblDesignation);
		
		text_Designation = new JTextField();
		text_Designation.setBounds(520, 22, 94, 25);
		panelProduits.add(text_Designation);
		text_Designation.setColumns(10);
		
		text_designationFP = new JTextField();
		text_designationFP.setColumns(10);
		text_designationFP.setBounds(123, 104, 88, 25);
		panelProduits.add(text_designationFP);
		
		
		text_Stock.setBounds(310, 104, 94, 25);
		panelProduits.add(text_Stock);
		
		JLabel lblTVA = new JLabel("TVA:");
		lblTVA.setForeground(SystemColor.textHighlightText);
		lblTVA.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTVA.setBounds(238, 140, 67, 25);
		panelProduits.add(lblTVA);
		
		text_TVA = new JTextField();
		text_TVA.setColumns(10);
		text_TVA.setBounds(310, 140, 95, 25);
		panelProduits.add(text_TVA);
	     
		 JLabel lblDesignFP = new JLabel("D\u00E9signation_FP:");
	     lblDesignFP.setForeground(Color.WHITE);
	     lblDesignFP.setFont(new Font("Times New Roman", Font.BOLD, 13));
	     lblDesignFP.setBounds(10, 104, 93, 25);
	     panelProduits.add(lblDesignFP);
	     
	     JLabel lblStock = new JLabel("Stock:");
	     lblStock.setForeground(Color.WHITE);
	     lblStock.setFont(new Font("Times New Roman", Font.BOLD, 13));
	     lblStock.setBounds(238, 106, 67, 20);
	     panelProduits.add(lblStock);
	     
	     JLabel lblStockmin = new JLabel("Stock_min:");
	     lblStockmin.setForeground(Color.WHITE);
	     lblStockmin.setFont(new Font("Times New Roman", Font.BOLD, 13));
	     lblStockmin.setBounds(428, 104, 82, 25);
	     panelProduits.add(lblStockmin);
	     
	     text_stockmin = new JTextField();
	     text_stockmin.setColumns(10);
	     text_stockmin.setBounds(519, 104, 95, 25);
	     panelProduits.add(text_stockmin);
	     
	     JLabel lblpuhorstaxe = new JLabel("PU_Hors_Taxe:");
	     lblpuhorstaxe.setForeground(Color.WHITE);
	     lblpuhorstaxe.setFont(new Font("Times New Roman", Font.BOLD, 13));
	     lblpuhorstaxe.setBounds(10, 145, 100, 25);
	     panelProduits.add(lblpuhorstaxe);
	     
	     text_PUHorsTaxe = new JTextField();
	     text_PUHorsTaxe.setColumns(10);
	     text_PUHorsTaxe.setBounds(123, 145, 88, 25);
	     panelProduits.add(text_PUHorsTaxe);
	     
	     text_code = new JTextField();
	     text_code.setColumns(10);
	     text_code.setBounds(123, 28, 88, 25);
	     panelProduits.add(text_code);
	     
	     JLabel lblFournisseur = new JLabel("Fournisseur:");
	     lblFournisseur.setForeground(Color.WHITE);
	     lblFournisseur.setFont(new Font("Times New Roman", Font.BOLD, 13));
	     lblFournisseur.setBounds(238, 65, 80, 25);
	     panelProduits.add(lblFournisseur);
	     
	     JComboBox text_fournisseur = new JComboBox();
	     String sql2 = "select raison_sociale from fournisseur";
			try{
	            pst= conn.prepareStatement(sql2);      
	            rs=pst.executeQuery();
	            while (rs.next()){
	                String tf=rs.getString("raison_sociale");
	                //System.out.println(tf);
	                text_fournisseur.addItem(tf);
	              
	            }           
	        }catch(Exception e1){
	            JOptionPane.showMessageDialog(null,e1);
	        }
		 
			text_fournisseur.setBounds(310, 65, 95, 25);
		 panelProduits.add(text_fournisseur);
	    
	    
	     
	     JPanel panel = new JPanel();
	     panel.setLayout(null);
	     panel.setOpaque(false);
	     panel.setForeground(Color.BLACK);
	     panel.setBorder(new TitledBorder(UIManager

	             		.getBorder("TitledBorder.border"), "",

	             		TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
	     panel.setBackground(Color.BLACK);
	     panel.setBounds(615, 11, 337, 210);
	     panelProduits.add(panel);
	     
	     JTextArea textArea = new JTextArea();
			textArea.setBounds(10, 11, 317, 188);
			panel.add(textArea);
			
	     JPanel panelboutons = new JPanel();
	     panelboutons.setForeground(new Color(0, 0, 0));
	     panelboutons.setLayout(null);
	     panelboutons.setOpaque(false);
	     panelboutons.setBorder(new LineBorder(Color.WHITE));
	     panelboutons.setBackground(new Color(0, 0, 0));
	     panelboutons.setBounds(50, 181, 555, 40);
	     panelProduits.add(panelboutons);
	     btnLogin.setBounds(10, 4, 116, 30);
	     panelboutons.add(btnLogin);
	     btnLogin.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		try {
						Class.forName("com.mysql.jdbc.Driver");
						
						String url = "jdbc:mysql://localhost:3306/gestion_entreprise";
						Connection c = DriverManager.getConnection(url,"root","");

						Statement stmt = c.createStatement();
						
						
						String famille_produit = Integer.parseInt(text_CodeFP.getText())+"/"+text_designationFP.getText();
						
				
						Produit produit1 = new Produit(Integer.parseInt(text_code.getText().toString()),
								Integer.parseInt(text_ref.getText().toString()),text_Designation.getText().toString(),
								text_unitemesure.getSelectedItem().toString(),text_fournisseur.getSelectedItem().toString(),
								famille_produit,Integer.parseInt(text_Stock.getValue().toString()),
								Integer.parseInt(text_stockmin.getText().toString()),
								Integer.parseInt(text_PUHorsTaxe.getText().toString()),
								Integer.parseInt(text_TVA.getText().toString()));
						
						String req= Requetes_SQL.ajouter_produit(produit1);
						//System.out.println(req);
						
						int nb=stmt.executeUpdate(req);
						if(nb==0)
							JOptionPane.showMessageDialog(null, "ERREUR d'ajout","Ajout_produit_Achat" , JOptionPane.OK_OPTION);
						else
							JOptionPane.showMessageDialog(null, "ajout avec succés!","Ajout_produit_Achat" , JOptionPane.OK_OPTION);
						
						table.setModel(model);
	           			DefaultTableModel model = (DefaultTableModel) table.getModel();
	           			model.addRow(new Object[] {
	           					text_code.getText(),
	           					text_ref.getText(),
	           					text_Designation.getText(),
	           					text_unitemesure.getSelectedItem(),
	           					text_fournisseur.getSelectedItem(),
	           					text_CodeFP.getText(),
	           					text_designationFP.getText(),
	           					text_Stock.getValue(),
	           					text_stockmin.getText(),
	           					text_PUHorsTaxe.getText(),
	           					text_TVA.getText()
	           					
	           					});
	      				
	           			textArea.setText("");
	   					textArea.append("                     Fiche Produit Achat\n"
	   					+"       ******************************************************** \n"
	   					+"Code :\t"+text_code.getText()
	   					+"\nRef :\t "+text_ref.getText()
	   					+"\nDesignation :\t "+text_Designation.getText()
	   					+"\nUnite_Mesure :\t "+text_unitemesure.getSelectedItem()
	   					+"\nFournisseur :\t "+text_fournisseur.getSelectedItem()
	   					+"\nCodeFP : "+text_CodeFP.getText()
	   					+"\nDesignationFP : "+text_designationFP.getText()
	   					+"\nStock : "+text_Stock.getValue()
	   					+"\nStock_min : "+text_stockmin.getText()
	   					+"\nPUHorsTaxe : "+text_PUHorsTaxe.getText()
	   					+"\nTVA : "+text_TVA.getText()+"\n");
			      			
		     		
	   					text_code.setText(null);
       					text_ref.setText(null);
       					text_Designation.setText(null);
       					text_unitemesure.setSelectedItem(null);
       					text_fournisseur.setSelectedItem(null);
       					text_CodeFP.setText(null);
       					text_designationFP.setText(null);
       					text_Stock.setValue(1);
       					text_stockmin.setText(null);
       					text_Designation.setText(null);
       					text_PUHorsTaxe.setText(null);
       					text_TVA.setText(null);
	      				
					}
					
					catch (Exception event) {
						JOptionPane.showMessageDialog(null, event);
					}
				
		     	}
		     });
	     btnLogin.setIcon(new ImageIcon(PanelClient.class.getResource("/image/add.png")));
	     
	     JButton btnModifier = new JButton("Modifier");
	     btnModifier.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		try {
                        Class.forName("com.mysql.jdbc.Driver");
						
						String url = "jdbc:mysql://localhost:3306/gestion_entreprise";
						Connection c = DriverManager.getConnection(url,"root","");

						Statement stmt = c.createStatement();
						
						
						String famille_produit = Integer.parseInt(text_CodeFP.getText())+"/"+text_designationFP.getText();
						
				
						Produit produit1 = new Produit(Integer.parseInt(text_code.getText().toString()),
								Integer.parseInt(text_ref.getText().toString()),text_Designation.getText().toString(),
								text_unitemesure.getSelectedItem().toString(),text_fournisseur.getSelectedItem().toString(),
								famille_produit,Integer.parseInt(text_Stock.getValue().toString()),
								Integer.parseInt(text_stockmin.getText().toString()),
								Integer.parseInt(text_PUHorsTaxe.getText().toString()),
								Integer.parseInt(text_TVA.getText().toString()));
						
						String req= Requetes_SQL.modifier_produit(produit1);
						PreparedStatement pst = conn.prepareStatement(req);
						pst.execute();
	                	JOptionPane.showMessageDialog(null, "Mise à jour de Produit Achat avec succés");
	                	pst.close();
	                	
	                	textArea.setText("");
	   					textArea.append("                     Fiche Produit Achat\n"
	   					+"       ******************************************************** \n"
	   					+"Code :\t"+text_code.getText()
	   					+"\nRef :\t "+text_ref.getText()
	   					+"\nDesignation :\t "+text_Designation.getText()
	   					+"\nUnite_Mesure :\t "+text_unitemesure.getSelectedItem()
	   					+"\nFournisseur :\t "+text_fournisseur.getSelectedItem()
	   					+"\nCodeFP : "+text_CodeFP.getText()
	   					+"\nDesignationFP : "+text_designationFP.getText()
	   					+"\nStock : "+text_Stock.getValue()
	   					+"\nStock_min : "+text_stockmin.getText()
	   					+"\nPUHorsTaxe : "+text_PUHorsTaxe.getText()
	   					+"\nTVA : "+text_TVA.getText()+"\n");
			      			
		     		
	   					text_code.setText(null);
       					text_ref.setText(null);
       					text_Designation.setText(null);
       					text_unitemesure.setSelectedItem(null);
       					text_fournisseur.setSelectedItem(null);;
       					text_CodeFP.setText(null);
       					text_designationFP.setText(null);
       					text_Stock.setValue(1);
       					text_stockmin.setText(null);
       					text_Designation.setText(null);
       					text_PUHorsTaxe.setText(null);
       					text_TVA.setText(null);
	      				
	   					updateTable("1=1 ");
	   					
	   					//updateTable();
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
		           		String sql = "DELETE FROM `produit` WHERE code=" +value; 
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
		    						JOptionPane.showMessageDialog(null, "Aucune donnée pour supprimer" , "Gestion des produits", JOptionPane.OK_OPTION);
		    					}
		    					else {
		    						JOptionPane.showMessageDialog(null, "Selectionner une ligne pour la supprimer" , "Gestion des produits", JOptionPane.OK_OPTION);
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
	        		.getBorder("TitledBorder.border"), "",
	        		TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
	     paneltableau.setOpaque(false);
	     paneltableau.setBackground(new Color(0, 0, 0));
	     paneltableau.setBounds(10, 254, 962, 256);
	     add(paneltableau);
	     
	    
	     
	     JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 45, 931, 200);
		 paneltableau.add(scrollPane);
		 
		 combobox.setModel(new DefaultComboBoxModel(new String[] {"Code", "Ref", "Designation","Unite_mesure",
				 "Fournisseur","CodeFP","DesignationFP","Stock","Stock_min","PU_hors_taxe","TVA"}));
			combobox.setForeground(Color.black);
			combobox.setBackground(new Color(255, 255, 255));
			combobox.setBounds(159, 7, 195, 25);
			paneltableau.add(combobox);
		 
	     
	     Object col []= {"Code", "Ref", "Designation","Unite_mesure","Fournisseur","CodeFP",
	    		 "DesignationFP","Stock","Stock_min","PU_hors_taxe",
	    		 "TVA"};
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
			           		String sql = "SELECT * FROM `produit` WHERE code=" +code; 
			         
			           		pst = c.prepareStatement(sql);
			    			rs = pst.executeQuery();
			           		while (rs.next()) {
		                		String tab[];
		                		String lp = rs.getString("famille_produit").toString();
		                		tab = lp.split("/");
		                		String codeFP = tab[0];
		                		String DesignationFP = tab[1];
		                		
		                		
		                		text_code.setText(rs.getString("code").toString());
		                		text_ref.setText(rs.getString("ref").toString());
		                		text_Designation.setText(rs.getString("designation").toString());
		                		text_unitemesure.setSelectedItem(rs.getString("unite_mesure").toString());
		                		text_fournisseur.setSelectedItem(rs.getString("fournisseur").toString());
		                		text_CodeFP.setText(codeFP);
		                		text_designationFP.setText(DesignationFP);
		                		text_Stock.setValue(rs.getInt("stock"));
		                		text_stockmin.setText(rs.getString("stock_min").toString());
		                		text_PUHorsTaxe.setText(rs.getString("PU_hors_taxe").toString());
		                		text_TVA.setText(rs.getString("TVA").toString());
		                		
		                	}
							
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null,e1);
						}
				}
				
			});
			table.setModel(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(89);
			scrollPane.setViewportView(table);
			
			JLabel lblRecherche = new JLabel("");
			lblRecherche.setBounds(110, 7, 39, 32);
			paneltableau.add(lblRecherche);
			lblRecherche.setVerticalAlignment(SwingConstants.TOP);
			lblRecherche.setIcon(new ImageIcon(PanelClient.class.getResource("/image/seo (1).png")));
			
			textField_search = new JTextField();
			textField_search.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					try {
						String selection = (String)combobox.getSelectedItem();
						String sql = "select * from produit where "+selection+"=?"; 
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
			textField_search.setBounds(364, 7, 278, 25);
			paneltableau.add(textField_search);
			
			
	        
	        
		setVisible(true);
		//StockEmpty();

	}
	
	public void updateTable() {
		conn = ConnectionDB.ConnectDb();	
		if(conn != null)
			{
			String sql = "SELECT * FROM `produit`";
            try {
            	pst = conn.prepareStatement(sql);
            	rs = pst.executeQuery();
            	Object col []= {"Code", "Ref", "Designation","Unite_mesure","Fournisseur","CodeFP",
       	    		 "DesignationFP","Stock","Stock_min","PU_hors_taxe","TVA"};
    			model.setColumnIdentifiers(col);
    			table.setModel(model);
            	Object[] columnData = new Object[11];
      
            	while (rs.next()) {
            		String tab[];
            		String lp = rs.getString("famille_produit").toString();
            		tab = lp.split("/");
            		String codeFP = tab[0];
            		String DesignationFP = tab[1];
            		
            		columnData[0] = rs.getInt("code");
            		columnData[1] = rs.getString("ref");
            		columnData[2] = rs.getString("designation");
            		columnData[3] = rs.getString("unite_mesure");
            		columnData[4] = rs.getString("fournisseur");
            		columnData[5] = codeFP;
            		columnData[6] = DesignationFP;
            		columnData[7] = rs.getInt("stock");
            		columnData[8] = rs.getInt("stock_min");
            		columnData[9] = rs.getInt("PU_hors_taxe");
            		columnData[10] = rs.getInt("TVA");
            		
            		
            		 
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
				String sql1 = "select * from produit"; 
				PreparedStatement pst = conn.prepareStatement(sql1);
				ResultSet rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
        		
			
				if (!rs.first())
					emptyTable = true;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/*public void StockEmpty() {
			
			if (Requettes.stock_select("produit.stock <= 3") != null) {
				MessageAlert msg = new MessageAlert();
				//msg.updateTable("produit.stock <= 3");
				msg.setVisible(true);
			}
			
		}*/
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}
}
	


