package myappsmem.optimization;

public class YoungGenerationTest {

	public static void main(String[] args) {
		System.out.println("Starting Young Generation Test...");

        // Allocate a large number of objects
        for (int i = 0; i < 100000; i++) {
            byte[] array = new byte[1024]; // 1 KB
        }

        System.out.println("Completed Young Generation Test.");

	}

}
