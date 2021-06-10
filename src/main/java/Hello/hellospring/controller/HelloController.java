package Hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-string")
    @ResponseBody   // http 헤더와 바디 부의 바디. body 부분에 내가 직접 넣어주겠다. API 방식. 데이터가 직접 가는 것.
    public String helloString(@RequestParam("name") String name) {
        return "hello "+name;   //"hello Spring" 템플릿 엔진과의 차이는 뷰 없이 문자가 바로 가는 것.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;


        }
    }


}
