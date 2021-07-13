import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class RegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String f=req.getParameter("firstname");
		String l=req.getParameter("lastname");
		String e=req.getParameter("email");
		String g=req.getParameter("gender");
		String r=req.getParameter("registernumber");
		String b=req.getParameter("branch");
		String y=req.getParameter("year");
		String s=req.getParameter("section");
		String i=req.getParameter("internetfacility");
		String p=req.getParameter("phonenumber");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/one", "root", "1230780vksl");
            RequestDispatcher rd=req.getRequestDispatcher("happy.html");
			PreparedStatement ps=((java.sql.Connection) con).prepareStatement("insert into finallist(firstname,lastname,email,gender,registernumber,branch,year,section,internetfacility,phonenumber) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,f);
			ps.setString(2,l);
			ps.setString(3,e);
			ps.setString(4,g);
			ps.setString(5,r);
			ps.setString(6,b);
			ps.setString(7,y);
			ps.setString(8,s);
			ps.setString(9,i);
			ps.setString(10,p);
			int k=ps.executeUpdate();
			if(k>0) {
				rd.forward(req,res);
			}
		}catch(Exception e2) {
			System.out.println(e2);
		}
		out.close();
	}
}