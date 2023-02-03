class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            int len = command[1] - command[0] + 1;

            int[] arr = new int[len];
            System.arraycopy(array, command[0] - 1, arr, 0, len);

            quickSort(arr, 0, len - 1);
            answer[i] = arr[command[2] - 1];
        }

        return answer;
    }

    private void quickSort(int[] arr, int start, int end) {
        int pivotIndex = partition(arr, start, end);

        if (start < pivotIndex - 1) {
            quickSort(arr, start, pivotIndex - 1);
        }

        if (pivotIndex < end) {
            quickSort(arr, pivotIndex, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];

        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;

            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        return start;
    }

    private void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}