package myappsmem.optimization;

import java.util.ArrayList;
import java.util.List;

public class MyAppMemAnalyzer {

	 public static void main(String[] args) {
		 
		 long startTime = System.currentTimeMillis(); // Capture start time
	        System.out.println("Starting Memory Intensive Application...");

	        // Allocate a large amount of memory
	        int[] largeArray = new int[100000000];

	        // Perform some operations
	        for (int i = 0; i < largeArray.length; i++) {
	            largeArray[i] = i;
	        }

	        System.out.println("Completed Memory Intensive Operations.");
	        
	        long endTime = System.currentTimeMillis(); // Capture end time
	        long duration = endTime - startTime; // Calculate duration

	        System.out.println("Time taken: " + duration + " milliseconds");	    }

}
