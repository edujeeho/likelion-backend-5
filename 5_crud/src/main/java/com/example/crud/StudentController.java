package com.example.crud;

import com.example.crud.model.StudentDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
    // StudentService 를 Controller 에서 사용
    private final StudentService studentService;

    public StudentController(
            StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/create-view")
    public String createView() {
        return "create";
    }

    @PostMapping("/create")
    public String create(
            @RequestParam("name")
            String name,
            @RequestParam("email")
            String email
    ) {
        StudentDto studentDto
                = studentService.createStudent(name, email);
//        return "redirect:/create-view";
        return "redirect:/home";

    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute(
                "studentList",
                studentService.readStudentAll()
        );
        return "home";
    }

    @GetMapping("/{id}")
    public String read(
            @PathVariable("id") Long id,
            Model model
    ) {
//        studentService.readStudent(id);
        model.addAttribute(
                "student",
                studentService.readStudent(id)
        );
        return "read";
    }

    // TODO url 설정 / ("/{id}/edit") 또는 ("/{id}/update-view") / @GetMapping
    @GetMapping("/{id}/update-view")
    public String updateView(
            // TODO 아이디와 Model 받아오기 / Long id, Model model
            @PathVariable("id") Long id,
            Model model
    ){
        // TODO Model에 student 데이터 부여 / studentService.readStudent
        model.addAttribute(
                "student",
                studentService.readStudent(id)
        );

        // TODO update.html 돌려주기 / "update"
        return "update";
    }

    @PostMapping("/{id}/update")
    public String update(
            // TODO StudentController.readOne()를 참조
            @PathVariable("id") Long id,
            // TODO StudentController.create()를 참조
            @RequestParam("name") String name,
            @RequestParam("email") String email
    ) {
        // service 활용하기
        studentService.updateStudent(id, name, email);
        // 상세보기 페이지로 redirect
        return String.format("redirect:/%s", id);
    }

    // TODO
    // deleteView 메소드 만들기
    // GetMapping 을 써서...
    // Long id는 어떻게...
    // studentDto 를 가지고...
    // return...
    @GetMapping("/{id}/delete-view")
    public String deleteView(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        StudentDto studentDto
                = studentService.readStudent(id);
        model.addAttribute("student", studentDto);
        return "delete";
    }

    @PostMapping("/{id}/delete")
    public String delete(
            @PathVariable("id")
            Long id
    ) {
        studentService.deleteStudent(id);
        // update 때는 데이터가 남아있지만
        // delete 는 돌아갈 상세보기가 없다
        // 그래서 홈으로 돌아간다.
        return "redirect:/home";
    }

}



