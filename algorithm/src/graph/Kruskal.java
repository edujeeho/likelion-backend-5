package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Kruskal {
    int[] parent;
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer neTokenizer = new StringTokenizer(reader.readLine());
        int nodeCount = Integer.parseInt(neTokenizer.nextToken());
        int edgeCount = Integer.parseInt(neTokenizer.nextToken());

        // Kruskal 알고리즘은 서로소 집합의 개념을 이용해 서로다른 두 정점을
        // 연결했을 때 사이클이 발생하는지 안하는지 구분한다.
        // 배열로 표현한 트리를 만들자
        parent = new int[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            parent[i] = i;
        }

        // 간선 정보 해독 (시작, 끝, 가중치)
        int[][] edges = new int[edgeCount][3];
        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer edgeTokenizer = new StringTokenizer(reader.readLine());
            edges[i][0] = Integer.parseInt(edgeTokenizer.nextToken());
            edges[i][1] = Integer.parseInt(edgeTokenizer.nextToken());
            edges[i][2] = Integer.parseInt(edgeTokenizer.nextToken());
        }

        // 1. 간선들을 가중치 기준에서 정렬한다.
        Arrays.sort(edges, Comparator.comparingInt(edge -> edge[2]));


        // 2. 간선들을 가중치 순서대로 순회하면서 고른다.
        // N-1개만 고르더라도 다 끝
        int picked = 0;
        int totalWeight = 0;
        List<String> pickedEdges = new ArrayList<>();
        for (int i = 0; i < edgeCount; i++) {
            int start = edges[i][0];
            int end = edges[i][1];

            // 2-1. start와 end를 연결한 간선을 택하면
            // 사이클이 생기지 않는지? findSet, union
            if (findSet(start) != findSet(end)) {
                // 두 원소를 하나의 집합으로
                union(start, end);
                // 간선을 골랐음을 표시
                picked++;
                // 총 가중치 업데이트
                totalWeight += edges[i][2];
                pickedEdges.add(Arrays.toString(edges[i]));
            }

            // 3. 고른 간선의 갯수가 N-1개가 될때 까지
            if (picked == nodeCount - 1) break;
        }

        System.out.println(totalWeight);
        System.out.println(pickedEdges);
    }

    // findSet: 내 부모가 나일때까지 재귀호출
    public int findSet(int node) {
        if (parent[node] != node)
            return findSet(parent[node]);
        else return parent[node];
    }

    // union: y가 속한 집합을 X가 속한 집합에 합친다.
    public void union(int x, int y) {
        parent[findSet(y)] = findSet(x);
    }

    public static void main(String[] args) throws IOException {
        new Kruskal().solution();
    }
}
/*
8 11
0 1 41
0 2 14
0 3 13
1 4 27
2 5 21
3 5 33
3 7 22
4 6 11
4 7 17
5 6 35
6 7 19

 */