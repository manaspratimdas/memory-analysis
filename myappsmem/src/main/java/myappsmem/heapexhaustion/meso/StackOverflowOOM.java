package myappsmem.heapexhaustion.meso;

public class StackOverflowOOM {

	public static void main(String[] args) {
		
		 try {
	            recursiveMethod(1);
	        } catch (StackOverflowError e) {
	            System.err.println("StackOverflowError occurred!");
	            e.printStackTrace();
	        }

	}
	
	public static void recursiveMethod(int num) {
        // Call the method recursively with a larger increment
        recursiveMethod(num + 1000);
    }

}
