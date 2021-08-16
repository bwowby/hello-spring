package hello.hellospring.repository;
import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//jparepository를 가지고 있으면 jpa가 스프링 빈으로 자동으로 등록해줌
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository {

    //JPQL select m from Member m where m.name = ? -> 인터페이스 메소드 이름이랑 파라미터만 가지고 생성됨7890
    @Override
    Optional<Member> findByName(String name);
}
