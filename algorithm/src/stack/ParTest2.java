package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParTest2 {
    public boolean solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();  // 괄호 입력 받는 부분

        // 소괄호, 중괄호, 대괄호로 이루어진 수식을 검서하는 코드를 작성하시오.
        Stack<Character> charStack = new Stack<>();

        // 문자열 길이만큼 순회한다.
        for (int i = 0; i < input.length(); i++) {
            char next = input.charAt(i);

            // 1. 모든 여는 괄호를 만날때 push
            if (next == '(' || next == '{' || next == '[') {
                charStack.push(next);
            }
            // 2. 어떤 닫는 괄호든 만날 경우
            else if (next == ')' || next == '}' || next == ']') {
                // a. pop 할게 없으면 검사 실패 (false 반환)
                //    => 스택이 비어있다.
                if (charStack.empty()) return false;
                // b. 아니라면 pop
                char top = charStack.pop();

                // c. pop의 결과로 나온 값이 올바른 여는 괄호인지 확인
                // `들어온건 닫는 소괄호 && top은 여는 소괄호`가 아닐 때 실패
                if (next == ')' && top != '(') return false;
                else if (next == '}' && top != '{') return false;
                else if (next == ']' && top != '[') return false;
            }
        }

        // 3. 순회가 끝났을때 스택이 비었는지 확인
        return charStack.empty();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new ParTest2().solution());
    }
}
