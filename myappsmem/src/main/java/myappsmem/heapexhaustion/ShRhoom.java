package myappsmem.heapexhaustion;

import java.util.ArrayList;
import java.util.List;

public class ShRhoom {

	
    static class LargeObject {
        private byte[] memory = new byte[1024 * 1024]; // 1 MB
    }

    static class Container {
        private List<LargeObject> objects = new ArrayList<>();
    }
    
    
	public static void main(String[] args) {
		List<Container> containers = new ArrayList<>();
        try {
            while (true) {
                Container container = new Container();
                for (int i = 0; i < 10; i++) {
                    container.objects.add(new LargeObject());
                }
                containers.add(container);
            }
        } catch (OutOfMemoryError e) {
            System.err.println("OutOfMemoryError occurred!");
            e.printStackTrace();
        }

	}

}
