package heap;

import java.util.Arrays;

public class HeapSort {
    public void sort(int[] arr){
        // 배열의 크기를 조사
        int size = arr.length;

        // 전체 배열을 힙의 형태로
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
        }

        // 정렬 안된 마지막 노드랑 루트 노드를 교환해가며
        // 남은 원소들을 힙의 형태로 유지
        for (int i = size - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    // 본래 heap의 siftDown 연산과 동일한데, 그 범위를 한정시켜 동작시킨다.
    // heap에서 졍렬되지 않은 부분만 heap으로 변환해야 하기 때문에
    // size를 전달해서 그 범위를 한정시킨다.
    private void heapify(int[] array, int size, int index) {
        while (index < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            // 최대 원소의 위치 저장용
            int maxIndex = index;
            // 왼쪽 자식이 존재하며 && 왼쪽 자식의 값이 현재 최대 원소 (루트) 보다 큰 경우
            if (leftChild < size && array[leftChild] > array[maxIndex]) {
                // 둘을 교환할 준비
                maxIndex = leftChild;
            }
            // 오른쪽도 동일, 이때 왼쪽이 더 컷으면 maxIndex가 갱신되었을 것이고,
            // 아니라면 그대로 루트 였을것이다. 그래서 한번만 비교해도 둘중 더 큰것과 비교가 된다.
            if (rightChild < size && array[rightChild] > array[maxIndex]) {
                maxIndex = rightChild;
            }

            // 양쪽 자식과 비교했는데
            // 최댓값의 위치가 갱신되지 않은 경우
            // 힙의 조건에 부합한다.
            if (maxIndex == index) break;
            int temp = array[index];
            array[index] = array[maxIndex];
            array[maxIndex] = temp;

            index = maxIndex;
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 4, 7, 1, 2, 6, 3};
        new HeapSort().sort(array);
        System.out.println(Arrays.toString(array));
    }
}
