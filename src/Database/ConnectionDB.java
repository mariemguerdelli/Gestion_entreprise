package Database;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;


public class ConnectionDB {

	public static Connection ConnectDb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
  			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_entreprise","root","");
  			//JOptionPane.showMessageDialog(null,"Database Connected");
  			return conn;
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
			
		}
		}
	
	
}
	

