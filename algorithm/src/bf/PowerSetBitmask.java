package bf;

import java.util.ArrayList;
import java.util.List;

// 비트연산을 활용한 부분집합 구하기
public class PowerSetBitmask {
    public static void main(String[] args) {
        int[] set = {2, 3, 5};
        new PowerSetBitmask().powerSet(set);
    }

    public void powerSet(int[] set) {
        int n = set.length;
        // 집합의 부분집합의 갯수는 2^n 개 인데, 1 << n 의 결과도 2^n 이다.
        int subsetCount = 1 << n;
        // i를 2진수로 생각하면,
        // 각 자릿수가 1일때 해당 자리숫수번재 원소를 고른다
        // 고 가정한다
        for (int i = 0; i < subsetCount; i++) {
            List<Integer> subset = new ArrayList<>();
            // n개의 원소를 판단하기 위해 n번 반복
            for (int j = 0; j < n; j++) {
                // 1을 j 자리 옮긴 후 i와 '&' 연산을 하면
                // i의 j번째 자리가 0인지 1인지 구분할 수 있다.
                if ((i & (1 << j)) != 0)
                    subset.add(set[j]);
            }

            System.out.println(subset);
        }
    }
}
