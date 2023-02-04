import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return -1;
                } else if (o1 > o2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        for (int num : scoville) {
            priorityQueue.add(num);
        }

        int answer = 0;

        while (priorityQueue.size() >= 2) {
            int firstScovile = priorityQueue.poll();
            if (firstScovile >= K) {
                break;
            }

            int secondScovile = priorityQueue.poll();
            int newScovile = firstScovile + (secondScovile * 2);

            priorityQueue.add(newScovile);
            answer++;
        }
        
        return priorityQueue.peek() < K ? -1 : answer;
    }
}
