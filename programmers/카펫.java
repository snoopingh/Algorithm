// 42842
class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int width = 0;
        int height = 0;

        for (int i = total; i > 0; i--) {
            if (total % i == 0) {
                width = i;
                height = total / i;
            }

            if (height < 3 || width < height) {
                continue;
            }

            if ((width - 2) * (height - 2) == yellow) {
                break;
            }
        }

        return new int[] {width, height};
    }
}