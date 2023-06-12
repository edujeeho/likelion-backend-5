package stack;

public class MyStack {
    // 스택에 실제 데이터가 저장되는 곳
    private final int[] arr = new int[16];
    // 현재 스택의 최고점을 파악하기 위한 top
    private int top = -1;


    public MyStack(){}

    // push: 데이터를 스택의 제일 위에 넣는 메소드
    public void push(int data) {
        // 0. arr가 가득 찬건지를 판단한다. 감사합니다.
        if (arr.length - 1 == top) {
            throw new RuntimeException("stack is full");
        }
//        // 1. top을 하나 증가시킨다.
//        top++;
//
//        // 2. arr[top]에 data를 할당한다.
//        arr[top] = data;
        arr[++top] = data;
        // 끝!
    }

    // pop: 데이터를 스택의 제일 위에서 회수하는 메소드
    public int pop() {
        // 0. arr가 비어있는지 판단한다. (top)
        // if (top == -1) {
        if (empty()) {
            throw new RuntimeException("stack is empty");
        }
//        // 1. arr[top]의 값을 임시 저장한다.
//        int temp = arr[top];
//
//        // 2. top의 값을 하나 감소한다.
//        top--;
//
//        // 3. return temporary value
//        return temp;
        return arr[top--];

        // Done!
    }

    // peek: return the top of stack without removing
    // without removing => do not change top
    public int peek() {
        // 0. check if stack not empty
        // if (top == -1) {
        if (empty()) {
            throw new RuntimeException("stack is empty");
        }
        // 1. return arr[top];
        return arr[top];
    }

    // empty: check if stack is empty
    public boolean empty() {
        // stack is empty when top == -1
        return top == -1;
    }

    public static void main(String[] args) {
        // 스택에 3개의 데이터를 넣었다가 빼보자
        MyStack intStack = new MyStack();
        intStack.push(3);
        intStack.push(5);
        intStack.push(7);
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.empty());
        System.out.println(intStack.peek());

    }
}










