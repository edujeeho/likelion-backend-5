package aps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 2636
public class Prob2636 {
    private final int[][] deltas = new int[][]{
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1},
    };
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer colRowToken = new StringTokenizer(reader.readLine());
        int y = Integer.parseInt(colRowToken.nextToken());
        int x = Integer.parseInt(colRowToken.nextToken());

        int cheeseCount = 0;
        int lastCheese = 0;

        int[][] board = new int[y][x];
        for (int i = 0; i < y; i++) {
            StringTokenizer rowToken = new StringTokenizer(reader.readLine());
            for (int j = 0; j < x; j++) {
                board[i][j] = Integer.parseInt(rowToken.nextToken());
                if (board[i][j] == 1) cheeseCount++;
            }
        }


        boolean[][] visited = new boolean[y][x];
        int reps = 0;
        Queue<int[]> thisRep = new LinkedList<>();
        thisRep.add(new int[]{0, 0});
        while (cheeseCount > 0) {
            reps++;
            Queue<int[]> nextRep = new LinkedList<>();
            Queue<int[]> nextMelt = new LinkedList<>();
            while (!thisRep.isEmpty()) {
                int[] now = thisRep.poll();

                for (int[] delta: deltas) {
                    int nextY = now[0] - delta[0];
                    int nextX = now[1] - delta[1];
                    if (-1 < nextX && nextX < x && -1 < nextY && nextY < y && !visited[nextY][nextX]){
                        visited[nextY][nextX] = true;
                        int[] next = new int[]{nextY, nextX};
                        if (board[nextY][nextX] == 1) {
                            nextMelt.add(next);
                            nextRep.add(next);
                        }
                        else {
                            thisRep.add(next);
                        }
                    }
                }
            }
            thisRep = nextRep;
            lastCheese = cheeseCount;
            cheeseCount -= nextMelt.size();
            while (!nextMelt.isEmpty()) {
                int[] melt = nextMelt.poll();
                board[melt[0]][melt[1]] = 0;
            }
        }

        System.out.println(reps + "\n" + lastCheese);
    }

    public static void main(String[] args) throws IOException {
        new Prob2636().solution();
    }
}
