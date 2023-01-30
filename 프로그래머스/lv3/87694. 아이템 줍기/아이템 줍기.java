import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        characterX = characterX * 2;
        characterY = characterY * 2;
        itemX = itemX * 2;
        itemY = itemY * 2;

        boolean[][] map = new boolean[102][102];

        for (int[] data : rectangle) {
            for (int i = data[1] * 2; i <= data[3] * 2; i++) {
                for (int j = data[0] * 2; j <= data[2] * 2; j++) {
                    map[i][j] = true;
                }
            }
        }

        for (int[] data : rectangle) {
            for (int i = data[1] * 2 + 1; i < data[3] * 2; i++) {
                for (int j = data[0] * 2 + 1; j < data[2] * 2; j++) {
                    map[i][j] = false;
                }
            }
        }

        Stack<Character> stack = new Stack<>();
        stack.add(new Character(characterX, characterY));

        List<Integer> result = new ArrayList<>();
        int count = 0;

        while (true) {
            if (stack.isEmpty()) {
                result.add(count);
                break;
            }

            Character temp = stack.pop();
            int x = temp.x;
            int y = temp.y;

            if (x == itemX && y == itemY) {
                result.add(count);
            }

            map[y][x] = false;

            if (map[y + 1][x]) stack.add(new Character(x, y + 1));
            if (map[y][x + 1]) stack.add(new Character(x + 1, y));
            if (map[y - 1][x]) stack.add(new Character(x, y - 1));
            if (map[y][x - 1]) stack.add(new Character(x - 1, y));

            count++;
        }

        return Math.min(result.get(0) / 2, Math.abs(result.get(0) / 2 - result.get(1) / 2));
    }
}

class Character {
    int x;
    int y;

    public Character(int x, int y) {
        this.x = x;
        this.y = y;
    }
}