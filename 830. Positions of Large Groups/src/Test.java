import java.util.*;

public class Test {

    public static List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        if (S == null || S.length() == 0) return result;
        StringBuilder sb = new StringBuilder(S + " ");
        int index = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) == sb.charAt(i - 1)){
                ++index;

            }
            else {
                if (index >= 3){
                    result.add(Arrays.asList(i - index,i - 1));
                }
                index = 1;
            }

        }
        System.out.println(result);
        return result;
    }


    public static void main(String[] args) {
        largeGroupPositions("aaa"); // [[3,5],[6,9],[12,14]]





    }

}
