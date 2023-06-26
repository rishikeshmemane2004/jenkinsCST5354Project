package day1Jun23;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class ReadingPRoerptiesFileUsingJava8FEatures {

	public static void main(String[] args) throws IOException {
		String fileName=System.getProperty("user.dir") + "/src/test/java/day1Jun23/config.properties";
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(fileName);
		prop.load(fis);
		prop.forEach((key, value) -> System.out.println(key + " :: " + value));

        // Get all keys
       prop.keySet().forEach(x -> System.out.println(x));
        
       Set<Object> ks =  prop.keySet();
       Iterator<Object> iter = ks.iterator();
       while(iter.hasNext())
       {
    	   Object k = iter.next();
    	   
    	   System.out.println(k + " : "  + prop.get(k));
       }
       
       
	}
}
