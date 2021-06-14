package Hello.hellospring.repository;

import Hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepo {

    private static Map<Long, Member> store = new HashMap<>();   //실무에서는 공유되는 문제 때문에 컨커런트해시맵 써야함.
    private static long sequence = 0L;  //실무에서는 동시성 문제 때문에 어텀 롱.

    @Override
    public Member save(Member member) {
        member.setId(++sequence);   //id setting
        store.put(member.getId(), member);  //store
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  //null 일 경우가 있을 수 있으면 optional.ofNullable로 감싸주면 클라이언트에서 뭘 할 수 있음.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //이름 같은거 찾고 하나라도 찾으면 반환.

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
