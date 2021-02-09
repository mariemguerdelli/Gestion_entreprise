package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;

import Vue.PanelAchat;
import Vue.PanelEntreprise;
import Vue.PanelVente;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
public class AdminPanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private PanelEntreprise panelEntreprise;
	private PanelVente panelVente;
	private PanelAchat panelAchat;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AdminPanel() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
        		Authentification.class.getResource("/image/office (1).png")));
		setTitle("Admin Panel");
		setBackground(SystemColor.activeCaptionBorder);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelEntreprise = new PanelEntreprise();
		panelEntreprise.setBackground(SystemColor.activeCaptionBorder);
		panelEntreprise.setBounds(0, 0, 998, 573);
		panelVente = new PanelVente();
		panelVente.setBackground(SystemColor.activeCaptionBorder);
		panelVente.setBounds(0, 0, 998, 573);
		panelAchat = new PanelAchat(); 
		panelAchat.setBackground(SystemColor.activeCaptionBorder);
		panelAchat.setBounds(0, 0, 998, 573);
		
		JPanel paneMenu = new JPanel();
		paneMenu.setBackground(new Color(0, 128, 128));
		paneMenu.setBounds(2, 2, 191, 597);
		contentPane.add(paneMenu);
		paneMenu.setLayout(null);
		
		JLabel lbliconLogo = new JLabel("Admin Panel");
		lbliconLogo.setFont(new Font("Dialog", Font.BOLD, 16));
		lbliconLogo.setForeground(new Color(255, 255, 255));
		lbliconLogo.setLabelFor(this);
		lbliconLogo.setBounds(10, 5, 179, 85);
		lbliconLogo.setIcon(new ImageIcon(AdminPanel.class.getResource("/image/administrator (1).png")));
		paneMenu.add(lbliconLogo);
		
		JPanel panentreprise = new JPanel();
		panentreprise.addMouseListener(new PanelButtonMouseAdapter(panentreprise) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panentreprise);
				panelEntreprise.setVisible(true);
				
			}
			
		});
		panentreprise.setBackground(new Color(0, 139, 139));
		panentreprise.setBounds(0, 157, 190, 46);
		paneMenu.add(panentreprise);
		panentreprise.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTION ENTREPRISE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setBounds(58, 11, 131, 24);
		panentreprise.add(lblNewLabel);
		
		JLabel lblIconHome = new JLabel("");
		lblIconHome.setIcon(new ImageIcon(AdminPanel.class.getResource("/image/enterprise (1).png")));
		lblIconHome.setBounds(10, 2, 50, 44);
		panentreprise.add(lblIconHome);
		
		JPanel panVente = new JPanel();
		panVente.addMouseListener(new PanelButtonMouseAdapter(panVente) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panVente);
				panelVente.setVisible(true);
			}
		});
			
		panVente.setBackground(new Color(0, 139, 139));
		panVente.setBounds(0, 201, 190, 46);
		paneMenu.add(panVente);
		panVente.setLayout(null);

		
		JLabel lblGestionVente = new JLabel("GESTION VENTE");
		lblGestionVente.setBounds(54, 11, 111, 19);
		lblGestionVente.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionVente.setForeground(Color.WHITE);
		lblGestionVente.setFont(new Font("Dialog", Font.BOLD, 12));
		panVente.add(lblGestionVente);
		
		JLabel lblIconVente = new JLabel("");
		lblIconVente.setIcon(new ImageIcon(AdminPanel.class.getResource("/image/shopping-cart.png")));
		lblIconVente.setBounds(10, 0, 50, 44);
		panVente.add(lblIconVente);
		
		JPanel panAchat = new JPanel();
		panAchat.addMouseListener(new PanelButtonMouseAdapter(panAchat) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panAchat);
    			panelAchat.setVisible(true);
       			
			}
		});
		panAchat.setBackground(new Color(0, 139, 139));
		panAchat.setBounds(0, 246, 190, 46);
		paneMenu.add(panAchat);
		panAchat.setLayout(null);
		
		JLabel lblGestionAchat = new JLabel("GESTION ACHAT");
		lblGestionAchat.setBounds(49, 11, 119, 19);
		lblGestionAchat.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionAchat.setForeground(Color.WHITE);
		lblGestionAchat.setFont(new Font("Dialog", Font.BOLD, 12));
		panAchat.add(lblGestionAchat);
		
		JLabel lblIconAchat = new JLabel("");
		lblIconAchat.setIcon(new ImageIcon(AdminPanel.class.getResource("/image/commission.png")));
		lblIconAchat.setBounds(10, 0, 50, 44);
		panAchat.add(lblIconAchat);
		
		JLabel lblExit = new JLabel("X");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("Comic Sans MS", Font.BOLD,14));
		lblExit.setBounds(1170, 0, 20, 20);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//if(JOptionPane.showConfirmDialog(null, "","Confirmation",JOptionPane.YES_NO_OPTION)==0) {
					AdminPanel.this.dispose();
				//}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblExit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblExit.setForeground(Color.WHITE);
			}
		});
		contentPane.add(lblExit);
		
		JPanel panelMainContent = new JPanel();
		panelMainContent.setBounds(192, 25, 998, 573);
		contentPane.add(panelMainContent);
		panelMainContent.setLayout(null);
		
		
		panelMainContent.add(panelEntreprise);
		panelMainContent.add(panelVente);
		panelMainContent.add(panelAchat);
		panelEntreprise.setVisible(true);
		
		
	}
	
	public void menuClicked(JPanel panel) {
		panelEntreprise.setVisible(false);
		panelVente.setVisible(false);
		panelAchat.setVisible(false);
		panel.setVisible(true);
		
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
