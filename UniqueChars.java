public class UniqueChars {
    public static void main(String[] args) {
        String word = args[0];
        System.out.println(getUniqueCharacters(word));
    }

    public static String getUniqueCharacters(String word) {
        String result = ""; 

        // Iterate through each character in the input string
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            
            // Check if the character is a space or if it's not already in the result string
            if (currentChar == ' ' || result.indexOf(currentChar) == -1 || result.indexOf(currentChar) == i) {
                if (currentChar == ' ') {
                    result += ' ';
                    
                }
                else{
                    result += currentChar; // Append the character to the result string
                }
               
            }
        }

        return result;
    }
}
