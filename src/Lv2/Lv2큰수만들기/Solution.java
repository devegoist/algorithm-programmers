package Lv2.Lv2큰수만들기;

/**
 * @author kim, eun soo - devegoist
 * @date 22/03/2019
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("1924", 0));
    }

    public static String solution(String number, int k) {
        int size = number.length() - k;

        return getValue(number, size);
    }

    private static String getValue(String number, int size) {
        int index = 0;
        String value;
        String maxValue = "0";

        while (index < number.length()) {
            value = number.substring(index, index + 1);

            if (size > 1) {
                if (size - 1 > number.substring(index + 1).length()) {
                    index++;
                    continue;
                }

                value += getValue(number.substring(index + 1), size - 1);
            } else {
                value = number.substring(index, index + 1);
            }

            maxValue = String.valueOf(Math.max(Integer.valueOf(maxValue), Integer.valueOf(value)));

            index++;
        }

        return maxValue;
    }
}


