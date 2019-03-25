package Lv1.Lv1체육복;

/**
 * @author kim, eun soo - devegoist
 * @date 04/02/2019
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{2, 3, 5}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        

        int[] wholeStudents = new int[n];   //a[]{0,1,2,3,4}

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -200;
                    reserve[j] = -100;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == -200) {
                    continue;
                }

                if (lost[i] + 1 == reserve[j] || lost[i] - 1 == reserve[j]) {
                    reserve[j] = -100;
                    break;
                }

                if (j == reserve.length - 1 && reserve[j] != -200) {
                    wholeStudents[i] = 1;
                }
            }
        }

        for (int wholeStudent : wholeStudents) {
            if (wholeStudent == 0) {
                answer ++;
            }
        }

        return answer;
    }
}
