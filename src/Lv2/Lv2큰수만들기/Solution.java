package Lv2.Lv2큰수만들기;

/**
 * @author kim, eun soo - devegoist
 * @date 22/03/2019
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("1924", 1));
    }

    public static String solution(String number, int k) {
        int size = number.length() - k;

        return getValue("", number, size);
    }

    private static String getValue(String preNumber, String number, int size) {
        int index = 0;
        String maxNumber = "0";

        while (index < number.length()) {
            String currentPreNum = preNumber + number.substring(index, index + 1);

            if (size == 1) {
                maxNumber = String.valueOf(Math.max(Integer.valueOf(maxNumber), Integer.valueOf(currentPreNum)));
            } else {
                maxNumber = String.valueOf(Math.max(Integer.valueOf(maxNumber), Integer.valueOf(getValue(currentPreNum, number.substring(index + 1), size - 1))));
            }
            index++;
        }

        return maxNumber;
    }
}


