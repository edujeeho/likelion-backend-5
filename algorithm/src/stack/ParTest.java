package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParTest {
    public boolean solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();  // 괄호 입력 받는 부분

        Stack<Character> charStack = new Stack<>();

        // 문자열 길이만큼 순회한다.
        for (int i = 0; i < input.length(); i++) {
            char next = input.charAt(i);

            // 1. 여는 괄호를 만날때 push
            if (next == '(') {
                charStack.push(next);
            }
            // 2. 닫는 괄호를 만날 경우
            else if (next == ')') {
                // a. pop 할게 없으면 검사 실패 (false 반환)
                //    => 스택이 비어있다.
                if (charStack.empty()) return false;
                // b. 아니라면 pop
                char top = charStack.pop();

                // c. pop의 결과로 나온 값이 여는 괄호인지 확인
                //    => 여는 괄호가 아니라면 실패
                if (top != '(') return false;
            }
        }

        // 3. 순회가 끝났을때 스택이 비었는지 확인
        return charStack.empty();
    }

    public static void main(String[] args) throws IOException {
        System.out.println((new ParTest()).solution());
    }
}
