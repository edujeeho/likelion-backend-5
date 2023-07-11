package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1802 {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        for (int i = 0; i < tests; i++) {
            if (foldable(reader.readLine()))
                System.out.println("YES");
            else System.out.println("NO");
        }
    }

    // 종이의 굴곡이 0과 1로 문자열로 주어진다.
    // 1000110
    private boolean foldable(String paper) {
        // assert paper.length() % 2 == 1;
        // 굴곡이 하나라면 확인할 필요가 없다. 반 접었으니
        if (paper.length() > 1) {
            // 절반 지점
            int half = paper.length() / 2;
            // 왼쪽 종이와 오른쪽 종이가 조건을 만족하는지 검사한다.
            // 조건이 만족되지 않으면 불가능
            if (!foldable(paper.substring(0, half))) return false;
            if (!foldable(paper.substring(half + 1))) return false;
            // 작은 부분들이 만족스러웠으면,
            // 현재 크기에서 서로 좌우 역대칭이 되는지 확인한다.
            for (int i = 1; i < half + 1; i++) {
                // 중간 지점에서 i만큼 + 또는 - 한 위치의 굴곡을 확인한다.
                // 굴곡의 모양이 일치하는 경우 조건이 만족되지 않는다.
                if (paper.charAt(half + i) == paper.charAt(half - i))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        new Boj1802().solution();
    }
}
/*
3
0
000
1000110

 */