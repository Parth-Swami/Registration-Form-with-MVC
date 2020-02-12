import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {
	static Connection con=null;
	
	protected static Connection getConnection() throws Exception {
		System.out.println("ssdfs");
		
		try{
	         Class.forName("com.mysql.jdbc.Driver");
	         con= DriverManager.getConnection("jdbc:mysql://localhost:3306/user?autoReconnect=true&useSSL=false","root","root");
	         System.out.println("sucessful connection");
		}
	
	catch(ClassNotFoundException e)
	          {
				System.out.println(e);
	          }
            return con;
}

}