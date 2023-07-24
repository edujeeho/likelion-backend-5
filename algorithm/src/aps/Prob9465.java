package aps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Boj 9465
public class Prob9465 {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < testCases; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] stickers = new int[2][n];
            for (int j = 0; j < 2; j++) {
                StringTokenizer stickerToken = new StringTokenizer(reader.readLine());
                for (int k = 0; k < n; k++) {
                    stickers[j][k] = Integer.parseInt(stickerToken.nextToken());
                }
            }
            answer.append(solve(n, stickers)).append('\n');
        }
        System.out.print(answer);
    }

    private int solve(int cols, int[][] stickers) {
        if (cols == 1) return Math.max(stickers[0][0], stickers[1][0]);
        int[][] table = new int[2][cols];
        table[0][0] = stickers[0][0];
        table[1][0] = stickers[1][0];
        table[0][1] = table[1][0] + stickers[0][1];
        table[1][1] = table[0][0] + stickers[1][1];
        for (int i = 2; i < cols; i++) {
            table[0][i] = Math.max(table[1][i - 1] + stickers[0][i], table[1][i - 2] + stickers[0][i]);
            table[1][i] = Math.max(table[0][i - 1] + stickers[1][i], table[0][i - 2] + stickers[1][i]);
        }

        return Math.max(table[0][cols - 1], table[1][cols - 1]);
    }

    public static void main(String[] args) throws IOException {
        new Prob9465().solution();
    }
}
