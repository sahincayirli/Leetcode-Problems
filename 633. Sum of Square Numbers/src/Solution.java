public class Solution {

    public static void main(String[] args) {

    }

    public static boolean judgeSquareSum(int c) {

        if (2147395600 < c)
            return false;

        for (int i = 0; i * i <= c  ; i++) {
            double b = Math.sqrt(c - i * i);
            if (b == (int) b)
                return true;
        }
        return false;
    }

}

/*
*
*
* 1^2 + 3^2 = 10
*
*
* */