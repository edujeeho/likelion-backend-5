package sort;

import java.util.Arrays;

public class SelectionSortRecursive {
    public static void main(String[] args) {
        int[] arr = {25, 12, 18, 24, 2, 21};

        new SelectionSortRecursive().sort(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr, int start) {
        // 모든 원소를 확인했다.
        if (!(start < arr.length)) return;
        // 제일 앞에 원소를 현재 제일 작다고 설정
        int minIndex = start;
        // start + 1부터 끝 원소까지 차근차근 비교한다.
        for (int i = start + 1; i < arr.length; i++) {
            // 제일 작은 숫자를 찾는다.
            if (arr[i] < arr[minIndex]) minIndex = i;
        }

        // 제일 앞의 원소와 제일 작은 원소를 교환한다.
        int temp = arr[start];
        arr[start] = arr[minIndex];
        arr[minIndex] = temp;

        // 남은 영역에 대해서 똑같은 작업을 진행한다.
        sort(arr, start + 1);
    }
}
