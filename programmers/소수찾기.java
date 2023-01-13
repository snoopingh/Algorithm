import java.util.HashSet;
import java.util.Set;

// 42839
class Solution {
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        recursion("", numbers);

        int answer = 0;

        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    private void recursion(String str, String numbers) {
        if (!str.equals("")) {
            set.add(Integer.parseInt(str));
        }

        for (int i = 0; i < numbers.length(); i++) {
            recursion(str + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i +1));
        }
    }

    private boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}