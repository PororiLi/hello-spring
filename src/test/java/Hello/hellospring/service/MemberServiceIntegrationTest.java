package Hello.hellospring.service;

import Hello.hellospring.domain.Member;
import Hello.hellospring.repository.MemberRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

//스프링 통합 테스트
@SpringBootTest
@Transactional    //트랜잭션 넣어주면 테스트를 실행하고 테스트가 끝나면 롤백을 해줌. 그래서 디비에 넣었던 데이터는 반영안되고 지워짐.
public class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepo memberRepo;


    @Test
    void 회원가입() {   //테스트는 한글로도 이름 많이씀 실제 빌드될때 포함이 안되기 때문에
        //given
        Member member = new Member();
        member.setName("spring2");

        //when
        Long saveId = memberService.join(member);

        // then  문법 추천.
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }


    @Test
    public void 중복회원예외() {  //테스트 케이스의 핵심은 정상 플로우 확인 뿐 아니라 예외 상황 찾는것.
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2)); //더 유용한 에러 캐치 문법.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다."); //이렇게 메시지 검증.


        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
