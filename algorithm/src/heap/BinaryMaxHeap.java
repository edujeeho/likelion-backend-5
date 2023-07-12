package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class BinaryMaxHeap {
    private int[] heap;
    private int size;

    public BinaryMaxHeap() {
        heap = new int[32];
        size = 0;
    }

    // 삽입 연산
    public void insert(int item) {
        heap[size] = item;
        siftUp(size);
        size++;
    }

    // index에 존재하는 원소를 자신의 부모와 비교해서
    // 힙의 조건을 만족시키도록 교환을 반복적으로 진행
    private void siftUp(int index) {
        // 루트 원소가 아닌 동안
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            // 힙의 조건을 만족하는 관계면 반복 중단
            if (heap[index] <= heap[parentIndex]) {
                break;
            }

            // 아니면 교환
            int temp = heap[index];
            heap[index] = heap[parentIndex];
            heap[parentIndex] = temp;
            index = parentIndex;
        }
    }

    public int remove() {
        // 루트 노드를 제거하고
        int root = heap[0];
        // 마지막 자식을 할당한다.
        heap[0] = heap[size - 1];
        size--;
        siftDown(0);

        return root;
    }

    private void siftDown(int index) {
        while (index < size) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            // 최대 원소의 위치 저장용
            int maxIndex = index;
            // 왼쪽 자식이 존재하며 && 왼쪽 자식의 값이 현재 최대 원소 (루트) 보다 큰 경우
            if (leftChild < size && heap[leftChild] > heap[maxIndex]) {
                // 둘을 교환할 준비
                maxIndex = leftChild;
            }
            // 오른쪽도 동일, 이때 왼쪽이 더 컷으면 maxIndex가 갱신되었을 것이고,
            // 아니라면 그대로 루트 였을것이다. 그래서 한번만 비교해도 둘중 더 큰것과 비교가 된다.
            if (rightChild < size && heap[rightChild] > heap[maxIndex]) {
                maxIndex = rightChild;
            }

            // 양쪽 자식과 비교했는데
            // 최댓값의 위치가 갱신되지 않은 경우
            // 힙의 조건에 부합한다.
            if (maxIndex == index) break;

            int temp = heap[index];
            heap[index] = heap[maxIndex];
            heap[maxIndex] = temp;
            index = maxIndex;
        }
    }

    public static void main(String[] args) {
        BinaryMaxHeap maxHeap = new BinaryMaxHeap();
        for (int i = 0; i < 32; i++) {
            maxHeap.insert(i);
        }
        for (int i = 0; i < 32; i++) {
            System.out.println(maxHeap.remove());
        }

        int[] arr = new int[]{3, 4, 0, 5, 1, 2, 8, 6, 9};

        System.out.println("priority queue");
        // min heap을 사용하는것과 비슷한 PriorityQueue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.offer(arr[i]);
        }
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        System.out.println("priority queue reverse");
        // max heap은 Collections.reverseOrder()를 사용할 수 있다.
        PriorityQueue<Integer> priorityQueueMax = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            priorityQueueMax.offer(arr[i]);
        }
        while (!priorityQueueMax.isEmpty()) {
            System.out.println(priorityQueueMax.poll());
        }
    }
}




