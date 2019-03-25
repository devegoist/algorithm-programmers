package Lv1.Lv1문자열내마음대로정렬하기;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author kim, eun soo - devegoist
 * @date 10/02/2019
 */
public class Solution {
    public static void main(String[] args) {
        solution(new String[]{"aaa", "aac", "aab"}, 1);
    }

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, Comparator.comparing(String::toString, (stringA, stringB) -> {
            char a = stringA.charAt(n);
            char b = stringB.charAt(n);

            if (a > b)
                return 1;
            else if (a < b)
                return -1;
            return stringA.compareTo(stringB);
        }));

        return strings;
    }
}
