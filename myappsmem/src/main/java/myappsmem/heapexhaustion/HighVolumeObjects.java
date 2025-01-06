package myappsmem.heapexhaustion;

import java.util.ArrayList;
import java.util.List;

public class HighVolumeObjects {

	public static void main(String[] args) throws InterruptedException {
		List<Object> objectList = new ArrayList<>();
        try {
            while (true) {
                // Continuously create new objects and add them to the list
                objectList.add(new Object());
               // Thread.sleep(10);
            }
        } catch (OutOfMemoryError e) {
            System.err.println("OutOfMemoryError occurred: " + e.getMessage());
        }

	}

}
