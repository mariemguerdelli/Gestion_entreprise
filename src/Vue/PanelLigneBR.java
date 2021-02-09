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
import Metier.Ligne_BR;
import Vue.PanelEntreprise;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

public class PanelLigneBR extends JPanel {
	private JTextField text_Matricule;
	private JTextField text_Reference;
	private JTextField text_Designation;
	private JTextField text_PUHorsTVA;
	private JTextField text_UniteMesure;
	private JTextField text_PTotalHorsTVA;
	private JTextField text_TVA;
	private JTextField textFieldsearch;
	private JButton btnLogin = new JButton("Ajouter");
	DefaultTableModel model = new DefaultTableModel();
	static JTable table = new JTable();
	private JTextField textField_search;
	private JTextField txt_QteRecep;
    private boolean emptyTable = false;
    private JComboBox combobox = new JComboBox();
    public Vector<Ligne_BR> Vcp;
	
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;


	public PanelLigneBR(Vector<Ligne_BR> Vcp) {
		this.Vcp=Vcp;
		updateTable();
		setBackground(new Color(192, 192, 192));
		setSize(1200, 533);
		setLayout(null);
		
		JPanel panelDevis = new JPanel();
		panelDevis.setForeground(new Color(0, 0, 0));
		panelDevis.setLayout(null);
		panelDevis.setOpaque(false);
		panelDevis.setBorder(new TitledBorder(UIManager
        		.getBorder("TitledBorder.border"), "Gestion Ligne BR",
        		TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelDevis.setBackground(new Color(0, 0, 0));
		panelDevis.setBounds(10, 11, 962, 275);
        add(panelDevis);
		
		JLabel lblReference = new JLabel("Reference:");
		lblReference.setForeground(SystemColor.textHighlightText);
		lblReference.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblReference.setBounds(10, 22, 100, 25);
		panelDevis.add(lblReference);
		
		text_Reference = new JTextField();
		text_Reference.setColumns(10);
		text_Reference.setBounds(102, 22, 67, 20);
		panelDevis.add(text_Reference);
		
		JLabel lblUniteMesure = new JLabel("unite_mesure:");
		lblUniteMesure.setForeground(SystemColor.textHighlightText);
		lblUniteMesure.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblUniteMesure.setBounds(10, 54, 82, 25);
		panelDevis.add(lblUniteMesure);
		
		JLabel lblFournisseur = new JLabel("CodeFournisseur:");
		lblFournisseur.setForeground(SystemColor.textHighlightText);
		lblFournisseur.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblFournisseur.setBounds(179, 22, 111, 25);
		panelDevis.add(lblFournisseur);
		
		JComboBox text_CodeF = new JComboBox();
	     String sql = "select code from fournisseur";
			try{
	            pst= conn.prepareStatement(sql);      
	            rs=pst.executeQuery();
	            while (rs.next()){
	                int tf=rs.getInt("code");
	                System.out.println(tf);
	                text_CodeF.addItem(String.valueOf(tf));
	              
	            }           
	        }catch(Exception e1){
	            JOptionPane.showMessageDialog(null,e1);
	        }
			text_CodeF.setBounds(287, 24, 82, 20);
	     panelDevis.add(text_CodeF);
		
		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setForeground(SystemColor.textHighlightText);
		lblDesignation.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDesignation.setBounds(379, 22, 82, 25);
		panelDevis.add(lblDesignation);
		
		
		
		JComboBox text_Designation = new JComboBox();
	     String sql1 = "select designation from produit";
			try{
	            pst= conn.prepareStatement(sql1);      
	            rs=pst.executeQuery();
	            while (rs.next()){
	                String tf=rs.getString("designation");
	                //System.out.println(tf);
	                text_Designation.addItem(tf);
	              
	            }           
	        }catch(Exception e1){
	            JOptionPane.showMessageDialog(null,e1);
	        }
		 text_Designation.setBounds(471, 22, 67, 20);
	     panelDevis.add(text_Designation);
		
		
		text_PUHorsTVA = new JTextField();
		text_PUHorsTVA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 String sql2="select PU_hors_taxe from produit where designation=?";
			       try{
			            pst= conn.prepareStatement(sql2);      
			            pst.setString(1,(String) text_Designation.getSelectedItem());
			            rs=pst.executeQuery();
			            if (rs.next()){
			                String t1=rs.getString("PU_hors_taxe");
			                Float t11 = Float.parseFloat(t1);
			                text_PUHorsTVA.setText(String.valueOf(t11));
			                rs.close();
			                pst.close();
			            }           
			        }catch(Exception e1){
			            JOptionPane.showMessageDialog(null,e1);
			        }
			}
		});
		text_PUHorsTVA.setColumns(10);
		text_PUHorsTVA.setBounds(102, 90, 67, 20);
		panelDevis.add(text_PUHorsTVA);
		
		
		JComboBox text_UniteMesure = new JComboBox();
	     String sql2 = "select unite_mesure from produit";
			try{
	            pst= conn.prepareStatement(sql2);      
	            rs=pst.executeQuery();
	            while (rs.next()){
	                String tf=rs.getString("unite_mesure");
	                System.out.println(tf);
	                text_UniteMesure.addItem(tf);
	              
	            }           
	        }catch(Exception e1){
	            JOptionPane.showMessageDialog(null,e1);
	        }
		 
		 text_UniteMesure.setBounds(122, 54, 87, 20);
	     panelDevis.add(text_UniteMesure);
		
		 
		text_PTotalHorsTVA = new JTextField();
		text_PTotalHorsTVA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int qte = Integer.parseInt(txt_QteRecep.getText().toString());
				float puhorstva = Float.parseFloat(text_PUHorsTVA.getText().toString());
				text_PTotalHorsTVA.setText(String.valueOf(qte*puhorstva));
			}
		});
		text_PTotalHorsTVA.setColumns(10);
		text_PTotalHorsTVA.setBounds(301, 92, 77, 20);
		panelDevis.add(text_PTotalHorsTVA);
		
		JLabel lblPUHorsTVA = new JLabel("PU_hors_TVA:");
		lblPUHorsTVA.setForeground(SystemColor.textHighlightText);
		lblPUHorsTVA.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblPUHorsTVA.setBounds(11, 90, 93, 25);
		panelDevis.add(lblPUHorsTVA);
		
		JLabel lblTVA = new JLabel("TVA:");
		lblTVA.setForeground(SystemColor.textHighlightText);
		lblTVA.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTVA.setBounds(389, 54, 55, 25);
		panelDevis.add(lblTVA);
		
		JLabel lblPTotalHorsTVA = new JLabel("P_Total_Hors_TVA:");
		lblPTotalHorsTVA.setForeground(SystemColor.textHighlightText);
		lblPTotalHorsTVA.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblPTotalHorsTVA.setBounds(179, 90, 119, 25);
		panelDevis.add(lblPTotalHorsTVA);
		
		text_TVA = new JTextField();
		text_TVA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 String sql2="select TVA from produit where designation=?";
			       try{
			            pst= conn.prepareStatement(sql2);      
			            pst.setString(1,(String) text_Designation.getSelectedItem());
			            rs=pst.executeQuery();
			            if (rs.next()){
			                String t1=rs.getString("TVA");
			                Float t11 = Float.parseFloat(t1);
			                text_TVA.setText(String.valueOf(t11));
			                rs.close();
			                pst.close();
			            }           
			        }catch(Exception e1){
			            JOptionPane.showMessageDialog(null,e1);
			        }
			}
		});
		text_TVA.setColumns(10);
		text_TVA.setBounds(440, 56, 67, 20);
		panelDevis.add(text_TVA);
	     
	     JLabel lblQteRecep = new JLabel("Quantit\u00E9:");
	     lblQteRecep.setForeground(Color.WHITE);
	     lblQteRecep.setFont(new Font("Times New Roman", Font.BOLD, 13));
	     lblQteRecep.setBounds(223, 54, 67, 25);
	     panelDevis.add(lblQteRecep);
	     
	     txt_QteRecep = new JTextField();
	     txt_QteRecep.setColumns(10);
	     txt_QteRecep.setBounds(286, 56, 87, 20);
	     panelDevis.add(txt_QteRecep);
	     
	     
		
		JPanel panel = new JPanel();
	     panel.setLayout(null);
	     panel.setOpaque(false);
	     panel.setForeground(Color.BLACK);
	     panel.setBorder(new TitledBorder(UIManager

	             		.getBorder("TitledBorder.border"), "",

	             		TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
	     panel.setBackground(Color.BLACK);
	     panel.setBounds(601, 11, 351, 253);
	     panelDevis.add(panel);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 7, 331, 235);
		panel.add(textArea);
	     
	     
	     JPanel panelboutons = new JPanel();
	     panelboutons.setForeground(new Color(0, 0, 0));
	     panelboutons.setLayout(null);
	     panelboutons.setOpaque(false);
	     panelboutons.setBorder(new LineBorder(Color.WHITE));
	     panelboutons.setBackground(new Color(0, 0, 0));
	     panelboutons.setBounds(38, 212, 555, 40);
	     panelDevis.add(panelboutons);
	     
	     btnLogin.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		try {
		     			
						Class.forName("com.mysql.jdbc.Driver");
						String url = "jdbc:mysql://localhost:3306/gestion_entreprise";
						Connection c = DriverManager.getConnection(url,"root","");
	                     
						Statement stmt = c.createStatement();
						
						
						Ligne_BR ligne_BR1 = new Ligne_BR(Integer.parseInt(text_Reference.getText()),
								Integer.parseInt(text_CodeF.getSelectedItem().toString()),text_Designation.getSelectedItem().toString(),text_UniteMesure.getSelectedItem().toString(),
								Integer.parseInt(txt_QteRecep.getText().toString()),Float.parseFloat(text_PUHorsTVA.getText().toString()),Float.parseFloat(text_TVA.getText().toString()),
								Float.parseFloat(text_PTotalHorsTVA.getText().toString()));
						
						
						String req= Requetes_SQL.ajouter_ligne_BR(ligne_BR1);
						
						int nb=stmt.executeUpdate(req);
						if(nb==0)
							JOptionPane.showMessageDialog(null, "ERREUR d'ajout","Ajout_LigneBR" , JOptionPane.OK_OPTION);
						else
							JOptionPane.showMessageDialog(null, "ajout avec succ�s!","Ajout_LigneBR" , JOptionPane.OK_OPTION);
						
						 Vector<Ligne_BR> vector = new Vector<Ligne_BR>();
					        vector.add(ligne_BR1);
					    
					      
					        String sql4 = "Update produit set stock = stock+'"+txt_QteRecep.getText()+"'  where  designation='"+text_Designation.getSelectedItem()+"'" ;  
		          			PreparedStatement pst4 = conn.prepareStatement(sql4);
		                	pst4.execute();
		                	pst4.close();
						
				
						
						table.setModel(model);
	           			DefaultTableModel model = (DefaultTableModel) table.getModel();
	           			model.addRow(new Object[] {
	           					text_Reference.getText(),
	           					text_CodeF.getSelectedItem(),
	           					text_Designation.getSelectedItem(),
	           					text_UniteMesure.getSelectedItem(),
	           					txt_QteRecep.getText(),
	           					text_PUHorsTVA.getText(),
	           					text_TVA.getText(),
	           					text_PTotalHorsTVA.getText()
	           					});
	      				
	           			textArea.setText("");
	   					textArea.append("                     Fiche Bon Reception\n"
	   					+"       ******************************************************** \n"
	   					+"Code :\t"+text_Reference.getText()
	   					+"\nClient :\t "+text_CodeF.getSelectedItem()
	   					+"\nDatebon :\t "+text_Designation.getSelectedItem()
	   					+"\nDateReception :\t "+text_UniteMesure.getSelectedItem()
	   					+"\nAdresseReception :\t "+txt_QteRecep.getText()
	   					+"\nInfoBon :\t "+text_PUHorsTVA.getText()
	   					+"\nReference :\t "+text_TVA.getText()
	   					+"\nPTotalHorsTVA : "+text_PTotalHorsTVA.getText()+"\n");
			      			
	   					
	   					text_Reference.setText(null);
	   					text_CodeF.setSelectedItem(null);
	   					text_Designation.setSelectedItem(null);
	   					text_UniteMesure.setSelectedItem(null);
	   					txt_QteRecep.setText(null);
	   					text_PUHorsTVA.setText(null);
	   					text_TVA.setText(null);
	   					text_PTotalHorsTVA.setText(null);
					}
					
					catch (Exception event) {
						JOptionPane.showMessageDialog(null,event);
					}
				
		     	}
		     	
		     });
	     btnLogin.setBounds(10, 4, 116, 30);
	     panelboutons.add(btnLogin);
	     btnLogin.setIcon(new ImageIcon(PanelClient.class.getResource("/image/add.png")));
	     
	     JButton btnModifier = new JButton("Modifier");
	     btnModifier.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		try {
	                    Class.forName("com.mysql.jdbc.Driver");
						
						String url = "jdbc:mysql://localhost:3306/gestion_entreprise";
						Connection c = DriverManager.getConnection(url,"root","");

						Statement stmt = c.createStatement();
					
						Ligne_BR ligne_BRUp = new Ligne_BR(Integer.parseInt(text_Reference.getText()),
								Integer.parseInt(text_CodeF.getSelectedItem().toString()),text_Designation.getSelectedItem().toString(),text_UniteMesure.getSelectedItem().toString(),
								Integer.parseInt(txt_QteRecep.getText().toString()),Float.parseFloat(text_PUHorsTVA.getText().toString()),Float.parseFloat(text_TVA.getText().toString()),
								Float.parseFloat(text_PTotalHorsTVA.getText().toString()));
						
						String req= Requetes_SQL.modifier_ligneBR(ligne_BRUp);
						
						PreparedStatement pst = conn.prepareStatement(req);
						
						pst.execute();
						
	                	JOptionPane.showMessageDialog(null, "Mise � jour de bon reception avec succ�s");
	                	pst.close();
	                	
	                	textArea.setText("");
	   					textArea.append("                     Fiche Bon Reception\n"
	   					+"       ******************************************************** \n"
	   					+"Code :\t"+text_Reference.getText()
	   					+"\nClient :\t "+text_CodeF.getSelectedItem()
	   					+"\nDatebon :\t "+text_Designation.getSelectedItem()
	   					+"\nDateReception :\t "+text_UniteMesure.getSelectedItem()
	   					+"\nAdresseReception :\t "+txt_QteRecep.getText()
	   					+"\nInfoBon :\t "+text_PUHorsTVA.getText()
	   					+"\nReference :\t "+text_TVA.getText()
	   					+"\nPTotalHorsTVA : "+text_PTotalHorsTVA.getText()+"\n");
			      			
		     		
	   					text_Reference.setText(null);
	   					text_CodeF.setSelectedItem(null);
	   					text_Designation.setSelectedItem(null);
	   					text_UniteMesure.setSelectedItem(null);
	   					txt_QteRecep.setText(null);
	   					text_PUHorsTVA.setText(null);
	   					text_TVA.setText(null);
	   					text_PTotalHorsTVA.setText(null);
	   					updateTable("1=1 ");
	   					
	   					
		     		}
		     		catch (Exception event) {
						JOptionPane.showMessageDialog(null, event);
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
		           		String sql = "DELETE FROM `ligne_br` WHERE ref=" +value; 
		           		pst = conn.prepareStatement(sql);
		            	pst.execute();
		            	JOptionPane.showMessageDialog(null, "Donn�es supprim�s");
		            	pst.close();
		            	DefaultTableModel model = (DefaultTableModel) table.getModel();
		            	model.removeRow(table.getSelectedRow());}
		           		
		           		catch(Exception ex) {
		           			JOptionPane.showMessageDialog(null, ex);
		           			if(table.getSelectedRow() == -1) {
		    					if(table.getRowCount() == 0) {
		    						JOptionPane.showMessageDialog(null, "Aucune donn�e pour supprimer" , "Gestion des adh�rants", JOptionPane.OK_OPTION);
		    					}
		    					else {
		    						JOptionPane.showMessageDialog(null, "Selectionner une ligne pour la supprimer" , "Gestion des adh�rants", JOptionPane.OK_OPTION);
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
	     paneltableau.setBounds(10, 297, 962, 213);
	     add(paneltableau);
	     
	     combobox.setModel(new DefaultComboBoxModel(new String[] {"Ref", "Code_Fournisseur",
	    		 "Designation","Unite_mesure",
	    		 "Qte_recep","PU_hors_TVA","TVA","PTotalHorsTVA"}));
			combobox.setForeground(Color.black);
			combobox.setBackground(new Color(255, 255, 255));
			combobox.setBounds(207, 7, 195, 25);
			paneltableau.add(combobox);
	     
	     JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 45, 931, 157);
		 paneltableau.add(scrollPane);
	     
		 Object tab []= {"Ref", "Code_Fournisseur","Designation","Unite_mesure",
	    		 "Qte_recep","PU_hors_TVA","TVA","PTotalHorsTVA"};
			model.setColumnIdentifiers(tab);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (!emptyTable) {
						try {
							Class.forName("com.mysql.jdbc.Driver");
			    			String url = "jdbc:mysql://localhost:3306/gestion_entreprise";
			    			Connection c = DriverManager.getConnection(url,"root","");
			    			Statement stmt = c.createStatement();
			    	        
			    		
							int row = table.getSelectedRow();
							
							int code = Integer.parseInt((table.getModel().getValueAt(row, 0))
									.toString());
							
			           		String sql = "SELECT * FROM `ligne_br` WHERE ref=" +code; 
			           		
			         
			           		pst = c.prepareStatement(sql);
			    			rs = pst.executeQuery();
			           		while (rs.next()) {
			           			
		                		text_Reference.setText(rs.getString("ref").toString());
		                		text_CodeF.setSelectedItem(rs.getString("code_fournisseur").toString());
		                		text_Designation.setSelectedItem(rs.getString("designation").toString());
		                		text_UniteMesure.setSelectedItem(rs.getString("unite_mesure").toString());
		                		txt_QteRecep.setText(rs.getString("qte_receptionnee").toString());
		                		text_PUHorsTVA.setText(rs.getString("PU_hors_TVA").toString());
		                		text_TVA.setText(rs.getString("TVA").toString());
		                		text_PTotalHorsTVA.setText(rs.getString("P_total_horsTVA").toString());

		                	}
							
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1);
						}
				}}
				
			});
			
			table.setModel(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(89);
			scrollPane.setViewportView(table);
			
			JLabel lblRecherche = new JLabel("");
			lblRecherche.setBounds(146, 7, 39, 32);
			paneltableau.add(lblRecherche);
			lblRecherche.setVerticalAlignment(SwingConstants.TOP);
			lblRecherche.setIcon(new ImageIcon(PanelClient.class.getResource("/image/seo (1).png")));
			
			textField_search = new JTextField();
			textField_search.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					try {
						String selection = (String)combobox.getSelectedItem();
						String sql = "select * from ligne_br where "+selection+"=?"; 
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
			textField_search.setBounds(430, 7, 234, 25);
			paneltableau.add(textField_search);
			
	        
	        
		setVisible(true);

	}
	
	public void updateTable() {
		conn = ConnectionDB.ConnectDb();	
		if(conn != null)
			{
			String sql = "SELECT * FROM `ligne_br`";
            try {
            	pst = conn.prepareStatement(sql);
            	rs = pst.executeQuery();
            	Object col []= {"Ref", "Code_Fournisseur","Designation","Unite_mesure",
       	    		 "Qte_recep","PU_hors_TVA","TVA","PTotalHorsTVA"};
    			model.setColumnIdentifiers(col);
    			table.setModel(model);
            	Object[] columnData = new Object[8];
      
            	while (rs.next()) {
            		
            		columnData[0] = rs.getInt("ref");
            		columnData[1] = rs.getInt("code_fournisseur");
            		columnData[2] = rs.getString("designation");
            		columnData[3] = rs.getString("unite_mesure");
            		columnData[4] = rs.getString("qte_receptionnee");
            		columnData[5] = rs.getFloat("PU_hors_TVA");
            		columnData[6] = rs.getFloat("TVA");
            		columnData[7] = rs.getFloat("P_total_horsTVA");
          		 
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
				String sql1 = "select * from ligne_br"; 
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
	


