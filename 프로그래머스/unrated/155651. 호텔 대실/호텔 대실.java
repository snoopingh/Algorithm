class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] room = new int[60 * 24 + 10];

        for (String[] str : book_time) {
            room[getMinute(str[0])] += 1;
            room[getMinute(str[1]) + 10] += -1;
        }

        for (int i = 1; i < room.length; i++) {
            room[i] += room[i - 1];
            answer = Math.max(answer, room[i]);
        }

        return answer;
    }

    private int getMinute(String str) {
        String[] arr = str.split(":");
        return (Integer.parseInt(arr[0]) * 60) + Integer.parseInt(arr[1]);
    }
}