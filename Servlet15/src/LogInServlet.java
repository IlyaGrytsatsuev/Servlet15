import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogInServlet extends HttpServlet {

    private UsersList users;

    public void init(ServletConfig config) {
        try {
            users = new UsersList();
            users.readFile();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        
        if(name.equals("Admin") && password.equals("228358")){
        	request.getRequestDispatcher("AdminPanel.html").include(request, response);
        	out.print("Welcome, " + name);
            	HttpSession session = request.getSession(false);
            	if (session != null) {
                	session.invalidate();
            	}
            	session = request.getSession(true);
            	session.setAttribute("name", "Admin");
            	session.setMaxInactiveInterval(30*60);
            	response.sendRedirect("Ads");
        }

	else{
		if (users.CheckUser(name, password)) {
		    request.getRequestDispatcher("LoggedInPanel.html").include(request, response);
		    out.print("Welcome, " + name);
		    HttpSession session = request.getSession(false);
		    if (session != null) {
		        session.invalidate();
		    }
		    session = request.getSession(true);
		    session.setAttribute("name", name);
		    session.setMaxInactiveInterval(30*60);
		    response.sendRedirect("Ads");

		} else {
		    request.getRequestDispatcher("LoggedOutPanel.html").include(request, response);
		    out.print("Sorry, username or password is wrong !");
		    request.getRequestDispatcher("LoginLink.html").include(request, response);

		}
        }
        out.println("</html></body>");

    }

}
