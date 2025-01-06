package myappsmem.process;

import java.util.ArrayList;
import java.util.List;

public class MyAppMemAnalyzer {

	public static void main(String[] args) {
		
		
		List<long[]> memoryHog = new ArrayList<>();
	    try {
	        while (true) {
	            memoryHog.add(new long[1_000_000]);
	        }
	    } catch (OutOfMemoryError e) {
	        return;
	    }

	}

}
