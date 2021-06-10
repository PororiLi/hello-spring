package Hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")    //get: http-get, post 할때 get 임.
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!");
        return "hello"; //return의 이름이 헬로. 기본적으로 ViewResolver가 resources/templates 폴더의 hello.html을 찾아서 실행 시키라는 것.
    }
}
