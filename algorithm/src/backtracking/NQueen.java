package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {
    // 판을 int[][] 다 구현하는 방법
    // 아니면 각 줄의 어느 위치에 퀸이 존재하는지를 기록하는 방법
    private int[] queenPos;
    // N
    private int size;
    // 몇개의 퀸을 놨는지
    private int count;

    public int solution() throws IOException {
        // 입력은 N
        size = Integer.parseInt(
                new BufferedReader((
                        new InputStreamReader(System.in))).readLine());
        queenPos = new int[size];
        count = 0;
        setQueenPos(0);
        return count;
    }

    // row 번째 줄에 Queen 배치할 차례
    private void setQueenPos(int row) {
        // 전부 배치 완료
        if (row == size) {
            count++;
        }
        else for (int i = 0; i < size; i++) {
            // row 번째 Queen의 위치는 순회중인 i
            queenPos[row] = i;
            // 이번줄에 배치한 결과가 조건에 부합하면 다음줄로
            if (checkQueen(row)) setQueenPos(row + 1);
        }
    }

    // 유망성 조사
    // 현재 배치가 N - Queen 문제의 답의 요구사항을 만족하는지
    private boolean checkQueen(int row) {
        for (int i = 0; i < row; i++) {
            // 1. 세로줄에 겹치는지
            if (queenPos[i] == queenPos[row])
                return false;
                // 2. 대각선에 겹치는지
            else if (Math.abs(queenPos[i] - queenPos[row]) == row - i) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new NQueen().solution());
    }
}


