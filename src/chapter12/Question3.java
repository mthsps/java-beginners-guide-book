package chapter12;

public class Question3 {
	
	enum Tools {
		SCREWDRIVER, WRENCH, HAMMER, PLIERS
		}
	
	
	public static void main(String[] args) {
		
		for (Tools tool : Tools.values()) {
			
			System.out.println(tool + " tool and its ordinal value " + tool.ordinal() + " in enum Tools");
			
		}
	}

}
