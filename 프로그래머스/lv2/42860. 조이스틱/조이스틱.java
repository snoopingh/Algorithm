class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int temp = len - 1;

        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);

            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            // BBBBAAAAA, BBBBAAAB
            // temp = Math.min(temp, i + i + len - next);
            temp = Math.min(temp, i + len - next + Math.min(i, len - next));
        }

        return answer + temp;
    }
}