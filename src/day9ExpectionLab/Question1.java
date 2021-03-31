package day9ExpectionLab;

import java.io.FileInputStream;
import java.io.IOException;

public class Question1 {
	public static void main(String[] args) {
		
	}
	public void met() throws IOException {
		FileInputStream in = new FileInputStream("input.txt");
        System.out.println("This is not printed");
	}
}
