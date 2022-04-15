package chapter03;

import java.io.IOException;

public class Question10 {
	
	public static void main(String args[]) throws IOException {
		

		char output, input, ignore;
		
		 do {
			 
			System.out.println("Please, insert a character. To terminate, insert a period: ");
			input = (char) System.in.read();
			
			do {
				ignore = (char) System.in.read();
			} while (ignore != '\n');
				
			if (input > 96 & input < 123) {
				output = (char) (input - 32);
				System.out.println(output);
				
			} else if (input > 65 & input < 96) {
				output = (char) (input + 32);
				System.out.println(output);
			} else if (input != '.') {
				System.out.println("It's not a letter...");
			}
			
		} while (input != 46);
		
	} 

}
