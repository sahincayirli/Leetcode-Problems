import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static int distributeCandies(int[] candies) {
        return Math.min(candies.length / 2, (int) IntStream.of(candies).distinct().count());
    }

    public static void main(String[] args) {

        var caseLength = 5;
        var candies = List.of(IntStream.of(1, 1, 2, 2, 3, 3).toArray(), IntStream.of(1, 1, 2, 3).toArray(),
                IntStream.of(1, 1).toArray(), IntStream.of(1, 11).toArray(), IntStream.of(2, 2).toArray());

        var result = List.of(3, 2, 1, 1, 1);

        for (int i = 0; i < caseLength; i++) {
            if (result.get(i) != distributeCandies(candies.get(i))) {
                System.out.println("FAIL");
                System.out.println("CASE : " + (i + 1));
                return;
            }
        }

        System.out.println("SUCCESS");
    }

}
