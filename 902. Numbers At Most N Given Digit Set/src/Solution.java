
//902. Numbers At Most N Given Digit Set

/*
    Expilanation:
    Given an array of digits, you can write numbers using each digits[i] as many times as we want.
    For example, if digits = ['1','3','5'], we may write numbers such as '13', '551', and '1351315'.
    Return the number of positive integers that can be generated that are less than or equal to a given integer n.
*/

/*
    Example 1:
    Input: digits = ["1","3","5","7"], n = 100
    Output: 20
    Explanation:
    The 20 numbers that can be written are:
    1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.

    Example 2:
    Input: digits = ["1","4","9"], n = 1000000000
    Output: 29523
    Explanation:
    We can write 3 one digit numbers, 9 two digit numbers, 27 three digit numbers,
    81 four digit numbers, 243 five digit numbers, 729 six digit numbers,
    2187 seven digit numbers, 6561 eight digit numbers, and 19683 nine digit numbers.
    In total, this is 29523 integers that can be written using the digits array.

    Example 3:
    Input: digits = ["7"], n = 8
    Output: 1

*/

import java.util.Arrays;

public class Solution {

    public static int atMostNGivenDigitSet(String[] digits, int n) {

        int result = 0;

        long num = digitsToNum(digits);




        return result;
    }

    public static int numOfDigits(int num) {
        return (int) (Math.floor(Math.log10(num)) + 1);
    }

    public static long digitsToNum(String[] digits) {
        long num = 0;
        for (int i = 0; i < digits.length; i++) {
            num += (long)Integer.parseInt(digits[i]) * (long)Math.pow(10, (digits.length - 1) - i);
        }
        return num;
    }

    public static void main(String[] args) {

        System.out.println(Math.pow(3,10));
        
    }


}


