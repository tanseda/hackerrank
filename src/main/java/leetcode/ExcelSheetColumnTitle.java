package leetcode;

import java.math.BigInteger;

/**
 * Created by stan on 07/04/2021.
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        //convertToTitle(28);
        //System.out.println(convertToTitle(28));

        trailingZeroes(30);
    }

    public static String convertToTitle(int columnNumber) {

        StringBuilder builder = new StringBuilder();

        int val = 0, val2 = 0;
        int col2 = columnNumber;
        while (columnNumber != 0) {
            System.out.println("columnNumber "+ columnNumber);
            val = --columnNumber / 26;
            val2 = col2 / 26;
            col2--;
            System.out.println("columnNumber "+ columnNumber + " val : " + val
                    + " col2 : "+ col2
                    + " val2 : "+ val2
                    + " char " + (char) ('A' + columnNumber % 26)
                    + " char 2 " + (char) ('A' + col2 % 26));
            builder.appendCodePoint('A' + columnNumber % 26);
            columnNumber = val;
            col2 = val2;
        }

        return builder.reverse().toString();
    }

    public static BigInteger factorial(long val) {
        if (val == 0) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(val).multiply(factorial(val - 1));
        }
    }

    public static int countTrailingZeroes (BigInteger val) {
        String bigNum = val.toString();
        int count = 0;
        for(int i = bigNum.length() - 1; i >= 0; i--){
            if(bigNum.charAt(i) != '0'){
                break;
            }
            count++;
        }

        return count;
    }

    public static int countTrailingZeroes (int n) {
        int ans =0;

        while(n > 0) {
            ans += (n/5);
            n /= 5;
        }

        return ans;
    }

    public static int trailingZeroes(int n) {

        // 5 25 50 75 100 125 150 175 200

//        (n / 5) + (n / 25)
//                40 + 8
        // 28
        //31
        for (int i = 1; i < 201; i++ ) {
            BigInteger val = factorial(i);
            System.out.printf("Factorial(%d) =  trailing %d trailing2 %d %n " , i, countTrailingZeroes(val), countTrailingZeroes(i));
        }

        return 1;
    }

    public int titleToNumber(String columnTitle) {
        return 1;
    }
}
