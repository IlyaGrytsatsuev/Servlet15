import java.io.*;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;

public class AdsServlet extends HttpServlet{
    private AdsList ads_list;

    public void init(ServletConfig config) {
        try {
            ads_list = new AdsList();
            ads_list.readFile();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {
            ads_list.readFile();
            HashMap<String, String> tmp = ads_list.GetAdsList();
            HttpSession session = request.getSession(true);
            request.setAttribute("session", session);

            request.setAttribute("data", tmp);
            RequestDispatcher rd = request.getRequestDispatcher("Ads.jsp");
            rd.forward(request, response);
        }

        catch(Exception e){
            e.printStackTrace();
        }

    }
}
