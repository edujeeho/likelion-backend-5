package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BFPatternMatching {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String target = reader.readLine();
        String pattern = reader.readLine();

        int tarIdx = 0;
        int patIdx = 0;

        // TODO tarIdx 전체 길이보다 작을 동안에 반복한다.
        // TODO 존재하는지만 검사하면 된다 했을 경우 patIdx 가 pattern.length() 보다 작을 동안에 반복한다.
        while (tarIdx < target.length() && patIdx < pattern.length()) {
            // TODO target[tarIdx] 가 pattern[patIdx] 랑 다를 경우
            if (target.charAt(tarIdx) != pattern.charAt(patIdx)) {
                // TODO tarIdx를 patIdx가 여태까지 이동한 만큼 되돌린다.
                tarIdx -= patIdx;
                // TODO patIdx를 -1로 할당한다.
                patIdx = -1;
            }

            // TODO 다음칸으로 이동한다.
            tarIdx += 1;
            patIdx += 1;
        }
        // TODO patIdx == pattern.length() 이면 성공이다. 어디에서 찾았는지 출력한다.
        if (patIdx == pattern.length()) {
            System.out.println(tarIdx - patIdx);
        }
        // TODO 못찾으면 System.out.println("404 Not Found");
        else {
            System.out.println("404 Not Found");
        }
    }


    // qwertyuiuiuytrertyuiopopoiuytrqwertyuytrertywqwertyuiuytrewqwertyuiiuiuiytrewert
    // qwert
    public static void main(String[] args) throws IOException {
        new BFPatternMatching().solution();
    }
}
