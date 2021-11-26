package com.example.test.designpattern.chainofresponsibility.filterchain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpForm {

    // 문자만
    private String name;

    // 숫자만
    private String password;

}
