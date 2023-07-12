package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj17829 {
    private int[][] matrix;
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer row = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(row.nextToken());
            }
        }
        return pooling(n, 0, 0);
    }

    public int pooling(int n, int x, int y) {
        // 재귀호출하지 않고 계산한 결과를 반환
        if (n == 2) {
            int[] four = new int[]{
                    matrix[y][x],
                    matrix[y + 1][x],
                    matrix[y][x + 1],
                    matrix[y + 1][x + 1]
            };
            Arrays.sort(four);
            return four[2];
        }
        // 재귀호출 후 그 결과를 수집 후 자신의 결과로 반환
        else {
            int half = n / 2;
            int[] four = new int[] {
                    pooling(half, x, y),
                    pooling(half, x + half, y),
                    pooling(half, x, y + half),
                    pooling(half, x + half, y + half)
            };
            Arrays.sort(four);
            return four[2];
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Boj17829().solution());
    }
}
