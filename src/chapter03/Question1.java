package chapter03;

import java.io.IOException;

public class Question1 {
	
	public static void main(String args[]) throws IOException {
		
		char input;
		int count = 0;
		
		do {
			System.out.println("Please, insert a character. To terminate, insert a period: ");
			input = (char) System.in.read();
			
			if (input == 32) {
				count++;
			}
		} while (input != 46);
		
		System.out.println(count);
	}
	
}
