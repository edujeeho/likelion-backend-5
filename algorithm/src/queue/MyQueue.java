package queue;

public class MyQueue {
    private final int[] arr = new int[4];
    // Queue에서 데이터 꺼내는 위치
    private int front = -1;
    // Queue에 데이터 추가하는 위치
    private int rear = -1;

    public MyQueue() {}

    // 데이터 추가
    public void enQueue(int x) {
        // rear + 1이 배열의 크기만해질 때
        if (rear == arr.length - 1) {
            throw new RuntimeException("queue is full");
        }
        // rear를 하나 증가시킨다.
        rear++;
        // arr[rear]에 data를 할당한다.
        arr[rear] = x;
    }

    // 데이터 회수
    public int deQueue() {
        // front == rear일때 큐가 비어있음
        if (front == rear) {
            throw new RuntimeException("queue is empty");
        }
        // front를 하나 증가시킨다.
        front++;
        // arr[front]의 값을 반환한다.
        return arr[front];
    }

    // 큐가 비어있는지 확인
    public boolean isEmpty() {
        return front == rear;
    }

    // 다음에 나올 데이터가 무엇인지 학인 (Queue에서 빼내지 않음)
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        // 비어있지 않다면 front + 1의 값 반환
        return arr[front + 1];
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        System.out.println(queue.deQueue());
        queue.enQueue(5);
//        MyQueue intQueue = new MyQueue();
//        intQueue.enQueue(1);
//        intQueue.enQueue(2);
//        intQueue.enQueue(3);
//        System.out.println(intQueue.deQueue());
//        System.out.println(intQueue.deQueue());
//        System.out.println(intQueue.deQueue());
//
//        intQueue.enQueue(4);
//        System.out.println(intQueue.deQueue());
//
//        intQueue.enQueue(5);
//        intQueue.enQueue(6);
    }
}
