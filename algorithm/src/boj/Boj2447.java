package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2447 {
    private char[][] starboard;
    public void solution() throws IOException {
        int n = Integer.parseInt(
                new BufferedReader(new InputStreamReader(System.in)).readLine());
        starboard = new char[n][n];
        // starboard의 각 줄이 반환
        for (char[] row: starboard) {
            Arrays.fill(row, ' ');
        }

        setStar(n, 0, 0);
        StringBuilder drawStar = new StringBuilder();
        for (int i = 0; i < n; i++) {
            drawStar.append(starboard[i]).append('\n');
        }
        System.out.println(drawStar);
    }

    public void setStar(int n, int x, int y) {
        // n == 3이라면 실제로 별을 그리기 시작
        if (n == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // 가운데 지점에선 별을 그리지 않는다.
                    if (i == 1 && j == 1) continue;
                    starboard[y + i][x + j] = '*';
                }
            }
        }
        // 아니라면 n == 3 일때까지 재귀호출
        else {
            int offset = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // 가운데 사각형이면 굳이 재귀호출 안해도 된다.
                    if (i == 1 && j == 1) continue;
                    setStar(offset, x + offset * i, y + offset * j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Boj2447().solution();
    }
}
