package myappsmem.heapexhaustion.meso;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MetaspaceOOM {

	
	public static void main(String[] args) {
        List<ClassLoader> classLoaders = new ArrayList<>();
        try {
            while (true) {
                ClassLoader classLoader = new CustomClassLoader();
                classLoaders.add(classLoader);
                Class<?> clazz = classLoader.loadClass("MetaspaceOOM$Dummy");
                Method method = clazz.getDeclaredMethod("dummyMethod");
                method.invoke(clazz.newInstance());
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static class Dummy {
        public void dummyMethod() {
            // Dummy method to be invoked
        }
    }

    public static class CustomClassLoader extends ClassLoader {
        @Override
        public Class<?> findClass(String name) throws ClassNotFoundException {
            if (name.equals("MetaspaceOOM$Dummy")) {
                byte[] bytes = generateDummyClass();
                return defineClass(name, bytes, 0, bytes.length);
            }
            return super.findClass(name);
        }

        private byte[] generateDummyClass() {
            // Bytecode for a simple class with a dummy method
            return new byte[]{
                (byte) 0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE, // Magic number
                0x00, 0x00, 0x00, 0x34, // Version
                0x00, 0x0A, // Constant pool count
                // Constant pool entries...
                0x01, 0x00, 0x10, // UTF-8 string length
                'M', 'e', 't', 'a', 's', 'p', 'a', 'c', 'e', 'O', 'O', 'M', '$', 'D', 'u', 'm', 'm', 'y',
                // More bytecode...
            };
        }
    }
}
