import java.io.*;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;

public class AccountManagerServlet extends HttpServlet{
    private UsersList users;

    public void init(ServletConfig config) {
        try {
            users = new UsersList();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
                users.readFile();
        	String name = request.getParameter("name");
        	String state = request.getParameter("state");
        	
		if(state.equals("delete")){
		   users.delete(name);
		}
		
		users.writeFile();

        }
        catch( Exception e){
            e.printStackTrace();
        }

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {
            users.readFile();
            HashMap<String, String> tmp = users.getUsers();
           
            request.setAttribute("data", tmp);
            RequestDispatcher rd = request.getRequestDispatcher("AccountManager.jsp");
            rd.forward(request, response);
        }

        catch(Exception e){
            e.printStackTrace();
        }

    }
}
