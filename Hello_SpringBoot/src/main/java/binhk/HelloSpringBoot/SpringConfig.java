package binhk.HelloSpringBoot;

import binhk.HelloSpringBoot.repository.MemberRepository;
import binhk.HelloSpringBoot.repository.MemoryMemberRepository;
import binhk.HelloSpringBoot.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
