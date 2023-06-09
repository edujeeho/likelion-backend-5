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

        List<Integer> winningNums = lottoService.nextWinningNumber();

        model.addAttribute("winningNums", winningNums);

        return "lotto";
    }

    @RequestMapping("/history")
    public String history(Model model) {
        List<List<Integer>> history = lottoService.getHistory();

        model.addAttribute("history",  history);
        return "history";
    }

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
