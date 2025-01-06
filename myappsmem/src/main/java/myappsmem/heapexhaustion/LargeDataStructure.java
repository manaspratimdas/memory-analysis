package myappsmem.heapexhaustion;

import java.util.ArrayList;
import java.util.List;

public class LargeDataStructure {

	public static void main(String[] args) {
		
		List<int[]> largeDataStructure = new ArrayList<>();
        try {
            while (true) {
                // Allocate large arrays and add them to the list
                largeDataStructure.add(new int[1_000_000]);
            }
        } catch (OutOfMemoryError e) {
            System.err.println("OutOfMemoryError occurred: " + e.getMessage());
        }

	}

}
