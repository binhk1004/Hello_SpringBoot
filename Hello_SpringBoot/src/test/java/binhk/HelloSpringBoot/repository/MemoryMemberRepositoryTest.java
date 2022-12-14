package binhk.HelloSpringBoot.repository;

import binhk.HelloSpringBoot.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("binhk");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//        System.out.println("result = " +(result == member));
//        Assertions.assertEquals(member, null);
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("김빈현");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("김준빈");
        repository.save(member2);

        Member result = repository.findByName("김빈현").get();
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("김빈현");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("김준빈");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}
