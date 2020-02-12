

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

//import com.mysql.jdbc.Connection;
@WebServlet("/CustomerImplementation")
public class add extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    public add() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try
		{
			Connection con=DatabaseConnection.getConnection();

			String sql = "select * from register";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();     
			PrintWriter out=response.getWriter();
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Id</th><th>Name</th><th>address</th><th>phone</th><th>Salary</th><th>net</th><th>total</th><tr>");  
            while (rs.next()) 
            {  
                int n = rs.getInt("id");  
                String nm = rs.getString("name"); 
                String add=rs.getString("address");
                long ph=rs.getLong("phone");
                int s = rs.getInt("salary");   
                int net = rs.getInt("net");  
                int tot = rs.getInt("total");  
                out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + add + "</td><td>" + ph + "</td><td>" + s + "</td><td>" + net + "</td><td>" + tot + "</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            
        }  
    }  

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerImplementation cd = new CustomerImplementation();
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String salary = request.getParameter("salary");
		String net = request.getParameter("net");
		String total = request.getParameter("total");
		String SubmitType=request.getParameter("submit");
		customer c = new customer();
		System.out.println("dfdf");
		if(SubmitType.equals("submit"))
		{
			c.setName(name);
			c.setAddress(address);
			c.setPhone(Long.parseLong(phone));
			c.setSalary(Integer.parseInt(salary));
			c.setNet(Integer.parseInt(net));
			c.setTotal(Integer.parseInt(total));
			cd.insertCustomer(c);
			System.out.println("xvxcv");
			
		}
		doGet(request, response);
		System.out.println("xvdvdvxcvcxvxcvxcvxcvxcvxcvxcvxc");
	}

}
