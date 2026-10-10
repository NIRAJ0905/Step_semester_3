public class WordPalindromeChecker {
    public static void checkPalindrome(String word) {
        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();
        
        System.out.println(word);
        System.out.println(reversed);
        
        if (word.equals(reversed)) {
            System.out.println("palindrome");
        } else {
            System.out.println("not a palindrome");
        }
    }
}