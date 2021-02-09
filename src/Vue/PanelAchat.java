package Vue;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Metier.Ligne_BR;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.Color;
import java.awt.event.MouseAdapter;


public class PanelAchat extends JPanel{
	
	
		private static final long serialVersionUID = 1L;
		private PanelFournisseur panelFournisseur;
		private PanelProduitAchat panelProduitAchat;
		private PanelFactureAchat panelFactureAchat;
		private PanelBonReception panelBonReception;
		private PanelLigneBR panelLigneBR;
		public Vector<Ligne_BR> Vcp;
		
		public PanelAchat() {
			setBackground(SystemColor.activeCaptionBorder);
			setBounds(0,0,1200,478);
			setLayout(null);
			setVisible(true);
			
			panelFournisseur = new PanelFournisseur();
			panelFournisseur.setBackground(SystemColor.activeCaptionBorder);
			panelFournisseur.setBounds(0,-12,973,590);
			
			panelProduitAchat = new PanelProduitAchat();
			panelProduitAchat.setBackground(SystemColor.activeCaptionBorder);
			panelProduitAchat.setBounds(0,-12,973,512);
			
			panelFactureAchat = new PanelFactureAchat();
			panelFactureAchat.setBackground(SystemColor.activeCaptionBorder);
			panelFactureAchat.setBounds(0,-12,973,512);
			
			panelBonReception = new PanelBonReception();
			panelBonReception.setBackground(SystemColor.activeCaptionBorder);
			panelBonReception.setBounds(0,-12,973,512);
			
			panelLigneBR = new PanelLigneBR(Vcp);
			panelLigneBR.setBackground(SystemColor.activeCaptionBorder);
			panelLigneBR.setBounds(0,-12,973,512);
			
			
			
			
			
			JPanel panfournisseur = new JPanel();
			panfournisseur.addMouseListener(new PanelButtonMouseAdapter(panfournisseur) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(panfournisseur);
					panelFournisseur.setVisible(true);
				}
			});
			panfournisseur.setBackground(new Color(0, 139, 139));
			panfournisseur.setBounds(96, 11, 163, 29);
			add(panfournisseur);
			panfournisseur.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("FOURNISSEUR");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel.setBounds(39, 2, 114, 24);
			panfournisseur.add(lblNewLabel);
			
			JLabel lblIconajouter = new JLabel("");
			lblIconajouter.setIcon(new ImageIcon(PanelAchat.class.getResource("/image/consumer.png")));
			lblIconajouter.setBounds(10, 2, 39, 24);
			panfournisseur.add(lblIconajouter);
		
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(240,240,240,240));
			panel.setBounds(6, 51, 973, 500);
			add(panel);
			panel.setLayout(null);
			
			panel.add(panelFournisseur);
			panelFournisseur.setVisible(true);
			panel.add(panelProduitAchat);
			panel.add(panelFactureAchat);
			panel.add(panelBonReception);
			panel.add(panelLigneBR);
			panelProduitAchat.setVisible(true);
			
			
			
			
			JPanel panFactureAchat = new JPanel();
			panFactureAchat.setBounds(429, 11, 136, 29);
			add(panFactureAchat);
			panFactureAchat.addMouseListener(new PanelButtonMouseAdapter(panFactureAchat) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(panFactureAchat);
					panelFactureAchat.setVisible(true);
				}
			});
			panFactureAchat.setBackground(new Color(0, 139, 139));
			panFactureAchat.setLayout(null);
			
			JLabel lblNewLabel2 = new JLabel("FACTURE");
			lblNewLabel2.setForeground(new Color(255, 255, 255));
			lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel2.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel2.setBounds(40, 2, 87, 24);
			panFactureAchat.add(lblNewLabel2);
			
			
			JLabel lblIconmodifier2 = new JLabel("");
			lblIconmodifier2.setIcon(new ImageIcon(PanelAchat.class.getResource("/image/invoice.png")));
			lblIconmodifier2.setBounds(10, 2, 39, 27);
			panFactureAchat.add(lblIconmodifier2);	
			panelFactureAchat.setVisible(true);
			
			
			
			JPanel panBonReception = new JPanel();
			panBonReception.setBounds(581, 11, 174, 29);
			add(panBonReception);
			panBonReception.addMouseListener(new PanelButtonMouseAdapter(panBonReception) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(panBonReception);
					panelBonReception.setVisible(true);
				}
			});
			panBonReception.setBackground(new Color(0, 139, 139));
			panBonReception.setLayout(null);
			
			JLabel lblNewLabel3 = new JLabel("BON RECEPTION");
			lblNewLabel3.setForeground(new Color(255, 255, 255));
			lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel3.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel3.setBounds(43, 2, 121, 24);
			panBonReception.add(lblNewLabel3);
			
			
			JLabel lblIconmodifier3 = new JLabel("");
			lblIconmodifier3.setIcon(new ImageIcon(PanelAchat.class.getResource("/image/notes.png")));
			lblIconmodifier3.setBounds(10, 2, 39, 27);
			panBonReception.add(lblIconmodifier3);	
			
			
			JPanel panProduitAchat = new JPanel();
			panProduitAchat.setBounds(281, 11, 129, 29);
			add(panProduitAchat);
			panProduitAchat.addMouseListener(new PanelButtonMouseAdapter(panProduitAchat) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(panProduitAchat);
					panelProduitAchat.setVisible(true);
				}
			});
			panProduitAchat.setBackground(new Color(0, 139, 139));
			panProduitAchat.setLayout(null);
			
			JLabel lblNewLabel1 = new JLabel("PRODUIT");
			lblNewLabel1.setForeground(new Color(255, 255, 255));
			lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel1.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel1.setBounds(44, 2, 72, 24);
			panProduitAchat.add(lblNewLabel1);
			
			JLabel lblIconmodifier = new JLabel("");
			lblIconmodifier.setIcon(new ImageIcon(PanelAchat.class.getResource("/image/box.png")));
			lblIconmodifier.setBounds(10, 2, 35, 24);
			panProduitAchat.add(lblIconmodifier);	
			
			JPanel panel_ligneBR = new JPanel();
			panel_ligneBR.setLayout(null);
			panel_ligneBR.setBackground(new Color(0, 139, 139));
			panel_ligneBR.setBounds(765, 11, 136, 29);
			panel_ligneBR.addMouseListener(new PanelButtonMouseAdapter(panel_ligneBR) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(panel_ligneBR);
					panelLigneBR.setVisible(true);
				}
			});
			add(panel_ligneBR);
			
			JLabel lblLigneBr = new JLabel("Ligne BR");
			lblLigneBr.setHorizontalAlignment(SwingConstants.CENTER);
			lblLigneBr.setForeground(Color.WHITE);
			lblLigneBr.setFont(new Font("Dialog", Font.BOLD, 14));
			lblLigneBr.setBounds(43, 2, 83, 24);
			panel_ligneBR.add(lblLigneBr);
			
			JLabel label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon(PanelAchat.class.getResource("/image/notes.png")));
			label_1.setBounds(10, 2, 39, 27);
			panel_ligneBR.add(label_1);
			panelLigneBR.setVisible(true);
			
			
			
		}
			
			
	
		
		public void menuClicked(JPanel panell) {
			panelFournisseur.setVisible(false);
			panelProduitAchat.setVisible(false);
			panelFactureAchat.setVisible(false);
			panelBonReception.setVisible(false);
			panelLigneBR.setVisible(false);
			
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
