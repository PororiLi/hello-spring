package Hello.hellospring.repository;

import Hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>, MemberRepo {
    //인터페이스만 만들어 두면 data JPA가 구현체 알아서 만들어 줌.

    //JPOL select m from member m where m.name = ?
    //Optional<name> findByNameandMyname(String name, myName) 이런식으로 쓰면 됨. 개인 용은.
    @Override
    Optional<Member> findByName(String name);


}
