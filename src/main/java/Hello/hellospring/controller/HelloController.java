package Hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")    //get: http-get, post 할때 get 임.
    public String hello(Model model) {
        model.addAttribute("data", "hello!!!");
        return "hello"; //return의 이름이 헬로. 기본적으로 ViewResolver가 resources/templates 폴더의 hello.html을 찾아서 실행 시키라는 것.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {    //RequestParam , required 는 기본이 true 기본적으로 값을 넘겨줘야함.
        model.addAttribute("name", name);
        return "hello-template";
    }
}
