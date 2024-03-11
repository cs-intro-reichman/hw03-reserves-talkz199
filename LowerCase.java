public class LowerCase {
  public static void main(String[] args) {
      int numWords = args.length;
      String str = "";

      for (int i = 0; i < numWords; i++) {
          str = str + "" + args[i];
      }
      System.out.println(lowerCase(str));
  }

  /**
   * Returns a string which is identical to the original string, 
   * except that all the upper-case letters are converted to lower-case letters.
   * Non-letter characters are left as is.
   */
  public static String lowerCase(String str) {
      int nletters = str.length();
      char[] word = new char[nletters]; // Create an array to store characters

      for (int i = 0; i < nletters; i++) {
          char currentChar = str.charAt(i);
          if (currentChar >= 'A' && currentChar <= 'Z') { // Check if the character is uppercase
              // Convert uppercase to lowercase by adding the ASCII difference
              word[i] = (char) (currentChar + ('a' - 'A'));
          } else {
              word[i] = currentChar; // Keep non-letter characters as they are/
        
          }
      }


      return new String(word); // Convert char array to string and return
  }
}
