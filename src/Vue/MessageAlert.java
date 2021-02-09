package Vue;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.EtchedBorder;

import Database.ConnectionDB;
import Database.Requetes_SQL;

public class MessageAlert extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	/**
	 * Create the dialog.
	 */
	public MessageAlert() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				MessageAlert.class.getResource("/image/lib.png")));
		setAlwaysOnTop(true);
		setTitle("Stock epuisee");
		this.setSize(588, 201);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					close();
				}
			});
			okButton.setIcon(new ImageIcon(MessageAlert.class
					.getResource("/image/ok.png")));
			okButton.setBounds(228, 93, 82, 25);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}

	

		JLabel lblNewLabel = new JLabel(
				"Vous devez ajouter des produits : STOCK EPUISEE");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(66, 28, 496, 34);
		contentPanel.add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MessageAlert.class
				.getResource("/image/alert.png")));
		label.setBounds(10, 11, 46, 51);
		contentPanel.add(label);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MessageAlert.class
				.getResource("/image/bg-body.jpg")));
		lblNewLabel_1.setBounds(0, 0, 572, 162);
		contentPanel.add(lblNewLabel_1);
	}
	
	
	
	public void close() {
		this.setVisible(false);
	}
}
