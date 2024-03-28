package com.ohgiraffers.InBody;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InBodyService {

    private InBodyRepository inBodyRepository;

    public InBodyService(InBodyRepository inBodyRepository) {
        this.inBodyRepository = inBodyRepository;
    }

    @Transactional
    public void registMember(MemberDTO newMember) {
        Member member = new Member(newMember.getMemberId(),newMember.getMemberName(),newMember.getMemberPwd(),newMember.getPhone(),newMember.getCheckedBMI(),newMember.getAge(),new BMI(newMember.getHeight(), newMember.getWeight()));
        inBodyRepository.save(member); // 계산한 BMI값을 저장하겠금 넘겨준다
    }
}
