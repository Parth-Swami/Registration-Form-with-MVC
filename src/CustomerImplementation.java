import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerImplementation {
	static Connection con;
	static PreparedStatement ps;
	
	public customer getCustomer()
	{
		customer c = new customer();
		return null;
	}
   public int insertCustomer(customer c)
   {
	   System.out.println("dwfefegrbggsy");
	   int status=0;
	   System.out.println(status);
	  try
	   {
		  System.out.println("hello");
		con=DatabaseConnection.getConnection();
		String sql="INSERT INTO register (name, address, phone, salary, net, total) VALUES (?,?,?,?,?,?);";
		ps=con.prepareStatement(sql);
		ps.setString(1,c.getName());
		ps.setString(2, c.getAddress());
		ps.setLong(3, c.getPhone());
		ps.setInt(4, c.getSalary());
		ps.setInt(5, c.getNet());
		ps.setInt(6, c.getTotal());
		status=ps.executeUpdate();
		con.close();
		System.out.print("csdccz");
	   }
	  catch(Exception e) {
   }
	  return status;
}
}