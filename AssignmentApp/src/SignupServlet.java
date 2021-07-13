import java.io.IOException;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class SignupServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String u =req.getParameter("username");
		String p = req.getParameter("password");
		String c = req.getParameter("confirmpassword");
		
			try {
				if(c.equals(p))
				{
				Class.forName("com.mysql.jdbc.Driver");
				RequestDispatcher rd=req.getRequestDispatcher("login.html");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/one","root","1230780vksl");
				PreparedStatement ps=con.prepareStatement("insert into signup values(?,?)");
				ps.setString(1,u);
				ps.setString(2, p);
				
				int i=ps.executeUpdate();
				if(i>0) {
					rd.forward(req,res);
				}
				}
				else {
					out.println("wrong conformation of password...");
				}
			}catch(Exception e2) {
				out.println("Failed to signup...");
				out.println("retry");
			}
		out.close();
	}
}