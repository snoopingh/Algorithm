import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int citationsLength = citations.length;
        assert citationsLength >= 1 && citationsLength <= 1000;

        Arrays.sort(citations);

        for (int i = 0; i < citationsLength; i++) {
            int h = citationsLength - i;
            int citation = citations[i];
            assert citation >= 0 && citation <= 10000;

            if (citation >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
