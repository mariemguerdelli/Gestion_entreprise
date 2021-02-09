package Vue;

import javax.swing.JPanel;
import javax.swing.SwingConstants;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;


public class PanelFactureVente extends JPanel{
	
	
		private static final long serialVersionUID = 1L;
		private PanelFactureClient panelFactureClient;
		private PanelFactureAvoir panelFactureAvoir;
		
		public PanelFactureVente() {
			setBackground(SystemColor.activeCaptionBorder);
			setBounds(0,0,1000,478);
			setLayout(null);
			setVisible(true);
			
			panelFactureClient = new PanelFactureClient();
			panelFactureClient.setBackground(SystemColor.activeCaptionBorder);
			panelFactureClient.setBounds(0,0,987,500);
			
			panelFactureAvoir = new PanelFactureAvoir();
			panelFactureAvoir.setBackground(SystemColor.activeCaptionBorder);
			panelFactureAvoir.setBounds(0,0,987,500);
			
			
			
			JPanel panFactureClient = new JPanel();
			panFactureClient.addMouseListener(new PanelButtonMouseAdapter(panFactureClient) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(panFactureClient);
					panelFactureClient.setVisible(true);
				}
			});
			panFactureClient.setBackground(new Color(0, 139, 139));
			panFactureClient.setBounds(174, 11, 201, 29);
			add(panFactureClient);
			panFactureClient.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("FACTURE CLIENT");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel.setBounds(47, 2, 144, 24);
			panFactureClient.add(lblNewLabel);
			
			JLabel lblIconajouter = new JLabel("");
			lblIconajouter.setIcon(new ImageIcon(PanelFactureVente.class.getResource("/image/receipt.png")));
			lblIconajouter.setBounds(10, 2, 39, 24);
			panFactureClient.add(lblIconajouter);
			panelFactureClient.setVisible(true);
		
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(240,240,240,240));
			panel.setBounds(6, 39, 984, 521);
			add(panel);
			panel.setLayout(null);
			
			panel.add(panelFactureClient);
			panelFactureClient.setVisible(true);
			
			panel.add(panelFactureAvoir);
			
			JPanel panFactureAvoir = new JPanel();
			panFactureAvoir.setBounds(466, 11, 201, 29);
			add(panFactureAvoir);
			panFactureAvoir.addMouseListener(new PanelButtonMouseAdapter(panFactureAvoir) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(panFactureAvoir);
					panelFactureAvoir.setVisible(true);
				}
			});
			panFactureAvoir.setBackground(new Color(0, 139, 139));
			panFactureAvoir.setLayout(null);
			
			JLabel lblNewLabel1 = new JLabel("FACTURE AVOIR");
			lblNewLabel1.setForeground(new Color(255, 255, 255));
			lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel1.setFont(new Font("Dialog", Font.BOLD, 14));
			lblNewLabel1.setBounds(55, 2, 136, 24);
			panFactureAvoir.add(lblNewLabel1);
			
			JLabel lblIconmodifier = new JLabel("");
			lblIconmodifier.setIcon(new ImageIcon(PanelFactureVente.class.getResource("/image/sad.png")));
			lblIconmodifier.setBounds(10, 2, 39, 27);
			panFactureAvoir.add(lblIconmodifier);	
			panelFactureAvoir.setVisible(true);
			
			
			/*JPanel panmodifier = new JPanel();
			panmodifier.setBounds(341, 15, 163, 46);
			add(panmodifier);*/
			
			
			/*panmodifier.setBackground(new Color(0, 139, 139));
			panmodifier.setLayout(null);*/
	}
		
		public void menuClicked(JPanel panell) {
			panelFactureClient.setVisible(false);
			panelFactureAvoir.setVisible(false);
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
