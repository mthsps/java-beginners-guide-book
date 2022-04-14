package chapter14;

public class LambdaArgumentDemo {
	static String  changeString(StringFunction sf, String s) {
		return sf.function(s);
	}
	
	static StringFunction reverse = (str) -> {
		String result = "";
		
		for (int i = str.length()-1; i >= 0; i--) {
			result += str.charAt(i);
		}
		
		return result;
		
	};
	
	static StringFunction reverseCase = (str) -> {
		String result = "";
		char ch;
		
		for (int i= 0; i< str.length(); i++) {
			ch = str.charAt(i);
			if (Character.isUpperCase(ch)) 
				result += Character.toLowerCase(ch);
			else 
				result += Character.toUpperCase(ch);
		}
		return result;
	};
	
	
	public static void main(String[] args) {
		
		String inputString = "Lambda Expressions Expand Java";
		String outputString;
		
		System.out.println("Here is input string: " + inputString);
		
		outputString = changeString(reverse, inputString);
		
		System.out.println("The string reversed: " + outputString);
	
		outputString = changeString((str) -> str.replace(' ', '-'), inputString);
		System.out.println("The string with spaces replaced: " + outputString);
		
		outputString = changeString(reverseCase, inputString);
		
		System.out.println("The string in reversed case: " + outputString);
	}
}
