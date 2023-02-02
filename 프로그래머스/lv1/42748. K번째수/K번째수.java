import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int len = command[1] - command[0] + 1;
            int[] copyArray = new int[len];
            System.arraycopy(array, command[0] - 1, copyArray, 0, len);
            Arrays.sort(copyArray);
            answer[i] = copyArray[command[2] - 1];
        }

        return answer;
    }
}