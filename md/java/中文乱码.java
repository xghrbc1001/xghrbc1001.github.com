import java.io.*;
import java.util.regex.*;
public class Test{

     public static void main(String []args) throws Exception{
     	System.exit(0);
     	BufferedReader br = new BufferedReader(new FileReader("s.txt"));
     	Pattern reg = Pattern.compile("[\u00a1-\u00ff]");
     	Pattern reg2 = Pattern.compile("\u00b7");
     	String line;
     	while((line = br.readLine()) != null){
     		Matcher m = reg.matcher(line);
     		int count = 0;
     		while(m.find()) count++;
     		m = reg2.matcher(line);
     		int cnt = 0;
     		while(m.find()) cnt++;
     		if(count - cnt > 5){
     			System.out.println(line);
     		}
     	}
     }
}