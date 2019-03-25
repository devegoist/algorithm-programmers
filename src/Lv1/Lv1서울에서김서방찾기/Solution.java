package Lv1.Lv1서울에서김서방찾기;

import java.util.Arrays;

/**
 * @author kim, eun soo - devegoist
 * @date 14/02/2019
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Kim"}));
    }

    public static String solution(String[] seoul) {
        return String.format("김서방은 %d에 있다", Arrays.asList(seoul).indexOf("Kim"));
    }
}
