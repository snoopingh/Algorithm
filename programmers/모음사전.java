// 84512
class Solution {
    public int solution(String word) {
        String vowels = "AEIOU";
        int[] arr = {781, 156, 31, 6, 1};
        int answer = word.length();

        for (int i = 0; i < word.length(); i++) {
            int index = vowels.indexOf(word.charAt(i));
            answer += arr[i] * index;
        }

        return answer;
    }
}