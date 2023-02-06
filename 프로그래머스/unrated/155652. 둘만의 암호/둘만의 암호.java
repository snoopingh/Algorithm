class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            char temp = c;
            int idx = 0;

            while (idx < index) {
                temp = temp == 'z' ? 'a' : (char) (temp + 1);

                if (!skip.contains(String.valueOf(temp))) {
                    idx++;
                }
            }

            answer.append(temp);
        }

        return answer.toString();
    }
}