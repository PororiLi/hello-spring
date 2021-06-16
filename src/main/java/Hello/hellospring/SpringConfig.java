package Hello.hellospring;

import Hello.hellospring.aop.TimeTraceAop;
import Hello.hellospring.domain.Member;
import Hello.hellospring.repository.*;
import Hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.lang.management.ThreadInfo;

@Configuration  //여기 정의된 빈들을 스프링이 올라올때 컨테이너에 올리고 빈들을 만들어줌. config 만 수정하면 이렇게 쉽게 디비 수정 가능.
public class SpringConfig {

    private final MemberRepo memberRepo;

    @Autowired
    public SpringConfig(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;

    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepo);
    }

//    @Bean   //컴포넌트 스캔보다 이게 더 많이 쓰임
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberRepo memberRepo() {
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(entityManager);
//    }
}
