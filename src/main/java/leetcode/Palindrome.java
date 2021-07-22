package leetcode;

/**
 * Created by stan on 07/04/2021.
 * https://leetcode.com/problems/palindrome-number/
 */
public class Palindrome {
    public static void main(String[] args) {
        String test = "    Hello   ";
        System.out.println(test.trim());
        isPalindrome(121);

        System.out.println(Integer.toString(Integer.MIN_VALUE,10));
        System.out.println(Integer.toString(Integer.MAX_VALUE,10));
    }

    public static boolean isPalindrome(int x) {
        String number = Integer.toString(x, 10);

        int length = number.length();
        for(int i = 0; i < length / 2; i++) {
            if(number.charAt(i) != number.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;

    }

    public static boolean isPalindrome(String s) {

        //s = "A man, a plan, a canal: Panama"

        //s = "race a car"
        //'az'
        String lower = s.toLowerCase();
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < lower.length(); i++){
            if(('a' <= lower.charAt(i) && lower.charAt(i) <= 'z')
                    || ('0' <= lower.charAt(i) && lower.charAt(i) <= '9')){
                builder.append(lower.charAt(i));
            }
        }

        String palindromeCandidate = builder.toString();

        int size = palindromeCandidate.length();

        for ( int i = 0; i < size / 2; i++) {
            if (palindromeCandidate.charAt(i) != palindromeCandidate.charAt(size - 1 -i)) {
                return false;
            }
        }
        return true;
    }
}
