package ds.stack;

public class App {

    public static void main(String[] args) {

        System.out.println(reverseString("Hello"));
    }

    public static String reverseString(String str) {
        Stack charStack = new Stack(str.length());
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            charStack.push(str.charAt(i));
        }

        while (!charStack.isEmpty()) {
            result = result + charStack.peak();
            charStack.pop();
        }
        return result;
    }
}
