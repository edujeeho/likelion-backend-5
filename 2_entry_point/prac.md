### 간단 실습

Java를 이용해 git인 척 하는 프로그램을 작성합시다.

1. `JavaGit.java` 라는 파일의 `JavaGit` 이라는 클래스의 `main` 메소드를 수정해서 만듭니다.
2. 사용자는 `java JavaGit` 명령어를 이용해 이 프로그램을 사용한다고 가정합니다.
3. `java JavaGit add <임의의 문자열 입력>` 을 실행하면 `add changes to git:` 이라는 출력 다음 줄 부터 `<임의의 문자열 입력>` 부분에 지정된 파일들을 한줄씩 출력합니다.
4. `java JavaGit commit -m "<임의의 문자열 입력>"` 을 실행하면 `commit with message: "<임의의 문자열 입력>"` 이라고 출력합니다.
    1. `java JavaGit commit` 다음에 `-m` 이 없을경우, `no message specified` 라고 출력합니다.
5. `java JavaGit` 을 추가 인자없이 실행할 경우 `usage: add, commit` 을 출력합니다.
6. 입력은 제시된 조건을 만족하는 입력만 일어난다고 가정합니다.
7. 이번 문제에 한정하여, 다른 메소드나 클래스를 작성하지 않고 코드를 작성합니다.