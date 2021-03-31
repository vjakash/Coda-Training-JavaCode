package day14;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleLanguageDemo {
	public static void main(String[] args) {
		Locale locale=Locale.getDefault();
		System.out.println(locale);
		
		Locale.setDefault(new Locale("ta"));
		
		locale=Locale.getDefault();
		
		System.out.println(locale);
		
		ResourceBundle rb=ResourceBundle.getBundle("day14.Dictionary",locale);
//		ResourceBundle rb=ResourceBundle.getBundle("dictionary",locale);
		System.out.println(rb.getObject("hello"));
		
		rb=ResourceBundle.getBundle("day14.Dictionary",new Locale("te"));
//		rb=ResourceBundle.getBundle("dictionary",new Locale("te"));
		System.out.println(rb.getString("hello"));
	}
}
