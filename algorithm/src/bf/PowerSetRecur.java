package bf;

import java.util.Arrays;

// Recur -> Recursive
// 재귀함수로 부분집합 구하기
public class PowerSetRecur {
    public static void main(String[] args) {
        int[] set = new int[]{2, 3, 5};
        new PowerSetRecur().powerSet(set, 0, new int[set.length]);
    }

    public void powerSet(
            int[] set,
            // next 번째 원소를 선택할지 말지
            int next,
            int[] select
    ) {
        // next가 원소의 갯수가 되면 종료
        if (next == set.length) {
            // 지금 Select 배열을 보고 출력한다.
            for (int i = 0; i< set.length; i++) {
                if (select[i] == 1)
                    System.out.print(set[i] + " ");
            }
            System.out.println(Arrays.toString(select));
        }
        else {
            // 내건 고르지 않고 다음거
            select[next] = 0;
            powerSet(set, next + 1, select);
            // 내거 고르고 다음거
            select[next] = 1;
            powerSet(set, next + 1, select);
        }
    }
}
