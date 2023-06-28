package graph;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers43163 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        // words 내에 target 이 존재하지 않으면 바로 반환
        if (!Arrays.asList(words).contains(target)) return answer;

        // 최단거리를 구할거기 때문에, 문제 조건에는 다시 활용하면 안된다는 조건이 없지만
        // 원래 사용했던 단어를 다시 사용할 경우 최단거리에서 최소 +2 만큼 벌어지게 된다.
        boolean[] visited = new boolean[words.length];
        // 거리를 저장하기 위한 distance 배열
        // begin 에서 words[i] 까지 도달하는데 걸린 최소 변환 횟수
        // 원래는 Queue<int[]> 형식으로 주던것을 Queue<Integer>로, 두번째 값은 외부 배열로
        int[] distance = new int[words.length];

        // begin 에서 일단 도달할 수 있는 words 내의 단어를 Queue 에 enqueue
        Queue<Integer> toVisit = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            // 시작 단어와 유사한 단어일 경우
            if (similar(begin, words[i])) {
                // Queue에 enqueue
                toVisit.offer(i);
                visited[i] = true;
                distance[i] = 1;
            }
        }
        // BFS 진행
        while (!toVisit.isEmpty()) {
            int nextIdx = toVisit.poll();
            String nextWord = words[nextIdx];
            // 이번 단어가 Target이다.
            if (nextWord.equals(target)) {
                answer = distance[nextIdx];
                break;
            }

            // 다음 방문 대상 선정
            for (int i = 0; i < words.length; i++) {
                // 유사하고, 방문하지 않았다.
                if (similar(nextWord, words[i]) && !visited[i]) {
                    toVisit.offer(i);
                    visited[i] = true;
                    distance[i] = distance[nextIdx] + 1;
                }
            }
        }

        return answer;
    }

    // 인접 판단 메소드: 두 단어가 한글자 제외 동일한지
    private boolean similar(String word, String target) {
        // String.charAt(i)
        int k = 0;  // 몇글자 일치하는지 저장
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == target.charAt(i)) k++;
        }
        return k == word.length() - 1;
    }

    public static void main(String[] args) {
        System.out.println(
                new Programmers43163().solution("hit", "cog", new String[]{
                        "hot", "dot", "dog", "lot", "log", "cog"
                })
        );
        System.out.println(
                new Programmers43163().solution("hit", "cog", new String[]{
                        "hot", "dot", "dog", "lot", "log"
                })
        );
    }
}
