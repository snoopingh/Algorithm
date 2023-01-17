import java.util.LinkedList;
import java.util.Queue;

// 86971
// 다른사람의 풀이 봄
class Solution {
    int answer;
    int[][] arr;

    public int solution(int n, int[][] wires) {
        answer = n;
        arr = new int[n + 1][n + 1];

        for (int[] wire : wires) {
            arr[wire[0]][wire[1]] = 1;
            arr[wire[1]][wire[0]] = 1;
        }

        for (int[] wire : wires) {
            arr[wire[0]][wire[1]] = 0;
            arr[wire[0]][wire[1]] = 0;

            answer = Math.min(answer, bfs(n, wire[0]));

            arr[wire[0]][wire[1]] = 1;
            arr[wire[0]][wire[1]] = 1;
        }

        return answer;
    }

    private int bfs(int n, int start) {
        int[] visit = new int[n + 1];
        int count = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int point = queue.poll();
            visit[point] = 1;

            for (int i = 1; i <= n; i++) {
                if (visit[i] == 1) continue;
                if (arr[point][i] == 1) {
                    queue.offer(i);
                    count++;
                }
            }
        }

        return Math.abs(n - 2 * count);
    }
}