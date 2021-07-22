package leetcode;

/**
 * Created by stan on 09/04/2021.
 */
public class Stringmethods {


    public int strStr(String haystack, String needle) {
        // haystack = "hello", needle = "ll" -> 2

        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length()) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                j++;
            }

            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }

    public int myAtoi(String s) {

        //   -4193 with words

        String trimmedAndLowerCase = s
                .trim()
                .toLowerCase();

        if(trimmedAndLowerCase.length() == 0)
            return 0;

        StringBuilder builder = new StringBuilder();

        int i = 0;
        if(trimmedAndLowerCase.charAt(0) == '+' || trimmedAndLowerCase.charAt(0) == '-'){
            builder.append(trimmedAndLowerCase.charAt(0));
            i = 1;
        }

        while (i < trimmedAndLowerCase.length() && trimmedAndLowerCase.charAt(i) >= '0' && trimmedAndLowerCase.charAt(i)  <= '9') {
            builder.append(trimmedAndLowerCase.charAt(i++));
        }

        return (toInteger(builder));
    }

    public int toInteger(StringBuilder builder ) {
        String val = builder.toString();

        if(val.length() == 0)
            return 0;

        if(val.length() == 1 && (val.charAt(0) == '+' || val.charAt(0) == '-')) {
            return 0;
        }

        try {
            return Integer.parseInt(val);
        } catch (Exception ex) {
            if ( Double.parseDouble(val) > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else {
                return Integer.MIN_VALUE;
            }
        }
    }
}
