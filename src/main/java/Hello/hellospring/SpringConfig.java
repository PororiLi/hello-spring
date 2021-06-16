package Hello.hellospring;

import Hello.hellospring.repository.*;
import Hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration  //여기 정의된 빈들을 스프링이 올라올때 컨테이너에 올리고 빈들을 만들어줌. config 만 수정하면 이렇게 쉽게 디비 수정 가능.
public class SpringConfig {

    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    private EntityManager entityManager;

    @Autowired
    public SpringConfig(DataSource dataSource, EntityManager entityManager) {
        this.entityManager = entityManager;
        this.dataSource = dataSource;

    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepo());
    }

    @Bean
    public MemberRepo memberRepo() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(entityManager);
    }
}
