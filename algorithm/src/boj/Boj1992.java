package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1992 {
    // 입력에 대한 정보를 클래스 필드로 저장한다.
    // 입력된 0과 1로 구성된 이미지
    private char[][] image;
    // 결과를 저장하기 위한 StringBuilder
    public StringBuilder quadTreeBuilder;

    private void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        image = new char[n][];
        for (int i = 0; i < n; i++) {
            // String.toCharArray()를 사용하면 문자열을 char[]로 변환 가능
            image[i] = reader.readLine().toCharArray();
        }
        quadTreeBuilder = new StringBuilder();
        compressQuad(n, 0, 0);
        System.out.println(quadTreeBuilder.toString());
    }

    private void compressQuad(
            // n: 정사각형의 한변의 길이
            int n,
            // x: 정사각형의 시작 x index
            int x,
            // y: 정사각형의 시작 y index
            int y
    ) {
        // 조건을 마족했는지 검사하는 flag
        boolean success = true;
        // 모든 요소가 같지 않을 경우 success = false 를 해준다.
        // x, y의 값을 저장해두고
        // x ~ x + n - 1, y ~ y + n - 1 까지 반복하면서
        // 초기의 값과 달라지는지를 검사한다.
        char init = image[x][y];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (image[x + i][y + j] != init) {
                    success = false;
                    break;
                }
            }
            if (!success) break;
        }
        // 원소들 검사 후 success == false 라면 쪼개서 재귀호출
        if (!success) {
            // 좌 괄호 입력
            quadTreeBuilder.append('(');
            // 4등분을 위한 half
            int half = n / 2;
            for (int i = 0; i < 2; i++){
                for (int j = 0; j < 2; j++) {
                    compressQuad(
                            half,
                            x + half * i,
                            y + half * j
                    );
                }
            }
            // 4등분 영상이 압축이 끝나면 우괄호 입력
            quadTreeBuilder.append(')');
        } else {
            // 모든 원소가 일치했다면 첫번째 검사한 원소를 입력
            quadTreeBuilder.append(init);
        }
    }

    public static void main(String[] args) throws IOException {
        new Boj1992().solution();
    }

}
/*
8
11110000
11110000
00011100
00011100
11110000
11110000
11110011
11110011

((110(0101))(0010)1(0001))

 */