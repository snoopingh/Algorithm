// 87946
class Solution {
    int[][] dungeons;
    boolean[] visited;
    int answer = 0;

    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.visited = new boolean[dungeons.length];
        recursive(0, k);
        return answer;
    }

    private void recursive(int count, int k) {
        for (int i = 0; i < dungeons.length; i++) {
            int[] dungeon = dungeons[i];

            if (!visited[i] && k >= dungeon[0]) {
                visited[i] = true;
                recursive(count + 1, k - dungeon[1]);
                visited[i] = false;
            }
        }

        answer = Math.max(answer, count);
    }
}