package com.ohgiraffers.InBody;

import java.time.LocalDateTime;

public class MemberDTO {

//    private int memberNo;               // 회원번호
    private String memberId;            // 회원ID
    private String memberPwd;              // 비밀번호
    private String memberName;          // 회원명
    private String phone;               // 전화번호
    private LocalDateTime checkedBMI;   // 측정 날/시간
    private double height;              // 키
    private double weight;              // 몸무게
    private int age;                    // 나이


    public MemberDTO() {}

    public MemberDTO(String memberId, String memberPwd, String memberName, String phone, LocalDateTime checkedBMI, double height, double weight, int age) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.phone = phone;
        this.checkedBMI = checkedBMI;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDateTime getCheckedBMI() {
        return checkedBMI;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberId='" + memberId + '\'' +
                ", memberPwd=" + memberPwd +
                ", memberName='" + memberName + '\'' +
                ", phone='" + phone + '\'' +
                ", checkedBMI=" + checkedBMI +
                ", height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }
}
