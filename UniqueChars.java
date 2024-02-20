/** String processing exercise 2. */
public class UniqueChars {
    public static void main(String[] args) {  
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string, 
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String str) {
        int nletters = str.length();
        char[] word = new char[nletters];

        for (int i = 0; i < nletters; i++) {
            word[i] =  (char)str.charAt(i) ;
     if (((char)str.charAt(i) == (char)str.charAt(i+1)) && ((char)str.charAt(i) != 32)) {
        word[i] =  127 ;
     }

    }
     return new String(word);
    }
}
