class Solution {
    int[][] computers;
    boolean[] visited;
    int answer;

    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.visited = new boolean[computers.length];
        answer = 0;

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i);
            }
        }

        return answer;
    }

    private void dfs(int index) {
        visited[index] = true;

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[index][i] == 1) {
                dfs(i);
            }
        }
    }
}
