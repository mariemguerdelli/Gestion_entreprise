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

public class PanelFactureClient extends JPanel {
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
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JTextField text_codeBon;
	private JTextField text_TTC;
	/*private JTextField text_mPayer;
	private JTextField text_MReste;*/


	


	/**
	 * Create the panel.
	 */
	public PanelFactureClient() {
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
		lblDateFacture.setBounds(307, 23, 89, 20);
		panelDevis.add(lblDateFacture);
		
		
		txt_date = new JDateChooser();
        txt_date.setDateFormatString("yyyy-MM-dd");
        Date date = new Date();
        txt_date.setDate(date);
        txt_date.setBounds(395, 21, 96, 20);
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
	                //System.out.println(tf);
	                Combobox_Client.addItem(String.valueOf(tf));
	              
	            }           
	        }catch(Exception e1){
	            JOptionPane.showMessageDialog(null,e1);
	        }
			Combobox_Client.setBounds(209, 23, 82, 20);
	     panelDevis.add(Combobox_Client);
	     
	     
	     JComboBox comboBoxmodepayment = new JComboBox(new String[] {"espece", "cheque", "virement"});
	     comboBoxmodepayment.setBounds(110, 59, 89, 20);
	     panelDevis.add(comboBoxmodepayment);
	     
	     JComboBox comboBox = new JComboBox(new String[] {"F.C.BL", "F.C.Libre"});
	     comboBox.setBounds(297, 59, 96, 20);
	     panelDevis.add(comboBox);
		
		JLabel lbltype = new JLabel("Type_Facture:");
		lbltype.setForeground(SystemColor.textHighlightText);
		lbltype.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lbltype.setBounds(209, 57, 89, 25);
		panelDevis.add(lbltype);
		
		
		   text_codeBon = new JTextField();
		   text_codeBon.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
		       String sql = "select code from bon_livraison where code_client=?";
			    try{
			    	Class.forName("com.mysql.jdbc.Driver");
	    			String url = "jdbc:mysql://localhost:3306/gestion_entreprise";
	    			Connection c = DriverManager.getConnection(url,"root","");
	    			Statement stmt = c.createStatement();
	    			
	            pst= c.prepareStatement(sql);
	            pst.setString(1,(String)Combobox_Client.getSelectedItem());
	            rs=pst.executeQuery();
	            while (rs.next()){
	                int t1=rs.getInt("code");
	                //System.out.println(t1);
	                text_codeBon.setText(String.valueOf(t1));
	              
	            }           
	        }catch(Exception e1){
	            JOptionPane.showMessageDialog(null,e1);
	        }
				}
			});
			
		     text_codeBon.setColumns(10);
		     text_codeBon.setBounds(470, 57, 66, 25);
		     panelDevis.add(text_codeBon);
		     
		     JLabel lblTtc = new JLabel("TTC:");
		     lblTtc.setForeground(Color.WHITE);
		     lblTtc.setFont(new Font("Times New Roman", Font.BOLD, 13));
		     lblTtc.setBounds(10, 93, 49, 25);
		     panelDevis.add(lblTtc);
		     
		     text_TTC = new JTextField();
		     text_TTC.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
			      
				    try{
				    	Class.forName("com.mysql.jdbc.Driver");
		    			String url = "jdbc:mysql://localhost:3306/gestion_entreprise";
		    			Connection c = DriverManager.getConnection(url,"root","");
		    			Statement stmt = c.createStatement();
		    			 String sql = "select m_total_Payer from bon_livraison where code_client=?";
		            pst= c.prepareStatement(sql);
		            pst.setString(1,(String)Combobox_Client.getSelectedItem());
		            rs=pst.executeQuery();
		            while (rs.next()){
		                Float t1=rs.getFloat("m_total_Payer");
		                //System.out.println(t1);
		                text_TTC.setText(String.valueOf(t1));
		              
		            }           
		        }catch(Exception e1){
		            JOptionPane.showMessageDialog(null,e1);
		        }
					}
				});
		     
		     text_TTC.setColumns(10);
		     text_TTC.setBounds(50, 93, 66, 25);
		     panelDevis.add(text_TTC);
		     
		     
		     JLabel lblCodebon = new JLabel("Code_Bon:");
		     lblCodebon.setForeground(Color.WHITE);
		     lblCodebon.setFont(new Font("Times New Roman", Font.BOLD, 13));
		     lblCodebon.setBounds(405, 57, 66, 25);
		     panelDevis.add(lblCodebon);
		     
		     /*JLabel lblMontantpayer = new JLabel("Montant_Payer:");
		     lblMontantpayer.setForeground(Color.WHITE);
		     lblMontantpayer.setFont(new Font("Times New Roman", Font.BOLD, 13));
		     lblMontantpayer.setBounds(139, 93, 101, 25);
		     panelDevis.add(lblMontantpayer);
		     
		     text_mPayer = new JTextField();
		     text_mPayer.setColumns(10);
		     text_mPayer.setBounds(233, 93, 66, 25);
		     panelDevis.add(text_mPayer);
		     */
		     JLabel lblMontantrestant = new JLabel("Montant_Restant:");
		     lblMontantrestant.setForeground(Color.WHITE);
		     lblMontantrestant.setFont(new Font("Times New Roman", Font.BOLD, 13));
		     lblMontantrestant.setBounds(326, 93, 112, 25);
		     panelDevis.add(lblMontantrestant);
		     
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
		     
		    /* text_MReste = new JTextField();
		     text_MReste.addMouseListener(new MouseAdapter() {
		     	@Override
		     	public void mouseClicked(MouseEvent e) {
		     		float TTC = Float.parseFloat(text_TTC.getText().toString());
					float MPayer = Float.parseFloat(text_mPayer.getText().toString());
					text_MReste.setText(String.valueOf(TTC-MPayer));
		     	}
		     });
		     text_MReste.setColumns(10);
		     text_MReste.setBounds(427, 93, 66, 25);
		     panelDevis.add(text_MReste);*/
	     
	     
	     JPanel panelboutons = new JPanel();
	     panelboutons.setForeground(new Color(0, 0, 0));
	     panelboutons.setLayout(null);
	     panelboutons.setOpaque(false);
	     panelboutons.setBorder(new LineBorder(Color.WHITE));
	     panelboutons.setBackground(new Color(0, 0, 0));
	     panelboutons.setBounds(50, 155, 555, 40);
	     panelDevis.add(panelboutons);
	     btnAdd.setBounds(10, 4, 116, 30);
	     btnAdd.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		
		     		try {
		     			
		     			ConnectionDB c = new ConnectionDB();
						Statement stmt = c.ConnectDb().createStatement();
						
						String date1 = ((JTextField) txt_date.getDateEditor()
								.getUiComponent()).getText();
						
						Facture_client_BL factureBL = new Facture_client_BL(Integer.parseInt(text_code.getText().toString()),
							Integer.parseInt(Combobox_Client.getSelectedItem().toString()),date1,
							comboBoxmodepayment.getSelectedItem().toString(),comboBox.getSelectedItem().toString(),Integer.parseInt(text_codeBon.getText().toString()),
							Float.parseFloat(text_TTC.getText().toString()));
						
						String req= Requetes_SQL.ajouter_facture_client_BL(factureBL);
						
						
						int nb=stmt.executeUpdate(req);
						if(nb==0)
							JOptionPane.showMessageDialog(null, "ERREUR d'ajout","Ajout_FactureBL" , JOptionPane.OK_OPTION);
						else
							JOptionPane.showMessageDialog(null, "ajout avec succés!","Ajout_FactureBL" , JOptionPane.OK_OPTION);
						
						table.setModel(model);
	           			DefaultTableModel model = (DefaultTableModel) table.getModel();
	           			model.addRow(new Object[] {
	           					text_code.getText(),
	           					Combobox_Client.getSelectedItem(), 					
	           					((JTextField) txt_date.getDateEditor().getUiComponent()).getText(),
	           					comboBoxmodepayment.getSelectedItem(),
	           					comboBox.getSelectedItem(),
	           					text_codeBon.getText(),
	           					text_TTC.getText(),
	           					
	           					});
	           			
	           			textArea.setText("");
	   					textArea.append("                     Fiche Facture BL\n"
	   					+"       ******************************************************** \n"
	   					+"Code_Facture :\t"+text_code.getText()
	   					+"\nCode_Fournisseur :\t "+Combobox_Client.getSelectedItem()
	   					+"\nMode_Payement :\t "+comboBoxmodepayment.getSelectedItem()
	   					+"\nType_Facture :\t "+comboBox.getSelectedItem()
	   					+"\nDate_Facture :\t "+((JTextField) txt_date.getDateEditor().getUiComponent()).getText()
	   					+"\nCode_BonRecep :\t "+text_codeBon.getText()
	   					+"\nTTC :\t "+text_TTC.getText()
	   					+"\n");
	   					
	      				
	   					text_code.setText(null);
       					Combobox_Client.setSelectedItem(null); 					
       					comboBoxmodepayment.setSelectedItem(null);
       					comboBox.setSelectedItem(null);
       					text_codeBon.setText(null);
       					text_TTC.setText(null);
       					
	      				
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
						
						Facture_client_BL factureBL = new Facture_client_BL(Integer.parseInt(text_code.getText().toString()),
								Integer.parseInt(Combobox_Client.getSelectedItem().toString()),date1,
								comboBoxmodepayment.getSelectedItem().toString(),comboBox.getSelectedItem().toString(),Integer.parseInt(text_codeBon.getText().toString()),
								Float.parseFloat(text_TTC.getText().toString()));
						
						String req= Requetes_SQL.modifier_facture_client_BL(factureBL);
						//System.out.println(req);
						PreparedStatement pst = conn.prepareStatement(req);
						pst.execute();
	                	JOptionPane.showMessageDialog(null, "Mise à jour de factureBL avec succés");
	                	pst.close();
	                	
	                	textArea.setText("");
	   					textArea.append("                     Fiche Facture BL\n"
	   					+"       ******************************************************** \n"
	   					+"Code_Facture :\t"+text_code.getText()
	   					+"\nCode_Fournisseur :\t "+Combobox_Client.getSelectedItem()
	   					+"\nMode_Payement :\t "+comboBoxmodepayment.getSelectedItem()
	   					+"\nType_Facture :\t "+comboBox.getSelectedItem()
	   					+"\nDate_Facture :\t "+((JTextField) txt_date.getDateEditor().getUiComponent()).getText()
	   					+"\nCode_BonRecep :\t "+text_codeBon.getText()
	   					+"\nTTC :\t "+text_TTC.getText()+
	   					"\n");
			      			
		     		
	                	text_code.setText(null);
       					Combobox_Client.setSelectedItem(null); 					
       					comboBoxmodepayment.setSelectedItem(null);
       					comboBox.setSelectedItem(null);
       					text_codeBon.setText(null);
       					text_TTC.setText(null);
       					
       					
	   					
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
		           		String sql = "DELETE FROM `facture_fournisseur_bl` WHERE code=" +value; 
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
	     
	     Object col []= {"Code", "Client", "DateFacture","ModePayement","type_facture","code_bonLivr","m_total_payer","M_deja_Payer","M_Restant"};
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
			           		String sql = "select * from facture_client_bl WHERE code=" +code; 
			         
			           		pst = c.prepareStatement(sql);
			    			rs = pst.executeQuery();
			           		while (rs.next()) {
			           			
		                		text_code.setText(rs.getString("code").toString());
		                		Combobox_Client.setSelectedItem(rs.getString("code_client").toString());
		                		Date d = rs.getDate("date_facture");
		                		txt_date.setDate(d);
		                		comboBoxmodepayment.setSelectedItem(rs.getString("mode_payement").toString());
		                		comboBox.setSelectedItem(rs.getString("type_facture").toString());
		                		text_codeBon.setText(rs.getString("code_bon_livr").toString());
		                		text_TTC.setText(rs.getString("m_total_Payer").toString());
		                		
		                		
		                	}
							
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null,e1);
						}
				}
				
			});
			table.setModel(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(89);
			scrollPane.setViewportView(table);
			
			
			comboboxsearch.setModel(new DefaultComboBoxModel(new String[] {"code", "code_client", "date_facture",
					"mode_payement","type_facture",
					"code_bon_livr","m_total_Payer"}));
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
						String sql = "select * from facture_client_bl where "+selection+"=?"; 
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
			String sql = "select * from facture_client_bl";
            try {
            	pst = conn.prepareStatement(sql);
            	rs = pst.executeQuery();
            	Object col []= {"Code", "Client", "DateFacture","ModePayement","type_facture","code_bonLivr","m_total_payer"};
    			model.setColumnIdentifiers(col);
    			table.setModel(model);
            	Object[] columnData = new Object[7];
            	
            
            	while (rs.next()) {
            		
            		columnData[0] = rs.getInt("code");
            		columnData[1] = rs.getString("code_client");
            		columnData[2] = rs.getDate("date_facture");
            		columnData[3] = rs.getString("mode_payement");
            		columnData[4] = rs.getString("type_facture");
            		columnData[5] = rs.getInt("code_bon_livr");
            		columnData[6] = rs.getFloat("m_total_Payer");
            		
            		
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
				String sql1 = "select * from facture_client_bl"; 
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
	


