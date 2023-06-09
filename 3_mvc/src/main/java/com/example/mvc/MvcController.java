package com.example.mvc;

import com.example.mvc.model.Student;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

@Controller
public class MvcController {
    private final LottoService lottoService;
//    private int hitCount = 0;

    public MvcController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    @RequestMapping("/hits")
    public String hits(Model model) {
        int hitCount = lottoService.addHit();
        model.addAttribute("hits", hitCount);
        return "hits";
    }

    @RequestMapping("/lotto")
    public String lotto(Model model) {
//        // 6개의 임의의 숫자 만들기
//        List<Integer> winningNums = new ArrayList<>();
//        RandomGenerator random = new Random();
//        for (int i = 0; i < 6; i++) {
//            // 임의 정수를 반환하는 메소드
//            winningNums.add(random.nextInt(1, 46));
//        }
//
////        List<String> winningNumStrs = new ArrayList<>();
////        for (int i = 0; i < 6; i++) {
////            if (i == 5) {
////                winningNumStrs.add(winningNums.get(i).toString());
////            } else {
////                winningNumStrs.add(String.format("%d - ", winningNums.get(i)));
////            }
////        }
        List<Integer> winningNums = lottoService.nextWinningNumber();

        model.addAttribute("winningNums", winningNums);
//        model.addAttribute("winningNumStrs", winningNumStrs);

        return "lotto";
    }

    // history 매핑 추가


    @RequestMapping("/")
    public String home(Model model) {
        // 문자열을 모델에 전달
        model.addAttribute(
                "message",
                "Hello, Jeeho!");

        return "home";
    }

    @RequestMapping("/student")
    public String student(Model model) {
        // 객체를 모델에 전달
        model.addAttribute(
                "object",
                new Student("Jeeho Park", "jeeho@gmail.com"));
        return "student";
    }

    @RequestMapping("/is-logged-in")
    public String isLoggedIn(Model model) {
        model.addAttribute(
                "isLoggedIn",
                true
//                false
        );

        return "if-unless";
    }

    @RequestMapping("/each")
    public String items(Model model) {
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("foo");
        listOfStrings.add("bar");
        listOfStrings.add("baz");

        model.addAttribute("listOfStrings", listOfStrings);
//        for (String item : listOfStrings);

        List<Student> studentList = Arrays.asList(
                new Student("Alex", "alex@gmail.com"),
                new Student("Brad", "brad@gmail.com"),
                new Student("Chad", "chad@gmail.com")
        );
        model.addAttribute("studentList", studentList);
        return "each";
    }
}
