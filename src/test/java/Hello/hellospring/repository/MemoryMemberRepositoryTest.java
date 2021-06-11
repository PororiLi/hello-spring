package Hello.hellospring.repository;

import Hello.hellospring.domain.Member;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {   //테스트할 코드와 패키지명과 클래스 명을 같게 하고, 클래스명 뒤에 test 붙이는게 관례
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();    //클리어 스토어 하면 테스트 순서와 상관없이 저장소를 지움.
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();  //optional 에서 값을 꺼낼때는 get으로 꺼낼 수 있음. 좋은 방법은 아니지만 테스트니까
//        Assertions.assertEquals(member, result);    //junit에서 제공해주는 Assertions. 예상 값과 결과값을 비교해줌.

        assertThat(member).isEqualTo(result);    //이거 추천. static import 하기 실무에서는 build 툴과 엮어서 테스트 통과 못하면 빌드 안되게 함.

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
