import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String u=req.getParameter("username");
		String p=req.getParameter("password");
		String correctPassword=null;
		int i;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			RequestDispatcher rd=req.getRequestDispatcher("register.html");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/one","root","1230780vksl");
			Statement sta=con.createStatement();
			sta.executeQuery("select password from signup where username='"+u+"'");
			ResultSet rs=sta.getResultSet();
			if(rs.next())
			{
				correctPassword=rs.getString(1);
			}
			sta.close();
			if(correctPassword.contentEquals(p))
			{
				i=1;
			}
			else {
				i=0;
			}
			if(i==1) {
				rd.forward(req, res);
			}
			else {
			out.println("account not found");
			}
		}catch(Exception e2) {
			out.print(e2);
		}
	}
}