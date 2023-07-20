package leetcode.asteroidcollision;

import stack.ArrayStack;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        // 양수, 음수 순서만 서로 부딪힌다.
        // 음수, 양수는 부딪히지 않는다.
        // [10, 3, -5]
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            int target = asteroid;
            while (!stack.isEmpty() && stack.peek() > 0 && target < 0) {
                if (stack.peek() > Math.abs(target)) {
                    target = 0;
                } else if (stack.peek() == Math.abs(target)) {
                    stack.pop();
                    target = 0;
                } else {
                    stack.pop();
                }
            }

            if (target != 0) {
                stack.push(asteroid);
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

}
