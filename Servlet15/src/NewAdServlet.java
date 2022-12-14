import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class NewAdServlet extends HttpServlet{

    private AdsList list;

    public void init(ServletConfig config) {
            try{
            list = new AdsList();
            list.readFile();
            }
            catch(Exception e){
            e.printStackTrace();
            }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            request.getRequestDispatcher("StyleLink.html").include(request, response);
            request.getRequestDispatcher("LoggedInPanel.html").include(request, response);
            String name = request.getParameter("name");
            String text = request.getParameter("text");
            list.AddNewAdv(name, text);
            list.writeFile();
            out.println("Advertisement has been added !");

            out.println("</html></body>");
        }
        catch( Exception e){
            e.printStackTrace();
        }

    }
}
