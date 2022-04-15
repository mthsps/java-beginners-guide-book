package chapter05;

import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

public class Bubble {
	
	public static void main(String args[]) {
		
		Random rand = new Random();
	    int upperbound = 10;
	    int random = rand.nextInt(upperbound);
		
		int[] array = new int[random];
		
		for(int i=0; i < array.length; i++)
			array[i] = (int)Math.floor(Math.random()*(100-(-100)+1)+(-100));
		
		System.out.println("Original array: " + Arrays.toString(array));
		
		int size = array.length;
		int a, b, t;
			
		for(a=1; a < size; a++)
			for(b=size-1; b >= a; b--) {
				if(array[b-1] > array[b]) {
					t = array[b-1];
					array[b-1] = array[b];
					array[b] = t;
				}
				
			}
		
		System.out.println("Sorted array: " + Arrays.toString(array));
		
		
	}


}
