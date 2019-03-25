package Lv2.Lv2조이스틱;

import static Lv2.Lv2조이스틱.Solution.Direction.LEFT;
import static Lv2.Lv2조이스틱.Solution.Direction.RIGHT;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("BBAAAAAAAAABB"));
    }

    enum Direction{
        RIGHT(1),
        LEFT(-1);

        private int value;

        Direction(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private final static char A = 'A';
    private final static char Z = 'Z';

    static class Data {
        char[] name;
        int index;
        int count;

        Data(char[] name) {
            this.name = name;
        }

        void move(Direction direction) {
            this.index += direction.getValue();
            this.count += 1;

            if (this.index < 0) {
                this.index = name.length - 1;
            }

            if (this.index >= name.length) {
                this.index = 0;
            }
        }

        void findAlphabetCount() {
            char c = this.name[this.index];

            this.count += Math.min(Math.abs(A - c), Math.abs(Z - c) + 1);
            this.name[this.index] = 'A';
        }
    }

    public static int solution(String name) {
        Data data = new Data(name.toCharArray());
        computeData(data);

        return data.count;
    }

    private static Data computeData(Data data) {
        if (isFinish(data.name)) {
            return data;
        }

        data.findAlphabetCount();

        int rightNumberOfConsecutiveKey = findConsecutiveKeyCount(RIGHT, data);
        int leftNumberOfConsecutiveKey = findConsecutiveKeyCount(LEFT, data);

        int rightNextNumberOfFindKey = findNextKeyCount(RIGHT, data);
        int leftNextNumberOfFindKey = findNextKeyCount(LEFT, data);

        if (leftNumberOfConsecutiveKey == 0 && rightNumberOfConsecutiveKey == 0) {
            if (leftNextNumberOfFindKey == 0 && rightNextNumberOfFindKey == 0) {
                return data;
            } else if (leftNextNumberOfFindKey < rightNextNumberOfFindKey) {
                data.move(LEFT);
            } else {
                data.move(RIGHT);
            }
        } else if (leftNumberOfConsecutiveKey == 0) {
            data.move(RIGHT);
        } else if (rightNumberOfConsecutiveKey == 0) {
            data.move(LEFT);
        } else if (leftNumberOfConsecutiveKey < rightNumberOfConsecutiveKey) {
            data.move(LEFT);
        } else {
            data.move(RIGHT);
        }

        return computeData(data);
    }

    private static int findConsecutiveKeyCount(Direction direction, Data data) {
        int count = 0;
        if (direction.equals(RIGHT)) {
            for (int i = data.index + 1; i < data.index + data.name.length; i++) {
                if (data.name[i % data.name.length] != 'A') {
                    count++;
                } else {
                    break;
                }
            }
        } else if (direction.equals(LEFT)) {
            for (int i = data.index + data.name.length - 1; i > data.index; i--) {
                if (data.name[i % data.name.length] != 'A') {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    private static int findNextKeyCount(Direction direction, Data data) {
        int count = 0;
        if (direction.equals(RIGHT)) {
            for (int i = data.index + 1; i < data.index + data.name.length; i++) {
                if (data.name[i % data.name.length] == 'A') {
                    count++;
                } else {
                    return count++;
                }

            }
        } else if (direction.equals(LEFT)) {
            for (int i = data.index + data.name.length; i > data.index; i--) {
                if (data.name[i % data.name.length] == 'A') {
                    count++;
                } else {
                    return count++;
                }
            }
        }

        return 0;
    }

    private static boolean isFinish(char[] name) {
        for (char c : name) {
            if (c != 'A') {
                return false;
            }
        }
        return true;
    }


}

/*
    1. 첫번째 A의 위치에서 오른쪽으로 갈지 왼쪽으로 갈지 정한다.
        1) 오른쪽으로, 왼쪽으로 각각 A가 아닌 (계산을 해야하는) 알파뱃이 연속되는 숫자를 구한다.
        2) 더 큰 쪽으로 이동한다.
    2. 각 위치마다 알파벳 A와의 차이를 구한다.
    3. 각 action 마다 카운팅한다.

 */


