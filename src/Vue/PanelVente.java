package Vue;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Metier.Ligne_BL;
import Metier.Ligne_BR;
import Metier.Ligne_devis;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.Color;
import java.awt.event.MouseAdapter;

public class PanelVente extends JPanel{
	
	
		private static final long serialVersionUID = 1L;
		private PanelDevis panelDevis;
		private PanelLigneDevis panelLigneDevis;
		private PanelClient panelClient;
		private PanelBonLivraison panelBonLivraison;
		private PanelFactureVente panelFactureVente;
		private PanelProduitVente panelProduitVente;
		private PanelLigneBL panelLigneBL;
		public Vector<Ligne_BL> Vcp;
		public Vector<Ligne_devis>Vld;
		
		public PanelVente() {
			setBackground(SystemColor.activeCaptionBorder);
			setBounds(0,0,1000,478);
			setLayout(null);
			setVisible(true);
			
			panelDevis = new PanelDevis();
			panelDevis.setBackground(SystemColor.activeCaptionBorder);
			panelDevis.setBounds(0,-11,1009,520);
			
			panelLigneDevis = new PanelLigneDevis(Vld);
			panelLigneDevis.setBackground(SystemColor.activeCaptionBorder);
			panelLigneDevis.setBounds(0,-11,1009,520);
			
			panelClient = new PanelClient();
			panelClient.setBackground(SystemColor.activeCaptionBorder);
			panelClient.setBounds(0,-11,1009,520);
			
			panelBonLivraison = new PanelBonLivraison();
			panelBonLivraison.setBackground(SystemColor.activeCaptionBorder);
			panelBonLivraison.setBounds(0,-11,1009,520);
			
			panelFactureVente = new PanelFactureVente();
			panelFactureVente.setBackground(SystemColor.activeCaptionBorder);
			panelFactureVente.setBounds(0,-11,1009,520);
			
			panelProduitVente = new PanelProduitVente();
			panelProduitVente.setBackground(SystemColor.activeCaptionBorder);
			panelProduitVente.setBounds(0,-11,1009,520);
			
			panelLigneBL = new PanelLigneBL(Vcp);
			panelLigneBL.setBackground(SystemColor.activeCaptionBorder);
			panelLigneBL.setBounds(0,-12,973,512);
			
			JPanel pandevis = new JPanel();
			pandevis.addMouseListener(new PanelButtonMouseAdapter(pandevis) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(pandevis);
					panelDevis.setVisible(true);
				}
			});
			pandevis.setBackground(new Color(0, 139, 139));
			pandevis.setBounds(12, 11, 111, 29);
			add(pandevis);
			pandevis.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("DEVIS");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel.setBounds(39, 2, 62, 24);
			pandevis.add(lblNewLabel);
			
			JLabel lblIconajouter = new JLabel("");
			lblIconajouter.setIcon(new ImageIcon(PanelVente.class.getResource("/image/notes.png")));
			lblIconajouter.setBounds(10, 2, 39, 24);
			pandevis.add(lblIconajouter);
		
			
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.activeCaptionBorder);
			panel.setBounds(6, 51, 1200, 690);
			add(panel);
			panel.setLayout(null);
			
			panel.add(panelDevis);
			panelDevis.setVisible(true);
			panel.add(panelLigneDevis);
			panel.add(panelClient);
			panel.add(panelBonLivraison);
			panel.add(panelFactureVente);
			panel.add(panelProduitVente);
			panel.add(panelLigneBL);
			
			JPanel panClient = new JPanel();
			panClient.setBounds(286, 11, 118, 29);
			add(panClient);
			panClient.addMouseListener(new PanelButtonMouseAdapter(panClient) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(panClient);
					panelClient.setVisible(true);
				}
			});
			panClient.setBackground(new Color(0, 139, 139));
			panClient.setLayout(null);
			
			JLabel lblNewLabel1 = new JLabel("CLIENT");
			lblNewLabel1.setForeground(new Color(255, 255, 255));
			lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel1.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel1.setBounds(44, 2, 64, 24);
			panClient.add(lblNewLabel1);
			
			JLabel lblIconmodifier = new JLabel("");
			lblIconmodifier.setIcon(new ImageIcon(PanelVente.class.getResource("/image/consumer.png")));
			lblIconmodifier.setBounds(10, 2, 35, 24);
			panClient.add(lblIconmodifier);	
			panelClient.setVisible(true);
			
			
			
			
			JPanel panBonLivraison = new JPanel();
			panBonLivraison.setBounds(412, 11, 163, 29);
			add(panBonLivraison);
			panBonLivraison.addMouseListener(new PanelButtonMouseAdapter(panBonLivraison) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(panBonLivraison);
					panelBonLivraison.setVisible(true);
				}
			});
			panBonLivraison.setBackground(new Color(0, 139, 139));
			panBonLivraison.setLayout(null);
			
			JLabel lblNewLabel2 = new JLabel("BON LIVRAISON");
			lblNewLabel2.setForeground(new Color(255, 255, 255));
			lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel2.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel2.setBounds(40, 2, 113, 24);
			panBonLivraison.add(lblNewLabel2);
			
			
			JLabel lblIconmodifier2 = new JLabel("");
			lblIconmodifier2.setIcon(new ImageIcon(PanelVente.class.getResource("/image/delivery-truck.png")));
			lblIconmodifier2.setBounds(10, 2, 39, 27);
			panBonLivraison.add(lblIconmodifier2);	
			panelBonLivraison.setVisible(true);
			
			
			
			JPanel panFactureVente = new JPanel();
			panFactureVente.setBounds(585, 11, 129, 29);
			add(panFactureVente);
			panFactureVente.addMouseListener(new PanelButtonMouseAdapter(panFactureVente) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(panFactureVente);
					panelFactureVente.setVisible(true);
				}
			});
			panFactureVente.setBackground(new Color(0, 139, 139));
			panFactureVente.setLayout(null);
			
			JLabel lblNewLabel3 = new JLabel("FACTURE ");
			lblNewLabel3.setForeground(new Color(255, 255, 255));
			lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel3.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel3.setBounds(43, 2, 76, 24);
			panFactureVente.add(lblNewLabel3);
			
			
			JLabel lblIconmodifier3 = new JLabel("");
			lblIconmodifier3.setIcon(new ImageIcon(PanelVente.class.getResource("/image/invoice.png")));
			lblIconmodifier3.setBounds(10, 2, 39, 27);
			panFactureVente.add(lblIconmodifier3);	
			panelFactureVente.setVisible(true);
			
			
			JPanel panProduit = new JPanel();
			panProduit.setBounds(724, 11, 111, 29);
			add(panProduit);
			panProduit.addMouseListener(new PanelButtonMouseAdapter(panProduit) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(panProduit);
					panelProduitVente.setVisible(true);
				}
			});
			panProduit.setBackground(new Color(0, 139, 139));
			panProduit.setLayout(null);
			
			JLabel lblNewLabel4 = new JLabel("Produit");
			lblNewLabel4.setForeground(new Color(255, 255, 255));
			lblNewLabel4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel4.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel4.setBounds(41, 2, 60, 24);
			panProduit.add(lblNewLabel4);
			
			JLabel lblIconmodifier4 = new JLabel("");
			lblIconmodifier4.setIcon(new ImageIcon(PanelVente.class.getResource("/image/box.png")));
			lblIconmodifier4.setBounds(10, 2, 39, 27);
			panProduit.add(lblIconmodifier4);	
			panelProduitVente.setVisible(true);
			
			
			JPanel panel_ligneBL = new JPanel();
			panel_ligneBL.setLayout(null);
			panel_ligneBL.setBackground(new Color(0, 139, 139));
			panel_ligneBL.setBounds(845, 11, 129, 29);
			panel_ligneBL.addMouseListener(new PanelButtonMouseAdapter(panel_ligneBL) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(panel_ligneBL);
					panelLigneBL.setVisible(true);
				}
			});
			add(panel_ligneBL);
			
			JLabel lblLigneBl = new JLabel("Ligne BL");
			lblLigneBl.setHorizontalAlignment(SwingConstants.CENTER);
			lblLigneBl.setForeground(Color.WHITE);
			lblLigneBl.setFont(new Font("Dialog", Font.BOLD, 14));
			lblLigneBl.setBounds(43, 2, 83, 24);
			panel_ligneBL.add(lblLigneBl);
			
			JLabel label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon(PanelVente.class.getResource("/image/delivery-truck.png")));
			label_1.setBounds(10, 2, 39, 27);
			panel_ligneBL.add(label_1);
			
			JPanel panlignedevis = new JPanel();
			panlignedevis.setBounds(133, 11, 143, 29);
			add(panlignedevis);
			panlignedevis.addMouseListener(new PanelButtonMouseAdapter(panlignedevis) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(panlignedevis);
					panelLigneDevis.setVisible(true);
				}
			});
			panlignedevis.setBackground(new Color(0, 139, 139));
			panlignedevis.setLayout(null);
			
			JLabel lblNewLabeld = new JLabel("LIGNE_DEVIS");
			lblNewLabeld.setForeground(new Color(255, 255, 255));
			lblNewLabeld.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabeld.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabeld.setBounds(39, 2, 94, 24);
			panlignedevis.add(lblNewLabeld);
			
			JLabel lblIconajouterd = new JLabel("");
			lblIconajouterd.setIcon(new ImageIcon(PanelVente.class.getResource("/image/notes.png")));
			lblIconajouterd.setBounds(10, 2, 39, 24);
			panlignedevis.add(lblIconajouterd);
			panelLigneBL.setVisible(true);
		}
			
		
	
		
		public void menuClicked(JPanel panell) {
			panelDevis.setVisible(false);
			panelLigneDevis.setVisible(false);
			panelClient.setVisible(false);
			panelBonLivraison.setVisible(false);
			panelFactureVente.setVisible(false);
			panelProduitVente.setVisible(false);
			panelLigneBL.setVisible(false);
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
