package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj7662 {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        StringBuilder outBuilder = new StringBuilder();
        for (int i = 0; i < testCases; i++) {
            int commandCount = Integer.parseInt(reader.readLine());

            // Collections.reverseOrder로 최대 힙
            PriorityQueue<Integer> maxQueue
                    = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minQueue
                    = new PriorityQueue<>();
            // Map 만들기
            // Key: 입력 데이터, Value: 입력 데이터의 출현 횟수
            Map<Integer, Integer> tracker = new HashMap<>();
            int size = 0;
            for (int j = 0; j < commandCount; j++) {
                // I 숫자: 숫자를 삽입
                // D 1: 최대 원소 제거
                // D -1: 최소 원소 제거
                StringTokenizer commandToken = new StringTokenizer(reader.readLine());
                String command = commandToken.nextToken();
                int number = Integer.parseInt(commandToken.nextToken());
                if (command.equals("I")) {
                    // 두 우선순위 큐에 삽입
                    minQueue.offer(number);
                    maxQueue.offer(number);
                    tracker.put(number, tracker.getOrDefault(number, 0) + 1);
                    size++;
                }
                else if (number == 1 && size > 0){
                    // tracker에 키가 존재하는 원소가 나올때까지 queue에서 poll 한다.
                    // tracker에 키가 없다는 것은 입력된적 잇지만 다른 큐에 의해서 이미 빠져나갔다는 뜻
                    while (!tracker.containsKey(maxQueue.peek())) {
                        maxQueue.poll();
                    }
                    // 실제로 꺼낸 원소
                    int polled = maxQueue.poll();
                    // tracker 갱신
                    tracker.put(polled, tracker.get(polled) - 1);
                    if (tracker.get(polled) == 0) tracker.remove(polled);
                    size--;
                }
                else if (number == -1 && size > 0) {
                    while (!tracker.containsKey(minQueue.peek())) {
                        minQueue.poll();
                    }
                    int polled = minQueue.poll();
                    tracker.put(polled, tracker.get(polled) - 1);
                    if (tracker.get(polled) == 0) tracker.remove(polled);
                    size--;
                }
            }

            if (size == 0) {
                outBuilder.append("EMPTY\n");
            } else {
                while (!tracker.containsKey(maxQueue.peek())) {
                    maxQueue.poll();
                }
                while (!tracker.containsKey(minQueue.peek())) {
                    minQueue.poll();
                }
                outBuilder.append(maxQueue.poll())
                        .append(" ")
                        .append(minQueue.poll())
                        .append("\n");
            }
        }

        System.out.println(outBuilder);
    }

    public static void main(String[] args) throws IOException {
        new Boj7662().solution();
    }
}







