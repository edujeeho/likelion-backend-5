package com.example.form;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {
//    @RequestMapping(
//            value = "/send",
//            // RequestMapping에 method 인자를 추가하면
//            // 특정 method에 대해서만 작동
//            method = RequestMethod.GET
//    )
    @GetMapping("/send")
    public String getForm() {
        return "send";
    }

//    @RequestMapping(
//            value = "/receive",
//            method = RequestMethod.POST
//    )
    @PostMapping("/receive")
    public String receive(
            @RequestParam("msg")
            String msg,
            @RequestParam("email")
            String email
    ) {
        System.out.println(msg);
        System.out.println(email);
        return "send";
    }
}
