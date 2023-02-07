import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int x, int y, int n) {
        int cnt = 0;
        Set<Integer> prev = new HashSet<>();
        prev.add(x);

        Set<Integer> next;

        while (!prev.isEmpty()) {
            if (prev.contains(y)) {
                return cnt;
            }

            next = new HashSet<>();

            for (int num : prev) {
                if (num + n <= y) next.add(num + n);
                if (num * 2 <= y) next.add(num * 2);
                if (num * 3 <= y) next.add(num * 3);
            }
            prev = next;
            cnt++;
        }
        
        return -1;
    }
}