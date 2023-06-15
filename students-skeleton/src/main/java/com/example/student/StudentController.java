package com.example.student;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping("")
    public String home(Model model) {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    // create.html 응답
    @GetMapping("/create-view")
    public String createView() {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    // 새로운 StudentEntity 생성 후 상세보기 페이지로
    @PostMapping("/create")
    public String create() {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    // id에 해당하는 StudentEntity의 read.html 응답
    @GetMapping("/{id}")
    public String read() {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    // id에 해당하는 StudentEntity의 update.html 응답
    @GetMapping("/{id}/update-view")
    public String updateView(){
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    // id에 해당하는 StudentEntity 수정 후 상세보기 페이지로
    @PostMapping("/{id}/update")
    public String update() {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    // id에 해당하는 StudentEntity delete.html
    @GetMapping("/{id}/delete-view")
    public String deleteView() {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }

    // id에 해당하는 StudentEntity 삭제 후 홈페이지로
    @PostMapping("/{id}/delete")
    public String delete() {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED);
    }
}
