package dnc;

import java.util.Arrays;

public class QuickSort {
    public void sort(int[] arr) {
        // 비었거나 길이가 1 이하라면 정렬할 필요가 없다.
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // quicksort 후 나눠진 index를 반환받는다.
            int pivot = partition(arr, low, high);

            // 해당 index를 기준으로 좌우에 대하여 다시
            // quicksort를 호출한다.
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    // Pivot을 정하고, pivot을 기준으로 좌우 배열의 원소들을 교환한 뒤
    // pivot이 최종적으로 위치하는 곳을 반환하는 메소드
    private int partition(int[] arr, int low, int high) {
        // 오른쪽 끝이 pivot
        int pivot = arr[high];
        // 작은 원소가 들어갈 위치를 지정하는 i
        int i = low - 1;
        // j == low 부터 j == high - 1 까지 반복 (pivot 제외 전부 대조)
        for (int j = low; j < high; j++) {
            // 현재 원소의 값이 pivot 보다 작은 경우
            if (arr[j] <= pivot) {
                i++;
                // 왼쪽끝으로 보낸다.
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 이 과정이 끝나면 arr[i] 에는 pivot 보다 작은 원소가,
        // i + 1 ~ high - 1 의 모든 원소는 pivot 보다 큰 원소가 담겨있다.
        // i + 1과 pivot의 위치를 교환하면, i + 1 을 기준으로
        // 왼족은 pivot보다 작은 값이
        // 오른쪽은 pivot보다 큰 값이 위치한다.
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // 마지막으로 pivot의 위치를 반환한다.
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 1, 7, 4, 8, 6, 2, 5};
        new QuickSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
