package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Member;
import com.example.repository.MemberRepository;

@Service
@Transactional
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findOne(Integer no) {
        return memberRepository.findOne(no);
    }

    public Member create(Member member) {
        return memberRepository.save(member);
    }

    public Member update(Member member) {
        return memberRepository.save(member);
    }

    public void delete(Integer no) {
        memberRepository.delete(no);
    }
}
