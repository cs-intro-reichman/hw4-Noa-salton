/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */
public class ArrCharOps {
    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        System.out.println(str);  // Prints the string
        println(arr1);            // Prints an array of characters
        System.out.println(charAt(arr1,2));      
        System.out.println(indexOf(arr1,'l'));  
        System.out.println(indexOf(arr1,'l',3)); 
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(subArray(arr2, 2, 9));
        System.out.println(compareTo("abcd", "abcd"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abw", "abcd"));
        System.out.println(compareTo("Abcd", "a"));
        System.out.println(compareTo("apple", "banana"));
        System.out.println(compareTo("apple", "applepie"));
        System.out.println(compareTo("Zoo", "zoo"));
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2));
    }

    /** Prints the given array of characters, and moves the cursor to the next line.
     */
    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /** Returns the char value at the specified index. Assume that the array is non-empty.
     */
    public static char charAt(char[] arr, int index) {
        // Replace the following statement with your code
        return arr[index];
    }

    public static boolean equals(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false; 
            }
        }
        return true;
    }
    

    /** Returns the index within the given array of the first occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int indexOf(char[] arr, char ch) {
        int i=0;
        while (arr[i] != ch && i<arr.length){i++;}
        if (i== arr.length-1 && arr[-1] == ch){return -1;}
        return i;
    }

    /** Same as indexOf(char[], char), but starts the search in the given index.
     */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
        for (int i=fromIndex; i< arr.length; i++){if (arr[i]== ch){return i;}}
        return -1;
    }

    /** Returns the index within the given arr of the last occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int lastIndexOf(char[] arr, char ch) {
        for (int i=arr.length-1; i>=0; i--){if (arr[i]==ch){return i;}}
        return -1;
    }

    /* Returns an array which is the concatanation of the two given arrays.
    */
    public static char[] concat(char[] arr1, char[] arr2) {
        // Create a new array that can hold the combined length of both arrays
        char[] concat2 = new char[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            concat2[i] = arr1[i];
        }
        for (int j = 0; j < arr2.length; j++) {
            concat2[arr1.length + j] = arr2[j];
        }
    
        return concat2;
    }
    

    /** Returns a new array that can be described as a sub-array of this array.
     *  The sub-array begins at the specified beginIndex and extends to the character at index endIndex - 1.
     *  For example, if arr contains the characters "hamburger", then subArray(4, 8) returns an array of
     *  characters containing the characters "urge".
     */     
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        char[] sub = new char[endIndex - beginIndex];
        for (int i = 0; i < sub.length; i++) {
            sub[i] = arr[beginIndex + i];
        }
        
        return sub;
    }
    

    public static long hashCode(char[] arr) {
        if (arr.length == 0) {
            return 0; // Return 0 for empty array
        }
        
        long hash = 0; // Use long for larger values
        int n = arr.length;
        
        // Iterate over the array
        for (int i = 0; i < n; i++) {
            hash += (long) arr[i] * (long) Math.pow(7, n - 1 - i);
        }
        
        return hash;
    }
    

    /**
     * Compares the two strings lexicographically.
     * Assume that both strings are not empty.
     * 
     * Characters are compared one by one from left to right, using their numeric Unicode values,
        as follows:
     * 1. If two characters at the same position in both strings are different,
     *    the string with the smaller character is considered lexicographically smaller.
     * 2. If all characters in the shorter string match the corresponding characters
     *    in the longer string, the shorter string is considered lexicographically smaller.
     * 3. If both strings have the same characters and the same length, they are considered equal.
     * 
     * Examples:
     * - "apple" is less than "banana" because 'a' comes before 'b'.
     * - "abc" is less than "abcd" because it is shorter.
     * - "hello" is equal to "hello".
     * - "date" is greater than "dark" because 't' comes after 'k'.
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return -1 if str1 is lexicographically less than str2,
     *         zero if they are equal, and 1 if str1 is
     *         lexicographically greater than str2.
     *         return -2 if there is an error with the input.
     */
    public static int compareTo(String str1, String str2) {
        // Check for null input
        if (str1 == null || str2 == null) {
            return -2; // Return -2 for invalid input
        }
        
        // Compare characters one by one
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            
            if (c1 < c2) {
                return -1; // str1 is lexicographically smaller
            } else if (c1 > c2) {
                return 1; // str1 is lexicographically larger
            }
        }
    
        // If all characters match, compare by length
        if (str1.length() < str2.length()) {
            return -1; // str1 is shorter, so it's lexicographically smaller
        } else if (str1.length() > str2.length()) {
            return 1; // str1 is longer, so it's lexicographically larger
        }
    
        // If both strings are identical
        return 0; // They are equal
    }
    
}
