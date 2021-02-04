package Package;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public feedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String listQ1 = request.getParameter("listQ1");
		String listQ2 = request.getParameter("listQ2");
		String listQ3 = request.getParameter("listQ3");
		String listQ4 = request.getParameter("listQ4");
		String listQ5 = request.getParameter("listQ5");
		
		FeedbackBean fb = new FeedbackBean();
		fb.setQ1(listQ1);
		fb.setQ2(listQ2);
		fb.setQ3(listQ3);
		fb.setQ4(listQ4);
		fb.setQ5(listQ5);
		
		FeedIbackDAO dao = new FeedIbackDAO();
		try {
			int i = dao.feedback_insert(fb);
			if(i > 0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Finish.html");
				request.setAttribute("FeedbackBean",fb);
				rd.forward(request, response);
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
