package leetcode;

/**
 * Created by stan on 07/04/2021.
 */
public class CheckPowers {
    public static void main(String[] args) {
        CheckPowers instance = new CheckPowers();

        System.out.println((int)Math.pow(3,15));
        System.out.println((int)Math.pow(10,7));
        boolean retVal = instance.checkPowersOfThree(91);

        System.out.println("return : " + retVal);
    }

    public boolean checkPowersOfThree(int n) {

        int i = 1;
        while ((int)Math.pow(3,i) <= n ) {
            i++;
        }

        return checkPowersOfThree(n, 0, i);
    }

    boolean checkPowersOfThree(int sum, int index, int limit){
        if(sum == 0)
            return true;

        if(sum < 0)
            return false;

        for(int i = index; i < limit; i++){
            if(checkPowersOfThree(sum - (int)Math.pow(3,i), i+1, limit))
                return true;

        }

        return false;

    }
}
