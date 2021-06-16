package Hello.hellospring.repository;

import Hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


public class JpaMemberRepository implements MemberRepo {

    private final EntityManager entityManager;

    @Autowired
    public JpaMemberRepository(EntityManager entityManager) {   //jpa를 쓰려면 엔티티 매니저 주입 받아야함.
        this.entityManager = entityManager;
    }

    @Override
    public Member save(Member member) {
        entityManager.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
       Member member = entityManager.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {   //spring data jpa를 사용하면 이것도 안해도 되게 됨.
        List<Member> result = entityManager.createQuery("select m from Member  m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return entityManager.createQuery("select m from Member m", Member.class)
                .getResultList();   //멤버 엔티티 자체를 셀렉트 하는 것. Member m은 Member as m임
    }
}
