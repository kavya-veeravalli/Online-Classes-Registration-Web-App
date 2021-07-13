import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String r=req.getParameter("registernumber");
		String e=req.getParameter("email");
		String s=req.getParameter("section");
		String i=req.getParameter("internetfacility");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			RequestDispatcher rd=req.getRequestDispatcher("finish.html");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/one","root","1230780vksl");
			String query="update finallist set email='"+e+"', section='"+s+"', internetfacility='"+i+"' where registernumber='"+r+"'";
			Statement stmt = con.createStatement();
			int j = stmt.executeUpdate(query);
			//out.println("query" + query);
			if(j>0) {
				rd.forward(req, res);
			}
	        }
	catch (Exception e2) {
	            System.out.println(e2);
	        }
	 
	        out.close();
	    }
	}