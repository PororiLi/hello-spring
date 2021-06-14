package Hello.hellospring;

import Hello.hellospring.repository.MemberRepo;
import Hello.hellospring.repository.MemoryMemberRepository;
import Hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //여기 정의된 빈들을 스프링이 올라올때 컨테이너에 올리고 빈들을 만들어줌.
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepo());
    }

    @Bean
    public MemberRepo memberRepo() {
        return new MemoryMemberRepository();
    }
}
