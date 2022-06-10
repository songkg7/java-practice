package com.example.javapractice.designpattern.chainofresponsibility.filterchain;

public interface FilterChain {

    void setNext(FilterChain nextFilter);

    FilterChain doFilter(SignUpForm signUpForm);

}
