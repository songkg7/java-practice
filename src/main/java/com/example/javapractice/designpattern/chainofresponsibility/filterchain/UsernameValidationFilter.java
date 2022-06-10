package com.example.javapractice.designpattern.chainofresponsibility.filterchain;

public class UsernameValidationFilter implements FilterChain {

    private FilterChain nextFilter;

    @Override
    public void setNext(FilterChain nextFilter) {
        this.nextFilter = nextFilter;
    }

    @Override
    public FilterChain doFilter(SignUpForm signUpForm) {
        if (!signUpForm.getName().matches("^[a-zA-Z]*$")) {
            System.out.println("유저 아이디는 문자열이여야만 합니다.");
        }

        return nextFilter.doFilter(signUpForm);
    }

}
