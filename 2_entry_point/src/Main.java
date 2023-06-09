import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 인자를 하나 이상 받을때만 실행한다.
        if (args.length > 0) {
            // 첫번째 인자를 받아서
            String command = args[0];
            // 각각 확인
            if (command.equals("add") &&
                    // 여기에 인자 갯수 관련 검증 추가 가능
                    true) {
                // 명령어가 add 였을때
                System.out.println("add changes to git:");

                for (
                        // foreach문 내부에서 사용할 변수명
                        String filename:
                        // args를 1부터 끝까지 복사한다.
                        Arrays.copyOfRange(args, 1, args.length)
                ) {
                    // 출력
                    System.out.println(filename);
                }
            }
            else if (command.equals("commit")){
                if (!args[1].equals("-m")) {
                    System.out.println("no message specified");
                }
                else {
                    System.out.printf("commit with message: \"%s\"%n", args[2]);
                }
            }
        // 아니면 사용법 출력 후 종료
        } else {
            System.out.println("usage: add, commit");
        }
    }
}