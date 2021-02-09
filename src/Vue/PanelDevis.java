package Vue;


import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

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
import Metier.Bon_livraison;
import Metier.Bon_reception;
import Metier.Devis;
import Metier.Ligne_BL;
import Metier.Ligne_BR;
import Metier.Ligne_devis;
import Vue.PanelEntreprise;

import javax.swing.JButton;
import javax.imageio.ImageIO;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class PanelDevis extends JPanel{
	private JTextField text_code;
	private JTextField text_Matricule;
	private JTextField text_Client;
	private JTextField text_MtotalPayer;
	private JTextField text_MTotalHorsTVA;
	private JTextField text_MTotalTVA;
	private JTextField textFieldsearch;
	private JButton btnLogin = new JButton("Ajouter");
	DefaultTableModel model = new DefaultTableModel();
	static JTable table = new JTable();
	private JTextField textField_search;
	    private boolean emptyTable = false;
    private JComboBox combobox = new JComboBox();
	
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	PreparedStatement pst1 = null;
	ResultSet rs1 = null;
	private JTextField txt_nbrLigneBL;


	
	public PanelDevis() {
		updateTable();
		setBackground(new Color(192, 192, 192));
		setSize(1200, 533);
		setLayout(null);
		
		JPanel panelDevis = new JPanel();
		panelDevis.setForeground(new Color(0, 0, 0));
		panelDevis.setLayout(null);
		panelDevis.setOpaque(false);
		panelDevis.setBorder(new TitledBorder(UIManager
        		.getBorder("TitledBorder.border"), "Gestion Devis",
        		TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panelDevis.setBackground(new Color(0, 0, 0));
		panelDevis.setBounds(10, 11, 962, 275);
        add(panelDevis);
        
        JLabel lblCode = new JLabel("Code:");
        lblCode.setForeground(SystemColor.textHighlightText);
        lblCode.setFont(new Font("Times New Roman", Font.BOLD, 13));
        lblCode.setBounds(10, 22, 49, 25);
        panelDevis.add(lblCode);
		
		text_code = new JTextField();
		text_code.setBounds(101, 22, 67, 20);
		text_code.setColumns(10);
		text_code.setOpaque(false);
		text_code.setEditable(false);
		panelDevis.add(text_code);
		
		JLabel lblClient = new JLabel("Code_Client:");
		lblClient.setForeground(SystemColor.textHighlightText);
		lblClient.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblClient.setBounds(392, 22, 93, 25);
		panelDevis.add(lblClient);
		
		
		JComboBox text_Client = new JComboBox();
   	    text_Client.setBounds(484, 24, 97, 20);
	     panelDevis.add(text_Client);
		String sql = "select code_client from ligne_devis";
		try{
            pst= conn.prepareStatement(sql);      
            rs=pst.executeQuery();
            while (rs.next()){
                int t1=rs.getInt("code_client");
                System.out.println(t1);
                text_Client.addItem(String.valueOf(t1));
              
            }           
        }catch(Exception e1){
            JOptionPane.showMessageDialog(null,e1);
        }
		text_MtotalPayer = new JTextField();
		text_MtotalPayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				float mthtva = Float.parseFloat(text_MTotalHorsTVA.getText().toString());
				float mttva = Float.parseFloat(text_MTotalTVA.getText().toString());
				text_MtotalPayer.setText(String.valueOf(mthtva+((mttva*mthtva)/100)));
			}
		});
		text_MtotalPayer.setColumns(10);
		text_MtotalPayer.setBounds(499, 60, 67, 20);
		panelDevis.add(text_MtotalPayer);
		 
		text_MTotalHorsTVA = new JTextField();
		text_MTotalHorsTVA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 String sql2="select sum(P_total_horsTVA)as prix from ligne_devis where code_client=?";
			       try{
			            pst= conn.prepareStatement(sql2);      
			            pst.setString(1,(String) text_Client.getSelectedItem());
			            rs=pst.executeQuery();
			            if (rs.next()){
			                String t1=rs.getString("prix");
			                Float t11 = Float.parseFloat(t1);
			                text_MTotalHorsTVA.setText(String.valueOf(t11));
			                rs.close();
			                pst.close();
			            }           
			        }catch(Exception e1){
			            JOptionPane.showMessageDialog(null,e1);
			        }
			}
		});
		text_MTotalHorsTVA.setColumns(10);
		text_MTotalHorsTVA.setBounds(305, 60, 77, 20);
		panelDevis.add(text_MTotalHorsTVA);
		
		JLabel lblPUHorsTVA = new JLabel("M_Total_Payer:");
		lblPUHorsTVA.setForeground(SystemColor.textHighlightText);
		lblPUHorsTVA.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblPUHorsTVA.setBounds(408, 60, 93, 25);
		panelDevis.add(lblPUHorsTVA);
		
		JLabel lblTVA = new JLabel("M_total_TVA:");
		lblTVA.setForeground(SystemColor.textHighlightText);
		lblTVA.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTVA.setBounds(10, 58, 93, 25);
		panelDevis.add(lblTVA);
		
		JLabel lblMTotalHorsTVA = new JLabel("M_Total_Hors_TVA:");
		lblMTotalHorsTVA.setForeground(SystemColor.textHighlightText);
		lblMTotalHorsTVA.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMTotalHorsTVA.setBounds(183, 58, 119, 25);
		panelDevis.add(lblMTotalHorsTVA);
		
		text_MTotalTVA = new JTextField();
		text_MTotalTVA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sql1="select sum(TVA_appliquee) as tva from Ligne_devis where code_client=?";
			       try{
			            pst= conn.prepareStatement(sql1);      
			            pst.setString(1,(String) text_Client.getSelectedItem());
			            rs=pst.executeQuery();
			            if (rs.next()){
			                //String T=rs.getString("tva")+ "%";
			                String T=rs.getString("tva");
			                text_MTotalTVA.setText(T);
			                rs.close();
			                pst.close();
			            }
			            
			        }catch(Exception e1){
			            JOptionPane.showMessageDialog(null,e1);
			        }
			}
		});
		text_MTotalTVA.setColumns(10);
		text_MTotalTVA.setBounds(92, 58, 67, 20);
		panelDevis.add(text_MTotalTVA);
		
		 JLabel lblDate = new JLabel("Date_Devis:");
	     lblDate.setForeground(Color.WHITE);
	     lblDate.setFont(new Font("Times New Roman", Font.BOLD, 13));
	     lblDate.setBounds(197, 22, 74, 25);
	     panelDevis.add(lblDate);
	     
	     //DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	     
	     
	     JDateChooser dateChooserbon = new JDateChooser();
	     dateChooserbon.setDateFormatString("yyyy-MM-dd");
	     Date date = new Date();
	     dateChooserbon.setDate(date);
	     dateChooserbon.setBounds(283, 22, 87, 20);
	     panelDevis.add(dateChooserbon);
	     
	     
	     txt_nbrLigneBL = new JTextField();
	     txt_nbrLigneBL.addMouseListener(new MouseAdapter() {
	     	@Override
	     	public void mouseClicked(MouseEvent e) {
	     		int client = Integer.parseInt(text_Client.getSelectedItem().toString()); 
	     	
	     		try {
	     	        	int a=0;
	     	        	String sql = "select count(ref) as ref from ligne_devis where code_client="+client;
	     	        	
	     	        	pst= conn.prepareStatement(sql);
	     	        	rs=pst.executeQuery();
	     	        	  while(rs.next()) {
	     	        	        a=rs.getInt("ref");
	     	        	         System.out.println(a); 
	     	        	        txt_nbrLigneBL.setText(String.valueOf(a));
	     	        	   }
	     	        }
	     
	     	         catch(Exception e1){
	     	            JOptionPane.showMessageDialog(null,e1);
	     	            } 
	     	    
	     	}
	     });
	     txt_nbrLigneBL.setColumns(10);
	     txt_nbrLigneBL.setBounds(112, 96, 67, 20);
	     panelDevis.add(txt_nbrLigneBL);
	     
	     JLabel lblNbrLignebl = new JLabel("Nbr Ligne_devis:");
	     lblNbrLignebl.setForeground(Color.WHITE);
	     lblNbrLignebl.setFont(new Font("Times New Roman", Font.BOLD, 13));
	     lblNbrLignebl.setBounds(10, 94, 106, 25);
	     panelDevis.add(lblNbrLignebl);
	     
	     
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
		     		int client = Integer.parseInt(text_Client.getSelectedItem().toString()); 
					String sql = "select * from ligne_devis where code_client="+client; 
		     		try {
		     			pst = conn.prepareStatement(sql);
		            	rs = pst.executeQuery();
		            	
		            	Vector<Ligne_devis> vector = new Vector<Ligne_devis>();
		      
		            	while (rs.next()) {
		            		int a = rs.getInt("ref");
		            		int b = rs.getInt("code_client");
		            		String c = rs.getString("designation");
		            		String d = rs.getString("unite_mesure");
		            		int ee = rs.getInt("qte_receptionnee");
		            		float f = rs.getFloat("PU_hors_TVA");
		            		float j = rs.getFloat("TVA_appliquee");
		            		float h = rs.getFloat("P_total_horsTVA");
		            		
		            		
		            		Ligne_devis ligne_devis1 = new Ligne_devis(a,b,c,d,ee,f,j,h);
		            		vector.add(ligne_devis1);
		            		
		            	}

		     			
						Class.forName("com.mysql.jdbc.Driver");
						String url = "jdbc:mysql://localhost:3306/gestion_entreprise";
						Connection c = DriverManager.getConnection(url,"root","");
	                     
						Statement stmt = c.createStatement();
						
						
						String date1 = ((JTextField) dateChooserbon.getDateEditor()
								.getUiComponent()).getText();
						
						

						
						Devis DevisAdd = new Devis(0,date1,Integer.parseInt(text_Client.getSelectedItem().toString()),
								vector,Float.parseFloat(text_MTotalTVA.getText().toString()),
								Float.parseFloat(text_MTotalHorsTVA.getText().toString()),
								Float.parseFloat(text_MtotalPayer.getText().toString()));
						
						// accepteChiffres(text_Client);
					
						String req= Requetes_SQL.ajouter_devis(DevisAdd);
						//System.out.println(req);
						int nb=stmt.executeUpdate(req);
						//System.out.println(nb);
						if(nb==0)
							JOptionPane.showMessageDialog(null, "ERREUR d'ajout","Ajout_Devis" , JOptionPane.OK_OPTION);
						else
							JOptionPane.showMessageDialog(null, "ajout avec succés!","Ajout_Devis" , JOptionPane.OK_OPTION);
						
						table.setModel(model);
	           			DefaultTableModel model = (DefaultTableModel) table.getModel();
	           			/*for (int index = 0; index < vector.size(); index++) {
	           				Ligne_BL ligne =vector.get(index);*/
	           			
     	        	   
	           			model.addRow(new Object[] {
	           			
	           					text_code.getText(),
	           					((JTextField) dateChooserbon.getDateEditor().getUiComponent()).getText(),
	           					text_Client.getSelectedItem(),
	           					txt_nbrLigneBL.getText(),
	           					text_MTotalTVA.getText(),
	           					text_MTotalHorsTVA.getText(),
	           					text_MtotalPayer.getText(),
	           					
	           			
	           					
	           			});
	           			
	           			textArea.setText("");
	   					textArea.append("                     Fiche Devis\n"
	   					+"       ******************************************************** \n"
	   					+"Code :\t"+text_code.getText()
	   					+"\nDatebon :\t "+((JTextField) dateChooserbon.getDateEditor().getUiComponent()).getText()
	   					+"\nClient :\t "+text_Client.getSelectedItem()
	   					+"\nNbrligne_br : \t"+txt_nbrLigneBL.getText()
	   					+"\nPUHorsTVA : "+text_MtotalPayer.getText()
	   					+"\nTVA : "+text_MTotalTVA.getText()
	   					+"\nPTotalHorsTVA : "+text_MTotalHorsTVA.getText()+"\n");
			      		
	           			
	           			text_code.setText(null);
	           			((JTextField) dateChooserbon.getDateEditor().getUiComponent()).setText(null);
	           			text_Client.setToolTipText(null);
	   					txt_nbrLigneBL.setText(null);
	   					text_MtotalPayer.setText(null);
	   					text_MTotalTVA.setText(null);
	   					text_MTotalHorsTVA.setText(null);
	   					
	   					updateTable("1=1");
					}
					
		     		catch(Exception e1){
	     	            JOptionPane.showMessageDialog(null,e1);
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
							
							String date1 = ((JTextField) dateChooserbon.getDateEditor()
									.getUiComponent()).getText();
							
						
							
							Devis DevisUp = new Devis(0,date1,Integer.parseInt(text_Client.getSelectedItem().toString()),
									Float.parseFloat(text_MTotalTVA.getText().toString()),
									Float.parseFloat(text_MTotalHorsTVA.getText().toString()),
									Float.parseFloat(text_MtotalPayer.getText().toString()));
							
							
						String req= Requetes_SQL.modifier_devis(DevisUp);
						System.out.println(req);
						PreparedStatement pst = conn.prepareStatement(req);
						pst.execute();
	                	JOptionPane.showMessageDialog(null, "Mise à jour de devis avec succés");
	                	pst.close();
	                	
	                	textArea.setText("");
	   					textArea.append("                     Fiche Devis\n"
	   					+"       ******************************************************** \n"
	   					+"Code :\t"+text_code.getText()
	   					+"\nDatebon :\t "+((JTextField) dateChooserbon.getDateEditor().getUiComponent()).getText()
	   					+"\nClient :\t "+text_Client.getSelectedItem()
	   					+"\nNbrligne_br : \t"+txt_nbrLigneBL.getText()
	   					+"\nPUHorsTVA : "+text_MtotalPayer.getText()
	   					+"\nTVA : "+text_MTotalTVA.getText()
	   					+"\nPTotalHorsTVA : "+text_MTotalHorsTVA.getText()+"\n");
			      		
	           			
	           			text_code.setText(null);
	           			((JTextField) dateChooserbon.getDateEditor().getUiComponent()).setText(null);
	           			text_Client.setToolTipText(null);
	   					txt_nbrLigneBL.setText(null);
	   					text_MtotalPayer.setText(null);
	   					text_MTotalTVA.setText(null);
	   					text_MTotalHorsTVA.setText(null);
	   					
	   					updateTable("1=1");
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
		           		String sql = "DELETE FROM `devis` WHERE code=" +value; 
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
		    						JOptionPane.showMessageDialog(null, "Aucune donnée pour supprimer" , "Gestion des devis", JOptionPane.OK_OPTION);
		    					}
		    					else {
		    						JOptionPane.showMessageDialog(null, "Selectionner une ligne pour la supprimer" , "Gestion des devis", JOptionPane.OK_OPTION);
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
	     //paneltableau.setBorder(new LineBorder(Color.WHITE));
	     paneltableau.setOpaque(false);
	     paneltableau.setBackground(new Color(0, 0, 0));
	     paneltableau.setBounds(10, 297, 962, 213);
	     add(paneltableau);
	     
	     combobox.setModel(new DefaultComboBoxModel(new String[] {"Code", "Date", "Client",
   	    		"ligne_devis","m_total_TVA","m_total_hors_TVA","m_total_Payer"}));
			combobox.setForeground(Color.black);
			combobox.setBackground(new Color(255, 255, 255));
			combobox.setBounds(207, 7, 195, 25);
			paneltableau.add(combobox);
	     
	     JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 45, 931, 157);
		 paneltableau.add(scrollPane);
	     
		 Object tab []= {"Code", "Date", "Client",
	   	    		"ligne_devis","m_total_TVA","m_total_hors_TVA","m_total_Payer"};
			model.setColumnIdentifiers(tab);
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
			           		String sql = "SELECT * FROM `devis` WHERE code=" +code; 
			         
			           		pst = c.prepareStatement(sql);
			    			rs = pst.executeQuery();
			           		while (rs.next()) {
		                	
		                		text_code.setText(rs.getString("code").toString());
		                		Date d = rs.getDate("date");
		                		text_Client.setSelectedItem(rs.getString("client").toString());
		                		text_MTotalHorsTVA.setText(rs.getString("m_total_hors_TVA").toString());
		                		text_MTotalTVA.setText(rs.getString("m_total_TVA").toString());
		                		text_MtotalPayer.setText(rs.getString("m_total_Payer").toString());
		                		
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
						String sql = "select * from devis where "+selection+"=?"; 
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
			String sql = "SELECT * FROM `devis`";
            try {
            	pst = conn.prepareStatement(sql);
            	rs = pst.executeQuery();
            	Object col []= {"Code", "Date", "Client",
           	    		"ligne_devis","m_total_TVA","m_total_hors_TVA","m_total_Payer"};
    			model.setColumnIdentifiers(col);
    			table.setModel(model);
            	Object[] columnData = new Object[7];
            	//String sql = "SELECT * FROM `bon_reception`";
            	//pst1 = conn.prepareStatement(sql);
            	//rs1 = pst1.executeQuery();
            	// byte[] image = null;
                // while (rs1.next()) {
                 //  image = rs1.getBytes("ligne_br");
                 //}
            
            	while (rs.next()) {
            		
            		columnData[0] = rs.getInt("code");
            		columnData[1] = rs.getDate("date");
            		columnData[2] = rs.getInt("client");
            		columnData[3] = rs.getBlob("ligne_devis");
            		columnData[4] = rs.getFloat("m_total_TVA");
            		columnData[5] = rs.getFloat("m_total_hors_TVA");
            		columnData[6] = rs.getFloat("m_total_Payer");
            		
            		 
            		/*Blob blob = rs.getBlob("ligne_br");
                    ImageIcon icon = null;
                    InputStream is = blob.getBinaryStream();
                    BufferedImage img = ImageIO.read(is);
                    icon = new ImageIcon(img);*/
            		
            	      //créer l'image 
            	      /*Image img = Toolkit.getDefaultToolkit().createImage(image);
            	      ImageIcon icone = new ImageIcon(img);*/
            	      //JLabel l = new JLabel();
            	      //l.setIcon(icone);
            	      
    
    
                   //model.addRow(new Object[]{rs.getString("ligne_br"),icon});
    
            		/*BufferedImage image = ImageIO.read(((Blob) columnData[6]).getBinaryStream()); 
            	    FileOutputStream stream = new FileOutputStream(file); 
            	    ImageIO.write(image,"jpg",stream); */
            		
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
				String sql1 = "select * from devis"; 
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
	


