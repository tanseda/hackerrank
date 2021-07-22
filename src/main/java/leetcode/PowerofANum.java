/**
 * Created by stan on 07/04/2021.
 */

package leetcode;

public class PowerofANum {
    public boolean isPowerOfFour(int n) {
        if(n == 0)
            return false;

        double temp = Math.log(n) / Math.log(4);

        System.out.println("return : " + temp);
        System.out.println("return : " + Math.floor(temp));
        return (temp == Math.floor(temp));
    }

    public boolean isPowerOfThree(int n) {
        if ( n == 0 )
            return false;

        double epsilon = 0.00000001;

        return (Math.log(n) / Math.log(3) + epsilon) % 1 <= 2 * epsilon;
    }

    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        PowerofANum powerofANum = new PowerofANum();

        boolean retVal = powerofANum.isPowerOfFour(-4);

        System.out.println("return : " + retVal);

        boolean retVal1 = powerofANum.isPowerOfThree(14348906);

        System.out.println("return : " + retVal1);
    }
}
