package Lv1.Lv1두정수사이의합;

/**
 * @author kim, eun soo - devegoist
 * @date 14/02/2019
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(3, 3));
    }

    public static long solution(int a, int b) {
        long sum = a + b;
        long count = Math.abs(a - b) + 1;

        return sum * count / 2;
    }
}
