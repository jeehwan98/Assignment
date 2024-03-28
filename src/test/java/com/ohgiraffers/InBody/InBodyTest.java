package com.ohgiraffers.InBody;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@SpringBootTest
public class InBodyTest {


    @Autowired
    private InBodyService inBodyService;

    private static Stream<Arguments> getMember() {
        return Stream.of(
                Arguments.of(
                        "jeehwan98",
                        "jeehwan9898!",
                        "김지환",
                        "010-7656-9003",
                        LocalDateTime.now(),
                        175.0,
                        82.0,
                        27
                )
        );
    }

    @ParameterizedTest
    @MethodSource("getMember")
    void testCreateMember(String memberId, String memberName, String memberPwd, String phone, LocalDateTime checkedBMI, double height, double weight, int age) {
        // given
        MemberDTO newMember = new MemberDTO(memberId,memberPwd,memberName,phone,checkedBMI,height,weight,age); // 회원 정보를 DTO에다가 담아서 정보를 보내준다

        // when
        // then
        Assertions.assertDoesNotThrow(() -> inBodyService.registMember(newMember));
}







}
