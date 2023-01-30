import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int answer;
        int[][] move = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        int[][] visited = new int[maps.length][maps[0].length];
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0));
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentCount = visited[current.y][current.x];

            for (int i = 0; i < 4; i++) {
                Node next = new Node(current.x + move[i][0], current.y + move[i][1]);

                if (next.x < 0 || next.x == maps[0].length || next.y < 0 || next.y == maps.length) {
                    continue;
                }

                if (maps[next.y][next.x] == 0) {
                    continue;
                }

                visited[next.y][next.x] = currentCount + 1;
                maps[next.y][next.x] = 0;
                queue.add(next);
            }
        }

        answer = visited[maps.length - 1][maps[0].length - 1];
        if (answer == 0) {
            return -1;
        }

        return answer;
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
