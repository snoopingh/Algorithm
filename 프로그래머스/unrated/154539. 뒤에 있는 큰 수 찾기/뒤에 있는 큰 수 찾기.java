import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(0, numbers[0]));
        int[] answer = new int[numbers.length];

        for (int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty()) {
                if (stack.peek().getValue() < numbers[i]) {
                    Node node = stack.pop();
                    answer[node.getIndex()] = numbers[i];
                } else {
                    stack.push(new Node(i, numbers[i]));
                    break;
                }
            }
            stack.push(new Node(i, numbers[i]));
        }

        for (int i = 0; i < numbers.length; i++) {
            if (answer[i] == 0) {
                answer[i] = -1;
            }
        }

        return answer;
    }
}

class Node {
    private final int index;
    private final int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }
}