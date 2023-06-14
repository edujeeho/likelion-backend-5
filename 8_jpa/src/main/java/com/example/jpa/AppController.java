package com.example.jpa;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// 사용자의 입력을 받는 요소
//@Controller
@RestController  // 모든 메소드에 @ResponseBody를 붙이는 용도
public class AppController {
    private final AppService service;

    public AppController(AppService service){
        this.service = service;
    }

    @GetMapping("create")
    // @Controller의 Mapper 메소드에 @ResponseBody가 붙으면
    // View를 반환하는 것이 아닌 데이터 (Http Response Body) 를 반환한다.
    // @RestController의 경우 모든 메소드가 @ResponseBody가 붙은 것처럼 동작한다.
    // (그러니 사실 여기 붙은건 생략 가능하다)
    public @ResponseBody String create() {
        this.service.createStudent(
                "alex",
                35,
                "010-1234-5678",
                "alex@gmail.com"
        );

        return "done";
    }

    @GetMapping("read")
    public @ResponseBody String readOne() {
        this.service.readStudent(1L);
        return "done-read-one";
    }

    @GetMapping("read-all")
    public @ResponseBody String readAll() {
        this.service.readStudentAll();
        return "done-read-all";
    }

    @GetMapping("update")
    public @ResponseBody String update() {
        this.service.updateStudent(1L, "alexander");
        return "done-update";
    }

    @GetMapping("delete")
    public @ResponseBody String delete() {
        this.service.deleteStudent(1L);
        return "done-delete";
    }

    @GetMapping("find")
    public @ResponseBody String find() {
        this.service.findAllByTest();
        return "done-find";
    }
}
