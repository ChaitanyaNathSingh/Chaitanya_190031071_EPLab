package Package;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet_1() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("stu_name");
		String email = request.getParameter("stu_email");
		String dept = request.getParameter("stu_dep");
		
		StudentBean sb = new StudentBean();
		
		sb.setName(name);
		sb.setEmail(email);
		sb.setDept(dept);
		
		StudentDAO dao = new StudentDAO();	
		
		try {
			int i = dao.student_insert(sb);
			if(i > 0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("view.jsp");
				request.setAttribute("RegisterBean",sb);
				rd.include(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("error.html");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
