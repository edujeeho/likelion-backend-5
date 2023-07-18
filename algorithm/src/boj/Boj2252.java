package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Boj2252 {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer infoToken = new StringTokenizer(reader.readLine());
        int students = Integer.parseInt(infoToken.nextToken());
        int compares = Integer.parseInt(infoToken.nextToken());

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < students + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i <compares; i++) {
            StringTokenizer edgeToken = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(edgeToken.nextToken());
            int end = Integer.parseInt(edgeToken.nextToken());
            adjList.get(start).add(end);
        }
        // 1. 진입 차수 정리
        int[] inDegrees = new int[students + 1];
        for (List<Integer> neighbors: adjList) {
            for (int neighbor: neighbors) {
                inDegrees[neighbor]++;
            }
        }

        // 2. 진입 차수에 따른 첫 정점 정하기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < students + 1; i++) {
            if (inDegrees[i] == 0) queue.offer(i);
        }

        // 3. Queue 를 이용 위상정렬 진행
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int neighbor: adjList.get(node)) {
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) queue.offer(neighbor);
            }
        }

        // 정답 출력
        StringBuilder answer = new StringBuilder();
        for (int node: result) answer.append(node).append(' ');
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new Boj2252().solution();
    }
}

