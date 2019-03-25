package Lv1.Lv1가운데글자가져오기;

/**
 * @author kim, eun soo - devegoist
 * @date 07/02/2019
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("asdfghjk"));
    }

    public static String solution(String s) {
        int length = s.length();

        if (length % 2 == 0) {
            return String.valueOf(s.charAt(length / 2 - 1)) + s.charAt(length / 2);
        } else {
            return String.valueOf(s.charAt(length / 2));
        }
    }
}
