class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i);

            for (int j = 0; j < index; j++) {

                do {
                    num++;
                    if (num == 123) {
                        num = 97;
                    }
                } while (skip.indexOf(num) > -1);
            }

            answer.append((char) num);
        }

        return answer.toString();
    }
}