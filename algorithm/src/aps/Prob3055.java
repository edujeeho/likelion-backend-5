package aps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 3055
public class Prob3055 {
    private int row;
    private int col;
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer rowColToken = new StringTokenizer(reader.readLine());
        row = Integer.parseInt(rowColToken.nextToken());
        col = Integer.parseInt(rowColToken.nextToken());
        char[][] board = new char[row][];
        boolean[][] visited = new boolean[row][col];

        int[][] deltas = new int[][]{
                new int[] {-1, 0},
                new int[] {1, 0},
                new int[] {0, -1},
                new int[] {0, 1},
        };
        Queue<int[]> nextVisit = new LinkedList<>();
        Queue<int[]> nextWater = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            board[i] = reader.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'S') nextVisit.add(new int[]{i, j});
                else if (board[i][j] == '*') nextWater.add(new int[]{i, j});
            }
        }

        boolean success = false;
        int reps = 0;
        while (!success) {
            reps += 1;

            Queue<int[]> thisWater = nextWater;
            nextWater = new LinkedList<>();
            while (!thisWater.isEmpty()) {
                int[] now = thisWater.poll();
                for (int[] delta: deltas) {
                    int nextY = now[0] + delta[0];
                    int nextX = now[1] + delta[1];
                    if (checkBounds(nextX, nextY) &&
                            (board[nextY][nextX] == '.' || board[nextY][nextX] == 'S')
                    ) {
                        board[nextY][nextX] = '*';
                        nextWater.add(new int[]{nextY, nextX});
                    }
                }
            }

            Queue<int[]> thisVisit = nextVisit;
            nextVisit = new LinkedList<>();
            while (!thisVisit.isEmpty()) {
//                System.out.println("hog queue size: " + thisVisit.size());
                int[] now = thisVisit.poll();
//                if (board[now[0]][now[1]] == '*') continue;
                for (int[] delta: deltas) {
                    int nextY = now[0] + delta[0];
                    int nextX = now[1] + delta[1];
                    if (checkBounds(nextX, nextY) && !visited[nextY][nextX]) {
                        if (board[nextY][nextX] == '.') {
                            visited[nextY][nextX] = true;
                            nextVisit.add(new int[]{nextY, nextX});
                        }
                        else if (board[nextY][nextX] == 'D') {
                            success = true;
                            break;
                        }
                    }
                }
                if (success) break;
            }

            if (nextVisit.isEmpty()) {
                break;
            }

        }

        if (!success) System.out.println("KAKTUS");
        else System.out.println(reps);
    }

    private boolean checkBounds(int x, int y) {
        return -1 < y && y < row && -1 < x && x < col;
    }

    public static void main(String[] args) throws IOException {
        new Prob3055().solution();
    }
}
