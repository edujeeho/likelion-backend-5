package topo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TopologicalSorting {
    private List<List<Integer>> adjList;
    private int nodes;

    public void topologicalSort() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer infoToken = new StringTokenizer(reader.readLine());
        nodes = Integer.parseInt(infoToken.nextToken());
        int edges = Integer.parseInt(infoToken.nextToken());
        adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            StringTokenizer edgeToken = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(edgeToken.nextToken());
            int end = Integer.parseInt(edgeToken.nextToken());
            adjList.get(start).add(end);
        }

        kahn();
        dfs();
    }

    // DFS 시작
    private void dfs() {
        // 방문 배열
        boolean[] visited = new boolean[nodes];
        // 처리 중 배열
        boolean[] inProcess = new boolean[nodes];
        // 결과 저장 스택
        Stack<Integer> resultReversed = new Stack<>();
        boolean success = true;
        // 모든 정점을 시작점으로 DFS
        for (int i = 0; i < nodes; i++) {
            // 단 이미 전 시행에서 방문했으면 추가 방문 불필요
            if (!visited[i])
                success = dfsRecursive(i, visited, inProcess, resultReversed);
            // 한번이라도 실패하면 위상 정렬 불가
            if (!success) break;
        }
        List<Integer> result = new ArrayList<>();
        // 성공 했을 때만 출력용 결과 작업
        if (success)
            while (!resultReversed.empty())
                result.add(resultReversed.pop());
        System.out.println(result);
    }

    private boolean dfsRecursive(
            int next,
            boolean[] visited,
            boolean[] inProcess,
            Stack<Integer> resultReversed
    ) {
        // 일단 방문 정점을 방문 및 처리 중으로 표시
        visited[next] = true;
        inProcess[next] = true;

        for (int neighbor: adjList.get(next)) {
            // 처리 중 (인접 정점이 남은 정점)인 정점을 만나면 이는 싸이클이다.
            if (inProcess[neighbor]) return false;
            // 미방문 정점을 만나면 다음 재귀
            else if (!visited[neighbor])
                // 재귀 중 false 는 싸이클의 존재를 의미
                if(!dfsRecursive(neighbor, visited, inProcess, resultReversed))
                    return false;
        }
        // for의 종료는 모든 인접 정점의 방문을 의미, 기록한다.
        resultReversed.push(next);

        // 처리가 끝났으니 처리 중 배열은 false 로
        inProcess[next] = false;
        return true;
    }

    private void kahn() {
        int[] inDegrees = new int[nodes];
        // 진입 차수를 구한다.
        for (List<Integer> neighbors : adjList) {
            for (int neighbor : neighbors) {
                inDegrees[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        // 진입 차수가 0인 정점들 부터 시작
        for (int i = 0; i < nodes; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        // Queue 가 비어있지 않을 동안
        while (!queue.isEmpty()) {
            int node = queue.poll();
            // 이번 방문점을 기록
            result.add(node);

            // 현재 방문점의 인접 정점들의 진입 차수를 하나 줄인다.
            for (int neighbor : adjList.get(node)) {
                inDegrees[neighbor]--;
                // 진입 차수가 0이 되면 방문 가능
                if (inDegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        // 결과에 기록된 정점 갯수가 실제 정점보다 적을 경우 위상 정렬 불가
        if (result.size() < nodes)
            System.out.println(new ArrayList<>());
        else System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        new TopologicalSorting().topologicalSort();
    }
}

/*
7 8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6

 */

/*
7 9
0 1
0 2
1 3
1 4
2 3
2 6
3 5
4 3
4 5

 */

/*
7 9
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
3 0

 */
