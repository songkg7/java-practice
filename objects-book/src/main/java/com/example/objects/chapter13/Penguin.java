package com.example.objects.chapter13;

public class Penguin implements Walker {

    private Bird bird;

    public Penguin(Bird bird) {
        this.bird = bird;
    }

    // ISP : 인터페이스 분리 원칙
    // penguin 은 bird 또는 flyer 의 내부 구현을 알지 못하기 때문에, 두 계층이 변경된다고해도 영향을 받지 않는다.
    @Override
    public void walking() {
        bird.walking();
    }
}
