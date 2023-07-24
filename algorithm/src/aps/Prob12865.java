package aps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// Boj 12865
public class Prob12865 {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer infoToken = new StringTokenizer(reader.readLine());
        int itemCount = Integer.parseInt(infoToken.nextToken());
        int totalWeight = Integer.parseInt(infoToken.nextToken());

        int[][] dp = new int[itemCount + 1][totalWeight + 1];
        int[][] items = new int[itemCount + 1][];
        for (int i = 1; i < itemCount + 1; i++) {
            StringTokenizer itemToken = new StringTokenizer(reader.readLine());
            items[i] = new int[]{
                    Integer.parseInt(itemToken.nextToken()),
                    Integer.parseInt(itemToken.nextToken())
            };
        }

        for (int itemNumber = 1; itemNumber < itemCount + 1; itemNumber++) {
            int itemWeight = items[itemNumber][0];
            int itemValue = items[itemNumber][1];
            for (int currentWeight = 0; currentWeight < totalWeight + 1; currentWeight++) {
                // 지금 무게에서 물건을 첨부 못하면 이전에 첨부한게 최고 가치
                if (itemWeight > currentWeight)
                    dp[itemNumber][currentWeight] = dp[itemNumber - 1][currentWeight];
                // 추가할 수 있다면,
                // 지금 아이템 가치 + 넣은 뒤 남은 공간에 넣을 수 있는, 마지막 최고가치
                // vs
                // 이전 최고 가치
                else
                    dp[itemNumber][currentWeight] = Math.max(
                            itemValue + dp[itemNumber - 1][currentWeight - itemWeight],
                            dp[itemNumber - 1][currentWeight]
                    );

            }
        }

//        System.out.println(Arrays.deepToString(dp));

        return dp[itemCount][totalWeight];
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Prob12865().solution());
    }
}
