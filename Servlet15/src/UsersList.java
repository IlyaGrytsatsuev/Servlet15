import  java.util.*;
import java.io.*;

public class UsersList {

    private HashMap <String, String> users ;

    public UsersList(){
        users = new HashMap<>();
    }

    public boolean CheckUser(String name, String password){

        for (String key : users.keySet()) {
            if(key.equals(name) && users.get(key).equals(password))
                return true ;
        }
        return false;
    }

    synchronized void delete(String key){
    	users.remove(key);
    }
    
    synchronized void readFile() throws Exception{
        String path = "/home/ilya/Desktop/Servlet15Files/Users";
        File list = new File(path);
        Scanner sc = new Scanner(list);

        while (sc.hasNextLine()){
            String [] tmp = sc.nextLine().split(" ");
            users.put(tmp[0], tmp[1]);
        }
    }
    
    synchronized void writeFile() throws Exception{
        String path = "/home/ilya/Desktop/Servlet15Files/Users";
        FileWriter fstream = new FileWriter(path);
        PrintWriter out = new PrintWriter(fstream);
        if(users.size() == 0){
            out.write("");
        }
        
        else {
            for (String key : users.keySet()) {
                out.write(key + " " + users.get(key) + "\n");
            }
        }
        fstream.close();
    }

    public HashMap<String, String> getUsers(){
    	return users;
    }

}
