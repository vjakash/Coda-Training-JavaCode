package day14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropDemo {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop=new Properties();
//		prop.put("Key1", "Value 1");
//		prop.put("Key2","Value 2");
		prop.load(new FileInputStream("abc.properties"));
		Enumeration e=prop.elements();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		System.out.println(prop.get("key1"));
	}
}
