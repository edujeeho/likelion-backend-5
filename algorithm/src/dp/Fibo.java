package dp;

public class Fibo {
    // n을 입력받고 n번째 피보나치 수열 출력
    public int fiboSimple(int n) {
        // k == 0, 1, 2
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        // F(k) == F(k - 1) + F(K - 2)
        return fiboSimple(n - 1) + fiboSimple(n - 2);
    }

    // 외부에서 호출하기 위한 메소드
    public int fiboMemo(int n) {
        return fiboMemoRe(n, new int[n + 1]);
    }

    private int fiboMemoRe(int n, int[] memo) {
        // k == 0, 1, 2
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        // F(k) == F(k - 1) + F(K - 2)
        // 만약에 이미 구해본 결과가 있다면 memo에 저장이 되어 있을거다.
        // 그것을 확인해보자.
        else if (memo[n] == 0)  // 만약 아직 없다면
            // 이번에 구해서 기록해주자.
            memo[n] = fiboMemoRe(n - 1, memo) + fiboMemoRe(n - 2, memo);
        // memo[n]이 있다면, 해당 값이 지금 구하고 있는 n번째 피보나치 수열 값
        return memo[n];
    }

    public int fiboTab(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // 계산 결과 기록용 배열
        int[] fib = new int[n + 1];
        // 알고 있는 결과는 미리 기록
        fib[1] = 1;
        fib[2] = 1;
        for (int i = 3; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }


    public static void main(String[] args) {
        Fibo fibo = new Fibo();
        int n = 30;
        // fiboSimple 계산
        long start = System.nanoTime();
        System.out.println("simple");
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            resultBuilder.append(fibo.fiboSimple(i)).append(' ');
        }
        System.out.println(resultBuilder);
        System.out.println(System.nanoTime() - start);
        System.out.println();

        // fiboMemo 계산
        start = System.nanoTime();
        System.out.println("memo");
        resultBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            resultBuilder.append(fibo.fiboMemo(i)).append(' ');
        }
        System.out.println(resultBuilder);
        System.out.println(System.nanoTime() - start);
        System.out.println();

        // fiboTab 계산
        start = System.nanoTime();
        System.out.println("tab");
        resultBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            resultBuilder.append(fibo.fiboTab(i)).append(' ');
        }
        System.out.println(resultBuilder);
        System.out.println(System.nanoTime() - start);
        System.out.println();
    }
}
