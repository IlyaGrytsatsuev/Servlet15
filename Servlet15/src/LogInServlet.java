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

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        
        

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
            

        } else {
            request.getRequestDispatcher("LoggedOutPanel.html").include(request, response);
            out.print("Sorry, username or password is wrong !");
            request.getRequestDispatcher("LoginLink.html").include(request, response);

        }
        out.println("</html></body>");

    }

}
