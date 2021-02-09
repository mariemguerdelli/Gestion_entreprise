package Vue;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import Vue.AdminPanel;

 



public class Authentification extends JFrame implements  ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField txtPassword;
    private JTextField txtLogin;
    private JPanel panel;
    private JLabel lbladmin;
    private JLabel lblImg;
    private JButton btnLogin = new JButton("Valider");
    private JButton btnQuitter = new JButton("Quitter");
  
   


   public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	Authentification frame = new Authentification();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
		
	
 
    public Authentification() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(
        		Authentification.class.getResource("/image/office (1).png")));
        setTitle("Authentification");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setForeground(Color.BLACK);
        contentPane.setBackground(new Color(0, 128, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

 

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setForeground(new Color(255, 255, 255));
        lblLogin.setBounds(102, 157, 97, 23);
        contentPane.add(lblLogin);
        lblLogin.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

 

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setBounds(102, 206, 97, 20);
        contentPane.add(lblPassword);
        lblPassword.setFont(new Font("Trebuchet MS", Font.BOLD, 20));

 

        txtLogin = new JTextField();
        txtLogin.setBounds(233, 159, 163, 23);
        contentPane.add(txtLogin);
        txtLogin.setColumns(10);

       

        txtPassword = new JPasswordField();
        txtPassword.setBounds(233, 207, 163, 23);
        contentPane.add(txtPassword);
        txtPassword.setColumns(10);

 
        
        btnLogin.setBounds(102, 260, 116, 23);
        btnLogin.addActionListener(this);
        contentPane.add(btnLogin);
        btnLogin.setIcon(new ImageIcon(Authentification.class
                .getResource("/image/ok.png")));
        


        panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 105, 899, 2);
		contentPane.add(panel);
 

		lbladmin = new JLabel("ADMIN AUTHENTIFICATION");
		lbladmin.setForeground(new Color(255, 255, 255));
		lbladmin.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbladmin.setBounds(59, 43, 368, 51);
        contentPane.add(lbladmin);

        lblImg = new JLabel("");
        lblImg.setIcon(new ImageIcon(Authentification.class
                .getResource("/image/gestion-des-contrats-de-service-apres-vente.png")));
        lblImg.setForeground(new Color(0, 128, 0));
        lblImg.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblImg.setBounds(130, 314, 233, 121);
        contentPane.add(lblImg);
               
       
        btnQuitter.setBounds(247, 260, 116, 23);
        btnQuitter.addActionListener(this);
        contentPane.add(btnQuitter);
        btnQuitter.setIcon(new ImageIcon(Authentification.class
                .getResource("/image/no.png")));
 
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBackground(new Color(0, 139, 139));
		lblNewLabel.setBounds(0, 0, 899, 569);
		contentPane.add(lblNewLabel);
	
			
 
    }
	public void close() {
		WindowEvent theEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(theEvent);
	}
    


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()== btnLogin) {
       		String lblUsername = txtLogin.getText();
       		String lblPassword = txtPassword.getText();
       		
       		if(lblPassword.contains("admin") && lblUsername.contains("admin")) {
       			JOptionPane.showMessageDialog(contentPane,"Bienvenue: ADMIN");
       			close();
    			JFrame home = new AdminPanel();
    			home.setVisible(true);
       			
       		}
       			
       		else {
       			JOptionPane.showMessageDialog(contentPane, "Identifiants Invalides","Erreur Login",JOptionPane.ERROR_MESSAGE);
       			txtLogin.setText(null);
       			txtPassword.setText(null);
       		}
    	}
		if(e.getSource()== btnQuitter) {
			dispose();
			}
		
		
	}
		
		
	}

