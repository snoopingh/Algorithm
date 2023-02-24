class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            int sum = 0;

            for (char c : targets[i].toCharArray()) {
                int min = -1;

                for (String s : keymap) {
                    int index = s.indexOf(c);
                    if (min == -1) {
                        min = index;
                        continue;
                    }

                    if (index != -1) {
                        min = Math.min(min, index);
                    }
                }

                if (min == -1) {
                    sum = -1;
                    break;
                }

                sum += min + 1;
            }

            answer[i] = sum;
        }

        return answer;
    }
}