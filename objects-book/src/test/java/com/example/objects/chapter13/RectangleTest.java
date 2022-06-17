package com.example.objects.chapter13;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RectangleTest {

    @Test
    @DisplayName("resize 메서드의 구현은 Rectangle 이 세운 가정에 기반하기 때문에 메서드 실행은 실패한다.")
    void resize() {
        Square square = new Square(10, 10, 10);

        assertThatThrownBy(() -> resize(square, 50, 100)).isInstanceOf(AssertionError.class);
    }

    // NOTE: 리스코프 치환 원칙의 위배
    // 클라이언트는 직사각형의 너비와 높이를 서로 다르게 설정하도록 프로그래밍할 것이다.
    // 그러나 아래 코드에서 인자로 Rectangle 대신 Square 를 전달할 경우, 너비와 높이는 항상 더 나중에 전달한 높이가 될 것이다.
    // 결과로 메서드 실행이 실패한다. (456p)
    public void resize(Rectangle rectangle, int width, int height) {
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        assert rectangle.getWidth() == width && rectangle.getHeight() == height;
    }
}