class Solution {
    int answer;
    String target;
    String[] words;
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        int length = words.length;
        this.answer = length + 1;
        this.target = target;
        this.words = words;
        this.visited = new boolean[length];

        for (int i = 0; i < length; i++) {
            if (compare(begin, words[i]) <= 1) {
                visited[i] = true;
                dfs(i, 1);
            }
        }

        return answer == length + 1 ? 0 : answer;
    }

    private void dfs(int cur, int sum) {
        if (target.equals(words[cur])) {
            answer = Math.min(sum, answer);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && compare(words[cur], words[i]) == 1) {
                visited[i] = true;
                dfs(i, sum + 1);
                visited[i] = false;
            }
        }
    }

    private int compare(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
        }
        return count;
    }
}
