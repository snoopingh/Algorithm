import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    String[][] tickets;
    boolean[] visited;
    List<String> answer;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.visited = new boolean[tickets.length];
        this.answer = new ArrayList<>();
        dfs("ICN", "ICN", 0);
        Collections.sort(answer);
        return answer.get(0).split(",");
    }

    private void dfs(String start, String path, int count) {
        if (count == tickets.length) {
            answer.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            String[] ticket = tickets[i];

            if (!visited[i] && start.equals(ticket[0])) {
                visited[i] = true;
                dfs(ticket[1], path + "," + ticket[1], count + 1);
                visited[i] = false;
            }
        }
    }
}
