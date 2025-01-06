package myappsmem.heapexhaustion;

import java.util.HashMap;
import java.util.Map;

public class MemoryLeak {
	
	private Map<Integer, String> leakMap = new HashMap<>();

	public static void main(String[] args) {
		MemoryLeak example = new MemoryLeak();
	        example.createLeak();

	}

	
	public void createLeak() {
        int counter = 0;
        try {
            while (true) {
                // Adding new entries to the map without removing old ones
            	for (int i=0;i<100000;i++) {
                leakMap.put(counter, "Value " + counter);
                }
            	 leakMap.put(counter, "Value " + counter);
                counter++;
            }
        } catch (OutOfMemoryError e) {
            System.err.println("OutOfMemoryError occurred: " + e.getMessage());
        }
    }
}
