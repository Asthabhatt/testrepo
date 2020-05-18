package crossAsyst.Webdriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class ReadWriteProperty {
	Properties prop=null;
	public HashMap loadproperty(String filename) {
		
		FileInputStream fis;
		HashMap<String,String> credential=new HashMap<String,String>();
	try {
		String name="Resources\\"+filename+".properties";
	 fis = new FileInputStream(name);    
     prop=new Properties();  
    prop.load(fis);
    
    Set set=prop.entrySet(); 
    Iterator itr=set.iterator();  
    while(itr.hasNext()){  
    Map.Entry entry=(Map.Entry)itr.next();
    String key=(String) entry.getKey();
    String value=(String) entry.getValue();
    credential.put(key, value);
    }
	}
	
    catch(FileNotFoundException fe) {
        fe.printStackTrace();
    } catch (IOException e) {
		e.printStackTrace();
	}
	return credential;
	}
	
	public void WriteProp(String key, String value,String filename) throws IOException
	{
		OutputStream output = null;
		try {
			String name="Resources\\"+filename+".properties";
		 output = new FileOutputStream(name);
		prop = new Properties();
		prop.setProperty(key, value);
		prop.store(output,null);
		
	} catch (IOException io) {
        io.printStackTrace();
    }
		finally {
			output.close();
		}
	}
}
