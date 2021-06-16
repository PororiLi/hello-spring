package Hello.hellospring.service;

import Hello.hellospring.domain.Member;
import Hello.hellospring.repository.MemberRepo;
import Hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional  //jpa를 사용할 때는 항상 트랜젝션이 있어야함.
public class MemberService {
    private final MemberRepo memberRepo;

    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }


    /*
    * 회원 가입
    * */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원 x.


        validateDuplicateMember(member);    // 중복 회원 검증.
        memberRepo.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        //        Optional<Member> result = memberRepo.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }); //null 일 수 있는 값을 optional 로 받아서 반환


        memberRepo.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            }); //따로 받아서 하면 결과물이 깔끔하지 않음. 바로 ifPresent 할 수 있음.
    }

    /*
    * 전체 회원 조회
    *
    * */
    public List<Member> findMembers() {
        return memberRepo.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepo.findById(memberId);
    }
}
