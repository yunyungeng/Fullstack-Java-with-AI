public class Demo {
    public static void main(String[] args) {
        // Primitive data types in Java
        int number = 10; // 32-bit signed integer. Standard choice for integer values.
        double pi = 3.14159; // 64-bit signed floating point
        boolean isTrue = true;
        char character = 'A'; // 16-bit unicode character. Stores a simple character file (letters, numbers)
        byte smallNumber = 127; // 8-bit signed integer
        short mediumNumber = 32767; // 16-bit signed integer -32768 to 32767
        float floatNumber = 1.14f; // 32-bit signed floating point

        // Reference data types in Java
        String text = "Hello, World"; // A sequence of characters. Strings are object.
        Object obj = new Object(); // A reference to an object
        int[] numbers = {1, 2, 3, 4, 5}; // An array of integers defined by []
        double[] decimalNumbers = {1.1, 1.2, 1.3, 1.4}; // An array of double
        String[] words = {"apple", "banana", "cherry"}; // An array of strings
        String[] emptyArray = new String[5]; // An empty array of strings with a length of 5
        
        System.out.println("Primitive Data Types: ");
    }
}