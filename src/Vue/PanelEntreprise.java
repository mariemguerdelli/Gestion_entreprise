package Vue;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import javax.swing.UIManager;

public class PanelEntreprise extends JPanel{
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	private JTextField text_Matricule;
	private JTextField text_NomEntreprise;
	private JTextField text_Description;
	private JTextField text_Banque;
	private JTextField text_Agence;
	private JTextField text_Rib;
	private JTextField text_NumRue;
	private JTextField text_Libelle;
	private JTextField text_CodePostale;
	private JTextField text_NomVille;
	private JTextField text_NumFixe;
	private JTextField text_NumMobile;
	private JTextField text_EtatFiscale;
	private JTextField text_Gouvernorat;
	private JTextField text_site;
	private JTextField text_fax;
	private JTextField text_email;
		private static final long serialVersionUID = 1L;
		//private JPanel contentPane;
		private PanelAjouter panelAjout;
		private PanelModifier panelModifier;
		
		public PanelEntreprise() {
			setBackground(SystemColor.activeCaptionBorder);
			setBounds(0,0,1000,478);
			setLayout(null);
			setVisible(true);
			
			panelAjout = new PanelAjouter();
			panelAjout.setBackground(SystemColor.activeCaptionBorder);
			panelAjout.setBounds(0,-22,845,522);
			
			panelModifier = new PanelModifier();
			panelModifier.setBackground(SystemColor.activeCaptionBorder);
			panelModifier.setBounds(0,-22,845,522);
			
			
			
			JPanel panajouter = new JPanel();
			panajouter.addMouseListener(new PanelButtonMouseAdapter(panajouter) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(panajouter);
					panelAjout.setVisible(true);
				}
			});
			panajouter.setBackground(new Color(0, 139, 139));
			panajouter.setBounds(62, 11, 143, 29);
			add(panajouter);
			panajouter.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("AJOUTER");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel.setBounds(47, 2, 74, 24);
			panajouter.add(lblNewLabel);
			
			JLabel lblIconajouter = new JLabel("");
			lblIconajouter.setIcon(new ImageIcon(PanelEntreprise.class.getResource("/image/add.png")));
			lblIconajouter.setBounds(10, 2, 39, 24);
			panajouter.add(lblIconajouter);
		
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(240,240,240,240));
			panel.setBounds(6, 65, 837, 495);
			add(panel);
			panel.setLayout(null);
			
			panel.add(panelAjout);
			panelAjout.setVisible(true);
			
			panel.add(panelModifier);
			
			JPanel panmodifier = new JPanel();
			panmodifier.setBounds(354, 11, 147, 29);
			add(panmodifier);
			panmodifier.addMouseListener(new PanelButtonMouseAdapter(panmodifier) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(panmodifier);
					panelModifier.setVisible(true);
					
		       		
				}});
			panmodifier.setBackground(new Color(0, 139, 139));
			panmodifier.setLayout(null);
			
			JLabel lblNewLabel1 = new JLabel("MODIFIER");
			lblNewLabel1.setForeground(new Color(255, 255, 255));
			lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel1.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel1.setBounds(55, 2, 82, 24);
			panmodifier.add(lblNewLabel1);
			
			JLabel lblIconmodifier = new JLabel("");
			lblIconmodifier.setIcon(new ImageIcon(PanelEntreprise.class.getResource("/image/updated.png")));
			lblIconmodifier.setBounds(10, 2, 39, 27);
			panmodifier.add(lblIconmodifier);	
			panelModifier.setVisible(true);
		
	}
		
		public void menuClicked(JPanel panell) {
			panelAjout.setVisible(false);
			panelModifier.setVisible(false);
			panell.setVisible(true);
			
		}
		
		private class PanelButtonMouseAdapter extends MouseAdapter{
			JPanel panel;
			public PanelButtonMouseAdapter(JPanel panel) {
				this.panel = panel;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(new Color (112,128,144));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(new Color (47,79,79));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panel.setBackground(new Color (60,179,113));
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panel.setBackground(new Color (112,128,144));
				
			}
		}
}
