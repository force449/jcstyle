package com.example.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.domain.Member;
import com.example.service.MemberService;

@RestController
@RequestMapping("api/members")
public class MemberRestController {
    @Autowired
    MemberService memberService;

    @RequestMapping(method = RequestMethod.GET)
    List<Member> getMembers() {
        List<Member> members = memberService.findAll();
        return members;
    }

    @RequestMapping(value = "{no}", method = RequestMethod.GET)
    Member getMember(@PathVariable Integer no) {
        Member member = memberService.findOne(no);
        return member;
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Member> postMembers(@RequestBody Member Member, UriComponentsBuilder uriBuilder) {
    	Member created = memberService.create(Member);
    	URI location = uriBuilder.path("api/members/{no}")
    	.buildAndExpand(created.getNo()).toUri();
    	HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(location);
    return new ResponseEntity<>(created, headers, HttpStatus.CREATED);
 }

    @RequestMapping(value = "{no}", method = RequestMethod.PUT)
    Member putMember(@PathVariable Integer no, @RequestBody Member Member) {
        Member.setNo(no);
        return memberService.update(Member);
    }

    @RequestMapping(value = "{no}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMember(@PathVariable Integer no) {
        memberService.delete(no);
    }
}
