package Lv2.Lv2큰수만들기;

/**
 * @author kim, eun soo - devegoist
 * @date 22/03/2019
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
    }

    public static String solution(String number, int k) {
        /*
            resultSize를 구한다.
            number을 하나씩 돌면서 index에 해당하는 숫자와 나머지 숫자들을 구분한다.
            나머지 숫자들을 돌면서 조합이 가장 큰 숫자를 찾는다.
            resultSize에 따라서 resultSize 만큼 재귀적으로 들어가며 반복한다.
            가장 큰 수를 찾는다.

            0 1 2 3
            1 9 2 4

            1924, 2
            1, 924, 1
            1, 9, 24, 0

            만들어야할 재귀
            -> String answer, String number와 int size를 내려받는다.
            -> answer + number들 중 answer + String 조합이 가장 큰 값을 size == 0이면 리턴한다.
            -> 0이 아니면 한번 더 재귀 들어감 (answer + number), number, size - 1;
         */

        int index = 0;
        int size = number.length() - k;
        String answer = "0";

        while (index < number.length()) {
            String result = getValue(number.substring(index, +index + 1), number.substring(index + 1), size);

            answer = String.valueOf(Math.max(Integer.valueOf(answer), Integer.valueOf(result)));
        }



        return answer;
    }

    public static String getValue(String answer, String number, int size) {
        String result = answer;

        if (size == 0) {
            return result;
        }

        int index = 0;

        while (index < number.length()) {
        }



        return "";
    }

}


