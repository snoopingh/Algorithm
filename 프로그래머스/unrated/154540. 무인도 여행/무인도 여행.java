import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    String[] maps;
    boolean[][] visit;
    List<Integer> answer = new ArrayList<>();

    public int[] solution(String[] maps) {
        this.maps = maps;
        this.visit = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'X') {
                    visit[i][j] = true;
                }
            }
        }

        for (int i = 0; i < maps.length; i++) {
            int sum = 0;
            for (int j = 0; j < maps[i].length(); j++) {
                sum = dfs(i, j);

                if (sum > 0) {
                    answer.add(sum);
                }
            }
        }

        Collections.sort(answer);
        return answer.size() == 0 ? new int[] { -1 } : answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dfs(int i, int j) {
        if (i < 0 || j < 0 || i == maps.length || j == maps[i].length() || visit[i][j]) {
            return 0;
        }
        visit[i][j] = true;
        return maps[i].charAt(j) - '0' + dfs(i + 1, j) + dfs(i - 1, j) + dfs(i, j + 1) + dfs(i, j - 1);
    }
}