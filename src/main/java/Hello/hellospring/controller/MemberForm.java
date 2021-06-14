package Hello.hellospring.controller;

public class MemberForm {   //DTO 클래스
    private String name;    //html에 작성한 input name ="name"을 보고 여기에 데이터 넣어줌.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
