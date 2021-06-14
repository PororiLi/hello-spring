package Hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")    // "/"/ 는 제일 첫번째 홈 호출될때
    public String home() {
        return "home";
    }
}
