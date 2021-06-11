package Hello.hellospring.repository;

import Hello.hellospring.domain.Member;

import java.util.Optional;
import java.util.List;

public interface MemberRepo {
    Member save(Member member);
    Optional<Member> findById(Long id); //null 을 반환하는 방식대신 optional으로 감싸서 반환하려 함. 자바 8
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
