import  java.util.*;
import java.io.*;

public class AdsList {
    private HashMap<String, String> AdInfo = new HashMap<>();

    public AdsList(){

    }

    synchronized void AddNewAdv(String name, String text) throws Exception{
        Date currentDate = new Date();
        String header = name + "  -  " + currentDate.toString();
        AdInfo.put(header, text);
        

    }

    synchronized void writeFile() throws Exception{
        String path = "/home/ilya/Desktop/Servlet15Files/AdList";
        FileWriter fstream = new FileWriter(path);
        BufferedWriter out = new BufferedWriter(fstream);
        for(String key : AdInfo.keySet()){
        	out.write(key + ": " + AdInfo.get(key) + "\n");
        }
    out.close();
    }

    synchronized void readFile() throws Exception{

        String path = "/home/ilya/Desktop/Servlet15Files/AdList";
        File list = new File(path);
        Scanner sc = new Scanner(list);

        while (sc.hasNextLine()) {
            String[] tmp = sc.nextLine().split(": ");
            StringBuilder header = new StringBuilder();
            StringBuilder text = new StringBuilder();

            header.append(tmp[0].replaceAll(": ", ""));
            text.append(tmp[1]);
            AdInfo.put(header.toString(), text.toString());
        }
	sc.close();
    }

    public HashMap <String, String> GetAdsList(){
        return AdInfo;
    }
}
