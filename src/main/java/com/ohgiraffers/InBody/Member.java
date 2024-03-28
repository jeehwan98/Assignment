package com.ohgiraffers.InBody;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "entityMembers")
@Table(name = "bmi_users")
public class Member {

    @Id
    @Column(name = "member_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int memberNo;
    @Column(name = "member_id")
    private String memberId;            // 회원Id
    @Column(name = "member_pwd")
    private String memberPwd;              // 비밀번호
    @Column(name = "member_name")
    private String memberName;          // 회원명
    @Column(name = "phone")
    private String phone;               // 전화번호
    @Column(name = "checked_bmi")
    private LocalDateTime checkedBMI;   // 측정 날/시간
//    @Column(name = "height")
//    private double height;              // 키
//    @Column(name = "weight")
//    private double weight;              // 몸무게
    @Column(name = "age")
    private int age;
    @Embedded
    private BMI bmi;

    protected Member() {} // public으로 바꿔야 하나..?

    public Member(String memberId, String memberPwd, String memberName, String phone, LocalDateTime checkedBMI, int age, BMI bmi) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.phone = phone;
        this.checkedBMI = checkedBMI;
        this.age = age;
        this.bmi = bmi;
    }

    public int getMemberNo() {
        return memberNo;
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

    public int getAge() {
        return age;
    }

    public BMI getBmi() {
        return bmi;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", memberName='" + memberName + '\'' +
                ", phone='" + phone + '\'' +
                ", checkedBMI=" + checkedBMI +
                ", age=" + age +
                ", bmi=" + bmi +
                '}';
    }
}
