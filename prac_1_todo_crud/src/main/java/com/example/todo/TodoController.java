package com.example.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {

    @GetMapping("/todo")
    public String home(){
        return "todo";
    }

    public String create() {
        // 새로운 TODO를 생성하는 컨트롤러 메소드
        throw new RuntimeException("TODO");
    }

    public String update() {
        // TODO의 done 상태를 변경하는 메소드
        throw new RuntimeException("TODO");
    }

    public String delete() {
        // TODO를 삭제하는 메소드
        throw new RuntimeException("TODO");
    }
}
