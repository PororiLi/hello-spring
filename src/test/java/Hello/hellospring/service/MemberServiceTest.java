package Hello.hellospring.service;

import Hello.hellospring.domain.Member;
import Hello.hellospring.repository.MemberRepo;
import Hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

//순수 테스트. 단위 테스트
class MemberServiceTest {
    MemberService memberService;
//    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();   //다른 객체 리포지토리 생성 하는 것 보다 좋은 방법 있음.
    MemoryMemberRepository memoryMemberRepository;


    @BeforeEach
    public void beforeEach() {
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);  // 이렇게 멤버 서비스에서 받는 방식. dependency Injection : DI
    }

    @AfterEach
    public void afterEach() {
        memoryMemberRepository.clearStore();    //클리어 스토어 하면 저장소를 지움.
    }


    @Test
    void 회원가입() {   //테스트는 한글로도 이름 많이씀 실제 빌드될때 포함이 안되기 때문에
        //given
        Member member = new Member();
        member.setName("hello");

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