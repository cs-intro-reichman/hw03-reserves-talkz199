public class UniqueChars {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java UniqueChars <string>");
            return;
        }

        String input = args[0];
        System.out.println("Original string: " + input);
        System.out.println("Unique characters: " + getUniqueCharacters(input));
    }

    public static String getUniqueCharacters(String input) {
        String result = ""; // Initialize an empty string to store unique characters

        // Iterate through each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            
            // Check if the character is a space or if it's not already in the result string
            if (currentChar == ' ' || result.indexOf(currentChar) == -1 || result.indexOf(currentChar) == i) {
                result += currentChar; // Append the character to the result string
            }
        }

        return result;
    }
}
